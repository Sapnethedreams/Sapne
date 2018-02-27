package ngo.sapne.intents.sapne;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class locationContactUs extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.location_activity, container);
        return view;
    }

    public void loc(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/place/Sector+16,+Rohini,+Delhi/@28.7332172,77.1114405,15z/data=!3m1!4b1!4m5!3m4!1s0x390d013da1e0d339:0x538f564961b603e8!8m2!3d28.7354495!4d77.117477"));
        startActivity(myIntent);
    }
}

