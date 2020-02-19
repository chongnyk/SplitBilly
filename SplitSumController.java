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
        taxDisplay.setText("Tax");

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
