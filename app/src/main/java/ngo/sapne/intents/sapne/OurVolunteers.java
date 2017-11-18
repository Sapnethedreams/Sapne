package ngo.sapne.intents.sapne;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class OurVolunteers extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_our_volunteer, container, false);
    }

    public void vol(View view) {
        Intent intent = new Intent(getActivity(), AllVolunteers.class);
        startActivity(intent);
    }


}
