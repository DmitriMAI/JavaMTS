package ru.mts.hw5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mts.hw5.animal.Animal;
import ru.mts.hw5.animal.impl.AbstractAnimal;
import ru.mts.hw5.animal.impl.Shark;
import ru.mts.hw5.animal.impl.Wolf;
import ru.mts.hw5.service.impl.SearchServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

import static java.util.Map.entry;

public class MainTest {
    @Nested
    class AbstractAnimalTest {
        private final Wolf wolf = new Wolf("W", 0.1, LocalDate.of(2020, 1, 8));
        private final Wolf wolf2 = new Wolf("W", 0.1, LocalDate.of(2020, 1, 8));
        private final Wolf wolf3 = new Wolf("W", 0.1, LocalDate.of(2020, 1, 8));

        @Test
        @DisplayName("Проверка правильной перегрузки equals")
        void testEqualsOverridden() throws NoSuchMethodException {
            String expectedClassName = "ru.mts.hw5.animal.impl.AbstractAnimal";
            String realClassName = AbstractAnimal.class
                    .getMethod("equals", Object.class).getDeclaringClass().getName();

            Assertions.assertEquals(expectedClassName, realClassName);
        }

        @Test
        @DisplayName("Проверка рефлексивности equals")
        void testReflexiveEquals() {
            Assertions.assertEquals(wolf, wolf);
        }

        @Test
        @DisplayName("Проверка симметричности equals")
        void testSymmetricEquals() {
            Assertions.assertEquals(wolf, wolf2);
            Assertions.assertEquals(wolf2, wolf);
        }

        @Test
        @DisplayName("Проверка транзитивности equals")
        void testTransitive() {
            Assertions.assertEquals(wolf, wolf2);
            Assertions.assertEquals(wolf2, wolf3);
            Assertions.assertEquals(wolf, wolf3);
        }

        @Test
        @DisplayName("Проверка консистентности equals")
        void testConsistent() {
            Assertions.assertEquals(wolf, wolf2);
            Assertions.assertEquals(wolf, wolf2);
        }

        @Test
        @DisplayName("Проверка непустого объекта equals")
        void testNullComparison() {
            Assertions.assertNotEquals(null, wolf);
        }
    }

    @Nested
    class SearchServiceTest {
        SearchServiceImpl searchService = new SearchServiceImpl();

        @Test
        @DisplayName("Проверка поиска животых рожденных в високосный год")
        void testFindLeapYearNames() {
            Animal[] animals = {new Shark("S", 0.1, LocalDate.of(2020, 1, 8)),
                    new Shark("S", 0.1, LocalDate.of(2024, 3, 2))};
            String[] expectedAnimalsNames = {"S", "S"};
            Animal[] animalsEmptyArray = {};

            Assertions.assertArrayEquals(expectedAnimalsNames, searchService.findLeapYearNames(animals));
            Assertions.assertArrayEquals(animalsEmptyArray, searchService.findLeapYearNames(animalsEmptyArray));

            //Проверка валидации аргументов
            Animal[] arrayOfNull = {null, null};
            Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.findLeapYearNames(null));
            Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.findLeapYearNames(arrayOfNull));
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("Проверка животных старше возраста")
        void testFindOlderAnimal(int ageOlderThan) {
            Animal[] animals = {new Wolf("AlphaWolf", 0.1, LocalDate.of(2020, 1, 2)),
                    new Shark("SmallerShark", 0.1, LocalDate.of(2021, 1, 2)),
                    new Shark("BiggerShark", 0.1, LocalDate.of(2022, 1, 8))};
            Animal[] animalsAnswer = Arrays.copyOfRange(animals, 0, 4 - ageOlderThan);
            Animal[] animalsEmptyArray = {};

            Assertions.assertArrayEquals(animalsAnswer, searchService.findOlderAnimal(animals, ageOlderThan));
            Assertions.assertArrayEquals(animalsEmptyArray, searchService.findOlderAnimal(animalsEmptyArray, ageOlderThan));

            //Проверка валидации аргументов
            Animal[] arrayOfNull = {null, null};
            Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.findOlderAnimal(null, ageOlderThan));
            Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.findOlderAnimal(arrayOfNull, ageOlderThan));
        }

        @Test
        @DisplayName("Проверка поиска дубликатов животных")
        void testFindDuplicate() {
            Animal[] animals = {new Wolf("D", 1, LocalDate.now()),
                    new Wolf("D", 1, LocalDate.now()),
                    new Wolf("D", 1, LocalDate.now()),
                    new Shark("D", 1, LocalDate.now()),
                    new Shark("D", 1, LocalDate.now())};
            Map<Animal, Integer> expectedDuplicates = Map.ofEntries(
                    entry(new Wolf("D", 1, LocalDate.now()), 2),
                    entry(new Shark("D", 1, LocalDate.now()), 1)
            );
            Map<Animal, Integer> actualDuplicates = searchService.findDuplicate(animals);
            Assertions.assertEquals(expectedDuplicates, actualDuplicates);

            //Проверка валидации аргументов
            Animal[] arrayOfNull = {null, null};
            Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.findDuplicate(null));
            Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.findDuplicate(arrayOfNull));
        }

    }
}
