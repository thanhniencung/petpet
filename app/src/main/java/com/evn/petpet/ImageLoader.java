package com.evn.petpet;

import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class ImageLoader {
    public static void load(ImageView target, String imageUrl) {
        if (target == null || imageUrl == null) {
            return;
        }

        if (imageUrl.isEmpty()) {
            return;
        }

        Picasso.get()
                .load(imageUrl)
                .transform(new CircleTransform())
                .memoryPolicy(MemoryPolicy.NO_CACHE,
                        MemoryPolicy.NO_STORE)
                .into(target);
    }

    public static void load(ImageView target, String imageUrl, Callback callback) {
        if (target == null || imageUrl == null) {
            return;
        }

        if (imageUrl.isEmpty()) {
            return;
        }

        if (callback == null) {
            return;
        }

        Picasso.get()
                .load(imageUrl)
                .transform(new CircleTransform())
                .memoryPolicy(MemoryPolicy.NO_CACHE,
                        MemoryPolicy.NO_STORE)
                .into(target, callback);
    }
}
