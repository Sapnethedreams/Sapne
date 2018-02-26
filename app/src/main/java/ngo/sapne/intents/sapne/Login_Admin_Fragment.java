package ngo.sapne.intents.sapne;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Anshul on 26/02/2018.
 */

public class Login_Admin_Fragment extends Fragment implements View.OnClickListener {

    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;



    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_admin, container, false);

        firebaseAuth = FirebaseAuth.getInstance();


        editTextEmail = (EditText) view.findViewById(R.id.editText_Admin_Email);
        editTextPassword = (EditText) view.findViewById(R.id.editText_Admin_Password);
        buttonSignIn = (Button) view.findViewById(R.id.button_Admin_Signin);

        progressDialog = new ProgressDialog(getActivity());

        //attaching click listener
        buttonSignIn.setOnClickListener(this);

        return view;
    }

    //method for user login
    private void adminLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(getActivity(),"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(getActivity(),"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Signing in Please Wait...");
        progressDialog.show();

        //logging in the admin


    }

    @Override
    public void onClick(View view) {
        if (view == buttonSignIn) {
            adminLogin();
        }
    }
}


