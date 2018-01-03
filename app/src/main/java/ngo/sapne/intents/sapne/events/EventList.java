package ngo.sapne.intents.sapne.events;

import java.util.Arrays;
import java.util.List;

import ngo.sapne.intents.sapne.R;

public class EventList {

    public static EventList get() {
        return new EventList();
    }

    public List<EventItem> getData() {
        return Arrays.asList(
                new EventItem(1, "Lohri Celebration", "Valued event", R.drawable.e1),
                new EventItem(2, "Lohri Celebration", "Valued event", R.drawable.e2),
                new EventItem(3, "Lohri Celebration", "Valued event", R.drawable.e3),
                new EventItem(4, "Lohri Celebration", "Valued event", R.drawable.e4),
                new EventItem(5, "Lohri Celebration", "Valued event", R.drawable.e5),
                new EventItem(6, "Lohri Celebration", "Valued event", R.drawable.e6),
                new EventItem(7, "Lohri Celebration", "Valued event", R.drawable.e7));
    }

    public List<EventItem> getExtraData() {
        return Arrays.asList(
                new EventItem(1, "Lohri Celebration", "Valued event", R.drawable.e8),
                new EventItem(2, "Lohri Celebration", "Valued event", R.drawable.e9),
                new EventItem(3, "Lohri Celebration", "Valued event", R.drawable.e10),
                new EventItem(4, "Lohri Celebration", "Valued event", R.drawable.e11),
                new EventItem(5, "Lohri Celebration", "Valued event", R.drawable.e12),
                new EventItem(6, "Lohri Celebration", "Valued event", R.drawable.e13),
                new EventItem(7, "Lohri Celebration", "Valued event", R.drawable.e14));
    }

}