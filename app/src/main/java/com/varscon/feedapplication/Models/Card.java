package com.varscon.feedapplication.Models;

import com.google.gson.annotations.SerializedName;

public class Card {

    @SerializedName("card_type")
    private String card_type;

    @SerializedName("card")
    private _Card card;

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public _Card getCard() {
        return card;
    }

    public void setCard(_Card card) {
        this.card = card;
    }
}
