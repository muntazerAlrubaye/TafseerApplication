package models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohammed on 1/26/18.
 */

public class Aya {

    @SerializedName("sura_index")
    private int suraIndex;
    @SerializedName("sura_name")
    private String suraName;
    @SerializedName("ayah_number")
    private int ayahNumber;
    @SerializedName("text")
    private String ayaText;

    public Aya() {
    }

    public Aya(int suraIndex, String suraName, int ayahNumber, String ayaText) {
        this.suraIndex = suraIndex;
        this.suraName = suraName;
        this.ayahNumber = ayahNumber;
        this.ayaText = ayaText;
    }

    public int getSuraIndex() {
        return suraIndex;
    }

    public void setSuraIndex(int suraIndex) {
        this.suraIndex = suraIndex;
    }

    public String getSuraName() {
        return suraName;
    }

    public void setSuraName(String suraName) {
        this.suraName = suraName;
    }

    public int getAyahNumber() {
        return ayahNumber;
    }

    public void setAyahNumber(int ayahNumber) {
        this.ayahNumber = ayahNumber;
    }

    public String getAyaText() {
        return ayaText;
    }

    public void setAyaText(String ayaText) {
        this.ayaText = ayaText;
    }
}
