

package ngo.sapne.intents.sapne;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ExpandingCells extends BaseActivity {

    private final int CELL_DEFAULT_HEIGHT = 150;
    private final int NUM_OF_CELLS = 3;

    private ExpandingListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     // setContentView(R.layout.activities1);
        getLayoutInflater().inflate(R.layout.activities1, frameLayout);
        ExpandableListItem[] values = new ExpandableListItem[] {
                new ExpandableListItem("Sapna", R.drawable.n1, "Joined on 8th June'16" ,CELL_DEFAULT_HEIGHT,
                        getResources().getString(R.string.short_lorem_ipsum)),
                new ExpandableListItem("Ajay", R.drawable.n2,"Joined on 3rd June'16", CELL_DEFAULT_HEIGHT,
                        getResources().getString(R.string.medium_lorem_ipsum)),
                new ExpandableListItem("Manpreet", R.drawable.n3, "Joined on 28th June'16",CELL_DEFAULT_HEIGHT,
                        getResources().getString(R.string.long_lorem_ipsum)),
        };

        List<ExpandableListItem> mData = new ArrayList<ExpandableListItem>();

        for (int i = 0; i < NUM_OF_CELLS; i++) {
            ExpandableListItem obj = values[i % values.length];
            mData.add(new ExpandableListItem(obj.getTitle(), obj.getImgResource(),obj.getdescr(),
                    obj.getCollapsedHeight(), obj.getText()));
        }

        CustomArrayAdapter adapter = new CustomArrayAdapter(this, R.layout.list_view_item, mData);

        mListView = (ExpandingListView)findViewById(R.id.main_list_view);
        mListView.setAdapter(adapter);
        mListView.setDivider(null);
    }

}
