package com.theah64.xrob.models;

/**
 * Created by theapache64 on 4/9/16.
 */
public class Contact {

    private final String id, name, phone;
    private final boolean isSynced;

    public Contact(String id, String name, String phone, boolean isSynced) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.isSynced = isSynced;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isSynced() {
        return isSynced;
    }
}