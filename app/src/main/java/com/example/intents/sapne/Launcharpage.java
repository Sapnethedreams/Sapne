package com.example.intents.sapne;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 22/08/2017.
 */

public class Launcharpage extends AppCompatActivity {
Button b1,b2,b3;
ViewPagerAdapter adapter;
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            b1=(Button)findViewById(R.id.explore);
            b2=(Button)findViewById(R.id.btnDonate1);
                b3=(Button)findViewById(R.id.btnJoinUs1);



        viewPager=(ViewPager)findViewById(R.id.viewpager);
        adapter=new ViewPagerAdapter(Launcharpage.this);
        viewPager.setAdapter(adapter);


}
public void donate1(View v)
{
    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sapne.org.in/DonateUs/Donation"));
    startActivity(myIntent);
}

public void join1(View v)
{
    Intent intent=new Intent(getApplicationContext(),JoinUs.class);
    startActivity(intent);




}



}