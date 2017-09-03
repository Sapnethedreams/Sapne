package com.example.intents.sapne;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by user on 22/08/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {



    private int[] image_resources={R.drawable.e1,R.drawable.e2,R.drawable.e3,R.drawable.e4};
    private Context ctx;
    private LayoutInflater inflate;

public ViewPagerAdapter(Context ctx)
{
    this.ctx=ctx;

}
    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(LinearLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      inflate=(LayoutInflater)ctx.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview=inflate.inflate(R.layout.viewpager_item,container,false);
        ImageView img;
        img=(ImageView)itemview.findViewById(R.id.imgview);
        img.setImageResource(image_resources[position]);



        container.addView(itemview);
        return itemview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout)object);
    }
}
