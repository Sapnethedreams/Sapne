package ngo.sapne.intents.sapne.events;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import ngo.sapne.intents.sapne.R;

/**
 * Created by SUBHADEEP ROY on 21-05-2018.
 */

public class Gridintent extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridintent);
        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);
ImageView v =(ImageView)findViewById(R.id.imga);
        if(getIntent() !=null)
                {
                    String info = getIntent().getStringExtra("info");
                    txtInfo.setText(info);
                }
        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");
        v.setImageResource(pic);

    }
}
