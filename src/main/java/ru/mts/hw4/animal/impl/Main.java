package ru.mts.hw4.animal.impl;

import ru.mts.hw4.animal.Animal;
import ru.mts.hw4.service.impl.CreateAnimalServiceImpl;
import ru.mts.hw4.service.impl.SearchServiceImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int age = 10;
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        SearchServiceImpl searchService = new SearchServiceImpl();
        Animal[] generatedAnimals = createAnimalService.createUniqueAnimals(15);
        String[] returnedAnimalsNames = searchService.findLeapYearNames(generatedAnimals);
        Animal[] returnedAnimals = searchService.findOlderAnimal(generatedAnimals, age);
        Animal[] forTestingFindDuplicatesAnimals = {new Wolf("D", 1, LocalDate.now()), new Wolf("D", 1, LocalDate.now()),
                new Wolf("D", 1, LocalDate.now()), new Shark("D", 1, LocalDate.now()),
                new Shark("D", 1, LocalDate.now())};

        System.out.println("Duplicates: ");
        searchService.findDuplicate(generatedAnimals);
        System.out.println("Animals name born in leap year:");
        for (String name : returnedAnimalsNames) {
            System.out.println(name);
        }
        System.out.println("Animals older then " + age + ":");
        for (Animal animal : returnedAnimals) {
            System.out.println(animal);
        }
    }
}