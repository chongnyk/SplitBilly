package com.example.splitbilly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SplitSumController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.split_sum_view);
    }

    public void calculatorClicked(View v){
        Entry[] database = new Entry[3];

        Entry fish = new Entry("fish", 0, 0, 0);
        Entry chip = new Entry("chip", 0, 0, 1);
        Entry toiletPaper = new Entry("toilet paper", 0, 0, 2);

        database[0] = fish;
        database[1] = chip;
        database[2] = toiletPaper;

        EditText name1View = (EditText) findViewById(R.id.input1);
        String name1 = name1View.getText().toString();
        EditText quant1View = (EditText) findViewById(R.id.input2);
        Double quant1 = Double.parseDouble(quant1View.getText().toString());
        EditText price1View = (EditText) findViewById(R.id.input3);
        Double price1 = Double.parseDouble(price1View.getText().toString());
        Entry entry1 = new Entry(name1, quant1, price1);
        if(entry1.retrieveTax(database) == -1){

        }
        entry1.setTaxType(entry1.retrieveTax(database));
        entry1.setTax(TaxModel.applyTax(entry1.getTaxType(), entry1.getPrice()));
        ((TextView) findViewById(R.id.output1)).setText(String.format("%.2f", entry1.getTax()));
        ((TextView) findViewById(R.id.output2)).setText(String.format("%.2f", entry1.getQuant() * (entry1.getPrice() + entry1.getTax())));

        EditText name2View = (EditText) findViewById(R.id.input4);
        String name2 = name2View.getText().toString();
        EditText quant2View = (EditText) findViewById(R.id.input5);
        Double quant2 = Double.parseDouble(quant2View.getText().toString());
        EditText price2View = (EditText) findViewById(R.id.input6);
        Double price2 = Double.parseDouble(price2View.getText().toString());
        Entry entry2 = new Entry(name2, quant2, price2);
        entry2.setTaxType(entry2.retrieveTax(database));
        entry2.setTax(TaxModel.applyTax(entry2.getTaxType(), entry2.getPrice()));
        ((TextView) findViewById(R.id.output3)).setText(String.format("%.2f", entry2.getTax()));
        ((TextView) findViewById(R.id.output4)).setText(String.format("%.2f", entry2.getQuant() * (entry2.getPrice() + entry2.getTax())));

        EditText name3View = (EditText) findViewById(R.id.input7);
        String name3 = name3View.getText().toString();
        EditText quant3View = (EditText) findViewById(R.id.input8);
        Double quant3 = Double.parseDouble(quant3View.getText().toString());
        EditText price3View = (EditText) findViewById(R.id.input9);
        Double price3 = Double.parseDouble(price3View.getText().toString());
        Entry entry3 = new Entry(name3, quant3, price3);
        entry3.setTaxType(entry3.retrieveTax(database));
        entry3.setTax(TaxModel.applyTax(entry3.getTaxType(), entry3.getPrice()));
        ((TextView) findViewById(R.id.output5)).setText(String.format("%.2f", entry3.getTax()));
        ((TextView) findViewById(R.id.output6)).setText(String.format("%.2f", entry3.getQuant() * (entry3.getPrice() + entry3.getTax())));

        EditText name4View = (EditText) findViewById(R.id.input10);
        String name4 = name4View.getText().toString();
        EditText quant4View = (EditText) findViewById(R.id.input11);
        Double quant4 = Double.parseDouble(quant4View.getText().toString());
        EditText price4View = (EditText) findViewById(R.id.input12);
        Double price4 = Double.parseDouble(price4View.getText().toString());
        Entry entry4 = new Entry(name4, quant4, price4);
        entry4.setTaxType(entry4.retrieveTax(database));
        entry4.setTax(TaxModel.applyTax(entry4.getTaxType(), entry4.getPrice()));
        ((TextView) findViewById(R.id.output7)).setText(String.format("%.2f", entry4.getTax()));
        ((TextView) findViewById(R.id.output8)).setText(String.format("%.2f", entry4.getQuant() * (entry4.getPrice() + entry4.getTax())));

        EditText name5View = (EditText) findViewById(R.id.input13);
        String name5 = name5View.getText().toString();
        EditText quant5View = (EditText) findViewById(R.id.input14);
        Double quant5 = Double.parseDouble(quant5View.getText().toString());
        EditText price5View = (EditText) findViewById(R.id.input15);
        Double price5 = Double.parseDouble(price5View.getText().toString());
        Entry entry5 = new Entry(name5, quant5, price5);
        entry5.setTaxType(entry5.retrieveTax(database));
        entry5.setTax(TaxModel.applyTax(entry5.getTaxType(), entry5.getPrice()));
        ((TextView) findViewById(R.id.output9)).setText(String.format("%.2f", entry5.getTax()));
        ((TextView) findViewById(R.id.output10)).setText(String.format("%.2f", entry5.getQuant() * (entry5.getPrice() + entry5.getTax())));

        double totalTax = entry1.getTax() + entry2.getTax() + entry3.getTax() + entry4.getTax() + entry5.getTax();
        ((TextView) findViewById(R.id.totalTax)).setText(String.format("%.2f", totalTax));

        double totalSum = (entry1.getPrice() * entry1.getQuant()) + (entry2.getPrice() * entry2.getQuant()) + (entry3.getPrice() * entry3.getQuant()) + (entry4.getPrice() * entry4.getQuant()) + (entry5.getPrice() * entry5.getQuant()) + totalTax;
        ((TextView) findViewById(R.id.totalSum)).setText(String.format("%.2f", totalSum));

    }

    public void createTableRow(View v){
        TableLayout tl = (TableLayout) findViewById(R.id.mainTable);
        TableRow tr = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        tr.setLayoutParams(lp);

        EditText nameEntry = new EditText(this);
        nameEntry.setLayoutParams(lp);
        nameEntry.setText("Name");

        EditText quantityEntry = new EditText(this);
        quantityEntry.setLayoutParams(lp);
        quantityEntry.setText("Quantity");

        EditText priceEntry = new EditText(this);
        priceEntry.setLayoutParams(lp);
        priceEntry.setText("Price");

        CheckBox checkToCalc = new CheckBox(this);
        checkToCalc.setLayoutParams(lp);

        TextView taxDisplay = new TextView(this);
        taxDisplay.setLayoutParams(lp);
        taxDisplay.setText("TaxModel");

        TextView pWTDisplay = new TextView(this);
        pWTDisplay.setLayoutParams(lp);
        pWTDisplay.setText("PriceWTax");

        tr.addView(nameEntry);
        tr.addView(quantityEntry);
        tr.addView(priceEntry);
        tr.addView(checkToCalc);
        tr.addView(taxDisplay);
        tr.addView(pWTDisplay);

        tl.addView(tr, 1, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }

}
