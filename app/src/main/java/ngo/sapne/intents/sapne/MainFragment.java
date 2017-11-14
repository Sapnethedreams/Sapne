package ngo.sapne.intents.sapne;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Prachi on 11/13/2017.
 */

public class MainFragment extends Fragment {
    public Button btnJoinUs1, btnSubmit1, explore;
    ImageView img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_main, container, false);

        img = (ImageView)view.findViewById(R.id.mainimgview);
        explore=(Button)view.findViewById(R.id.explore);
        btnJoinUs1= (Button)view.findViewById(R.id.btnJoinUs1);
        btnSubmit1= (Button)view.findViewById(R.id.btnDonate1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/Roboto-Regular.ttf").setFontAttrId(R.attr.fontPath).build());

        final int []imageArray={R.drawable.p11,R.drawable.p12,R.drawable.p3,R.drawable.p13,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p5,R.drawable.p14,R.drawable.p1};

        try {
            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                int i = 0;

                public void run() {
                    img.setImageResource(imageArray[i]);
                    i++;
                    if (i > imageArray.length - 1) {
                        i = 0;
                    }
                    handler.postDelayed(this, 4000);  //for interval...
                }
            };
            handler.postDelayed(runnable, 25); //for initial delay..
        } catch (OutOfMemoryError ignored){}
    }

    public void explore(View v) {

        Intent intent=new Intent(getActivity().getApplicationContext(),EventsExtraActivity.class);
        startActivity(intent);
    }

    public void donate1(View v) {

        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.payumoney.com/paybypayumoney/#/206415"));
        startActivity(myIntent);
    }

    public void join1(View v) {
        Intent intent=new Intent(getActivity().getApplicationContext(),JoinUs.class);
        startActivity(intent);
    }
}
