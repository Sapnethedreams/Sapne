package ngo.sapne.intents.sapne;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SuccessStoriesFrag extends android.support.v4.app.Fragment {

    VerticalViewPager ViewPager;
    Context mContext;

    public SuccessStoriesFrag()
    {

    }
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.success_stories_fragment, container, false);
            ViewPager = view.findViewById(R.id.viewpager8);
            ViewPager.setAdapter(new VerticalPagerAdapter(mContext));

            return view;

    }

    public static SuccessStoriesFrag newInstance()
    {
        SuccessStoriesFrag fragment=new SuccessStoriesFrag();
        return fragment;
    }
}