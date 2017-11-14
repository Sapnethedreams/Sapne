package ngo.sapne.intents.sapne;

import android.os.Bundle;

public class AllVolunteers extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_all_volunteer, frameLayout);
    }
}
