package ngo.sapne.intents.sapne;

import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;

import ngo.sapne.intents.sapne.util.Gmailsender;

public class SapneCare extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    Button send_button;
    EditText description_et;
    EditText no_et;
    EditText depart_et;
    EditText pos_et;
    EditText name_et;
    ProgressDialog progressDialog;
    GoogleApiClient mLocationClient;
    Location mLastLocation;
    Spinner spnjoin;





    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sapne_care, container, false);

        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(getActivity());
        builder.addApi(LocationServices.API);
        builder.addConnectionCallbacks(this);
        builder.addOnConnectionFailedListener(this);
        mLocationClient = builder.build();

        name_et= view.findViewById(R.id.name_et);
        depart_et= view.findViewById(R.id.depart_et);
        no_et= view.findViewById(R.id.no_et);
        description_et= view.findViewById(R.id.description_et);
        send_button= view.findViewById(R.id.care_button);
        progressDialog = new ProgressDialog(getActivity());
        spnjoin= view.findViewById(R.id.spnJoin);



        final ArrayList<String> joinusas = new ArrayList<>();
        joinusas.add("Intern");
        joinusas.add("Volunteer");


        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, joinusas);

        spnjoin.setAdapter(adapter);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String intStr="^[0-9*$]";
                final String name= name_et.getText().toString();
                String sub = joinusas.get(spnjoin.getSelectedItemPosition());
                String department= depart_et.getText().toString();
                String number=no_et.getText().toString();
                String Description=description_et.getText().toString();

                if (name.length() == 0) {
                    Toast.makeText(getActivity(), "Name Empty", Toast.LENGTH_LONG).show();
                    name_et.requestFocus();
                    return;
                }
 //               if (number.length() != 10) {
 //                   Toast.makeText(getActivity(), "Number field is Empty", Toast.LENGTH_SHORT).show();
 //                   no_et.requestFocus();
  //                  return;
  //              }


                if(department.length()==0)
                {
                    Toast.makeText(getActivity(), "Department field is empty", Toast.LENGTH_LONG).show();
                    depart_et.requestFocus();
                }
                if(Description.length()==0)
                {
                    Toast.makeText(getActivity(), "Description field is empty", Toast.LENGTH_LONG).show();
                    description_et.requestFocus();
                }
                if(number.length()!=10)
                {
                    if(number.trim().matches(intStr))
                    {
                        Toast.makeText(getActivity(), "entered number is not valid", Toast.LENGTH_LONG).show();
                        no_et.requestFocus();
                    }
                    else {
                        Toast.makeText(getActivity(), "number field is empty", Toast.LENGTH_LONG).show();
                        description_et.requestFocus();
                    }
                    return;
                }
                final String msg = "Name:\n" + name + "\nNumber:\n" + number + "\nPositon:\n" + sub + "\nDepartment:\n" + department + "\nDescription:\n" + Description;
                progressDialog.setMessage("Sending message Please Wait...");
                progressDialog.show();

                new Thread(new Runnable() {

                    public void run() {

                        try {

                            Gmailsender sender = new Gmailsender(

                                    "sapneapp@gmail.com",

                                    "sapne@delhi");

                            // sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

                            sender.sendMail("User Details", msg,

                                    name,

                                    "Sapnethedreams@gmail.com");

                            //  Toast.makeText(getApplicationContext(),"Submitted Successfully...",Toast.LENGTH_LONG).show();
                            getActivity().finish();

                        } catch (Exception e) {

                            Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
                        }

                    }

                }).start();
            }
        });

                return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mLocationClient != null) {
            mLocationClient.connect();
        }
    }



    @Override
    public void onConnected(@Nullable Bundle bundle) {

        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{
                        android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.INTERNET
                }, 10);
            }
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mLocationClient);
        if (mLastLocation != null) {
            double latitude = mLastLocation.getLatitude();
            double longitude = mLastLocation.getLongitude();


        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(getActivity(), "Connection Failed", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(getActivity(), "Connection Suspended", Toast.LENGTH_LONG).show();
    }
}

 //   @Override
 //   public void onActivityCreated(@Nullable Bundle savedInstanceState) {
 //       super.onActivityCreated(savedInstanceState);

  //      Button messageButton = getActivity().findViewById(R.id.care_button);
  //      messageButton.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View view) {
  //              Toast.makeText(getActivity(), "Sending message. We will respond to you soon.", Toast.LENGTH_SHORT).show();
  //          }
  //      });
  //  }
//}












