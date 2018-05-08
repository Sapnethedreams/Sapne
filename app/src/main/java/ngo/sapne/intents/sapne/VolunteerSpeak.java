package ngo.sapne.intents.sapne;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 *  Created by itsmeemohit on 30-11-2017.
 */

public class VolunteerSpeak extends android.support.v4.app.Fragment {

    String color_names[] = {"Suprabhat Das\nGraphic Designer\nMy experience with the SAPNE family has been incredible.The members are extremely co-operative and supportive.Being a novice in the field,I used to have a lot of queries but they were always there to help me out.I learnt to work under a stipulated time frame and always tried to give my best.\n\nAfter my long association" +
            "with this organisation, the people and the kids feels like my own family more than friends.Every time, I get oppurtunity to serve,I do it with 100% effort.Overall,this is one of the best organisation,I have been associated with so far.\n\nI am PROUD member of SAPNE family.", "Vaibhav Bisht(Intellectual Property Associate at LakshmiSri Attorneys)\n'Head of Digital Marketing/Management'\n at Sapne\n" +
            "\nIt is rare that you get an oppurtunity to work in an enviornment where your creativity is respected and your efforts received with genuine accolades. SAPNE is one such organisation where everyone, irrespective of their designation, is treated equally and has a chance to make their voice heard.\n\nDuring the past one year I've seen this organisation grow from a small dilapidated room to having four operational centres in three cities,thereby bringing a vast umbrella of youth within its reach.Despite rapid expansion, I find it incredible that the rapid expansion,I find it uncredible that the" +
            "organization continues to provide the same homely feeling to all its volunteers as it did during its founding months\n\n I wish the Team Members of SAPNE all the very best for the upcoming 2017 and hope that we continue to stride towards our common goal for the betterment of the socity.", "*Volunteer's Voice*\nBeing an intern at Sapne was an amazing experience. I can feel a positive change in myself,both personally and professionally.Being a social media intern, my way of looking at things has broadened.Moreover, it is an NGO, I, of course got a lot to learn from the works of people which highly contribute towards making a healthy society.It has made me towards making a healthy society.It has made me a more optimistic person.In addition to " +
            "that, the Sapne team is more like a family having the same goal. I loved a part of it.\n\n-Alankrita Shah(B.Tech Student,IIIT Bhubaneshwar)\n*Social Media Intern at Sapne*"};
    Integer image_id[] = {R.drawable.sp1, R.drawable.sp2, R.drawable.sp3};
    Context context;
    ListView lv;
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LayoutInflater inflater = (LayoutInflater)
          //      context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View single_row = inflater.inflate(R.layout.activity_volunteer_speak, null,
            //    true);

        setContentView(R.layout.activity_volunteer_speak);
        CustomListAdapter adapter=new CustomListAdapter(this,image_id,color_names);
        ListView lv=findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }
*/

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_volunteer_speak,container,false);

        CustomListAdapter adapter=new CustomListAdapter(this.getActivity(),image_id,color_names);
        lv= v.findViewById(R.id.listView);
        lv.setAdapter(adapter);
        return v;
    }
}
