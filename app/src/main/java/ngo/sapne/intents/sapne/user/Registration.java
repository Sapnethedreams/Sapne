package ngo.sapne.intents.sapne.user;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
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
import java.util.HashMap;
import java.util.Map;

import ngo.sapne.intents.sapne.R;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_APPEND;

/**
 * Created by user on 22/11/2017.
 */

public class Registration extends Fragment {

    public static Uri profileImageUrl;
    private final ArrayList<String> joinusas = new ArrayList<>();
    private EditText name, email, dob, edu, phn;
    private String name1, email1, dob1, edu1, post1, phn1;
    private Button GoToProf;
    private int PICK_IMAGE_REQUEST = 111;
    private Button uplod;
    private TextView t1;
    private ImageView prof;
    private Uri filePath;
    private ProgressDialog pd;
    private Spinner spnJoin;
    private FirebaseStorage storage = FirebaseStorage.getInstance();

    FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        mContext = view.getContext();
        name = view.findViewById(R.id.input_name);
        dob = view.findViewById(R.id.dob);
        edu = view.findViewById(R.id.edu);
        phn = view.findViewById(R.id.phn);
        spnJoin = view.findViewById(R.id.spnJoin);
        prof = view.findViewById(R.id.iv7);
        GoToProf = view.findViewById(R.id.btn_regi);
        t1 = view.findViewById(R.id.tv77);
        uplod = view.findViewById(R.id.bws);

        joinusas.add("Intern");
        joinusas.add("Volunteer");

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, joinusas);

        spnJoin.setAdapter(adapter);


        // Retrieving the value using its keys
        // the file name must be same in both saving
        // and retrieving the data
        SharedPreferences sh
                = getSharedPreferences("MySharedPref",
                MODE_APPEND);

        // The value will be default as empty string
        // because for the very first time
        // when the app is opened,
        // there is nothing to show
        String s1 = sh.getString("name", "");
        name.setText(s1);

        return view;
    }

    private SharedPreferences getSharedPreferences(String mySharedPref, int modeAppend) {
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
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
                saveUserInfo();
            }
        });
        uplod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageInView();
            }
        });
    }

    private void showImageInView() {

        FirebaseUser user = mAuth.getCurrentUser();
        String displayName = name.getText().toString();
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

    private void saveUserInfo() {
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {

            String displayName = name.getText().toString();


            String name4 = name.getText().toString();
            dob1 = dob.getText().toString();
            edu1 = edu.getText().toString();
            post1 = joinusas.get(spnJoin.getSelectedItemPosition());
            phn1 = phn.getText().toString().trim();
            email1 = user.getEmail();

            Map userMap = new HashMap();
            userMap.put("name", name4);
            userMap.put("email", email1);
            userMap.put("edu", edu1);
            userMap.put("phn", phn1);
            userMap.put("post", post1);
            userMap.put("dob", dob1);

//                Users users = new Users(name1, email1, post1, dob1, edu1, phn1);
            mDatabase.child(user.getUid()).updateChildren(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(mContext, "Profile Updated", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(mContext, "Error,please try again after some time", Toast.LENGTH_SHORT).show();
                }
            });

            getActivity().getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.content_frame, new ProfileFragment())
                    .commit();

        } else {
            Toast.makeText(getContext(), "Please Enter all details!", Toast.LENGTH_SHORT).show();
        }

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
        StorageReference profileImageReference = FirebaseStorage.getInstance().getReference("profilepics/ " + mAuth.getCurrentUser().getUid() + ".jpg");

        if (filePath != null) {
            profileImageReference.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    profileImageUrl = taskSnapshot.getDownloadUrl();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
