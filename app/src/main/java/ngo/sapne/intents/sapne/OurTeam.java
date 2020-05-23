package ngo.sapne.intents.sapne;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class OurTeam extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_our_team, container);

        ImageButton fbButton = view.findViewById(R.id.devesh_fb);
        ImageButton instaButton = view.findViewById(R.id.devesh_insta);

        fbButton.setOnClickListener(this);
        instaButton.setOnClickListener(this);

        return view;
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
