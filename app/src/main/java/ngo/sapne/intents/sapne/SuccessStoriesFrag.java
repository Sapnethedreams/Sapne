package ngo.sapne.intents.sapne;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class SuccessStoriesFrag extends android.support.v4.app.Fragment {

    VerticalViewPager ViewPager;

    public SuccessStoriesFrag()
    {

    }
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.success_stories_fragment, container, false);
            ViewPager = view.findViewById(R.id.viewpager8);
            ViewPager.setAdapter(new VerticalPagerAdapter(getActivity()));
            Toast.makeText(getActivity(),"Swipe Up",Toast.LENGTH_LONG).show();
            return view;
    }

    public static SuccessStoriesFrag newInstance()
    {
        SuccessStoriesFrag fragment = new SuccessStoriesFrag();
        return fragment;
    }
}