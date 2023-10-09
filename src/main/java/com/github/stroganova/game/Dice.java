package com.github.stroganova.game;
import java.util.Random;
/*
* Утилитарный класс со статическим методом для бросания кубика. 
*/

public class Dice {
    private Dice()   {
    }
    public static int roll() {
        Random r = new Random();
        System.out.print("Roll the dice... ");
        int value = r.nextInt(6) + 1;
        System.out.println(String.valueOf(value) + " dropped out.");
        return value;
    }
}
