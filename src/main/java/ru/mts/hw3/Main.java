package ru.mts.hw3;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl serviceImpl = new CreateAnimalServiceImpl();
        serviceImpl.createTenUniqueAnimals(5);
        serviceImpl.createTenUniqueAnimals();
    }
}