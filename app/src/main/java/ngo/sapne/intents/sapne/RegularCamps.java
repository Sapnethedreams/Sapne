package ngo.sapne.intents.sapne;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RegularCamps extends Fragment{
 private List<RegularCampItem> listData = new ArrayList<>();
    /*
    String names[]={"A teacher presents the past, reveals the present and creates the future, rightly said by John Holt. So, here at Sapne - our NGO, we are providing quality teachers, for the children who are willing to study and who want to make their future bright but due to some obstacles , they are unable to do so. Due to this reason, we are teaching them, making them capable for themselves and for the society too. We have organized regular camps in which we teach students, we provide the children with the academic education and apart from this, we play with them, we teach them how to live life to its fullest. And in the two hours of the camp, those children are so happy that their happiness, their joy, their cheer, cannot be expressed in words." ,
            "We believe that Learning is not the product of teaching , Learning is the product of activities of learners .\" So we indulge the children in various kinds of activities of their own interest and also in other activities which can benefit them in future. We dance together , we sing together , we play together , we study together , we giggle together , we gossip together , we share our memories , our experiences in those two hours of regular camps organized by Sapne For us , every sapna , every dream is important and hence we try our best to accomplish that , if not accomplish , we try our best to give that dream , a direction. For this , we provide teachers , who are skilled in their field of work and accordingly they teach , they train the students . In this way teachers get the platform to teach and express or share their knowledge , moreover , increase their knowledge , and students get quality education .\n" ,
            "\nWhile moving on the roads , we see many children who have not worn proper clothes , who are deprived of the basic needs , who should study and play at this age , but due to their financial conditions , they can't even think of doing all these things because , for them , three-time meal is more than enough for survival. Now the question arrises , What do we , as responsible citizen of the country , do for them ? Except for showing concern , except for being sympathetic , we do nothing . But Sapne , our NGO , is proud to tell that , we are doing something , we have taken first step and it is the \" First step that leads to the Final step . And we are sure that we will definitely reach till the final step with the support of our team and the children who want to make their future bright and satisfying .\n" ,
            "\n"};
    int[] images={R.drawable.b,R.drawable.banner,R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};
*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.content_regular1, container, false);
        initData();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RegularCamp_RecyclerAdapter myAdapter = new RegularCamp_RecyclerAdapter(listData);
        recyclerView.setAdapter(myAdapter);
        return view;
    }
  private void initData() {
        listData.add(new RegularCampItem(R.drawable.rc_1, R.string.regularcamp_para1));
        listData.add(new RegularCampItem(R.drawable.rc_2, R.string.regularcamp_para2));
        listData.add(new RegularCampItem(R.drawable.rc_3,R.string.regularcamp_para3));
    }
    private void it(){

    }
}
