package com.evn.petpet.presenter;

import android.os.AsyncTask;
import android.os.Handler;

import com.evn.petpet.base.BasePresenter;
import com.evn.petpet.model.Home;
import com.evn.petpet.model.Repo;
import com.evn.petpet.mvpview.RepoView;
import com.evn.petpet.network.EvnAPI;
import com.evn.petpet.network.EvnResponse;

import java.util.List;

public class RepoPresenter extends BasePresenter<RepoView> {
    public void getRepos() {
        EvnAPI.getAccountantService().listRepos()
                .enqueue(new EvnResponse<List<Repo>>() {
                    @Override
                    public void onData(List<Repo> data) {
                        if (getView() != null) {
                            getView().onRepo(data);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (getView() != null) {
                            getView().onError();
                        }
                    }
                });
    }

    public void getHome() {
        EvnAPI.getAccountantService().getHome()
                .enqueue(new EvnResponse<Home>() {
                    @Override
                    public void onData(Home data) {
                        if (getView() != null) {
                            getView().onHome(data);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (getView() != null) {
                            getView().onError();
                        }
                    }
                });
    }

}
