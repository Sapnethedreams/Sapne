package com.example.android.kaka;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                case 0: return FirstFragment.newInstance("Suprabhat Das");
                case 1: return SecondFragment.newInstance("NIKITA GUPTA");
                case 2: return ThirdFragment.newInstance("Alankrita Shah");
                case 3: return FourthFragment.newInstance("Vibhav Bisht");
                default: return FourthFragment.newInstance("Vibhav Bisht");
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
