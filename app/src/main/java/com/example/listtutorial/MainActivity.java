package com.example.listtutorial;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;





public class MainActivity extends AppCompatActivity {

    Button 한식;
    Button 분식;
    Button 중식;
    Button 일식;
    Button 양식;
    Button 카페;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        한식 = findViewById (R.id.한식);
        한식.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, hansik.class);
                startActivity (intent);
            }
        });

        분식 = findViewById (R.id.분식);
        분식.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, bunsik.class);
                startActivity (intent);
            }
        });


        중식 = findViewById (R.id.중식);
        중식.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, jungsik.class);
                startActivity (intent);
            }
        });


        일식 = findViewById (R.id.일식);
        일식.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, illsik.class);
                startActivity (intent);
            }
        });


        양식 = findViewById (R.id.양식);
        양식.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, yangsik.class);
                startActivity (intent);
            }
        });

        카페 = findViewById (R.id.카페);
        카페.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, cafe.class);
                startActivity (intent);
            }
        });
    }




}