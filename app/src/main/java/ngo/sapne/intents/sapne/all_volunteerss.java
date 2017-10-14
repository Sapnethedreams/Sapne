package ngo.sapne.intents.sapne;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;




public class all_volunteerss extends BaseActivity{



        ListView list;
        String[] web={
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",
                " ",











        };

        Integer[] imageId = {
                R.drawable.ss1,
                R.drawable.ss2,
                R.drawable.ss3,
                R.drawable.ss4,
                R.drawable.ss5,
                R.drawable.ss6,
                R.drawable.ss7,
                R.drawable.ss8,
                R.drawable.ss9,
                R.drawable.ss10,
                R.drawable.ss11,
                R.drawable.ss12,
                R.drawable.ss13,
                R.drawable.ss14,
                R.drawable.ss16
                , R.drawable.ss15,
                R.drawable.ss17,
                R.drawable.ss18,
                R.drawable.ss19,
                R.drawable.ss20,
                R.drawable.ss21,
                R.drawable.ss22,
                R.drawable.ss23,
                R.drawable.ss24


        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_volunteers);
            Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            Custom_List adapter= new Custom_List(all_volunteerss.this,web,imageId);
            list= (ListView)findViewById(R.id.list);
            list.setAdapter(adapter);

        }



    }


