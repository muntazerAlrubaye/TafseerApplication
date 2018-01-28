package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mohammed on 1/28/2018.
 */

public class SuraFull {
    @SerializedName("name")
    private String sura_name;
    @SerializedName("verse")
    private List<SuraResponse> verse;

    public SuraFull() {
    }

    public SuraFull(String sura_name, List<SuraResponse> verse) {
        this.sura_name = sura_name;
        this.verse = verse;
    }

    public String getSura_name() {
        return sura_name;
    }

    public void setSura_name(String sura_name) {
        this.sura_name = sura_name;
    }

    public List<SuraResponse> getVerse() {
        return verse;
    }

    public void setVerse(List<SuraResponse> verse) {
        this.verse = verse;
    }
}
