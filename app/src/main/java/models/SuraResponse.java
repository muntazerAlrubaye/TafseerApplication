package models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohammed on 1/28/18.
 */

public class SuraResponse {

    @SerializedName("verse_0")
    private String verse1;

    public SuraResponse() {
    }

    public String getVerse1() {
        return verse1;
    }

    public void setVerse1(String verse1) {
        this.verse1 = verse1;
    }
}
