package ngo.sapne.intents.sapne;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rohegde on 11/11/17.
 */

public class AboutUsFragment extends android.support.v4.app.Fragment{

    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_about_us, frameLayout);


    }
    */

    //@Override
    public View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_about_us, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        //getLayoutInflater().inflate(R.layout.fragment_about_us, frameLayout);
       // getLayoutInflater().inflate(R.layout.fragment_about_us, null);


    }

}
