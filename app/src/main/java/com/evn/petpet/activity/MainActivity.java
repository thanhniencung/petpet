package com.evn.petpet.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.evn.petpet.model.Repo;
import com.evn.petpet.mvpview.RepoView;
import com.evn.petpet.network.EvnAPI;
import com.evn.petpet.network.EvnResponse;
import com.evn.petpet.presenter.RepoPresenter;
import com.evn.petpet.shared.ImageLoader;
import com.evn.petpet.view.MyTextWatcher;
import com.evn.petpet.R;
import com.evn.petpet.base.BaseActivity;
import com.squareup.picasso.Callback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements RepoView  {
    Map<String, String> pets = new HashMap<>();

    ProgressBar imageLoading;
    EditText    editPetName;
    Button      btnGo;
    ImageView   ivAnimal;

    RepoPresenter repoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        repoPresenter = new RepoPresenter();
        repoPresenter.attachView(this);

        editPetName.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                handlePetNameTyping();
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(MainActivity.this,
                        SecondActivity.class);
                //handleGoClicked();
            }
        });

        repoPresenter.getRepos();
    }

    @Override
    public int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        imageLoading    = findViewById(R.id.imageLoading);
        editPetName     = findViewById(R.id.petName);
        btnGo           = findViewById(R.id.go);
        ivAnimal        = findViewById(R.id.petImage);
    }

    @Override
    public void initData() {
        pets.put("dog", "https://images.squarespace-cdn.com/content/v1/5a7f26bf268b96210912ae2d/1522770168413-11SGHGU3890Z0Q2PW22P/ke17ZwdGBToddI8pDm48kLxnK526YWAH1qleWz-y7AFZw-zPPgdn4jUwVcJE1ZvWEtT5uBSRWt4vQZAgTJucoTqqXjS3CfNDSuuf31e0tVH33scGBZjC30S7EYewNF5iKKwhonf2ThqWWOBkLKnojuqYeU1KwPvsAK7Tx5ND4WE/cody_golden.jpg");
        pets.put("cat", "https://www.smithsstationah.com/imagebank/eVetSites/Feline/01.jpg");
        pets.put("rabbit", "https://assets.change.org/photos/4/nh/bb/HfNHbbpayJVOjKD-400x400-noPad.jpg?1530422195");

        displayPetImage("dog");
    }


    private void handleGoClicked() {
        String petName = editPetName.getEditableText().toString();
        if (petName.isEmpty()) {
            editPetName.setTag(true);
            Animation animShake =
                    AnimationUtils.loadAnimation(
                            MainActivity.this,
                            R.anim.shake);
            editPetName.startAnimation(animShake);
            editPetName.setBackgroundResource(
                    R.drawable.bg_edit_petname_error);
            return;
        }

        displayPetImage(petName);
    }

    private void handlePetNameTyping() {
        Object tag = editPetName.getTag();
        if (tag == null) {
            return;
        }
        if (((Boolean) tag) == true) {
            editPetName.setTag(false);
            editPetName.setBackgroundResource(
                    R.drawable.bg_edit_petname);
        }
    }

    /**
     * @param name
     */
    void displayPetImage(String name) {
        String petImage = getPetImageByName(name);
        if (petImage == null) {
            return;
        }

        if (petImage.isEmpty()) {
            return;
        }

        ImageLoader.load(ivAnimal, petImage, new Callback() {
            @Override
            public void onSuccess() {
                imageLoading.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    /**
     *
     * @param name
     * @return
     */
    String getPetImageByName(String name) {
        return pets.get(name);
    }

    @Override
    public void onRepo(List<Repo> data) {
        String a = "";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        repoPresenter.deAttachView();
    }
}
