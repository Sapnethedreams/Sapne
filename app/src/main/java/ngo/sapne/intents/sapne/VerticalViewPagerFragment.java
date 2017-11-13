package ngo.sapne.intents.sapne;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class VerticalViewPagerFragment extends android.support.v4.app.Fragment {

    VerticalViewPager ViewPager;
    Context mContext;

    public VerticalViewPagerFragment()
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
    public static VerticalViewPagerFragment newInstance()
    {
        VerticalViewPagerFragment fragment=new VerticalViewPagerFragment();
        return fragment;
    }
}