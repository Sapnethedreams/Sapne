package com.example.intents.sapne;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
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

import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.entities.ZColor;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class BaseActivity extends AppCompatActivity {

    Toolbar toolbar;

    protected FrameLayout frameLayout;

    protected DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ExpandableListView mCategoryList;
    private ArrayList<Category> category_name = new ArrayList<Category>();
    private ArrayList<ArrayList<SubCategory>> subcategory_name = new ArrayList<ArrayList<SubCategory>>();
    private ArrayList<Integer> subCatCount = new ArrayList<Integer>();
    int previousGroup;
    public Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        frameLayout = (FrameLayout)findViewById(R.id.content_frame);
        this.getCatData();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder(). setDefaultFontPath("fonts/Roboto-Regular.ttf").setFontAttrId(R.attr. fontPath).build());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mCategoryList = (ExpandableListView) findViewById(R.id.left_drawer);

        //set up the adapter for the expandablelistview to display the categories.

        mCategoryList.setAdapter(new expandableListViewAdapter(BaseActivity.this, category_name, subcategory_name, subCatCount));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mCategoryList.setGroupIndicator(null);
        //mCategoryList.expandGroup(0);
        //mCategoryList.expandGroup(1);
        //defining the behavior when any group is clicked in expandable listview
        mCategoryList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View view,
                                        int groupPosition, long id) {


                if(groupPosition==4){
                    Intent intent = new Intent(BaseActivity.this, EventsActivity.class);
                    startActivity(intent);
                }
                else if(groupPosition==5)
                {
                    Intent intent = new Intent(BaseActivity.this, Contact_us.class);
                    startActivity(intent);

                } else if (groupPosition == 6) {
                    Intent intent = new Intent(BaseActivity.this, MainActivity.class);
                    startActivity(intent);

                } else if (parent.isGroupExpanded(groupPosition)) {

                  parent.collapseGroup(groupPosition);

                }

                else if(groupPosition==3) {
                    Intent intent = new Intent(BaseActivity.this, Products.class);
                    startActivity(intent);
                }

                else if(groupPosition==2) {

                    Intent intent = new Intent(BaseActivity.this, ExpandingCells.class);
                    startActivity(intent);
                }

                else if(parent.isGroupExpanded(groupPosition)) {
                    parent.collapseGroup(groupPosition);
                }



                else {
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
                if(groupPosition==1 && childPosition==1) {
                    Intent intent = new Intent(BaseActivity.this, Activities.class);

                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);
                }
                if(groupPosition==2&&childPosition==1)
                {
                    Intent intent = new Intent(BaseActivity.this, ExpandingCells.class);
                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);
                }
                if(groupPosition==0&&childPosition==0)
                {
                    Intent intent = new Intent(BaseActivity.this, AboutUs.class);
                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);

                }

                if(groupPosition==0&&childPosition==1)
                {
                    Intent intent = new Intent(BaseActivity.this, OurMission.class);
                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);

                }

                if(groupPosition==1&&childPosition==0)
                {
                    Intent intent = new Intent(BaseActivity.this, RegularCamps.class);
                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);

                }

                if(groupPosition==1&&childPosition==2)
                {
                    ZGallery.with(BaseActivity.this, new ArrayList<String>() {{
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g1).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g2).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g3).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g4).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g5).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g6).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g7).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g8).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g9).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g10).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g11).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g12).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g13).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g14).toString());
                        add(Uri.parse("android.resource://ngo.sapne.intents.sapne/" + R.drawable.g15).toString());
                    }}).setToolbarTitleColor(ZColor.WHITE) // toolbar title color
                            .setGalleryBackgroundColor(ZColor.BLACK) // activity background color
                            .setToolbarColorResId(R.color.colorPrimary) // toolbar color
                            .setTitle("Gallery") // toolbar title
                            .show();

                    mDrawerLayout.closeDrawer(mCategoryList);
                }

                if(groupPosition==1&&childPosition==3)
                {
                    Intent intent = new Intent( BaseActivity.this, our_volunteer.class);
                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);

                }


//                if(groupPosition==3&&childPosition==0)
//                {
//                    Intent intent = new Intent(MainActivity.this, Products.class);
//                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
//                    tempList = subcategory_name.get(groupPosition);

//                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
//                    startActivity(intent);
//                    mDrawerLayout.closeDrawer(mCategoryList);

//                }

                if (groupPosition == 0 && childPosition == 2) {
                    Intent intent = new Intent(BaseActivity.this, OurVision.class);
                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);
                }

                if (groupPosition == 0 && childPosition == 3) {
                    Intent intent = new Intent(BaseActivity.this, OurTeam.class);
                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);
                }
/*
                if(groupPosition==0&&childPosition==2)
                {
                    Intent intent = new Intent(BaseActivity.this, OurVision.class);
                    ArrayList<SubCategory> tempList = new ArrayList<SubCategory>();
                    tempList = subcategory_name.get(groupPosition);

                    intent.putExtra("subcategory", tempList.get(childPosition).getSubCatCode());
                    startActivity(intent);
                    mDrawerLayout.closeDrawer(mCategoryList);
                }*/

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
        switch(itemId) {

            case R.id.login1:

                Intent myIntent = new Intent(BaseActivity.this,LoginActivity.class);
                startActivity(myIntent);
                break;
            case R.id.notification:
                Intent myIntent1 = new Intent(BaseActivity.this,MainActivity.class);
                startActivity(myIntent1);

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


    public class expandableListViewAdapter extends BaseExpandableListAdapter {

        private LayoutInflater layoutInflater;
        private ArrayList<Category> categoryName = new ArrayList<Category>();
        ArrayList<ArrayList<SubCategory>> subCategoryName = new ArrayList<ArrayList<SubCategory>>();
        ArrayList<Integer> subCategoryCount = new ArrayList<Integer>();
        int count;
        Typeface type;

        SubCategory singleChild = new SubCategory();

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
        public int getChildrenCount(int groupPosition)
        {

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

            ImageView indicator=(ImageView)view.findViewById(R.id.expicon);

            if(groupPsition!=0 && groupPsition!=1 )

            {
                indicator.setVisibility(view.INVISIBLE);

            }else {

                indicator.setVisibility(view.VISIBLE);
                indicator.setImageResource(isExpanded ? R.drawable.ic_keyboard_arrow_up_black_24dp:R.drawable.ic_keyboard_arrow_down_black_24dp);


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

    public void getCatData()
    {
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
        subCategoryMatch.setSubCatName("Core Team");
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
        subCategoryMatch.setSubCatName("Gallery");
        subCategoryMatch.setSubCatCode("2005");
        subCategoryMatches.add(subCategoryMatch);

        subCategoryMatch = new SubCategory();
        subCategoryMatch.setSubCatName("Our Volunteer");
        subCategoryMatch.setSubCatCode("2002");
        subCategoryMatches.add(subCategoryMatch);



        subcategory_name.add(subCategoryMatches);
        subCatCount.add(subCategoryMatches.size());





    }
}

