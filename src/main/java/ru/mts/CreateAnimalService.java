package ru.mts;

import java.util.concurrent.ThreadLocalRandom;
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
     default void createTenUniqueAnimals(){
        int i = 0;
        System.out.println("Interface method with while");
        while (i < 10) {
            int randomNumForName = ThreadLocalRandom.current().nextInt(1, 300);
            double randomCost = ThreadLocalRandom.current().nextDouble(0.001, 300);
            switch (ThreadLocalRandom.current().nextInt(1, 4)) {
                case 1:
                    Wolf wolf = new Wolf("nameWolf " + randomNumForName, randomCost);
                    wolf.printAllFields();
                    break;
                case 2:
                    Shark shark = new Shark("nameShark " + randomNumForName, randomCost);
                    shark.printAllFields();
                    break;
                case 3:
                    Cat cat = new Cat("nameCat " + randomNumForName, randomCost);
                    cat.printAllFields();
                    break;
                case 4:
                    Dog dog = new Dog("nameDog " + randomNumForName, randomCost);
                    dog.printAllFields();
                    break;
                default:
                    System.out.println("There is no type of this animal");
                    break;
            }
            i++;
        }
    }
}
