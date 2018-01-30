package models;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Mohammed on 1/28/2018.
 */

public class SuraFull {
    @SerializedName("index")
    private String suraIndex;
    @SerializedName("name")
    private String sura_name;
    @SerializedName("verse")
    private JsonObject verse;
    @SerializedName("count")
    private int verse_count;

    public SuraFull() {
    }

    public String getSuraIndex() {
        return suraIndex;
    }

    public void setSuraIndex(String suraIndex) {
        this.suraIndex = suraIndex;
    }

    public String getSura_name() {
        return sura_name;
    }

    public void setSura_name(String sura_name) {
        this.sura_name = sura_name;
    }

    public JsonObject getVerse() {
        return verse;
    }

    public void setVerse(JsonObject verse) {
        this.verse = verse;
    }

    public int getVerse_count() {
        return verse_count;
    }

    public void setVerse_count(int verse_count) {
        this.verse_count = verse_count;
    }
}
