package com.example.intents.sapne;

import android.content.Intent;
import android.os.Bundle;

public class OurVision extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_our_vision);
        getLayoutInflater().inflate(R.layout.activity_our_vision, frameLayout);
    }
   
}
