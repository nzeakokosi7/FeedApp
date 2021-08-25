package com.varscon.feedapplication.Models;

import com.google.gson.annotations.SerializedName;

public class Font {
    @SerializedName("size")
    private Integer size;

    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }
}
