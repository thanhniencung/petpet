package com.evn.petpet.base;

public class MvpPresenter<T extends MvpView> {
    T view;

    public T getView() {
        return view;
    }

    public void attachView(T view) {
        this.view = view;
    }

    public void deAttachView() {
        this.view = null;
    }
}
