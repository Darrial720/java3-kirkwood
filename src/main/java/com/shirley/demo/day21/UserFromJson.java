package com.shirley.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserFromJson {
    @JsonProperty("results")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
}

class User {
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
}

class Name {
    @JsonProperty("title")
    private String title;
    @JsonProperty("first")
    private String first;
    @JsonProperty("last")
    private String last;

    @Override
    public String toString() {
        return title + ' ' + first + ' ' + last ;
    }
}

class Location {
    @JsonProperty("street")
    private Street street;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("coordinates")
    private Coordinates coordinates;
    @JsonProperty("timezone")
    private Timezone timezone;


    @Override
    public String toString() {
        return "{" +
                "street=" + street +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postcode='" + postcode + '\'' +
                ", coordinates=" + coordinates +
                ", timezone=" + timezone +
                '}';
    }
}

class Street {
    @JsonProperty("number")
    private String number;
    @JsonProperty("name")
    private String name;


    @Override
    public String toString() {
        return "{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
class Coordinates {
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;

    @Override
    public String toString() {
        return "{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
class Timezone {
    @JsonProperty("offset")
    private String offset;
    @JsonProperty("description")
    private String description;

    @Override
    public String toString() {
        return "{" +
                "offset='" + offset + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

class Login{
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("salt")
    private String salt;
    @JsonProperty("md5")
    private String md5;
    @JsonProperty("sha1")
    private String sha1;
    @JsonProperty("sha256")
    private String sha256;

    @Override
    public String toString() {
        return "{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", md5='" + md5 + '\'' +
                ", sha1='" + sha1 + '\'' +
                ", sha256='" + sha256 + '\'' +
                '}';
    }
}

class DOB{
    @JsonProperty("date")
    private String date;
    @JsonProperty("age")
    private String age;

    @Override
    public String toString() {
        return "{" +
                "date='" + date + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

class Id {
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;

    @Override
    public String toString() {
        return "Id{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

class Registered {
    @JsonProperty("date")
    private String date;
    @JsonProperty("age")
    private int age;

    @Override
    public String toString() {
        return "Registered{" +
                "date=" + date +
                ", age=" + age +
                '}';
    }
}

class Picture {
    @JsonProperty("large")
    private String large;
    @JsonProperty("medium")
    private String medium;
    @JsonProperty("thumbnail")
    private String thumbnail;

    @Override
    public String toString() {
        return "Picture{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}