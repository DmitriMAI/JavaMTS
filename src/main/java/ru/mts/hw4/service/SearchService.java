package ru.mts.hw4.service;

import ru.mts.hw4.animal.Animal;

/**
 * Интерфейс поиска в массиве животных
 * по заданному условию
 */
public interface SearchService {
    /**
     * При помощи цикла находит всех животных,
     * которые родились в високосный год
     *
     * @param animals Массив животных
     * @return Массив из имен животных
     */
    String[] findLeapYearNames(Animal[] animals);

    /**
     * При помощи цикла for находит всех
     * животных, возраст которых больше N лет
     *
     * @param animals Массив животных
     * @param N       Возраст, выше которого нужно найти
     * @return Массив подходящих животных
     */
    Animal[] findOlderAnimal(Animal[] animals, int N);

    /**
     * Выводит дубликаты животных
     *
     * @param animals Массив животных
     */
    void findDuplicate(Animal[] animals);
}
