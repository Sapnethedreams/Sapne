package ngo.sapne.intents.sapne.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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

import ngo.sapne.intents.sapne.BaseActivity;
import ngo.sapne.intents.sapne.R;

public class ExtraEventsFragment extends Fragment implements DiscreteScrollView.OnItemChangedListener,
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
        rateItemButton = view.findViewById(R.id.item_btn_rate);

        eventList = EventList.get();
        data = eventList.getData();
        itemPicker = view.findViewById(R.id.item_picker);
        itemPicker.setOrientation(Orientation.HORIZONTAL);
        itemPicker.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new EventsAdapter(data));
        itemPicker.setAdapter(infiniteAdapter);
        itemPicker.setItemTransitionTimeMillis(400);
        itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        onItemChanged(data.get(0));

        view.findViewById(R.id.item_btn_rate).setOnClickListener(this);
        view.findViewById(R.id.item_btn_buy).setOnClickListener(this);
        view.findViewById(R.id.item_btn_comment).setOnClickListener(this);

        view.findViewById(R.id.btn_smooth_scroll).setOnClickListener(this);
        view.findViewById(R.id.btn_transition_time).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_btn_rate:
                int realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
                EventItem current = data.get(realPosition);
                changeRateButtonState();
                break;
            case R.id.home:

                break;
            case R.id.btn_transition_time:
                break;
            case R.id.btn_smooth_scroll:
                DiscreteScrollViewOptions.smoothScrollToUserSelectedPosition(itemPicker, v);
                break;
            default:
                showUnsupportedSnackBar();
                break;
        }
    }

    private void onItemChanged(EventItem eventItem) {
        currentItemName.setText(eventItem.getName());
        currentItemPrice.setText(eventItem.getDesc());
        changeRateButtonState();
    }

    private void changeRateButtonState() {
        rateItemButton.setImageResource(R.drawable.common_google_signin_btn_icon_dark);
        rateItemButton.setColorFilter(ContextCompat.getColor(getContext(), R.color.black));
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
