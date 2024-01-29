package ru.mts.hw5.service.impl;

import ru.mts.hw5.animal.Animal;
import ru.mts.hw5.factory.AnimalFactory;
import ru.mts.hw5.service.CreateAnimalService;

import java.util.concurrent.ThreadLocalRandom;

import static ru.mts.hw5.factory.AnimalTypes.*;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    /**
     * Создает N уникальных животных
     *
     * @param n Сколько животных создать
     * @return Массив животных
     */
    public Animal[] createUniqueAnimals(int n) {
        Animal[] animals = new Animal[n];

        for (int i = 0; i < n; i++) {
            animals[i] = createRandomAnimal();
        }
        return animals;
    }

    /**
     * Создает 10 различных животных циклом do while
     *
     * @return Массив животных
     */
    @Override
    public Animal[] createUniqueAnimals() {
        Animal[] animals = new Animal[10];
        int i = 0;

        System.out.println("Impl method with do while");
        do {
            animals[i] = createRandomAnimal();
            i++;
        } while (i < 10);
        return animals;
    }

    private Animal createRandomAnimal() {
        AnimalFactory animalFactory = new AnimalFactory();

        switch (ThreadLocalRandom.current().nextInt(1, 4)) {
            case 1:
                return animalFactory.getAnimal(WOLF);
            case 2:
                return animalFactory.getAnimal(SHARK);
            case 3:
                return animalFactory.getAnimal(DOG);
            case 4:
                return animalFactory.getAnimal(CAT);
            default:
                throw new IllegalStateException("Wrong ENUM type");
        }
    }
}
