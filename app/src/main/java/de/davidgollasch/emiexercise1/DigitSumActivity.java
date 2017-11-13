package de.davidgollasch.emiexercise1;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DigitSumActivity extends AppCompatActivity {

    private TextView tvOutput;
    private EditText etNumber;
    private Button btnFire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digit_sum);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tuAkzentfarbe1BlauHell)));

        // Initialises the views and event listeners
        InitializeActivity();
    }

    /**
     * Construct the Interactive Structure
     */
    private void InitializeActivity() {
        tvOutput = (TextView) findViewById(R.id.digitSumOutput);
        btnFire = (Button) findViewById(R.id.digitSumFire);
        etNumber = (EditText) findViewById(R.id.digitSumInput);

        btnFire.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CalculateDigitSum();
            }
        });
    }

    /**
     * Trigger the Digit Sum Calculation
     */
    private void CalculateDigitSum() {
        if (etNumber.getText().toString().equals("")) {
            tvOutput.setText("Please enter a number first!");
        } else {
            int n = Integer.parseInt(etNumber.getText().toString());
            int q = 0;

            while (n > 0) {
                q += n % 10;
                n = n/10;
            }

            tvOutput.setText(q + "");
        }
    }
}
