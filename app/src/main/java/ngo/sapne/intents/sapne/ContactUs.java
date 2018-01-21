package ngo.sapne.intents.sapne;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class ContactUs extends Fragment {
    Button button2, button4, button3;
    EditText editText5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_us, container, false);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);

        button2 = view.findViewById(R.id.button2);


        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:07023208911"));
                startActivity(intent);
            }

        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "http://www.sapne.org.in/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);            }

        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Your message emailed to Sapne Team", Toast.LENGTH_LONG).show();
            }

        });
        return view;
    }

    public void location(View v) {
        String uri = String.format(Locale.ENGLISH, "https://maps.google.com/maps?daddr=%f,%f(%s)", 28.735615, 77.117572, "Sapne Office");

        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        myIntent.setPackage("com.google.android.apps.maps");
        try {
            startActivity(myIntent);
        } catch (ActivityNotFoundException ex) {
            try {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
            } catch (ActivityNotFoundException anex) {
                Toast.makeText(getActivity(), "please insatll a map application", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void ring(View v) {
        Intent myIntent = new Intent(getActivity(), ringContactUs.class);

        startActivity(myIntent);
    }

    public void twitter(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Sapne07"));
        startActivity(myIntent);
    }

    public void facebook(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Sapnethedreams"));

        startActivity(myIntent);
    }


    public void instagram(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/sapnethedreams/"));
        startActivity(myIntent);
    }

    public void linkedin(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sapnethedreams/"));
        startActivity(myIntent);
    }

    public void youtube(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
        startActivity(myIntent);
    }


}






