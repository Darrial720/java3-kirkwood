package com.shirley.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;

class Login {
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
