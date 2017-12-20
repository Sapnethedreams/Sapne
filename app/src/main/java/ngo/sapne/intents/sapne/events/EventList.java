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
                new EventItem(1, "Express your dreams", "To value everyone's dream - Sapne's motive", R.drawable.e3),
                new EventItem(2, "Lohri Celebration", "Marks the end of winter and coming of Spring", R.drawable.e1),
                new EventItem(3, "Republic Day", "Celebration with mini parade and national anthem", R.drawable.e2),
                new EventItem(4, "Truth and Dare", "Bringing out hidden curiosity among people", R.drawable.e4),
                new EventItem(5, "Independence Day", "Flag hosting and cultural programs", R.drawable.e5),
                new EventItem(6, "Cleanliness Drive", "Our contribution to a Swachh Bharat", R.drawable.e6),
                new EventItem(7, "Mrig Trishna", "An event to find smiles", R.drawable.e7));
    }

    public List<EventItem> getExtraData() {
        return Arrays.asList(
                new EventItem(1, "Safe Diwali Campaign", "Valued event", R.drawable.e8),
                new EventItem(2, "Diwali Fiesta", "Valued event", R.drawable.e9),
                new EventItem(3, "Children's Day", "Valued event", R.drawable.e10),
                new EventItem(4, "Kindness Day", "Valued event", R.drawable.e11),
                new EventItem(5, "Christmas Eve", "Valued event", R.drawable.e12),
                new EventItem(6, "1st Anniversary Of Spane", "Valued event", R.drawable.e13));
    }

}