package com.example.intents.sapne;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.entities.ZColor;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_sapne);

        ZGallery.with(this, new ArrayList<String>() {{
            add(Uri.parse("android.resource://com.example.intents.sapne/" + R.drawable.e1).toString());
            add(Uri.parse("android.resource://com.example.intents.sapne/" + R.drawable.e2).toString());
            add(Uri.parse("android.resource://com.example.intents.sapne/" + R.drawable.e3).toString());
        }}).setToolbarTitleColor(ZColor.WHITE) // toolbar title color
                .setGalleryBackgroundColor(ZColor.BLACK) // activity background color
                .setToolbarColorResId(R.color.colorPrimary) // toolbar color
                .setTitle("Gallery") // toolbar title
                .show();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
