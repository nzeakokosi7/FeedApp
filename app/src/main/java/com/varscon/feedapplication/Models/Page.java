package com.varscon.feedapplication.Models;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private List<Card> cards = new ArrayList<Card>();
    public List<Card> getCards() {
        return cards;
    }
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}