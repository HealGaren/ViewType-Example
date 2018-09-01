package com.example.healgaren.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private static NetworkManager instance;

    public static NetworkManager getInstance() {
        if (instance == null) instance = new NetworkManager();
        return instance;
    }

    public ProfileService profileService;

    private NetworkManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/HealGaren/b6cc6e82be1e3e261e16dfb7fa926801/raw/fa23b97a2afefb264892b9a3e81f3ad3869ed3c6")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        profileService = retrofit.create(ProfileService.class);
    }
}
