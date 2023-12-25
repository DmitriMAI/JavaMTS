package ru.mts.hw4.animal.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pet extends AbstractAnimal {
    public Pet() {
        this.character = "Chill";
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Breed: " + getBreed() + " Name: " + getName()
                + " Cost: " + getCost() + " Character: " + getCharacter() + " Birthday: " + getBirthDate().format(pattern);
    }
}
