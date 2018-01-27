package rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohammed on 1/28/2018.
 */

public class ApiClientSura {
    public static final String BASE_URL =
            "https://raw.githubusercontent.com/semarketir/quranjson/master/source/surah/";
    private static Retrofit retrofit = null;

    public static Retrofit getAllSura() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
