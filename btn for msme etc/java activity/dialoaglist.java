package ngo.sapne.intents.sapne;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class dialoaglist extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewlayout);
        ArrayAdapter<String> adapter;

        listView=findViewById(R.id.dialoglistid);

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.add("MSME");
        adapter.add("APPLY FOR RATION-CARD");
        adapter.add("APPLY FOR PASSPORT");
        adapter.add("WIDRAW PF");
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent =new Intent(dialoaglist.this,websites.class);

        if(position==0)
        {
            intent.putExtra("posi","0");
            startActivity(intent);
        }

        if(position==1)
        {
            intent.putExtra("posi","1");
            startActivity(intent);
        }

        if(position==2)
        {
            intent.putExtra("posi","2");
            startActivity(intent);
        }

        if(position==3)
        {
            intent.putExtra("posi","3");
            startActivity(intent);
        }



    }

}
