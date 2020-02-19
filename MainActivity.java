package com.example.splitbilly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.splitbilly.TaxModel.applyTax;
import static com.example.splitbilly.TaxModel.calculateTaxType;

public class MainActivity extends AppCompatActivity{

    // https://stackoverflow.com/questions/8460680/how-can-i-assign-an-id-to-a-view-programmatically
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    final int LIST_LENGTH = 5;

    Entry[] entries = new Entry[LIST_LENGTH];

    int row = 1; // keeps track of row for incremental id
    int col = 1; // keeps track of column for incremental id

    public void calcClicked(View v) {

        int selection = selectionHelper(row, col);

        // get name of current row entry
        EditText nameView =(EditText) findViewById(R.id.r1c1);
        String name = nameView.getText().toString();

        // get quantity of current row entry
        EditText quantityView =(EditText) findViewById(R.id.___);
        double quantity = Double.valueOf(nameView.getText().toString());

        // get price of current row entry
        EditText priceView =(EditText) findViewById(R.id.___);
        double price = Double.valueOf(nameView.getText().toString());

        Entry entry = new Entry(name, quantity, price, -1);

        entry.setTaxType(entry.retrieveTax(database)); // how to connect to database in TaxModel Main? Or set database here

        if (entry.getTaxType() == -1) {
            String strTaxType = ""; //prompt user to enter "None", "GST" or "HST"
            entry.setTaxType(calculateTaxType(strTaxType));
        }

        double appliedTax = applyTax(entry.getTaxType(), entry.getPrice());
        double totalCost = (entry.getPrice() + appliedTax) * entry.getQuant();

        // setting tax
        ((TextView) findViewById(R.id.___).setText(String.format("&.2f", appliedTax)));

        // setting total with tax price
        ((TextView) findViewById(R.id.___)).setText(String.format("&.2f", totalCost));

        row ++; // increment to get to the next row
        col = 1;
    }

    public int selectionHelper(int row, int col) {
        return Integer.valueOf("r" + row + "c" + col);
    }

}
