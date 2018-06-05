package ngo.sapne.intents.sapne;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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


public class BaseActivity extends AppCompatActivity {

    public Button login;
    protected FrameLayout frameLayout;
    private boolean doubleBackToExitPressedOnce = false;

    protected DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private int previousGroup;
    private ActionBarDrawerToggle mDrawerToggle;
    private ExpandableListView mCategoryList;
    private ArrayList<Category> category_name = new ArrayList<Category>();
    private ArrayList<ArrayList<SubCategory>> subcategory_name = new ArrayList<ArrayList<SubCategory>>();
    private ArrayList<Integer> subCatCount = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        this.getCatData();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mCategoryList = findViewById(R.id.left_drawer);

        //set up the adapter for the expandablelistview to display the categories.
        mCategoryList.setAdapter(new expandableListViewAdapter(BaseActivity.this, category_name, subcategory_name, subCatCount));

        mCategoryList.setGroupIndicator(null);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.content_frame, new MainFragment(), "MainFragment")
                .commit();

        //defining the behavior when any group is clicked in expandable listview
        mCategoryList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View view,
                                        int groupPosition, long id) {

                if (groupPosition == 4) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new EventsFragment(), "EventsFragment")
                            .commit();
                    mDrawerLayout.closeDrawer(mCategoryList);

                } else if (groupPosition == 5) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new ContactUs(), "ContactUs")
                            .commit();
                    mDrawerLayout.closeDrawer(mCategoryList);

                } else if (groupPosition == 6) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new VolunteerSpeak(), "VolunteerSpeak")
                            .commit();
                    mDrawerLayout.closeDrawer(mCategoryList);

                } else if (groupPosition == 7) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new SapneCare(), "SapneCare")
                            .commit();
                    mDrawerLayout.closeDrawer(mCategoryList);

                } else if (groupPosition == 8) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new MainFragment(), "MainFragment")
                            .commit();
                    mDrawerLayout.closeDrawer(mCategoryList);

                } else if (parent.isGroupExpanded(groupPosition)) {
                    parent.collapseGroup(groupPosition);

                } else if (groupPosition == 3) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new Products(), "Products")
                            .commit();
                    mDrawerLayout.closeDrawer(mCategoryList);

                } else if (groupPosition == 2) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new SuccessStoriesFrag(), "SuccessStoriesFrag")
                            .commit();
                    mDrawerLayout.closeDrawer(mCategoryList);

                } else if (parent.isGroupExpanded(groupPosition)) {
                    parent.collapseGroup(groupPosition);
                } else {
                    if (groupPosition != previousGroup) {
                        parent.collapseGroup(previousGroup);
                    }
                    previousGroup = groupPosition;
                    parent.expandGroup(groupPosition);
                }

                parent.smoothScrollToPosition(groupPosition);
                return true;
            }

        });

        mCategoryList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                //calling CatWiseSearchResults with parameters of subcat code.
                //CatWiseSearchResults will fetch items based on subcatcode.
                if (groupPosition == 1 && childPosition == 1) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new Activities(), "Activities")
                            .commit();

                    mDrawerLayout.closeDrawer(mCategoryList);
                }
                if (groupPosition == 2 && childPosition == 1) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new SuccessStoriesFrag(), "VerticalViewPagerFragment")
                            .commit();

                    mDrawerLayout.closeDrawer(mCategoryList);
                }
                if (groupPosition == 0 && childPosition == 0) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new AboutUs(), "AboutUs")
                            .commit();

                    mDrawerLayout.closeDrawer(mCategoryList);

                }

                if (groupPosition == 0 && childPosition == 1) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new OurMission(), "OurMission")
                            .commit();

                    mDrawerLayout.closeDrawer(mCategoryList);
                }

                if (groupPosition == 1 && childPosition == 0) {
//                    getSupportFragmentManager().
//                            beginTransaction().
//                            replace(R.id.content_frame, new RegularCamps(), "RegularCamps")
//                            .commit();

                    Intent intent = new Intent(BaseActivity.this, GridActivity.class);
                    startActivity(intent);

                    mDrawerLayout.closeDrawer(mCategoryList);
                }

                if (groupPosition == 1 && childPosition == 2) {
                    ZGallery.with(BaseActivity.this, new ArrayList<String>() {{
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g1).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g2).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g3).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g4).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g5).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g6).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g7).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g8).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g9).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g10).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g11).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g12).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g13).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g14).toString());
                        add(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.g15).toString());
                    }}).setToolbarTitleColor(ZColor.WHITE) // toolbar title color
                            .setGalleryBackgroundColor(ZColor.BLACK) // activity background color
                            .setToolbarColorResId(R.color.colorPrimary) // toolbar color
                            .setTitle("Gallery") // toolbar title
                            .show();

                    mDrawerLayout.closeDrawer(mCategoryList);
                }

                if (groupPosition == 1 && childPosition == 3) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new OurVolunteers(), "OurVolunteers")
                            .commit();

                    mDrawerLayout.closeDrawer(mCategoryList);

                }

                if (groupPosition == 0 && childPosition == 2) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new OurVision(), "OurVision")
                            .commit();
                    mDrawerLayout.closeDrawer(mCategoryList);
                }

                if (groupPosition == 0 && childPosition == 3) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new OurTeam(), "OurTeam")
                            .commit();

                    mDrawerLayout.closeDrawer(mCategoryList);
                }

                return true;
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {


            @Override
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }

        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
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
                Fragment mainFrag = getSupportFragmentManager().findFragmentByTag("MainFragment");
                if (mainFrag == null) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.content_frame, new MainFragment(), "MainFragment")
                            .commit();
                }
                break;
        }
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
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

    public void getCatData() {
        category_name.clear();
        Category categoryDetails = new Category();

        categoryDetails.setCatCode(10);
        categoryDetails.setCatName("Who We Are");

        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(20);
        categoryDetails.setCatName("Our Bit");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(30);
        categoryDetails.setCatName("Success Stories");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(40);
        categoryDetails.setCatName("Products");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(50);
        categoryDetails.setCatName("Events");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(60);
        categoryDetails.setCatName("Contact Us");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(70);
        categoryDetails.setCatName("Volunteers Speak");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(80);
        categoryDetails.setCatName("Sapne Care");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(90);
        categoryDetails.setCatName("Home");
        category_name.add(categoryDetails);


        //----Populate Sub Category Codes
        subcategory_name.clear();

        ArrayList<SubCategory> subCategoryMatches = new ArrayList<SubCategory>();

        SubCategory subCategoryMatch = new SubCategory();

        subCategoryMatch.setSubCatName("About Us");
        subCategoryMatch.setSubCatCode("1001");
        subCategoryMatches.add(subCategoryMatch);

        subCategoryMatch = new SubCategory();
        subCategoryMatch.setSubCatName("Our Mission");
        subCategoryMatch.setSubCatCode("1002");
        subCategoryMatches.add(subCategoryMatch);

        subCategoryMatch = new SubCategory();
        subCategoryMatch.setSubCatName("Our Vision");
        subCategoryMatch.setSubCatCode("1003");
        subCategoryMatches.add(subCategoryMatch);

        subcategory_name.add(subCategoryMatches);
        subCatCount.add(subCategoryMatches.size());
        //---

        subCategoryMatches = new ArrayList<SubCategory>();

        subCategoryMatch = new SubCategory();
        subCategoryMatch.setSubCatName("Regular Camps");
        subCategoryMatch.setSubCatCode("2002");
        subCategoryMatches.add(subCategoryMatch);

        subCategoryMatch = new SubCategory();
        subCategoryMatch.setSubCatName("Activities Corner");
        subCategoryMatch.setSubCatCode("2004");
        subCategoryMatches.add(subCategoryMatch);

        subCategoryMatch = new SubCategory();
        subCategoryMatch.setSubCatName("Gallery");
        subCategoryMatch.setSubCatCode("2005");
        subCategoryMatches.add(subCategoryMatch);

        subCategoryMatch = new SubCategory();
        subCategoryMatch.setSubCatName("Our Team");
        subCategoryMatch.setSubCatCode("2002");
        subCategoryMatches.add(subCategoryMatch);

        subcategory_name.add(subCategoryMatches);
        subCatCount.add(subCategoryMatches.size());
    }

    public class expandableListViewAdapter extends BaseExpandableListAdapter {

        ArrayList<ArrayList<SubCategory>> subCategoryName = new ArrayList<ArrayList<SubCategory>>();
        ArrayList<Integer> subCategoryCount = new ArrayList<Integer>();
        int count;
        Typeface type;
        SubCategory singleChild = new SubCategory();
        private LayoutInflater layoutInflater;
        private ArrayList<Category> categoryName = new ArrayList<Category>();

        public expandableListViewAdapter(Context context, ArrayList<Category> categoryName, ArrayList<ArrayList<SubCategory>> subCategoryName, ArrayList<Integer> subCategoryCount) {

            layoutInflater = LayoutInflater.from(context);
            this.categoryName = categoryName;
            this.subCategoryName = subCategoryName;
            this.subCategoryCount = subCategoryCount;
            this.count = categoryName.size();
        }


        @Override
        public int getGroupCount() {
            return categoryName.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {

            return (subCategoryCount.get(groupPosition));
        }

        @Override
        public Object getGroup(int i) {
            return categoryName.get(i).getCatName();
        }

        @Override
        public SubCategory getChild(int i, int i1) {
            ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
            tempList = subCategoryName.get(i);
            return tempList.get(i1);
        }

        @Override
        public void onGroupCollapsed(int groupPosition) {
            super.onGroupCollapsed(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPsition, boolean isExpanded, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = layoutInflater.inflate(R.layout.expandablelistcategory, viewGroup, false);
            }

            TextView textView = (TextView) view.findViewById(R.id.cat_desc_1);
            textView.setText(getGroup(groupPsition).toString());
            textView.setTypeface(type);

            ImageView indicator = (ImageView) view.findViewById(R.id.expicon);

            if (groupPsition != 0 && groupPsition != 1)
            {
                indicator.setVisibility(View.INVISIBLE);
            } else {
                indicator.setVisibility(View.VISIBLE);
                indicator.setImageResource(isExpanded ? R.drawable.ic_keyboard_arrow_up_black_24dp : R.drawable.ic_keyboard_arrow_down_black_24dp);
            }

            return view;
        }


        @Override
        public View getChildView(int i, int i1, boolean isExpanded, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = layoutInflater.inflate(R.layout.expandablelistviewsubcat, viewGroup, false);
            }

            singleChild = getChild(i, i1);

            TextView childSubCategoryName = (TextView) view.findViewById(R.id.subcat_name);
            childSubCategoryName.setTypeface(type);
            childSubCategoryName.setText(singleChild.getSubCatName());
            return view;

        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}

