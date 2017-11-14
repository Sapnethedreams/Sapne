package ngo.sapne.intents.sapne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class OurVolunteers extends BaseActivity {
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_our_volunteer);
        getLayoutInflater().inflate(R.layout.activity_our_volunteer, frameLayout);
        int[] iamges={R.drawable.ss1,R.drawable.ss2,R.drawable.ss3};
    }
    public void vol(View view){
        Intent intent=new Intent(OurVolunteers.this,AllVolunteers.class);
        startActivity(intent);
    }


}
