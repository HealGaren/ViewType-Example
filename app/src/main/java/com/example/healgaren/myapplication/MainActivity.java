package com.example.healgaren.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        adapter.addProfile(new Profile("최예찬", "ㅋㅋ", "https://avatars0.githubusercontent.com/u/13010755"));
        adapter.addProfile(new Profile("테스트", "상태다", "https://avatars0.githubusercontent.com/u/4777586"));
        adapter.addProfile(new Profile("글라이드", "아 피카소 표절임", "https://avatars1.githubusercontent.com/u/423539"));
        adapter.addProfile(new Profile("구글", "아이폰 조아여", "https://avatars2.githubusercontent.com/u/1342004"));

    }
}
