package ngo.sapne.intents.sapne;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import ngo.sapne.intents.sapne.events.ExtraEventsFragment;


public class MainFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        img = view.findViewById(R.id.mainimgview);

        final int[] imageArray = {R.drawable.p8, R.drawable.p5, R.drawable.p1, R.drawable.p3, R.drawable.p11, R.drawable.p12, R.drawable.p7};

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
        Button btnJoinUs = getActivity().findViewById(R.id.btnJoinUs1);
        Button btnSubmit = getActivity().findViewById(R.id.btnDonate1);

        explore.setOnClickListener(this);
        btnJoinUs.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        getActivity().findViewById(R.id.appBarAnim).setBackgroundColor(Color.parseColor("#1DE9B6"));
    }

    public void explore() {
        getActivity().getSupportFragmentManager().
                beginTransaction().
                replace(R.id.content_frame, new ExtraEventsFragment(), "ExtraEventsFragment")
                .commit();
    }


    public void donate() {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.payumoney.com/paybypayumoney/#/206415"));
        startActivity(myIntent);
    }

    public void join() {
        getActivity().getSupportFragmentManager().
                beginTransaction().
                replace(R.id.content_frame, new FragmentJoinUs(), "FragmentJoinUs")
                .commit();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.explore:
                explore();
                break;

            case R.id.btnJoinUs1:
                join();
                break;

            case R.id.btnDonate1:
                donate();
                break;
        }
    }

    @Override
    public void onDestroy() {
        getActivity().findViewById(R.id.appBarAnim).setBackgroundResource(R.drawable.gradient_green);
        super.onDestroy();
    }
}

