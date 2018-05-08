package ngo.sapne.intents.sapne.user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ngo.sapne.intents.sapne.R;
import ngo.sapne.intents.sapne.user.LoginFragment;
import ngo.sapne.intents.sapne.user.Users;


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
        String name4 = name.getText().toString().toLowerCase().trim();
        String dob1 = dob.getText().toString().trim();
        String edu1 = edu.getText().toString().trim();
        String post1 = intern.getText().toString().trim();
        String phn1 = mob.getText().toString().trim();
        String email1 = email.getText().toString().trim();
        Users users= new Users(name4, email1, post1, dob1, edu1, phn1);
        mDatabase.child(name4).setValue(users);
        Toast.makeText(getContext(), "Values Modified Successfully", Toast.LENGTH_SHORT).show();
    }

    private void loadUserInfo() {
        String name1 = name.getText().toString().toLowerCase().trim();
        db1= FirebaseDatabase.getInstance().getReference().child("users").child(name1);
        db1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    Toast.makeText(getContext(), "Name not found", Toast.LENGTH_SHORT).show();
                    edu.setText("");
                    email.setText("");
                    dob.setText("");
                    mob.setText("");
                    intern.setText("");
                    return;
                }
                String edu1 =dataSnapshot.child("edu").getValue().toString();
                String email1 =dataSnapshot.child("email").getValue().toString();
                String dob1 =dataSnapshot.child("dob").getValue().toString();
                String vol1 =dataSnapshot.child("volunteer").getValue().toString();
                String mob1 =dataSnapshot.child("phn").getValue().toString();

                edu.setText(edu1);
                email.setText(email1);
                dob.setText(dob1);
                intern.setText(vol1);
                mob.setText(mob1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
