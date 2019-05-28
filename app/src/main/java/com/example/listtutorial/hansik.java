package com.example.listtutorial;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;


import java.util.Arrays;
import java.util.List;


public class hansik extends AppCompatActivity implements RecyclerAdapter.OnItemClickListener {


    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hansik);


        back = findViewById (R.id.button);
        back.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (hansik.this, MainActivity.class);
                startActivity (intent);
            }
        });


        init();

        getData();


    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, seatActivity.class);
        startActivity(intent);
    }


    private RecyclerAdapter adapter;


    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        // 임의의 데이터
        List<String> listTitle = Arrays.asList("더진국", "내가 찜한 닭", "칼제비", "1", "2", "3", "4", "5", "6", "7");
        List<String> listContent = Arrays.asList(
                "더진국입니다",
                "내가 찜한 닭입니다",
                "칼제비입니다",
                "1", "2", "3", "4", "5", "6", "7"
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.img1,
                R.drawable.img1,
                R.drawable.img1,
                R.drawable.img1,
                R.drawable.img1,
                R.drawable.img1,
                R.drawable.img1
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
