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

public class jungsik extends AppCompatActivity {
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jungsik);

        back = findViewById(R.id.button4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(jungsik.this, MainActivity.class);
                startActivity(intent);
            }
        });

        init();

        getData();
    }

        private RecyclerAdapter adapter;


        private void init() {
            RecyclerView recyclerView = findViewById(R.id.recyclerView3);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);

            adapter = new RecyclerAdapter();
            recyclerView.setAdapter(adapter);
        }

        private void getData() {
            // 임의의 데이터
            List<String> listTitle = Arrays.asList("홍춘", "홍콩반점", "쓰부");
            List<String> listContent = Arrays.asList(
                    "홍춘입니다",
                    "홍콩반점입니다",
                    "쓰부입니다"
            );
            List<Integer> listResId = Arrays.asList(
                    R.drawable.n,
                    R.drawable.m,
                    R.drawable.o
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
