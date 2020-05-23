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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotificationList extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_notification__list, container, false);
        loadNotification(v);
        return v;
    }

    private void loadNotification(View view) {
        String[] notif={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        String[] title={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};

        ListView listView = view.findViewById(R.id.list1);
        List<Notif> threeStringsList = new ArrayList<>();

        SharedPreferences sharedPref = getActivity().getSharedPreferences("notification1",Context.MODE_PRIVATE);
        int z = sharedPref.getInt("key",0);

        for (int i=1;i<=z+3;i++){
            String y = sharedPref.getString("notify"+i,"");
            String x = sharedPref.getString("notify3"+i,"");
            title[i]=x;
            notif[i]=y;
            Notif notfs = new Notif(y,x);
            threeStringsList.add(notfs);
        }
        NotifAdapter notifAdapter= new NotifAdapter(getActivity(), R.layout.list_items_notification, threeStringsList);
        listView.setAdapter(notifAdapter);

    }
}
