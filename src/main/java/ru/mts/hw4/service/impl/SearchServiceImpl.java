package ru.mts.hw4.service.impl;

import ru.mts.hw4.animal.Animal;
import ru.mts.hw4.service.SearchService;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class SearchServiceImpl implements SearchService {
    /**
     * При помощи цикла находит всех животных,
     * которые родились в високосный год
     *
     * @param animals Массив животных
     * @return Массив из имен животных
     */
    @Override
    public String[] findLeapYearNames(Animal[] animals) {
        validateAnimals(animals);
        List<String> animalsReturn = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.getBirthDate().isLeapYear()) {
                animalsReturn.add(animal.getName());
            }
        }
        return animalsReturn.toArray(new String[0]);
    }

    /**
     * При помощи цикла for находит всех
     * животных, возраст которых больше N лет
     *
     * @param animals Массив животных
     * @param N       Возраст, выше которого нужно найти
     * @return Массив подходящих животных
     */
    @Override
    public Animal[] findOlderAnimal(Animal[] animals, int N) {
        validateAnimals(animals);
        List<Animal> animalsReturn = new ArrayList<>();

        for (Animal animal : animals) {
            if (Period.between(animal.getBirthDate(), LocalDate.now()).getYears() > N) {
                animalsReturn.add(animal);
            }
        }
        return animalsReturn.toArray(new Animal[0]);
    }

    /**
     * Выводит дубликаты животных
     *
     * @param animals Массив животных
     */
    @Override
    public void findDuplicate(Animal[] animals) {
        validateAnimals(animals);
        Map<Animal, Integer> animalDuplicates = new HashMap<>();
        Set<Animal> uniqueAnimals = new HashSet<>();
        Animal[] animalFoundedDuplicates;
        Integer[] animalFoundedDuplicatesNum;

        for (Animal animal : animals) {
            if (uniqueAnimals.contains(animal)) {
                if (animalDuplicates.containsKey(animal)) {
                    int val = animalDuplicates.get(animal) + 1;

                    animalDuplicates.put(animal, val);
                } else {
                    animalDuplicates.put(animal, 1);
                }
            } else {
                uniqueAnimals.add(animal);
            }
        }
        animalFoundedDuplicates = animalDuplicates.keySet().toArray(new Animal[0]);
        animalFoundedDuplicatesNum = animalDuplicates.values().toArray(new Integer[0]);

        for (int i = 0; i < animalFoundedDuplicates.length; i++) {
            System.out.println(animalFoundedDuplicates[i] + " duplicate - " + animalFoundedDuplicatesNum[i]);
        }
    }

    private void validateAnimals(Animal[] animals) {
        if (animals == null) {
            throw new IllegalArgumentException("Animals array cannot be null");
        }
        for (Animal animal : animals) {
            if (animal == null) {
                throw new IllegalArgumentException("Some animal is null");
            }
        }
    }
}
