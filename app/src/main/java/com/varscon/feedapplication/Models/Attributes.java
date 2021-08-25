package com.varscon.feedapplication.Models;

import com.google.gson.annotations.SerializedName;

public class Attributes {
    @SerializedName("text_color")
    private String textColor;

    @SerializedName("font")
    private Font font;

    public String getTextColor() {
        return textColor;
    }
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
    public Font getFont() {
        return font;
    }
    public void setFont(Font font) {
        this.font = font;
    }
}
