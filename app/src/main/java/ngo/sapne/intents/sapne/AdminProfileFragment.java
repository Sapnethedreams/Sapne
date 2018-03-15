package ngo.sapne.intents.sapne;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminProfileFragment extends Fragment implements View.OnClickListener{

    Button logOut,modify,get_details;
    FirebaseAuth firebaseAuth;
    EditText name,email,dob,edu,intern,mob;
    DatabaseReference db1,db2,db3,db4,db5,mDatabase;
    public AdminProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_admin_profile, container, false);
        logOut=view.findViewById(R.id.buttonLogout);
        modify=view.findViewById(R.id.bModify);
        get_details=view.findViewById(R.id.bDetails);
        mob=view.findViewById(R.id.etMob);
        name=view.findViewById(R.id.etName);
        dob = view.findViewById(R.id.etDob);
        email = view.findViewById(R.id.etEmail);
        edu = view.findViewById(R.id.etEdu);
        intern = view.findViewById(R.id.etIntern);
        get_details.setOnClickListener(this);
        modify.setOnClickListener(this);
        logOut.setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance().getReference("users"); //Dont pass any path if you want root of the tree


        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == logOut) {
            firebaseAuth= FirebaseAuth.getInstance();
            firebaseAuth.signOut();
            //closing activity
            getActivity().getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.content_frame, new LoginFragment(), "LoginFragment")
                    .commit();
        }
        if (view==modify){
            ModifyUserDetails();
        }
        if (view==get_details){
            loadUserInfo();
        }
    }

    private void ModifyUserDetails() {
        String name4 = name.getText().toString().toLowerCase();
        String dob1 = dob.getText().toString();
       String edu1 = edu.getText().toString();
       String post1 = intern.getText().toString();
        String phn1 = mob.getText().toString();
        String email1= email.getText().toString();
        Users users= new Users(name4, email1, post1, dob1, edu1, phn1);
        mDatabase.child(name4).setValue(users);
        Toast.makeText(getContext(),"Values Modified Successfully",Toast.LENGTH_SHORT);
    }

    private void loadUserInfo() {
        String name1 = name.getText().toString();
        db1= FirebaseDatabase.getInstance().getReference().child("users").child(name1).child("edu");
        db2= FirebaseDatabase.getInstance().getReference().child("users").child(name1).child("email");
        db3= FirebaseDatabase.getInstance().getReference().child("users").child(name1).child("dob");
        db4= FirebaseDatabase.getInstance().getReference().child("users").child(name1).child("volunteer");
        db5= FirebaseDatabase.getInstance().getReference().child("users").child(name1).child("phn");
        db1.addValueEventListener(new ValueEventListener() {
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
        db2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    return;
                }
                String edu1= dataSnapshot.getValue().toString();
                email.setText(edu1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        db3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    return;
                }
                String edu1= dataSnapshot.getValue().toString();
                dob.setText(edu1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        db4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    return;
                }
                String edu1= dataSnapshot.getValue().toString();
                intern.setText(edu1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        db5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    return;
                }
                String edu1= dataSnapshot.getValue().toString();
                mob.setText(edu1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
