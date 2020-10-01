package com.evn.petpet.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    protected TextView title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getViewId());

        initView();
        initData();
    }

    public abstract int getViewId();
    public abstract void initView();
    public abstract void initData();

    protected void goTo(Activity activity, Class target) {
        Intent intent = new Intent(activity,
                target);
        startActivity(intent);
    }
}
