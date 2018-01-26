package models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohammed on 1/26/18.
 */

public class Tafseer {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public Tafseer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tafseer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
