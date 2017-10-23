package ngo.sapne.intents.sapne;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        
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
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
