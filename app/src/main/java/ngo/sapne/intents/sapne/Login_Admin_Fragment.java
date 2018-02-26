package ngo.sapne.intents.sapne;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Anshul on 26/02/2018.
 */

public class Login_Admin_Fragment extends Fragment implements View.OnClickListener {

    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editText_repassword;
    private EditText editText_adminpass;
    private EditText name;
    private EditText mobno;
    public ImageView imgview;
    private Button loadpic;

    private static int RESULT_LOAD_IMAGE = 1;

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
        editText_repassword=(EditText)view.findViewById(R.id.editText_Admin_rePassword);
        editText_adminpass =(EditText)view.findViewById(R.id.editText_Admin_adPassword);
        name=(EditText)view.findViewById(R.id.editText_admin_name);
        mobno=(EditText)view.findViewById(R.id.editText_adminno);
        imgview=(ImageView)view.findViewById(R.id.imgView);
        loadpic=(Button)view.findViewById(R.id.buttonLoadPicture);

        progressDialog = new ProgressDialog(getActivity());



        loadpic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });



        //attaching click listener
        buttonSignIn.setOnClickListener(this);

        return view;
    }

    //method for user login
    private void adminLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();
        String repassword = editText_repassword.getText().toString().trim();
        String adminpass = editText_adminpass.getText().toString().trim();
        //checking if fields  are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(getActivity(),"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(getActivity(),"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(adminpass)){
            Toast.makeText(getActivity(),"Please enter admin password",Toast.LENGTH_LONG).show();
            return;
        }

        if(password!=repassword){
            Toast.makeText(getActivity(),"Please enter correct password",Toast.LENGTH_LONG).show();
            return;
        }
        if(name.length()==0){
            Toast.makeText(getActivity(),"Please enter name",Toast.LENGTH_LONG).show();
            return;
        }

        if(mobno.length()==0){
            Toast.makeText(getActivity(),"Please enter name",Toast.LENGTH_LONG).show();
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



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Admin_fragment_support ad;
        ad = new Admin_fragment_support();

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = ad.method();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            imgview.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }


    }
}



