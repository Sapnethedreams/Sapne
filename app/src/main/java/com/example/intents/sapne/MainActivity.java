package com.example.intents.sapne;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class MainActivity extends AppCompatActivity {

    protected DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    int previousGroup;
    private ActionBarDrawerToggle mDrawerToggle;
    private ExpandableListView mCategoryList;
    private ArrayList<Category> category_name = new ArrayList<Category>();
    private ArrayList<ArrayList<SubCategory>> subcategory_name = new ArrayList<ArrayList<SubCategory>>();
    private ArrayList<Integer> subCatCount = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getCatData();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/Roboto-Regular.ttf").setFontAttrId(R.attr.fontPath).build());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mCategoryList = (ExpandableListView) findViewById(R.id.left_drawer);

        //set up the adapter for the expandablelistview to display the categories.
        mCategoryList.setAdapter(new expandableListViewAdapter(MainActivity.this, category_name, subcategory_name, subCatCount));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //defining the behavior when any group is clicked in expandable listview
        mCategoryList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View view,
                                        int groupPosition, long id) {
                if (groupPosition == 4 || groupPosition == 6) {
                    return true;
                } else if (groupPosition == 5) {
                    Intent intent = new Intent(MainActivity.this, Contact_us.class);
                    startActivity(intent);

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
                    Intent intent = new Intent(MainActivity.this, Activities.class);

                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);
                }

                if (groupPosition == 0 && childPosition == 0) {
                    Intent intent = new Intent(MainActivity.this, AboutUs.class);

                    ArrayList<SubCategory> tempList;
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);
                }

                if (groupPosition == 0 && childPosition == 1) {
                    Intent intent = new Intent(MainActivity.this, OurMission.class);

                    ArrayList<SubCategory> tempList;
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);
                }

                if (groupPosition == 0 && childPosition == 2) {
                    Intent intent = new Intent(MainActivity.this, OurVision.class);

                    ArrayList<SubCategory> tempList;
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
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
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    public void getCatData() {
        category_name.clear();
        Category categoryDetails = new Category();

        categoryDetails.setCatCode(10);
        categoryDetails.setCatName("WHO WE ARE");

        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(20);
        categoryDetails.setCatName("OUR BIT");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(30);
        categoryDetails.setCatName("SUCCESS STORIES");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(40);
        categoryDetails.setCatName("PRODUCTS");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(50);
        categoryDetails.setCatName("EVENTS");
        category_name.add(categoryDetails);

        categoryDetails = new Category();
        categoryDetails.setCatCode(60);
        categoryDetails.setCatName("CONTACT US");
        category_name.add(categoryDetails);
        categoryDetails = new Category();
        categoryDetails.setCatCode(70);
        categoryDetails.setCatName("HOME");
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

        subCategoryMatch = new SubCategory();
        subCategoryMatch.setSubCatName("Our Team");
        subCategoryMatch.setSubCatCode("1004");
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
        subCategoryMatch.setSubCatName("Volume of the month");
        subCategoryMatch.setSubCatCode("2005");
        subCategoryMatches.add(subCategoryMatch);

        subCategoryMatch = new SubCategory();
        subCategoryMatch.setSubCatName("Our Volunteer");
        subCategoryMatch.setSubCatCode("2002");
        subCategoryMatches.add(subCategoryMatch);


        subcategory_name.add(subCategoryMatches);
        subCatCount.add(subCategoryMatches.size());

        subCategoryMatches = new ArrayList<SubCategory>();

        subCategoryMatch = new SubCategory();

        subCategoryMatch.setSubCatName("RECENT");
        subCategoryMatch.setSubCatCode("2001");
        subCategoryMatches.add(subCategoryMatch);
        subCategoryMatch = new SubCategory();
        subCategoryMatch.setSubCatName("Past");
        subCategoryMatch.setSubCatCode("6001");
        subCategoryMatches.add(subCategoryMatch);

        subcategory_name.add(subCategoryMatches);
        subCatCount.add(subCategoryMatches.size());

        subCategoryMatches = new ArrayList<SubCategory>();

        subCategoryMatch = new SubCategory();

        subCategoryMatch.setSubCatName("T-shirts");
        subCategoryMatch.setSubCatCode("5001");
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
        public int getChildrenCount(int i) {
            return (subCategoryCount.get(i));
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
        public View getGroupView(int i, boolean isExpanded, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = layoutInflater.inflate(R.layout.expandablelistcategory, viewGroup, false);
            }

            TextView textView = (TextView) view.findViewById(R.id.cat_desc_1);
            textView.setText(getGroup(i).toString());
            textView.setTypeface(type);

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


