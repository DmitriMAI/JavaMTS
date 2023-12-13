package ru.mts;

import java.util.concurrent.ThreadLocalRandom;

public class CreateAnimalServiceImpl implements CreateAnimalService{
    public void createTenUniqueAnimals(int n) {
        System.out.println("Impl method with for");
        for (int i = 0; i < n; i++){
            printCreatedUniqueAnimal();
        }
    }
    @Override
    public void createTenUniqueAnimals() {
        int i = 0;

        System.out.println("Impl method with do while");
        do {
            printCreatedUniqueAnimal();
            i++;
        } while (i < 10);
    }
    private void printCreatedUniqueAnimal(){
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
    }
}
