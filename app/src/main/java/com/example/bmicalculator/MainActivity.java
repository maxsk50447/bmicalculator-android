package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);

        double height = Double.parseDouble(editText.getText().toString());
        double weight = Double.parseDouble(editText2.getText().toString());
        double bmi = weight/(Math.pow((height/100), 2));
        String result = String.format("Your BMI is %.1f", bmi);
        textView.setText(result);
        editText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        editText2.onEditorAction(EditorInfo.IME_ACTION_DONE);
        textView.setVisibility(View.VISIBLE);
        if (bmi < 22) {
            imageView.setImageResource(R.drawable.underweight);
        } else if (bmi >= 22 && bmi <= 30) {
            imageView.setImageResource(R.drawable.okay);
        } else {
            imageView.setImageResource(R.drawable.fat);
        }
    }
}
