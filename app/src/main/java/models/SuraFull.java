package models;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Mohammed on 1/28/2018.
 */

public class SuraFull {
    @SerializedName("name")
    private String sura_name;
    @SerializedName("verse")
    private JSONObject verse;

    public SuraFull() {
    }

    public String getSura_name() {
        return sura_name;
    }

    public void setSura_name(String sura_name) {
        this.sura_name = sura_name;
    }

    public JSONObject getVerse() {
        return verse;
    }

    public void setVerse(JSONObject verse) {
        this.verse = verse;
    }
}
