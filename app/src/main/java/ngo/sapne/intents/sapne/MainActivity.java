package ngo.sapne.intents.sapne;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import ngo.sapne.intents.sapne.events.ExtraEventsFragment;


public class MainActivity extends Fragment implements View.OnClickListener {

    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        img = view.findViewById(R.id.mainimgview);

        final int[] imageArray = {R.drawable.p1};

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
        } catch (OutOfMemoryError ignored) {
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button explore = getActivity().findViewById(R.id.explore);
        Button btnJoinUs1 = getActivity().findViewById(R.id.btnJoinUs1);
        Button btnSubmit1 = getActivity().findViewById(R.id.btnDonate1);

        explore.setOnClickListener(this);
        btnJoinUs1.setOnClickListener(this);
        btnSubmit1.setOnClickListener(this);
    }

    public void explore(View v) {
        Intent intent = new Intent(getActivity(), ExtraEventsFragment.class);
        startActivity(intent);
    }

    public void donate1(View v) {

        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.payumoney.com/paybypayumoney/#/206415"));
        startActivity(myIntent);

    }

    public void join1(View v) {
        Intent intent = new Intent(getActivity(), JoinUs.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.explore:
                explore(view);
                break;

            case R.id.btnJoinUs1:
                donate1(view);
                break;

            case R.id.btnDonate1:
                join1(view);
                break;
        }
    }
}

