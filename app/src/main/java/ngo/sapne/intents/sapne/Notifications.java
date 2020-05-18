package ngo.sapne.intents.sapne;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = findViewById(R.id.toolbar);
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
        Intent i=new Intent(this,MainFragment.class);
        startActivity(i);
        finish();
    }
}
