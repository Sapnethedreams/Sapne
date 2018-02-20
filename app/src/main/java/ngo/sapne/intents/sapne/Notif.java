package ngo.sapne.intents.sapne;

/**
 * Created by Naruto on 2/14/2018.
 */

public class Notif {
    String notf;
    String title;
    public Notif(String notf,String title){
        this.notf=notf;
        this.title=title;
    }
    public String getNotif(){
        return notf;
    }
    public String getTitle(){
        return title;
    }

}
