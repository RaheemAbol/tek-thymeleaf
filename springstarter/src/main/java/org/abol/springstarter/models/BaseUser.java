package org.abol.springstarter.models;


import lombok.Data;

@Data
public class BaseUser {

    private String name;
    private String email;
    private String tel;
    private String password;
    private String refer;
    private String contact;
    private boolean terms;
}
