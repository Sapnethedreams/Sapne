package ngo.sapne.intents.sapne;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rohegde on 11/11/17.
 */

public class OurMissionFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_our_mission, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        // setContentView(R.layout.activity_our_mission);
        //getLayoutInflater().inflate(R.layout.activity_our_mission, frameLayout);
        getLayoutInflater().inflate(R.layout.activity_our_mission, null);

    }
}
