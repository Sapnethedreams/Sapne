package ngo.sapne.intents.sapne;


public class Users {


        private String name;
        private String email;
        private String volunteer;
        private String dob;
        private String id;
        private String edu;


        public Users(){

        }

        public Users(String id,String name, String email, String volunteer,String dob,String edu) {
            this.name = name;
            this.id=id;
            this.email = email;
            this.volunteer = volunteer;
            this.dob=dob;
            this.edu=edu;
        }

        public String getId()
        {
            return id;
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
}
