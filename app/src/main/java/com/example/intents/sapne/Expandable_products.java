package com.example.intents.sapne;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Expandable_products extends Activity {


    Products_Adapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new Products_Adapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Description");
        listDataHeader.add("Designer Information");
        listDataHeader.add("Details and Care");

        // Adding child data
        List<String> Description = new ArrayList<String>();
        Description.add("Design and Patented by SAPNE");
        Description.add("Design and Patented by SAPNE");
        Description.add("Design and Patented by SAPNE");

        List<String> Designer_Information = new ArrayList<String>();
        Designer_Information.add("Storm and midnight-blue stretch cotton-blend");
        Designer_Information.add("Notch lapels, functioning buttoned cuffs, two front flap pockets");
        Designer_Information.add("Single vent, internal pocket");
        Designer_Information.add("Two button fastening");
        Designer_Information.add("84% cotton, 14% nylon, 2% elastane");
        Designer_Information.add("Dry clean");

        List<String> Details_and_Care = new ArrayList<String>();
        Details_and_Care.add("An infusion of West Coast cool and New York attitude, Rebecca Minkoff is synonymous with It girl style");
        Details_and_Care.add(" Minkoff burst on the fashion scene with her best-selling 'Morning After Bag' ");
        Details_and_Care.add("Later she expanded her offering with the Rebecca Minkoff Collection ");
        Details_and_Care.add("a range of luxe city staples with a \"downtown romantic\" theme");

        listDataChild.put(listDataHeader.get(0), Description); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Designer_Information);
        listDataChild.put(listDataHeader.get(2), Details_and_Care);
    }


}
