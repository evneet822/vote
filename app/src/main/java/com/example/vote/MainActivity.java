package com.example.vote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText id;
    EditText name;
    Spinner spinner;
    ToggleButton toggleButton;
    Button button;
    ArrayList<String> voterId;
    boolean isExist = false;
    int candidatechoosen;
    boolean spinnerSelected = false;
    int c1 = 0;
    int c2 = 0;
    int c3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        spinner = findViewById(R.id.spinner2);
        toggleButton = findViewById(R.id.toggleButton);
        button = findViewById(R.id.button);
        voterId = new ArrayList<>();
        Button totalVotes = findViewById(R.id.button2);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                candidatechoosen = position;
                switch (position){
                    case 1:
                        spinnerSelected = true;
                        break;
                    case 2:
                        spinnerSelected = true ;
                        break;
                    case 3:
                        spinnerSelected = true;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty()&!id.getText().toString().isEmpty()&toggleButton.isChecked()&spinnerSelected){
                    if(!voterId.isEmpty()){
                        String enterId = id.getText().toString();
                        System.out.println(enterId);
                        for (String i: voterId){
                            System.out.println("iside for loop");
                            System.out.println("i:"+i);
                            if (enterId.equals(i)){
                                System.out.println("inside if loop");
                                isExist = true;
                                break;
                            }
                            isExist = false;
                        }
                        if (!isExist){
                            voterId.add(id.getText().toString());
                            System.out.println(voterId);
                            switch (candidatechoosen){
                                case 1:
                                    c1 += 1;
                                    System.out.println("c1:"+c1);
                                    break;
                                case 2:
                                    c2 += 1;
                                    System.out.println("c2:"+c2);
                                    break;
                                case 3:
                                    c3 += 1;
                                    System.out.println("c3:"+c3);
                                    break;
                            }
                            Toast.makeText(MainActivity.this, "Vote done successfully", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(MainActivity.this, "already voted", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        voterId.add(id.getText().toString());
                        System.out.println(voterId);
                        switch (candidatechoosen){
                            case 1:
                                c1 += 1;
                                System.out.println("c1:"+c1);
                                break;
                            case 2:
                                c2 += 1;
                                System.out.println("c2:"+c2);
                                break;
                            case 3:
                                c3 += 1;
                                System.out.println("c3:"+c3);
                                break;
                        }
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "empty feilds", Toast.LENGTH_SHORT).show();
                }

            }
        });
        totalVotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("candidate1",c1);
                intent.putExtra("candidate2",c2);
                intent.putExtra("candidate3",c3);
                startActivity(intent);
            }
        });



    }
}
