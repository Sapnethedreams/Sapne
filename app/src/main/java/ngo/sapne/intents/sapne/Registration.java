package ngo.sapne.intents.sapne;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


public class Registration extends AppCompatActivity {

    EditText name, email, dob, edu, post;
    String name1, email1, dob1, edu1, post1;
    Button register;
    int PICK_IMAGE_REQUEST = 111;
    Button uplod;
    TextView t1;
    Uri filePath;
    ProgressDialog pd;
    FirebaseStorage
            storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://sapne-241cc.appspot.com/");    //change the url according to your firebase app
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        name = (EditText) findViewById(R.id.input_name);
        email = (EditText) findViewById(R.id.input_email);
        dob = (EditText) findViewById(R.id.dob);
        edu = (EditText) findViewById(R.id.edu);
        post = (EditText) findViewById(R.id.post);
        register = (Button) findViewById(R.id.btn_regi);
        uplod = (Button) findViewById(R.id.bws);
        t1 = (TextView) findViewById(R.id.t1);
        mDatabase = FirebaseDatabase.getInstance().getReference("users"); //Dont pass any path if you want root of the tree
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
        uplod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadimage();
            }
        });


    }

    public void addUser() {

     /*   if(t1.getText().equals("Selected file"))
        {
            Toast.makeText(this,"Please select file",Toast.LENGTH_LONG).show();
        }*/


        //t1.setText(filePath.toString());
        if (filePath != null) {

            StorageReference childRef = storageRef.child("image.jpg");

            //uploading the image
            UploadTask uploadTask = childRef.putFile(filePath);

            uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    name1 = name.getText().toString();
                    email1 = email.getText().toString();
                    dob1 = dob.getText().toString();
                    edu1 = edu.getText().toString();
                    post1 = post.getText().toString();
                    String id = mDatabase.push().getKey();

                    Users users = new Users(id, name1, email1, post1, dob1, edu1);
                    mDatabase.child(id).setValue(users);

                    Toast.makeText(getApplicationContext(), "Upload successful", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    //pd.dismiss();
                    Toast.makeText(getApplicationContext(), "Upload Failed -> " + e, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "Select an image", Toast.LENGTH_SHORT).show();
        }

        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
    }

    public void uploadimage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();

            try {
                //getting image from gallery
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                bitmap.getByteCount();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

