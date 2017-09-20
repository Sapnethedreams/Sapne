package com.example.intents.sapne;

import android.content.Intent;
import android.os.Bundle;

public class Updates extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_updates);
        getLayoutInflater().inflate(R.layout.activity_updates, frameLayout);
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
