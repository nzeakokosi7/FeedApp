package com.varscon.feedapplication.Models;

import com.google.gson.annotations.SerializedName;

public class Title {

    @SerializedName("value")
    private String value;

    @SerializedName("attributes")
    private Attributes attributes;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Attributes getAttributes() {
        return attributes;
    }
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}
