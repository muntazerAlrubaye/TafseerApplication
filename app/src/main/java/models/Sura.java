package models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohammed on 1/26/18.
 */

public class Sura {
    @SerializedName("index")
    private int index;

    @SerializedName("name")
    private String name;

    public Sura(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public Sura() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
