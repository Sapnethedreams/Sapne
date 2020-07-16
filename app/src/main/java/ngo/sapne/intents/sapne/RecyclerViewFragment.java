package ngo.sapne.intents.sapne;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



public class RecyclerViewFragment extends Fragment {

    protected static final String RECYCLER_VIEW_TYPE = "recycler_view_type";
    private RecyclerViewType recyclerViewType;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_activity, container, false);

        recyclerViewType = RecyclerViewType.LINEAR_VERTICAL;
        recyclerView = view.findViewById(R.id.sectioned_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpToolbarTitle();
        populateRecyclerView();
    }

    //set toolbar title and set back button
    private void setUpToolbarTitle() {
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.all_volunteers_page));
    }

    //populate recycler view
    private void populateRecyclerView() {
        ArrayList<SectionModel> sectionModelArrayList = new ArrayList<>();
        //for loop for sections
        ArrayList<String> textA11 = new ArrayList<>();
        ArrayList<Integer> itemA11 = new ArrayList<>();
        ArrayList<String> textA12 = new ArrayList<>();
        ArrayList<Integer> itemA12 = new ArrayList<>();

        ArrayList<String> textA21 = new ArrayList<>();
        ArrayList<Integer> itemA21 = new ArrayList<>();
        ArrayList<String> textA22 = new ArrayList<>();
        ArrayList<Integer> itemA22 = new ArrayList<>();

        ArrayList<String> textA31 = new ArrayList<>();
        ArrayList<Integer> itemA31 = new ArrayList<>();
        ArrayList<String> textA32 = new ArrayList<>();
        ArrayList<Integer> itemA32 = new ArrayList<>();

        ArrayList<String> textA41 = new ArrayList<>();
        ArrayList<Integer> itemA41 = new ArrayList<>();
        ArrayList<String> textA42 = new ArrayList<>();
        ArrayList<Integer> itemA42 = new ArrayList<>();
        
        ArrayList<String> textA51 = new ArrayList<>();
        ArrayList<Integer> itemA51 = new ArrayList<>();
        ArrayList<String> textA52 = new ArrayList<>();
        ArrayList<Integer> itemA52 = new ArrayList<>();

        ArrayList<String> textA61 = new ArrayList<>();
        ArrayList<Integer> itemA61 = new ArrayList<>();
        ArrayList<String> textA62 = new ArrayList<>();
        ArrayList<Integer> itemA62 = new ArrayList<>();

        ArrayList<String> textA71 = new ArrayList<>();
        ArrayList<Integer> itemA71 = new ArrayList<>();
        ArrayList<String> textA72 = new ArrayList<>();
        ArrayList<Integer> itemA72 = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {

          if(i==1) {  //for loop for items
                  itemA11.add(R.drawable.neha);
                  itemA12.add(R.drawable.mohit);
                  textA11.add("Neha Kshirsagar ");
                  textA12.add("Mohit Ochani");
                  itemA11.add(R.drawable.shubham);
                  itemA12.add(R.drawable.pooja);
                  textA11.add("Shubham Pandey ");
                  textA12.add("Pooja Rai");
                  itemA11.add(R.drawable.naman10);
                  itemA12.add(R.drawable.arjun10);
                  textA11.add("Naman Rawat");
                  textA12.add("Arjun");

              //add the section and items to array list
              sectionModelArrayList.add(new SectionModel("Android Development Team", textA11,textA12, itemA11,itemA12));
          }


            if(i==2) {  //for loop for items

                itemA21.add(R.drawable.ashiti);
                itemA22.add(R.drawable.rishabh);
                textA21.add("Ashiti Khanuja");
                textA22.add("Rishabh Tiwari ");
                itemA21.add(R.drawable.shishir);
                itemA22.add(0);
                textA21.add("Shishir Ranjan");
                textA22.add("");


                //add the section and items to array list
                sectionModelArrayList.add(new SectionModel("WEB Development Team",textA21,textA22, itemA21,itemA22));
            }

            if(i==3) {  //for loop for items

                itemA31.add(R.drawable.deepit);
                itemA32.add(R.drawable.umang);
                textA31.add("Deepit Badani");
                textA32.add("Umang Nyati");
                itemA31.add(R.drawable.akshay);
                itemA32.add(0);
                textA31.add("Akshay Sharma");
                textA32.add("");


                //add the section and items to array list
                sectionModelArrayList.add(new SectionModel("Graphics Design Team",textA31,textA32, itemA31,itemA32));
            }

            if(i==4) {  //for loop for items

                itemA41.add(R.drawable.anant);
                itemA42.add(R.drawable.ashutosh);
                textA41.add("Anant Jain");
                textA42.add("Ashutosh Barnwal");
                itemA41.add(R.drawable.gurpreet);
                itemA42.add(R.drawable.manvendra);
                textA41.add("Gurpreet Singh");
                textA42.add("Manvendra Singh");
                itemA41.add(R.drawable.nitin);
                itemA42.add(R.drawable.vishal);
                textA41.add("Nitin Agarwal");
                textA42.add("Vishal Mittal");
                itemA41.add(R.drawable.prakhar);
                itemA42.add(R.drawable.shivi);
                textA41.add("Prakhar Bajpai");
                textA42.add("Shivi Goyal");
                itemA41.add(R.drawable.piyush10);
                itemA42.add(0);
                textA41.add("Piyush Dubey");
                textA42.add("");



                //add the section and items to array list
                sectionModelArrayList.add(new SectionModel("Event Management Team",textA41,textA42, itemA41,itemA42));
            }




            if(i==6) {  //for loop for items

                itemA61.add(R.drawable.abhilasha10);
                itemA62.add(R.drawable.ankur10);
                textA61.add("Abhilasha Gupta");
                textA62.add("Ankur Rai");
                itemA61.add(R.drawable.megha10);
                itemA62.add(R.drawable.suvasini10);
                textA61.add("Megha Hemant Priti Desai");
                textA62.add("Suvasini Sherchan");
                itemA61.add(R.drawable.vishnupriya10);
                itemA62.add(0);
                textA61.add("Vishnupriya");
                textA62.add("");


                //add the section and items to array list
                sectionModelArrayList.add(new SectionModel("Content Writing Team",textA61,textA62, itemA61,itemA62));
            }

            if(i==7) {  //for loop for items

                itemA71.add(R.drawable.jennifer10);
                itemA72.add(R.drawable.dhananjay10);
                textA71.add("Jennifer");
                textA72.add("Dhananjay Kumar");


                //add the section and items to array list
                sectionModelArrayList.add(new SectionModel("Teaching Team",textA71,textA72, itemA71,itemA72));
            }

            if(i==5) {  //for loop for items

                itemA51.add(R.drawable.sanya10);
                itemA52.add(R.drawable.ishika10);
                textA51.add("Sanya Jain");
                textA52.add("Ishika Jain");
                itemA51.add(R.drawable.kiranjeet10);
                itemA52.add(R.drawable.piyush20);
                textA51.add("Kiranjeet Kaur");
                textA52.add("Piyush Gupta");
                itemA51.add(R.drawable.krishnaveni10);
                itemA52.add(R.drawable.ashish10);
                textA51.add("Krishnaveni Rathod");
                textA52.add("Ashish Raipuria");
                itemA51.add(R.drawable.saksham10);
                itemA52.add(R.drawable.radhika10);
                textA51.add("Saksham Jindal");
                textA52.add("Radhika Saraf");
                itemA51.add(R.drawable.namrata10);
                itemA52.add(R.drawable.anirudh10);
                textA51.add("Namrata Kushwaha");
                textA52.add("Anirudh Garg");





                //add the section and items to array list
                sectionModelArrayList.add(new SectionModel("HR / ADMIN Team",textA51,textA52, itemA51,itemA52));
            }


        }

        SectionRecyclerViewAdapter adapter = new SectionRecyclerViewAdapter(getActivity(), recyclerViewType, sectionModelArrayList);
        recyclerView.setAdapter(adapter);
    }
}
