package edu.cvtc.sradke7.contentcreatortcg.api.models;

import com.google.gson.annotations.SerializedName;

public class ImageUriResponse {

    @SerializedName("png")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
