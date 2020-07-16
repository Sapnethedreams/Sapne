package ngo.sapne.intents.sapne;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel=new NotificationChannel("notification","notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=(NotificationManager)getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);


        }
    }

    public void update(View v)
    {
        Intent intent= new Intent(Notifications.this,Updates.class);
        startActivity(intent);
    }

    public void invitation(View v)
    {
        Intent intent= new Intent(Notifications.this,Invitations.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(this,MainFragment.class);
        startActivity(i);
        finish();
    }
}
