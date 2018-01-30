package ngo.sapne.intents.sapne.events;

public class EventItem {

    private final int id;
    private final String name;
    private final String desc;
    private final int image;

    public EventItem(int id, String name, String desc, int image) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }
}