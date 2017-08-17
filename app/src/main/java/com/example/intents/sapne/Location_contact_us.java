package com.example.intents.sapne;

        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class Location_contact_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_activity);
    }
    public void loc(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/place/Sector+16,+Rohini,+Delhi/@28.7332172,77.1114405,15z/data=!3m1!4b1!4m5!3m4!1s0x390d013da1e0d339:0x538f564961b603e8!8m2!3d28.7354495!4d77.117477"));

        startActivity(myIntent);
    }
}

