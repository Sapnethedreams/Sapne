package ngo.sapne.intents.sapne;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Naruto on 2/14/2018.
 */

public class NotifAdapter extends ArrayAdapter<Notif> {
    private int resource;
    public NotifAdapter(@NonNull Context context, int resource, List<Notif> notif) {
        super(context, resource,notif);
        this.resource=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(resource, null);
        }

        Notif notif = getItem(position);

        if (notif != null) {
            TextView leftTextView = view.findViewById(R.id.txtNotif);
            TextView rightTextView = view.findViewById(R.id.txtTitle);

            leftTextView.setText(notif.getNotif());
            rightTextView.setText(notif.getTitle());
        }

        return view;
    }
}

