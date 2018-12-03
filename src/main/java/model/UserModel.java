package model;

import builder.UserBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserModel {

    @JsonProperty("id")
    private long id;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("userStatus")
    private long userStatus;

    public UserModel () {};
    public UserModel (UserBuilder builder) {
        builder.id=this.id;
        builder.userName=this.userName;
        builder.firstName=this.firstName;
        builder.lastName=this.lastName;
        builder.email=this.email;
        builder.password=this.password;
        builder.phone=this.phone;
        builder.userStatus=this.userStatus;
    };

    // Getter Methods

    public long getId() {
        return id;
    }

    public String getUsername() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public long getUserStatus() {
        return userStatus;
    }

    // Setter Methods

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserStatus(long userStatus) {
        this.userStatus = userStatus;
    }

}