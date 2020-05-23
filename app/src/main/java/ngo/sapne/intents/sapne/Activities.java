package ngo.sapne.intents.sapne;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Activities extends Fragment {

    ActivitiesAdapter adapter;
ViewPager activity_slider;

ImageButton leftNav;
ImageButton rightNav;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activities, container, false);
        activity_slider = view.findViewById(R.id.activity_slider);
        adapter = new ActivitiesAdapter( getActivity());
        activity_slider.setAdapter(adapter);
        leftNav = view.findViewById(R.id.left_nav);
        rightNav = view.findViewById(R.id.right_nav);
//        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
//
//        leftNav = (ImageButton) view.findViewById(R.id.left_nav);
//        rightNav = (ImageButton) view.findViewById(R.id.right_nav);

// Images left navigation
        leftNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = activity_slider.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    activity_slider.setCurrentItem(tab);
                } else if (tab == 0) {
                    activity_slider.setCurrentItem(tab);
                }
            }
        });

        // Images right navigatin
        rightNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = activity_slider.getCurrentItem();
                tab++;
                activity_slider.setCurrentItem(tab);
            }
        });

//        RecyclerView rv = view.findViewById(R.id.myRecycler);
     /*   //SET LAYOUT
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setItemAnimator(new DefaultItemAnimator());
        //ADAPTER
        MyAdapter adapter = new MyAdapter(getActivity(), names, images);
        rv.setAdapter(adapter);*/
        return view;
    }

}
