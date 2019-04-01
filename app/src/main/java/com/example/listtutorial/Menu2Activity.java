package com.example.listtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
    }


    public void onBackButtonClicked(View v){
        Toast.makeText(this, "돌아가기", Toast.LENGTH_LONG).show();

        finish();
        //화면을 없애주는 역할
    }
}
