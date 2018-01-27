package ngo.sapne.intents.sapne;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Notification_List extends AppCompatActivity {

    Toolbar toolbar;
    ListView lv_notification;


    Notification_list_adapter list_adapter;
    String[] notification_t = new String[] { "Notification1",
            "title 2",
            "title 3",
            "titile 4",
            "title5",
            "title6",
            "titile7",
            "title8",
            "ttile 9"
    };

    String[] notification_b = new String[] { "This is the first notification to sapne users",
            "noti 2",
            "noti 3",
            "noti 4",
            "noti 5",
            "noti 6",
            "noti 7",
            "noit 8",
            "noit 9"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_list);

        init();
        lv_notification.setAdapter(list_adapter);


    }

    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Notifications");
        list_adapter = new Notification_list_adapter(this,notification_t,notification_b);
        lv_notification = (ListView) findViewById(R.id.notification_listview);
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
