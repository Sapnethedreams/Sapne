package ngo.sapne.intents.sapne;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OurVolunteers extends Fragment{
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_our_volunteer, container, false);

        Button button = view.findViewById(R.id.vol_bn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearSectionedRecyclerViewVertical();
            }
        });
        return view;
    }

    public void linearSectionedRecyclerViewVertical() {
        startRecyclerViewActivity();
    }

    private void startRecyclerViewActivity() {
        getActivity().getSupportFragmentManager().
                beginTransaction().
                replace(R.id.content_frame, new RecyclerViewFragment(), "RecyclerViewFragment")
                .commit();
    }




}
