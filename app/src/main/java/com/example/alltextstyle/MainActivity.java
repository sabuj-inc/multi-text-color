package com.example.alltextstyle;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    TextView colorPlus, colorMinus, colorCount;
    int countNumber = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        colorPlus = findViewById(R.id.colorPlus);
        colorMinus = findViewById(R.id.colorMinus);
        colorCount = findViewById(R.id.colorCount);
        colorPlus.setOnClickListener(this);
        colorMinus.setOnClickListener(this);

        countNumber = Integer.parseInt(colorCount.getText().toString());


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.colorMinus) {
            --countNumber;
            multiColor();
        } else if (id == R.id.colorPlus) {
            ++countNumber;
            multiColor();
        }
    }

    public void multiColor() {

        if (countNumber <1) {
            countNumber =10;
            colorCount.setText("" + (countNumber));
        }else if(countNumber > 10){
            countNumber=1;
            colorCount.setText("" + (countNumber));
        }else {
            colorCount.setText("" + (countNumber));
        }
        SpannableString text = new SpannableString(textView.getText().toString());
        int[] color = {Color.YELLOW, Color.BLUE, Color.BLACK, Color.GREEN,Color.DKGRAY,Color.CYAN,Color.GRAY,Color.LTGRAY,Color.BLUE,Color.RED,Color.WHITE};
        int colorCount = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (colorCount >= countNumber) {
                    colorCount = 0;
                }
                text.setSpan(new ForegroundColorSpan(color[colorCount]), j, text.length(), 0);
                colorCount++;
            }

        }
        textView.setText(text, TextView.BufferType.SPANNABLE);
    }

}