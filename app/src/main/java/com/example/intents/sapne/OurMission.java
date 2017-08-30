package com.example.intents.sapne;

import android.os.Bundle;

public class OurMission extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_our_mission);
        getLayoutInflater().inflate(R.layout.activity_our_mission, frameLayout);
    }

}
