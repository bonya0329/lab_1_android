package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Header, Summary;
    private EditText Weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Header = findViewById(R.id.header);
        Weight = findViewById(R.id.weight);
        Summary = findViewById(R.id.summary);

        Weight.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                int ounces = Integer.parseInt(v.getText().toString());
                double baseCost = 3.00, addedCost = 0.00;


                // first Check
                if(ounces > 30) {
                    baseCost = 4.00;
                }

                ounces -= 16;
                // second Check
                while(ounces > 0) {
                    ounces -= 4;
                    addedCost += 0.50;
                }

                double total = baseCost + addedCost;
                String report = "";
                report += "Base Cost: " + baseCost + "\n";
                report += "Added Cost: " + addedCost + "\n";
                report += "Total Shipping-Cost: " + total + "\n";
                Summary.setText(report);
                return false;
            }
        });
    }
}