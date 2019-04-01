package com.example.listtutorial;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButton1Clicked(View v) {
        Toast.makeText(this, "카페 목록", Toast.LENGTH_LONG).show();
        //Toast를 이용한 문구 출력
        Intent intent = new Intent(this, MenuActivity.class);
        //다른 클래스로 전환하는 코드
        startActivity(intent);


    }

    public void onButton2Clicked(View v) {
        Toast.makeText(this, "식당 목록", Toast.LENGTH_LONG).show();
        //Toast를 이용한 문구 출력
        Intent intent = new Intent(this, Menu2Activity.class);
        //다른 클래스로 전환하는 코드
        startActivity(intent);
    }

}