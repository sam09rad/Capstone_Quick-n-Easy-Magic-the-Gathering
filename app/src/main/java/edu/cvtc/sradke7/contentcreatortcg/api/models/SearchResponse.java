package edu.cvtc.sradke7.contentcreatortcg.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

    @SerializedName("data")
    private List<CardResponse> cards;

    public List<CardResponse> getCards() {
        return cards;
    }

    public void setCards(List<CardResponse> cards) {
        this.cards = cards;
    }
}
