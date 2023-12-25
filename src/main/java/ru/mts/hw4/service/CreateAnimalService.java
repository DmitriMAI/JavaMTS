package ru.mts.hw4.service;

import ru.mts.hw4.animal.Animal;
import ru.mts.hw4.factory.AnimalFactory;

import java.util.concurrent.ThreadLocalRandom;

import static ru.mts.hw4.factory.AnimalTypes.*;

/**
 * Интерфейс создания
 * десяти различных животных
 * с помощью цикла while
 */
public interface CreateAnimalService {
    /**
     * Дефолтный метод генерации
     * десяти различных животных
     * циклом while
     */
    default Animal[] createUniqueAnimals() {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal[] animals = new Animal[10];
        int i = 0;

        while (i < 10) {
            switch (ThreadLocalRandom.current().nextInt(1, 4)) {
                case 1:
                    animals[i] = animalFactory.getAnimal(WOLF);
                    break;
                case 2:
                    animals[i] = animalFactory.getAnimal(SHARK);
                    break;
                case 3:
                    animals[i] = animalFactory.getAnimal(DOG);
                    break;
                case 4:
                    animals[i] = animalFactory.getAnimal(CAT);
                    break;
            }
            i++;
        }
        return animals;
    }
}
