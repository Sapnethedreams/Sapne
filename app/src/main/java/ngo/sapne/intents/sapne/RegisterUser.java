package ngo.sapne.intents.sapne;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class RegisterUser extends Fragment implements View.OnClickListener {




    //defining view objects
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignup;
    private  TextView textviewlogin_admin;

    private TextView textViewSignin;

    private ProgressDialog progressDialog;


    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;

    private SignInButton ggl_btn;
    private static final int RC_SIGN_IN=2;
    private GoogleApiClient mgoogleApiclient;
    private static final String TAG ="Something";
    private FirebaseAuth.AuthStateListener mAuthListner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_user, container, false);



        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        ggl_btn=(SignInButton) view.findViewById(R.id.google_reg__btn);

        //if getCurrentUser does not returns null
     //   if (firebaseAuth.getCurrentUser() != null) {
            //that means user is already logged in
            //so close this activity
       //     getActivity().getSupportFragmentManager().
        //            beginTransaction().
        //            replace(R.id.content_frame, new ProfileFragment(), "ProfileFragment")
        //            .commit();
       // }
        mAuthListner=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null)
                {
                    getActivity().getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new ProfileFragment(), "ProfileFragment")
                            .commit();
                }
            }
        };


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //initializing views
        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
        textViewSignin = (TextView) view.findViewById(R.id.textViewSignin);

        buttonSignup = (Button) view.findViewById(R.id.buttonSignup);
        textviewlogin_admin=(TextView)view.findViewById(R.id.textViewRegister_Admin);


        mgoogleApiclient = new GoogleApiClient.Builder(getActivity().getApplicationContext())
                .enableAutoManage(getActivity(), new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        //  Toast.makeText(loginuser.this,"Some error occured",Toast.LENGTH_LONG).show();
                    }
                }).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();
        ggl_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        progressDialog = new ProgressDialog(getActivity());

        //attaching listener to button
        buttonSignup.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
        textviewlogin_admin.setOnClickListener(this);

        return view;
    }



//methods for google login


    @Override
    public void onStart() {
        super.onStart();

        firebaseAuth.addAuthStateListener(mAuthListner);
    }


    @Override
    public void onPause() {
        super.onPause();
        mgoogleApiclient.stopAutoManage(getActivity());
        mgoogleApiclient.disconnect();
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mgoogleApiclient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess())
            {
                GoogleSignInAccount account =result.getSignInAccount();
                firebaseAuthWithGoogle(account);

            }
            else{

            }
        }
    }



    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {


        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");

                            getActivity().getSupportFragmentManager().
                                    beginTransaction().
                                    replace(R.id.content_frame, new Registration(), "Registration")
                                    .commit();


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                        }

                        // ...
                    }
                });
    }

    //end of funcitons for google login









    private void registerUser() {

        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getActivity(), "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity(), "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            getActivity().getSupportFragmentManager().
                                    beginTransaction().
                                    replace(R.id.content_frame, new Registration(), "Registration")
                                    .commit();
                        } else {
                            //display some message here
                            Toast.makeText(getActivity(), "Registration Error. You maybe already Registered or Credentials not correct", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    @Override
    public void onClick(View view) {

        if (view == buttonSignup) {
            registerUser();
        }

        if (view == textViewSignin) {
            getActivity().getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.content_frame, new LoginFragment(), "LoginFragment")
                    .commit();
        }

        if(view == textviewlogin_admin){
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.content_frame, new Login_Admin_Fragment(), "Login_Admin_Fragment")
                    .commit();
        }

    }
}
