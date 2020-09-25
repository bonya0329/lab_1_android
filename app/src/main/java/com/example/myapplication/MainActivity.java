package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text, summary;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
        weight = findViewById(R.id.weight);
        summary = findViewById(R.id.summary);

        weight.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                int ounce = Integer.parseInt(v.getText().toString());
                double baseCost = 3.00, addedCost = 0.00;

                if(ounce > 30) {
                    baseCost = 4.00;
                }

                ounce -= 16;
                while(ounce > 0) {
                    ounce -= 4;
                    addedCost += 0.50;
                }

                double totalCost = baseCost + addedCost;
                String report = "";
                report += "Base Cost: " + baseCost + "\n";
                report += "Added Cost: " + addedCost + "\n";
                report += "Total Shipping-Cost: " + totalCost + "\n";
                summary.setText(report);
                return false;
            }
        });
    }
}