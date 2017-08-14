package com.example.intents.sapne;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Adapter2 extends RecyclerView.Adapter<Myholder_stories> {

    Context c;
    String[] Member;
    String[]dates;
    String[]desc;
    int[] imgss;

    public Adapter2(Context ctx, String[] names, String[] date,String[] desc,int[] images)
    {

        this.c=ctx;
        this.Member=names;
        this.dates=date;
        this.desc=desc;
        this.imgss=images;
    }

    @Override
    public Myholder_stories onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.successstories,null);

        Myholder_stories holder1=new Myholder_stories(v);
        return holder1;
    }

    @Override
    public void onBindViewHolder(Myholder_stories holder1, final int position) {

        holder1.nameTxt1.setText(Member[position]);
        holder1.DateTxt.setText(dates[position]);
        holder1.DetailsTxt.setText(desc[position]);
        holder1.img.setImageResource(imgss[position]);

    }

    @Override
    public int getItemCount() {

        return Member.length;
    }
}
