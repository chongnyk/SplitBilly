package com.example.splitbilly;

public class TaxModel {
    final private static double TAXES[] = {0, 0.05, 0.13};

    public static void main(String[] args) {

        Entry[] database = new Entry[3];

        Entry fish = new Entry("fish", 0, 0, 0);
        Entry chip = new Entry("chip", 0, 0, 1);
        Entry toiletPaper = new Entry("toilet paper", 0, 0, 2);

        database[0] = fish;
        database[1] = chip;
        database[2] = toiletPaper;

        // Checking content in database
        for (Entry i: database) {
            System.out.println(i);
        }

        //test cases
        Entry test1 = new Entry("toilet paper", 1, 12.99, -1);
        Entry test2 = new Entry("paper", 1, 12.99, -1);
        Entry test3 = new Entry("chicken", 1, 10.99, -1);

        System.out.println(test1);
        System.out.println();
        System.out.println(test2);
        System.out.println();
        System.out.println(test3);
        System.out.println();

        // setting TaxType of test1
        test1.setTaxType(test1.retrieveTax(database));
        test2.setTaxType(test2.retrieveTax(database));
        test3.setTaxType(test3.retrieveTax(database));

        System.out.println(test1);
        System.out.println();
        System.out.println(test2);
        System.out.println();
        System.out.println(test3);
        System.out.println();

        // testing calculateTaxType method
        System.out.println("None: " + calculateTaxType("None"));
        System.out.println("GST: " + calculateTaxType("GST"));
        System.out.println("HST: " + calculateTaxType("HST"));
        System.out.println("Error: " + calculateTaxType("LME"));
        System.out.println();

        // testing applyTax method
        double appliedTax = applyTax(test1.getTaxType(), test1.getPrice());
        double totalCost = (test1.getPrice() + appliedTax) * test1.getQuant();
        System.out.println(test1);
        System.out.println(String.format("TaxModel: %.2f", appliedTax));
        System.out.println(String.format("Total Cost: %.2f", totalCost));

    }

    // Calculates TaxModel based on tax type and price
    public static double applyTax(int taxType, double price){
        return (price * TAXES[taxType]);
    }

    // returns the corresponding TaxModel Type from a string, -1 if type not found
    // None -> 0, GST -> 1, HST -> 2
    public static int calculateTaxType(String taxType) {

        int result = -1;

        if (taxType == "None") {
            result = 0;
        }
        else if (taxType == "GST") {
            result = 1;
        }
        else if (taxType == "HST") {
            result = 2;
        }

        return result;
    }
}
