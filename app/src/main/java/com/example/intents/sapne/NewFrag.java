package com.example.intents.sapne;

/**
 * Created by user on 25/08/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class NewFrag extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newfrag_layout);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return FirstFragment.newInstance("PLAYGROUND");
                case 1: return SecondFragment.newInstance("LEARNING");
                case 2: return ThirdFragment.newInstance("SKILL DEVELOPMENT");
                case 3: return FourthFragment.newInstance("ACTIVITIES");
                default: return FirstFragment.newInstance("PLAYGROUND");
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}