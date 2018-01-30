package rest;

import org.json.JSONObject;

import java.util.List;

import models.Aya;
import models.Sura;
import models.SuraFull;
import models.Tafseer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mohammed on 1/26/18.
 */

public interface ApiInterface {
    @GET("quran/")
    Call<List<Sura>> getSoura();

    @GET("quran/{sura_number}/{ayah_number}")
    Call<Aya> getAya(@Path("sura_number") int suarNumber, @Path("ayah_number") int ayahNumber);

    @GET("tafseer/")
    Call<List<Tafseer>> getTafseerName();

    @GET("surah_{sura_index}.json")
    Call<SuraFull> getFullSura(@Path("sura_index") String index);
}
