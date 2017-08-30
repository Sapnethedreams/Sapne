package com.example.intents.sapne;

import android.os.Bundle;

public class Updates extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_updates);
        getLayoutInflater().inflate(R.layout.activity_updates, frameLayout);
    }
}
