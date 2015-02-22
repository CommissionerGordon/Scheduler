package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.interfaces.SQLObject;

import java.util.ArrayList;
import java.util.List;

/*
    User Table Schema

    USER_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    USER_NAME VARCHAR(30)
*/

public class User implements SQLObject {

    private int id;
    private String name;

    private List<Activity> activities;

    public User(int id, String name) {
        this.id = id;
        this.name = name;

        activities = new ArrayList<Activity>();
    }

    @Override
    public String getUpdateString() {
        return null;
    }
}
