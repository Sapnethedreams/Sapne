
package com.example.intents.sapne;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JoinUs extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener  {

    EditText etAddress,etName,etPhoneNumber,etEmail,etAadhar,etOffice;
    Button btnSubmit;
    Spinner spnJoin;
    RadioGroup rgSex;

    
    GoogleApiClient mLocationClient;
    Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_us);
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();

        
        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this);
        builder.addApi(LocationServices.API);
        builder.addConnectionCallbacks(this);
        builder.addOnConnectionFailedListener(this);
        mLocationClient = builder.build();
        
        etName= (EditText) findViewById(R.id.etName);
        etPhoneNumber= (EditText) findViewById(R.id.etPhoneNumber);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etAddress= (EditText) findViewById(R.id.etAddress);
        etAadhar= (EditText) findViewById(R.id.etAadhar);
        etOffice= (EditText) findViewById(R.id.etOffice);
        btnSubmit= (Button) findViewById(R.id.btnSubmit);
        spnJoin= (Spinner) findViewById(R.id.spnJoin);
        rgSex= (RadioGroup) findViewById(R.id.rgSex);

        final ArrayList<String> joinusas=new ArrayList<>();
        joinusas.add("Intern");
        joinusas.add("Volunteer");
        joinusas.add("Donor");
        joinusas.add("Supporter");


        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,joinusas);

        spnJoin.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String phone = etPhoneNumber.getText().toString();
                final String email = etEmail.getText().toString();
                String gender = rgSex.getCheckedRadioButtonId() == R.id.rbMale ? "Male" : "Female";
                //String batch = etAddress.getText().toString();
                String sub = joinusas.get(spnJoin.getSelectedItemPosition());
                String aadhar = etAadhar.getText().toString();
                String address = etAddress.getText().toString();
                String office = etOffice.getText().toString();
                if (name.length() == 0) {
                    Toast.makeText(getApplication(), "Name Empty", Toast.LENGTH_LONG).show();
                    etName.requestFocus();
                    return;
                }
                if (phone.length() != 10) {
                    Toast.makeText(getApplicationContext(), "Phone Number Empty", Toast.LENGTH_SHORT).show();
                    etPhoneNumber.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();
                    etEmail.requestFocus();
                    return;
                }
                if (address.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter Address", Toast.LENGTH_SHORT).show();
                    etAddress.requestFocus();
                    return;
                }

                if (office.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter Office/Institute", Toast.LENGTH_SHORT).show();
                    etOffice.requestFocus();
                    return;
                }
                if (aadhar.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Aadhar No. Empty", Toast.LENGTH_SHORT).show();
                    etAadhar.requestFocus();
                    return;
                }
                final String msg = "Name:" + name + "\nPhone Number:" + phone + "\nEmail:" + email + "\nGender:" + gender + "\nAddress:" + address + "\nOffice/Institute:" + office + "\nAadhar No.:" + aadhar + "\nJoining As:" + sub;

                new Thread(new Runnable() {

                    public void run() {

                        try {

                            Gmailsender sender = new Gmailsender(

                                    "sapneapp@gmail.com",

                                    "sapne@delhi");



                           // sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

                            sender.sendMail("Joined form details", msg,

                                    email,

                                    "sapneapp@gmail.com");



                            Toast.makeText(getApplicationContext(),"Submitted Successfully...",Toast.LENGTH_LONG).show();





                        } catch (Exception e) {

                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();



                        }

                    }

                }).start();

            }
            });


    }
    
    //For Location Detection

    @Override
    protected void onStart() {
        super.onStart();
        if (mLocationClient != null) {
            mLocationClient.connect();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[] {
                        android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.INTERNET
                },10);
            }
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mLocationClient);
        if(mLastLocation!=null)
        {
            double latitude=mLastLocation.getLatitude();
            double longitude=mLastLocation.getLongitude();


            Geocoder geocoder=new Geocoder(this, Locale.ENGLISH);
            try
            {
                List<Address> addresses=geocoder.getFromLocation(latitude,longitude,1);
                if (addresses!=null)
                {

                    android.location.Address fetchedAddress=addresses.get(0);
                    etAddress.setText(fetchedAddress.getFeatureName()+","+fetchedAddress.getSubLocality()+","+fetchedAddress.getLocality()+"-"+fetchedAddress.getPostalCode()+","+fetchedAddress.getAdminArea()+","+fetchedAddress.getCountryName());

                }
                else
                    etAddress.setText("No Location Found");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    Toast.makeText(getApplicationContext(),"Connection Failed",Toast.LENGTH_LONG).show();
    }


    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(getApplicationContext(),"Connection Suspended",Toast.LENGTH_LONG).show();
    }

}


