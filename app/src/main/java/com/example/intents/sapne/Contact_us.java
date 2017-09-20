package com.example.intents.sapne;


        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

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
        Intent myIntent = new Intent(Contact_us.this, Location_contact_us.class);
        startActivity(myIntent);
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
    public void youtubr(View v)
    {
        Intent myIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com"));

    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}






