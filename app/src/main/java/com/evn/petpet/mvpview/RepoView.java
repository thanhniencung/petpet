package com.evn.petpet.mvpview;

import com.evn.petpet.base.MvpView;
import com.evn.petpet.model.Home;
import com.evn.petpet.model.Repo;

import java.util.List;

public interface RepoView extends MvpView {
    void onRepo(List<Repo> data);
    void onHome(Home home);
    void onError();
}
