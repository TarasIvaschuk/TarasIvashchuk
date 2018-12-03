package builder;


import model.UserModel;

public class UserBuilder {

       public UserBuilder(){};

       public long id;
       public String userName;
       public String firstName;
       public String lastName;
       public String email;
       public String password;
       public String phone;
       public long userStatus;

       public UserBuilder userName (String userName){
       this.userName = userName;
       return this;
   }

       public UserBuilder id (long id){
       this.id = id;
       return this;
   }

       public UserBuilder firstName (String firstName){
       this.firstName = firstName;
       return this;
   }

       public UserBuilder lastName (String lastName){
       this.lastName = lastName;
       return this;
   }

       public UserBuilder email (String email) {
       this.email = email;
       return this;
   }

       public UserBuilder password (String password) {
       this.password = password;
       return this;
   }

    public UserBuilder phone (String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder userStatus (long userStatus) {
        this.userStatus = userStatus;
        return this;
    }

       public UserModel build () {
       return new UserModel (this);
   }

   }
