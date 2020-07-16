package ngo.sapne.intents.sapne;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.entities.ZColor;

import java.util.ArrayList;

import ngo.sapne.intents.sapne.events.EventsFragment;
import ngo.sapne.intents.sapne.user.LoginFragment;


public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    protected DrawerLayout mDrawerLayout;
    private boolean doubleBackToExitPressedOnce = false;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.content_frame, new MainFragment(), "MainFragment")
                    .commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
        checkLocationPermission();

        //For showing gallery activity
//        ZGallery.with(BaseActivity.this, new ArrayList<String>() {{
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g1).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g2).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g3).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g4).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g5).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g6).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g7).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g8).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g9).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g10).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g11).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g12).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g13).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g14).toString());
//            add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g15).toString());
//        }}).setToolbarTitleColor(ZColor.WHITE) // toolbar title color
//                .setGalleryBackgroundColor(ZColor.BLACK) // activity background color
//                .setToolbarColorResId(R.color.colorPrimary) // toolbar color
//                .setTitle("Gallery") // toolbar title
//                .show();


    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(BaseActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String btnName = null;
        switch (itemId) {

            case R.id.login1:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new LoginFragment(), "LoginFragment")
                        .commit();
                break;
            case R.id.notification:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new NotificationList(), "NotificationList")
                        .commit();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }


        Fragment mainFrag = getSupportFragmentManager().findFragmentByTag("MainFragment");
        if (mainFrag == null) {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.content_frame, new MainFragment(), "MainFragment")
                    .commit();
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 3000);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Permission was granted.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {


                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            //You can add here other case statements according to your requirement.
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_home:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new MainFragment(), "MainFragment")
                        .commit();
                break;

            case R.id.nav_events:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new EventsFragment(), "EventsFragment")
                        .commit();
                break;

            case R.id.nav_success_stories:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new SuccessStoriesFrag(), "SuccessStoriesFrag")
                        .commit();
                break;

            case R.id.nav_volunteer_speak:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new VolunteerSpeak(), "VolunteerSpeak")
                        .commit();
                break;

            case R.id.nav_care:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new SapneCare(), "SapneCare")
                        .commit();
                break;

            case R.id.nav_our_mission:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new OurMission(), "OurMission")
                        .commit();
                break;

            case R.id.nav_our_vision:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new OurVision(), "OurVision")
                        .commit();
                break;

            case R.id.nav_our_team:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new OurVolunteers(), "OurVolunteers")
                        .commit();
                break;

            case R.id.nav_regular_camps:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new RegularCamps(), "RegularCamps")
                        .commit();
                break;

            case R.id.nav_activities_corner:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new Activities(), "Activities")
                        .commit();
                break;

            case R.id.nav_contact_us:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new ContactUs(), "ContactUs")
                        .commit();
                break;

            case R.id.nav_nearby_ngo:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new NearbyNGO(), "NearbyNGO")
                        .commit();
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        return true;
    }

}

