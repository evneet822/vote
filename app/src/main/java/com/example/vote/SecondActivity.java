package com.example.vote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EditText cand1 = findViewById(R.id.cand1);
        EditText cand2 = findViewById(R.id.cand2);
        EditText cand3 = findViewById(R.id.cand3);

        Intent intent = getIntent();
        cand1.setText(String.valueOf(intent.getIntExtra("candidate1",0)));
        cand2.setText(String.valueOf(intent.getIntExtra("candidate2",0)));
        cand3.setText(String.valueOf(intent.getIntExtra("candidate3",0)));
    }
}
