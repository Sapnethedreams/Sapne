package com.example.intents.sapne;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class EventsActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_events, null, false);
        setContentView(contentView);

        final ViewPager viewPager = (ViewPager) contentView.findViewById(R.id.events_pager);
        viewPager.setAdapter(new CustomTabPagerAdapter(this));
        viewPager.setPageTransformer(false, new ZoomOutPageTransformer());
        viewPager.setOffscreenPageLimit(4);

        ImageButton leftButton = (ImageButton)findViewById(R.id.events_left);
        leftButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int num = viewPager.getCurrentItem();
                if(num > 0){
                    viewPager.setCurrentItem(num - 1, true);
                }
            }
        });

        ImageButton rightButton = (ImageButton)findViewById(R.id.events_right);
        rightButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int num = viewPager.getCurrentItem();
                if(num < 4){
                    viewPager.setCurrentItem(num + 1, true);
               }
            }
        });
    }


    public class CustomTabPagerAdapter extends FragmentPagerAdapter {

        private SparseArray<Fragment> registeredFragments = new SparseArray<>();

        CustomTabPagerAdapter(AppCompatActivity activity) {
            super(activity.getSupportFragmentManager());
        }

        // Register the fragment when the item is instantiated
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            registeredFragments.put(position, fragment);
            return fragment;
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = getRegisteredFragment(position);
            if (fragment == null) {
                switch (position) {
                    case 0:
                        fragment = EventsFrag1.newInstance();
                        break;

                    case 1:
                        fragment = EventsFrag2.newInstance();
                        break;

                    case 2:
                        fragment = EventsFrag3.newInstance();
                        break;

                    case 3:
                        fragment = EventsFrag4.newInstance();
                        break;
                }
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            registeredFragments.remove(position);
            super.destroyItem(container, position, object);
        }

        // Returns the fragment for the position (if instantiated)
        public Fragment getRegisteredFragment(int position) {
            return registeredFragments.get(position);
        }
    }

}
