package ngo.sapne.intents.sapne;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 10/11/2017.
 */

public class VerticalViewPagerActivity extends android.support.v4.app.Fragment {

    VerticalViewPager ViewPager;
    Context mContext;

    public VerticalViewPagerActivity()
    {

    }
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.activities1, container, false);
            ViewPager = (VerticalViewPager) view.findViewById(R.id.viewpager8);
            ViewPager.setAdapter(new VerticalPagerAdapter(mContext));

            return view;

    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        mContext=context;
    }
    public static VerticalViewPagerActivity newInstance()
    {
        VerticalViewPagerActivity fragment=new VerticalViewPagerActivity();
        return fragment;
    }
}