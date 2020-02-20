package ca.yorku.eecs.splitbilly;

import android.icu.util.LocaleData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Date;

public class Summary extends AppCompatActivity
{
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_layout);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openEntry();

            }
        });
    }

    public void openEntry()
    {
        Intent intent = new Intent(this, SplitSum.class);
        startActivity(intent);
    }

    public void summaryButton(View view)
    {
        TextView summary = (TextView)findViewById(R.id.summary);
        TextView totalTax = (TextView)findViewById(R.id.totalTax);
        TextView totalSum = (TextView)findViewById(R.id.totalSum);
        String sumAmount = totalSum.getText().toString();
        double index = Double.parseDouble(sumAmount);
        String result = "Billy has paid " +   "$ until " + java.time.LocalDate.now();
        result +="\n\n" + "Everyone owns Billy " +   "$";
        summary.setText(result);
    }

}
