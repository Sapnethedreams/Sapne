package com.example.intents.sapne;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SuccessStory extends BaseActivity {

String names[]={"Sapna","Ajay","Manpreet"};
 String date[]={"Joined on 8th June'16","Joined on 3rd June'16","Joined on 28th June'16"
 };
 String desc[]={"Her name is Sapna, a young girl who recently migrated to Delhi from Nepal, along with her parents. The first few months in Delhi were tough. Having little knowledge of Hindi, the common language, Sapna struggled to communicate with other kids of her dilapidated locality in Delhi. But not only does she share her name with our organisation, she shares SAPNE's grit and determination as well! Since the past three months, Sapna's been working diligently on her Hindi under the guidance of tutors provided by SAPNE. Her hardwork seems to be paying off and she can now converse and play with her friends with relative ease. During one of the career counselling sessions organised by SAPNE at her locality, Sapna shared her dream of becoming a doctor when she grows up. \"I want to help the needy\" she says with her trademark adorable smile. Help her fulfil her dreams.","AJAY, a 26 year old boy suffering from EPILEPSY,a neurological disorder. He is a man of great inspiration for all of us. Ajay is so keen to get himself educated like all the other children. His innocence,dedication and hard work will not let him down. Despite of facing the major problems he has in his life,his struggle fades all the other things that hinders the path of learning. He has that zeal to attain good and achieve best. We are very much involved into him by supporting his efforts. Are you? Help us so that we could provide him the best he wants.","Manpreet, despite belonging to a underprivileged section of the society is an integral part of SAPNE family and is no less than any of the so-called “rich children”. But due to some social and economic barriers, her dreams are somehow being neglected. She wants to adore her life and aspires to be a successful and respected teacher. Though, she has some learning disabilities and speech defects but, due to this, her dreams should not be shattered. So, we, with the help of our special educators are teaching her through the play-way method and hence she is edging towards her dreams."};
  int images[]={R.drawable.n1,R.drawable.n2,R.drawable.n3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activities1);
        getLayoutInflater().inflate(R.layout.activities1, frameLayout);
        RecyclerView rv1= (RecyclerView) findViewById(R.id.myRecycler1);
        //SET LAYOUT
        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv1.setItemAnimator(new DefaultItemAnimator());
        //ADAPTER
        Adapter2 adapter=new Adapter2(this,names,date,desc,images);
        rv1.setAdapter(adapter);

    }

    @Override protected void attachBaseContext(Context newBase) {super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase)); }




}







