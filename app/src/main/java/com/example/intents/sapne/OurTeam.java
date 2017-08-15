package com.example.intents.sapne;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

public class OurTeam extends MainActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_our_team, null, false);
        mDrawerLayout.addView(contentView, 0);

        ImageButton fbButton = (ImageButton) contentView.findViewById(R.id.devesh_fb);
        ImageButton instaButton = (ImageButton) contentView.findViewById(R.id.devesh_insta);

        fbButton.setOnClickListener(this);
        instaButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

         switch (v.getId()) {
             case R.id.devesh_fb:
                 String urlfb = "https://www.facebook.com/devesh.mittal.50";
                 Intent i = new Intent(Intent.ACTION_VIEW);
                 i.setData(Uri.parse(urlfb));
                 startActivity(i);
                 break;

             case R.id.devesh_insta:
                 String urlintsa = "https://www.instagram.com/devesh.mittal.50";
                 Intent i1 = new Intent(Intent.ACTION_VIEW);
                 i1.setData(Uri.parse(urlintsa));
                 startActivity(i1);
                 break;
         }
    }
}
