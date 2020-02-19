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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
    }
    public void summaryButton(View view)
    {
        TextView summary = (TextView)findViewById(R.id.summary);
        String result = "Billy has paid " + 1000 + " dollars until " + java.time.LocalDate.now();
        result +="\n\n" + "Everyone owns Billy " + 250 + " dollars";
        summary.setText(result);
    }

}
