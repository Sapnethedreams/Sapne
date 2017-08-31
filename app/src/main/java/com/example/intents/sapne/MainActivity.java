package com.example.intents.sapne;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class MainActivity extends BaseActivity {

    public Button btnJoinUs1, btnSubmit1, explore;
    ViewPagerAdapter adapter;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_main);
        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/Roboto-Regular.ttf").setFontAttrId(R.attr.fontPath).build());

        // toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        explore = (Button) findViewById(R.id.explore);
        btnJoinUs1 = (Button) findViewById(R.id.btnJoinUs1);
        btnSubmit1 = (Button) findViewById(R.id.btnDonate1);

    /*  btnJoinUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),JoinUs.class);
                startActivity(intent);
            }
        });
*/
    }

    public void explore(View v) {
        Intent intent = new Intent(getApplicationContext(), NewFrag.class);
        startActivity(intent);
    }

    public void donate1(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.payumoney.com/paybypayumoney/#/206415"));
        startActivity(myIntent);
    }

    public void join1(View v) {
        Intent intent = new Intent(getApplicationContext(), JoinUs.class);
        startActivity(intent);
    }


}

