package com.example.intents.sapne;

import android.content.ActivityNotFoundException;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.util.Locale;

public class Contact_us extends     BaseActivity {
    Button button2,button4,button3;
    EditText editText5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.contact_us);
        getLayoutInflater().inflate(R.layout.contact_us, frameLayout);
        button3=(Button)findViewById(R.id.button2);
        button4=(Button)findViewById(R.id.button2);

        button2=(Button)findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your message emailed to Sapne Team", Toast.LENGTH_LONG).show();
            }

        });
    }


       public void location(View v) {
        String uri=String.format(Locale.ENGLISH,"https://maps.google.com/maps?daddr=%f,%f(%s)",28.735615,77.117572,"Sapne Office");

        Intent myIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
        myIntent.setPackage("com.google.android.apps.maps");
        try {
            startActivity(myIntent);
        }
        catch (ActivityNotFoundException ex){
            try {
                Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
                startActivity(i);
            }catch (ActivityNotFoundException anex)
            {
                Toast.makeText(this,"please insatll a map application",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void ring(View v) {
        Intent myIntent = new Intent(Contact_us.this, Ring_contact_us.class);

        startActivity(myIntent);
    }
    public void twitter(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Sapne07"));
        startActivity(myIntent);
    }
    public void facebook(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Sapnethedreams"));

        startActivity(myIntent);
    }


    public void instagram(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/sapnethedreams/"));
        startActivity(myIntent);
    }

    public void linkedin(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sapnethedreams/"));
        startActivity(myIntent);
    }
    public void youtube(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com"));
         startActivity(myIntent);
    }

    
}






