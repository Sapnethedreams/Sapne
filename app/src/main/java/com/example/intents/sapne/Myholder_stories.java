package com.example.intents.sapne;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Myholder_stories extends RecyclerView.ViewHolder {
    //VIEWS
    ImageView img;
    TextView nameTxt1;
    TextView DateTxt;
    TextView DetailsTxt;

    public Myholder_stories(View itemView1) {
        super(itemView1);
        //ASSIGNING VIEWS
        img = (ImageView) itemView1.findViewById(R.id.playerImage1);
        nameTxt1 = (TextView) itemView1.findViewById(R.id.nameTxt1);
        DateTxt = (TextView) itemView1.findViewById(R.id.dateTxt);
        DetailsTxt = (TextView) itemView1.findViewById(R.id.DetailTxt);

    }
}