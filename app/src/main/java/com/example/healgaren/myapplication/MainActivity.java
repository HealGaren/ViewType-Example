package com.example.healgaren.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NetworkManager.getInstance().profileService.getMock().enqueue(new Callback<ResultVo>() {
            @Override
            public void onResponse(Call<ResultVo> call, Response<ResultVo> response) {
                ResultVo result = response.body();
                initRecyclerAdapterFromResultVo(result);
            }

            @Override
            public void onFailure(Call<ResultVo> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    void initRecyclerAdapterFromResultVo(ResultVo result) {


    }
}
