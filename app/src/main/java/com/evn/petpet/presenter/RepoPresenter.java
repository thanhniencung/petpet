package com.evn.petpet.presenter;

import com.evn.petpet.base.MvpPresenter;
import com.evn.petpet.model.Repo;
import com.evn.petpet.mvpview.RepoView;
import com.evn.petpet.network.EvnAPI;
import com.evn.petpet.network.EvnResponse;

import java.util.List;

public class RepoPresenter extends MvpPresenter<RepoView> {
    public void getRepos() {
        EvnAPI.getAccountantService().listRepos()
                .enqueue(new EvnResponse<List<Repo>>() {
                    @Override
                    public void onData(List<Repo> data) {
                        getView().onRepo(data);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }
                });
    }
}
