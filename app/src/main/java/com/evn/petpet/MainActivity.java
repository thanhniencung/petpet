package com.evn.petpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    static Map<String, String> pets = new HashMap<>();

    static {
        pets.put("dog", "https://images.squarespace-cdn.com/content/v1/5a7f26bf268b96210912ae2d/1522770168413-11SGHGU3890Z0Q2PW22P/ke17ZwdGBToddI8pDm48kLxnK526YWAH1qleWz-y7AFZw-zPPgdn4jUwVcJE1ZvWEtT5uBSRWt4vQZAgTJucoTqqXjS3CfNDSuuf31e0tVH33scGBZjC30S7EYewNF5iKKwhonf2ThqWWOBkLKnojuqYeU1KwPvsAK7Tx5ND4WE/cody_golden.jpg");
        pets.put("cat", "https://www.smithsstationah.com/imagebank/eVetSites/Feline/01.jpg");
        pets.put("rabit", "https://assets.change.org/photos/4/nh/bb/HfNHbbpayJVOjKD-400x400-noPad.jpg?1530422195");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String petName = ((EditText) findViewById(R.id.petName)).getEditableText().toString();
                if (petName.isEmpty()) {
                    return;
                }

                displayPetImage(petName);
            }
        });
    }

    void displayPetImage(String name) {
        String petImage = getPetImageByName(name);
        if (petImage.isEmpty()) {
            return;
        }

        Picasso.get()
                .load(petImage)
                .into(((ImageView) findViewById(R.id.petImage)));
    }

    String getPetImageByName(String name) {
        return pets.get(name);
    }
}
