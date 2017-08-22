package com.example.intents.sapne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class JoinUs extends AppCompatActivity {

    EditText etAddress,etName,etPhoneNumber,etEmail,etAadhar,etOffice;
    Button btnSubmit;
    Spinner spnJoin;
    RadioGroup rgSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_us);
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();

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


        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,joinusas);

        spnJoin.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String phone = etPhoneNumber.getText().toString();
                String email = etEmail.getText().toString();
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
                String msg = "Name:" + name + "\nPhone Number:" + phone + "\nEmail:" + email + "\nGender:" + gender + "\nAddress:" + address + "\nOffice/Institute:" + office + "\nAadhar No.:" + aadhar + "\nJoining As:" + sub;

                //Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                //i.putExtra("msg",msg);
                //Intent i=new Intent(getApplicationContext(),);
                //i.putExtra("email",email);
                //startActivity(i);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                SendMail sm = new SendMail(JoinUs.this, "sapnethedreams@gmail.com", "New Entry", msg);

                //Executing sendmail to send email
                sm.execute();
            }});


    }
}