package com.evn.petpet.network.service.accountant;

import com.evn.petpet.model.Home;
import com.evn.petpet.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AccountantService {
    @GET("users/thanhniencung/repos")
    Call<List<Repo>> listRepos();

    @GET("/")
    Call<Home> getHome();
}