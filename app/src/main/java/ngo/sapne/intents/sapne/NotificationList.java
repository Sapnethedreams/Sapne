package ngo.sapne.intents.sapne;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class NotificationList extends Fragment {

    Toolbar toolbar;
    ListView lv_notification;


    NotificationListAdapter list_adapter;
    String[] notification_t = new String[] { "Sapne turns 2",
            "Ayaam",
            "Donate Us",
            "Mayor's Birthday",
            "Cultural Fest",
            "Happy New Year",
            "Cleaning Drive",
            "Active volunteers needed",
            "Sapne ki Paathshala",
            "Join Sapne"
    };

    String[] notification_b = new String[] { "Celebrating Sapne's birthday this weekend.",
            "The biggest event by Sapne comes on Jan 28th.",
            "Give a child the gift of education.",
            "Celebration of our Mayor's Birthday by Spane",
            "Be a beacon of hope this year.",
            "Celebrate new year with a resolution to help children.",
            "Come take part in Swacch Bharat Abhiyan with us.",
            "Volunteers needed for Sapne's next event. Certifications will be provided.",
            "We organised a regular camp to teach students. Come join our team.",
            "A single dream is powerful than a thousand realities. Help us fulfil that."
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_notification_list, container, false);

        init(view);
        lv_notification.setAdapter(list_adapter);
        return view;
    }

    private void init(View view) {

        list_adapter = new NotificationListAdapter(getActivity(), notification_t,notification_b);
        lv_notification = (ListView) view.findViewById(R.id.notification_listview);
    }

   //@Override
   // public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
     //  getMenuInflater().inflate(R.menu.menu_main, menu);
       // return true;
   // }

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
      //  int id = item.getItemId();

//noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
       // }

       // return super.onOptionsItemSelected(item);
    //}
}
