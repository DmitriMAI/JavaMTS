package ru.mts;

import java.math.BigDecimal;

public class Predator extends AbstractAnimal{
    Predator(){
        this.character = "Angry";
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
