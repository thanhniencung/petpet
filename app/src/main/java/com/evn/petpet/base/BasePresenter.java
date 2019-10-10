package com.evn.petpet.base;

public class BasePresenter<T extends MvpView> {
    T view;

    public T getView() {
        return view;
    }

    public void setViewListener(T view) {
        this.view = view;
    }

    public void deAttachView() {
        this.view = null;
    }
}
