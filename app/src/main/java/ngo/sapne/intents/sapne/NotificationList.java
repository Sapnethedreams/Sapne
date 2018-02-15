package ngo.sapne.intents.sapne;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NotificationList extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_notification__list);
        loadNotification();

    }
    private void loadNotification() {
        String[] notif={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        ListView listView = (ListView)findViewById(R.id.list1);
        List<Notif> threeStringsList = new ArrayList<>();

        SharedPreferences sharedPref = getSharedPreferences("notification1",Context.MODE_PRIVATE);
        int z = sharedPref.getInt("key",0);

        for (int i=1;i<z;i++){
            String y = sharedPref.getString("notify"+i,"");
            notif[i]=y;
            Notif notfs = new Notif(y);
            threeStringsList.add(notfs);


        }
        NotifAdapter notifAdapter= new NotifAdapter(this, R.layout.list_items_notification, threeStringsList);
        listView.setAdapter(notifAdapter);

    }
}