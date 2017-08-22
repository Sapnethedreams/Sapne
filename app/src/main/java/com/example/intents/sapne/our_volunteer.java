package com.example.intents.sapne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class our_volunteer extends AppCompatActivity {
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_volunteer);
        int[] iamges={R.drawable.ss1,R.drawable.ss2,R.drawable.ss3};
    }
    public void vol(View view){
        Intent intent=new Intent(our_volunteer.this,all_volunteer.class);
        startActivity(intent);
    }


}
