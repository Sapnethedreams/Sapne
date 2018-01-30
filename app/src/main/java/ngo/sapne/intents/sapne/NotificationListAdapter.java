package ngo.sapne.intents.sapne;

/**
 * Created by Anshul on 26/01/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NotificationListAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    String[] title;
    Context context;
    String[] body;

    public NotificationListAdapter(Context context, String[] noti_title_list, String[] noti_body_list) {
// TODO Auto-generated constructor stub
        title = noti_title_list;
        this.context = context;
        body = noti_body_list;
        inflater = (LayoutInflater) this.context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
// TODO Auto-generated method stub
        return title.length;
    }

    @Override
    public Object getItem(int position) {
// TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
// TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub
        Holder holder = new Holder();
        View view;
        view = inflater.inflate(R.layout.cardview_notification_list, null);

        holder.notification_title = view.findViewById(R.id.notification_title);
        holder.notification_body = view.findViewById(R.id.notification_body);

        holder.notification_title.setText(title[position]);
        holder.notification_body.setText(body[position]);


        return view;
    }

    public class Holder {
        TextView notification_title;
        TextView notification_body;
    }

}



