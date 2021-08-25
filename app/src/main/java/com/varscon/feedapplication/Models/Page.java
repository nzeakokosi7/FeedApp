package com.varscon.feedapplication.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Page {
    @SerializedName("cards")
    private List<Card> cards = new ArrayList<Card>();
    public List<Card> getCards() {
        return cards;
    }
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}