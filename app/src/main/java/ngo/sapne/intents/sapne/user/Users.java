package ngo.sapne.intents.sapne.user;


public class Users {


        private String name;
        private String email;
        private String volunteer;
        private String dob;
        private String edu,phn;


        public Users(){

        }

        public Users(String name, String email, String volunteer,String dob,String edu,String phn) {
            this.name = name;
            this.email = email;
            this.volunteer = volunteer;
            this.dob=dob;
            this.edu=edu;
            this.phn=phn;
        }

        public String getname() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getVolunteer() {
            return volunteer;
        }
        public String getDob()
        {
            return dob;
    }
    public String getEdu()
    {
        return edu;
    }
    public String getPhn(){return phn;}
}
