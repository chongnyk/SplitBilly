package com.example.splitbilly;

public class Tax {
    final private static double TAXES[] = {0, 0.05, 0.13};

    public static double applyTax(int select, double price){
        return (price * TAXES[select]);
    }
}
