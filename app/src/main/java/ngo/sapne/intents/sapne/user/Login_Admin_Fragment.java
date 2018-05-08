package ngo.sapne.intents.sapne.user;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import ngo.sapne.intents.sapne.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Anshul on 26/02/2018.
 */

public class Login_Admin_Fragment extends Fragment  implements View.OnClickListener{

    private static String secret_code = "123456";
    public ImageView imgview;
    Uri profileImageUrl;
    int PICK_IMAGE_REQUEST = 101;
    Uri filePath;
    private Button buttonSignup;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editText_repassword;
    private EditText editText_adminpass;
    private EditText name;
    private EditText mobno;
    private String name1,email1,pas1,pas2,adminPas,mob1;
   private TextView t1;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_admin, container, false);


        editTextEmail = view.findViewById(R.id.editText_Admin_Email);
        editTextPassword = view.findViewById(R.id.editText_Admin_Password);
        buttonSignup = view.findViewById(R.id.button_Admin_Signup);
        editText_repassword= view.findViewById(R.id.editText_Admin_rePassword);
        editText_adminpass = view.findViewById(R.id.editText_Admin_adPassword);
        name= view.findViewById(R.id.editText_admin_name);
        mobno= view.findViewById(R.id.editText_adminno);
        imgview= view.findViewById(R.id.imgView);
        imgview.setOnClickListener(this);
        buttonSignup.setOnClickListener(this);
        t1=view.findViewById(R.id.t1);

        progressDialog = new ProgressDialog(getActivity());

        return view;
    }


    @Override
    public void onClick(View view) {
        if (view==buttonSignup){
            createUser();
        }
        if (view==imgview){
            upLoadProfPic();
        }
    }

    private void upLoadProfPic() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            t1.setVisibility(View.INVISIBLE);
            try {
                //getting image from gallery
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
                imgview.setImageBitmap(bitmap);
                uploadImageToFirebase();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadImageToFirebase() {
        StorageReference profileImageReference = FirebaseStorage.getInstance().getReference("profilepics/ " + System.currentTimeMillis() + ".jpg");

        if(filePath!=null){
            profileImageReference.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    profileImageUrl = taskSnapshot.getDownloadUrl();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getActivity() ,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    private void createUser() {
        firebaseAuth = FirebaseAuth.getInstance();


        name1 = name.getText().toString().toLowerCase().trim();
       email1= editTextEmail.getText().toString();
        pas1 = editTextPassword.getText().toString().trim();
        pas2 = editText_repassword.getText().toString().trim();
        adminPas=editText_adminpass.getText().toString();
        mob1 = mobno.getText().toString().trim();
        if(name1.isEmpty()){
            name.setError("name required");
            name.requestFocus();
            return;
        }
        if(mob1.isEmpty()){
            mobno.setError("name required");
            mobno.requestFocus();
            return;
        }
        if(email1.isEmpty()){
            editTextEmail.setError("email required");
            editTextEmail.requestFocus();
            return;
        }
        if(pas1.isEmpty()){
            editTextPassword.setError("password  required");
            editTextPassword.requestFocus();
            return;
        }
        if(pas2.isEmpty()){
            editText_repassword.setError("name required");
            editText_repassword.requestFocus();
            return;
        }
        if(adminPas.isEmpty()){
            editText_adminpass.setError("name required");
            editText_adminpass.requestFocus();
            return;
        }
        if (pas1.equals(pas2)){
            if (adminPas.equals(secret_code)){
                progressDialog.setMessage("Registering Please Wait...");
                progressDialog.show();
                firebaseAuth.createUserWithEmailAndPassword(email1,pas1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            saveUserInfo();
                            getActivity().getSupportFragmentManager().
                                    beginTransaction().
                                    replace(R.id.content_frame, new AdminProfileFragment(), "Admin Profile")
                                    .commit();
                        } else {
                            //display some message here
                            Toast.makeText(getActivity(), "Registration Error. You maybe already Registered or Credentials not correct", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
            }
            else {
                Toast.makeText(getContext(), "Enter correct admin password", Toast.LENGTH_LONG).show();

            }
        }
        else {
            Toast.makeText(getContext(), "Enter correct password in both fields", Toast.LENGTH_LONG).show();
        }



    }

   private void saveUserInfo() {
        FirebaseUser user= firebaseAuth.getCurrentUser();

        if(user!=null) {


            String displayName= name.getText().toString();
            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(displayName)
                    .setPhotoUri(profileImageUrl)
                    .build();
            user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                    }
                }
            });
        }
        String uid= user.getUid();
      String mob2=mobno.getText().toString();
       mDatabase = FirebaseDatabase.getInstance().getReference("admin_users");
        String id = "privilaged_user";
        UsersAdmin users = new UsersAdmin(id,mob2);
        mDatabase.child(uid).setValue(users);
    }

}



