package com.example.splitbilly;

public class TaxModel {

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

        //test 1
        Entry test1 = new Entry("toilet paper", 1, 12.99, -1);

        System.out.println(test1);

        // setting TaxType of test1
        test1.setTaxType(test1.retrieveTax(database, test1));

        System.out.println(test1);

    }
}
