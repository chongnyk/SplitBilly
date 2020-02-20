package com.example.splitbilly;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class Summary extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEntry();

            }
        });
    }

    public void openEntry() {
        Intent intent = new Intent(this, SplitSumController.class);
        startActivity(intent);
    }

    public void summaryButton(View view) {
        TextView summary = (TextView) findViewById(R.id.summary);
        double totalTax = SplitSumController.totalTax;
        double totalSum = SplitSumController.totalSum;
        String result = "Billy has paid " + totalSum + "until " + java.time.LocalDate.now();
        result += "\n\n" + "Everyone owns Billy " + String.format("%.2f", (totalSum/4));
        summary.setText(result);
    }

}