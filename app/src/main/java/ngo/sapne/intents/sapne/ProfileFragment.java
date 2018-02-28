package ngo.sapne.intents.sapne;

/**
 * Created by dell pc on 05/10/2017.
 */
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

import static ngo.sapne.intents.sapne.NetworkUtil.context;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;
    private DatabaseReference db;
    private FirebaseUser user1;
    CircleImageView profpic;
    //view objects,
    private TextView textViewUserEmail,name,dob,edu,vol,phone,adm;
    private Button buttonLogout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profileuser, container, false);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            getActivity().getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.content_frame, new LoginFragment(), "LoginFragment")
                    .commit();
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) view.findViewById(R.id.email1);
        buttonLogout = (Button) view.findViewById(R.id.buttonLogout);
        profpic= view.findViewById(R.id.iv8);
        name= view.findViewById(R.id.name1);
        vol= view.findViewById(R.id.vol1);
        dob= view.findViewById(R.id.dob1);
        phone= view.findViewById(R.id.phn1);
        edu= view.findViewById(R.id.edu1);
        adm=view.findViewById(R.id.admin);
        adm.setOnClickListener(this);
        //displaying logged in user name
        textViewUserEmail.setText(user.getEmail());
        loadUserDob();
        loadUserPhone();
        loadUserVol();
        loadUserEdu();
        loadUserProfpic();

        //adding listener to button
        buttonLogout.setOnClickListener(this);

        return view;
    }


    private void loadUserEdu() {
        user1=FirebaseAuth.getInstance().getCurrentUser();
        db= FirebaseDatabase.getInstance().getReference().child("users").child(user1.getUid()).child("edu");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    return;
                }
                String edu1= dataSnapshot.getValue().toString();
                edu.setText(edu1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void loadUserVol() {
        user1=FirebaseAuth.getInstance().getCurrentUser();
        db= FirebaseDatabase.getInstance().getReference().child("users").child(user1.getUid()).child("volunteer");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    return;
                }
                String vol1= dataSnapshot.getValue().toString();
                vol.setText(vol1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void loadUserPhone() {
        user1=FirebaseAuth.getInstance().getCurrentUser();
        db= FirebaseDatabase.getInstance().getReference().child("users").child(user1.getUid()).child("phn");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    return;
                }
                String phn1= dataSnapshot.getValue().toString();
                phone.setText(phn1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void loadUserDob() {
        user1=FirebaseAuth.getInstance().getCurrentUser();
        db= FirebaseDatabase.getInstance().getReference().child("users").child(user1.getUid()).child("dob");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    return;
                }
                String dob1= dataSnapshot.getValue().toString();
                dob.setText(dob1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void loadUserProfpic() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null){
            Uri user3 = Registration.profileImageUrl;
            if (user3!=null) {
                Picasso.with(getActivity()).load(user3).into(profpic);
            }
            if (user.getDisplayName()!=null){
                name.setText("Welcome   " +user.getDisplayName());
            }

        }
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            getActivity().getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.content_frame, new LoginFragment(), "LoginFragment")
                    .commit();
        }
        if(view==adm){
            openAdmin();
        }
    }

    private void openAdmin() {
        db = FirebaseDatabase.getInstance().getReference().child("admin_users").child(firebaseAuth.getCurrentUser().getUid()).child("admin");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    return;
                }
                String admin1 = dataSnapshot.getValue().toString();
                if (admin1.isEmpty()) {
                    Toast.makeText(getContext(),"You are not privilaged to use this",Toast.LENGTH_LONG);
                }else {
                    getActivity().getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new AdminProfileFragment(), "ProfileFragment")
                            .commit();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }}




