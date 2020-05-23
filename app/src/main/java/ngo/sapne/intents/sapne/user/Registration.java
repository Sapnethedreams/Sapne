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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

import ngo.sapne.intents.sapne.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by user on 22/11/2017.
 */

public class Registration extends Fragment {

    public static Uri profileImageUrl;
    final ArrayList<String> joinusas = new ArrayList<>();
    EditText name, email, dob, edu, phn;
    String name1, email1, dob1, edu1, post1, phn1 ;
    Button GoToProf;
    int PICK_IMAGE_REQUEST = 111;
    Button uplod;
    TextView t1;
    ImageView prof;
    Uri filePath;
    ProgressDialog pd;
    Spinner spnJoin;
    FirebaseStorage
            storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://sapne-241cc.appspot.com/");    //change the url according to your firebase app
    FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        name = view.findViewById(R.id.input_name);
        dob = view.findViewById(R.id.dob);
        edu = view.findViewById(R.id.edu);
        phn = view.findViewById(R.id.phn);
        spnJoin = view.findViewById(R.id.spnJoin);
        prof = view.findViewById(R.id.iv7);
        GoToProf = view.findViewById(R.id.btn_regi);
        t1= view.findViewById(R.id.tv77);
        uplod = view.findViewById(R.id.bws);

        joinusas.add("Intern");
        joinusas.add("Volunteer");

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, joinusas);

        spnJoin.setAdapter(adapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance().getReference("users"); //Dont pass any path if you want root of the tree
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageChooser();
            }
        });
        GoToProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new ProfileFragment() )
                        .commit();
            }
        });
        uplod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInfo();
            }
        });
    }

    private void saveUserInfo() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user= mAuth.getCurrentUser();

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
                        Toast.makeText(getActivity(), "Profile Updated", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        String name4 = name.getText().toString().toLowerCase().trim();
        dob1 = dob.getText().toString();
        edu1 = edu.getText().toString();
        post1 = joinusas.get(spnJoin.getSelectedItemPosition());
        phn1 = phn.getText().toString().trim();
        email1= user.getEmail();
        Users users= new Users(name1, email1, post1, dob1, edu1, phn1);
        mDatabase.child(name4).setValue(users);
    }


    public void showImageChooser() {
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
                prof.setImageBitmap(bitmap);
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
}
