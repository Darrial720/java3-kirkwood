package com.shirley.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements Comparable<User>{
    @JsonProperty("name")
    private Name name;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("email")
    private String email;
    @JsonProperty("picture")
    private Picture picture;
    @JsonProperty("id")
    private Id id;
    @JsonProperty("registered")
    private Registered registered;
    @JsonProperty("login")
    private Login login;
    @JsonProperty("dob")
    private DOB dob;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("cell")
    private String cell;
    @JsonProperty("nat")
    private String nat;

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Picture getPicture() {
        return picture;
    }

    public Id getId() {
        return id;
    }

    public Registered getRegistered() {
        return registered;
    }

    public Login getLogin() {
        return login;
    }

    public DOB getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getCell() {
        return cell;
    }

    public String getNat() {
        return nat;
    }

    @Override
    public String toString() {
        return "User{" +
                "\n\tname=" + name +
                "\n\tgender='" + gender + '\'' +
                "\n\tlocation=" + location +
                "\n\temail='" + email + '\'' +
                "\n\tpicture='" + picture + '\'' +
                "\n\tid='" + id + '\'' +
                "\n\tregistered='" + registered + '\'' +
                "\n\tlogin='" + login + '\'' +
                "\n\tdob='" + dob + '\'' +
                "\n\tphone='" + phone + '\'' +
                "\n\tcell='" + cell + '\'' +
                "\n\tnat='" + nat + '\'' +
                "}\n";
    }


    @Override
    public int compareTo(User o) {
        int result = this.getName().getLast().compareTo(o.getName().getLast());
        if(result == 0){
            result = this.getName().getFirst().compareTo(o.getName().getFirst());
        }
        return result;
    }
}
