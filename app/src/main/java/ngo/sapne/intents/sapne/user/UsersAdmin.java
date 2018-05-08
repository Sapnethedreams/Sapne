package ngo.sapne.intents.sapne.user;

/**
 * Created by Naruto on 2/28/2018.
 */

public class UsersAdmin {
    public UsersAdmin(){}

    private String admin,mobile;
    public UsersAdmin(String admin,String mobile){
        this.admin=admin;
        this.mobile=mobile;
    }
    public String getAdmin(){
        return admin;
    }
    public String getMobile(){return mobile;}
}
