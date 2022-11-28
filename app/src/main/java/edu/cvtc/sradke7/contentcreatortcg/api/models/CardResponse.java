package edu.cvtc.sradke7.contentcreatortcg.api.models;

import com.google.gson.annotations.SerializedName;

public class CardResponse {

    @SerializedName("name")
    private String cardName;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
/*
    @SerializedName("image_uris")
    private ImageUriResponse imageUri;
    */

}

