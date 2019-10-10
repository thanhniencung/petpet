package com.evn.petpet.network;

import com.evn.petpet.network.service.accountant.AccountantService;
import com.evn.petpet.network.service.saling.SalingService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EvnAPI {
    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static AccountantService getAccountantService() {
        return retrofit.create(AccountantService.class);
    }

    public static SalingService getSalingService() {
        return retrofit.create(SalingService.class);
    }
}