package com.varscon.feedapplication.Models;

import com.google.gson.annotations.SerializedName;

public class _Card {
    @SerializedName("value")
    private String value;

    @SerializedName("attributes")
    private Attributes attributes;

    @SerializedName("title")
    private Title title;

    @SerializedName("description")
    private Description description;

    @SerializedName("image")
    private Image image;


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
    public Title getTitle() {
        return title;
    }
    public void setTitle(Title title) {
        this.title = title;
    }
    public Description getDescription() {
        return description;
    }
    public void setDescription(Description description) {
        this.description = description;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
}
