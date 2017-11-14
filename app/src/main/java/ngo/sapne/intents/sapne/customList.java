package ngo.sapne.intents.sapne;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by work on 8/21/2017.
 */
public class customList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public customList(Activity context,
                      String[] web, Integer[] imageId) {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }

    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single,null,true);
        TextView textView =(TextView)rowView.findViewById(R.id.txt);
        ImageView imageView =(ImageView)rowView.findViewById(R.id.img);
        TextView txtTitle= (TextView)rowView.findViewById(R.id.txt);
        txtTitle.setText(web[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;

    }
    }


