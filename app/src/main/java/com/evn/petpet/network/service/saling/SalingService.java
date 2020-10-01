package com.evn.petpet.network.service.saling;

import com.evn.petpet.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SalingService {
    @GET("users/thanhniencung/repos")
    Call<List<Repo>> listRepos();
}