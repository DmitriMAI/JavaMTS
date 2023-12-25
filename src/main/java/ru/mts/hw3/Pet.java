package ru.mts.hw3;

import java.math.BigDecimal;

public class Pet extends AbstractAnimal{
    Pet(){
        this.character = "Chill";
    }
    @Override
    public String getBreed(){
        return breed;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public BigDecimal getCost(){
        return cost;
    }
    @Override
    public String getCharacter(){
        return character;
    }
    public void printAllFields(){
        System.out.println("Breed: " + getBreed() + " Name: " + getName()
                + " Cost: " + getCost() + " Character: " + getCharacter());
    }
}
