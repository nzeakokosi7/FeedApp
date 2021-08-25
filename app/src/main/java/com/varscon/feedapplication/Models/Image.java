package com.varscon.feedapplication.Models;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("url")
    private String url;

    @SerializedName("size")
    private Size size;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }
}