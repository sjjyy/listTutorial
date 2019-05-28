package com.example.listtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;


import java.util.Arrays;
import java.util.List;

public class illsik extends AppCompatActivity {
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illsik);

        back = findViewById (R.id.button5);
        back.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (illsik.this, MainActivity.class);
                startActivity (intent);
            }
        });

        init();

        getData();
    }



    private RecyclerAdapter adapter;


    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        // 임의의 데이터
        List<String> listTitle = Arrays.asList("권선생의 연어와 새우", "미소야", "스시아지");
        List<String> listContent = Arrays.asList(
                "권선생의 연어와 새우입니다",
                "미소야입니다",
                "스시아지입니다"
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.k,
                R.drawable.l,
                R.drawable.j
        );
        for (int i = 0; i < listTitle.size(); i++) {

            Data data = new Data();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            data.setResId(listResId.get(i));


            adapter.addItem(data);
        }

        adapter.notifyDataSetChanged();
    }
}

