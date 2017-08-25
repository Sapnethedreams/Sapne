package com.example.intents.sapne;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by work on 8/24/2017.
 */

public class splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e){
                      e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
