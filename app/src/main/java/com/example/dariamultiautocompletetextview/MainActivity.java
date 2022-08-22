package com.example.dariamultiautocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DariaMultiAutoCompleteTextview dariaMultiAutoCompleteTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dariaMultiAutoCompleteTextview = findViewById(R.id.input);

        dariaMultiAutoCompleteTextview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                dariaMultiAutoCompleteTextview.getOnCountListener().OnCountChanged(s.length());
            }
        });

    }
}

