package ru.mts.hw3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cat extends Pet{
    Cat(String name, double cost){
        validateArguments(name, cost);
        this.breed = "Сatlike";
        this.name = name;
        this.cost = BigDecimal.valueOf(cost)
                .setScale(2, RoundingMode.HALF_UP);
    }
    private void validateArguments(String name, double cost){
        if (name.length() > 255 || name.isEmpty()){
            throw new IllegalArgumentException("Not valid name must be in range 0 < X < 256");
        }
        if (cost < 0){
            throw new IllegalArgumentException("Price must be value zero or above, we lose money!");
        }
    }
}