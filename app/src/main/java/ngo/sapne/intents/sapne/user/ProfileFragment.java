package ngo.sapne.intents.sapne.user;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import ngo.sapne.intents.sapne.R;

import static android.content.Context.MODE_APPEND;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    CircleImageView profpic;
    ProgressDialog pd;
    //firebase auth object
    private FirebaseAuth firebaseAuth;
    private DatabaseReference db, db1;
    //view objects,
    private TextView textViewUserEmail, name, dob, edu, vol, phone, adm;
    private Button buttonLogout;

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profileuser, container, false);

        mContext = view.getContext();
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            getActivity().getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.content_frame, new LoginFragment(), "LoginFragment")
                    .commit();
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = view.findViewById(R.id.email1);
        buttonLogout = view.findViewById(R.id.buttonLogout);
        profpic = view.findViewById(R.id.iv8);
        name = view.findViewById(R.id.name1);
        vol = view.findViewById(R.id.vol1);
        dob = view.findViewById(R.id.dob1);
        phone = view.findViewById(R.id.phn1);
        edu = view.findViewById(R.id.edu1);
        adm = view.findViewById(R.id.admin);
        adm.setOnClickListener(this);
        //displaying logged in user name
        textViewUserEmail.setText(user.getEmail());
        loadUserInfo();
        loadUserProfpic();

        //adding listener to button
        buttonLogout.setOnClickListener(this);

        try {
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
            String s1 = sh.getString("email", "");
            String s2 = sh.getString("name", "");
            textViewUserEmail.setText(s1);
            name.setText(s2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }

    private SharedPreferences getSharedPreferences(String mySharedPref, int modeAppend) {
        return null;
    }


    private void loadUserProfpic() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            Uri user3 = Registration.profileImageUrl;
            if (user3 != null) {
                Picasso.with(getActivity()).load(user3).into(profpic);
            }
            if (user.getDisplayName() != null) {
                name.setText("Welcome   " + user.getDisplayName());
            }

        }
    }

    private void loadUserInfo() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userId = firebaseUser.getUid();
//        String name1 = firebaseUser.getDisplayName().toLowerCase();
        db1 = FirebaseDatabase.getInstance().getReference().child("users").child(userId);

        db1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    Toast.makeText(mContext, "User details not found", Toast.LENGTH_SHORT).show();
                    phone.setVisibility(View.INVISIBLE);
                    edu.setVisibility(View.INVISIBLE);
                    vol.setVisibility(View.INVISIBLE);
                    dob.setVisibility(View.INVISIBLE);
                    return;
                }

                String nameString = dataSnapshot.child("name").getValue().toString();
                String dobString = dataSnapshot.child("dob").getValue().toString();
                String eduString = dataSnapshot.child("edu").getValue().toString();
                String emailString  = dataSnapshot.child("email").getValue().toString();
                String phnString = dataSnapshot.child("phn").getValue().toString();
                String volString = dataSnapshot.child("post").getValue().toString();

                textViewUserEmail.setText(emailString);
                name.setText(nameString);
                vol.setText(volString);
                dob.setText(dobString);
                edu.setText(eduString);
                phone.setText(phnString);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    @Override
    public void onClick(View view) {
        //if logout is pressed
        if (view == buttonLogout) {
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            getActivity().getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.content_frame, new LoginFragment(), "LoginFragment")
                    .commit();
        }
        if (view == adm) {
            pd = new ProgressDialog(getContext());
            pd.setMessage("Opening Admin Page");
            pd.dismiss();
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
                    Toast.makeText(mContext, "You are not privilaged to use this", Toast.LENGTH_LONG);
                } else {
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
    }
}




