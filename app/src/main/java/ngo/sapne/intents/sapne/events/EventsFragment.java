package ngo.sapne.intents.sapne.events;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.Orientation;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;

import ngo.sapne.intents.sapne.R;

public class EventsFragment extends Fragment implements DiscreteScrollView.OnItemChangedListener,
        View.OnClickListener {

    private List<EventItem> data;
    private EventList eventList;

    private TextView currentItemName;
    private TextView currentItemPrice;
    private ImageView rateItemButton;
    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter infiniteAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        currentItemName = view.findViewById(R.id.item_name);
        currentItemPrice = view.findViewById(R.id.item_price);
        rateItemButton = view.findViewById(R.id.item_btn_link);

        eventList = EventList.get();
        data = eventList.getData();
        itemPicker = view.findViewById(R.id.item_picker);
        itemPicker.setOrientation(Orientation.HORIZONTAL);
        itemPicker.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new EventsAdapter(data));
        itemPicker.setAdapter(infiniteAdapter);
        itemPicker.setItemTransitionTimeMillis(500);
        itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        onItemChanged(data.get(0));

        view.findViewById(R.id.item_btn_link).setOnClickListener(this);
        view.findViewById(R.id.item_btn_right).setOnClickListener(this);
        view.findViewById(R.id.item_btn_star).setOnClickListener(this);

        view.findViewById(R.id.btn_events_donate).setOnClickListener(this);
        view.findViewById(R.id.btn_events_more).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_btn_link:
                //int realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
                //EventItem current = data.get(realPosition);
                break;
            case R.id.btn_events_more:
                getActivity().getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.content_frame, new ExtraEventsFragment(), "ExtraEventsFragment")
                        .commit();
                break;
            case R.id.item_btn_right:
                DiscreteScrollViewOptions.smoothScrollToUserSelectedPosition(itemPicker, v);
                break;
            case R.id.btn_events_donate:
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.payumoney.com/paybypayumoney/#/206415"));
                startActivity(myIntent);
                break;
            default:
                break;
        }
    }

    private void onItemChanged(EventItem eventItem) {
        currentItemName.setText(eventItem.getName());
        currentItemPrice.setText(eventItem.getDesc());
    }

    @Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int position) {
        int positionInDataSet = infiniteAdapter.getRealPosition(position);
        onItemChanged(data.get(positionInDataSet));
    }

    private void showUnsupportedSnackBar() {
        Snackbar.make(itemPicker, "", Snackbar.LENGTH_SHORT).show();
    }
}