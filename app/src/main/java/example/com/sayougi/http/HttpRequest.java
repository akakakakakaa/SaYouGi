package example.com.sayougi.http;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by icns on 2017-11-28.
 */

public class HttpRequest {
    public static SaYouGiService getSaYouGiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://115.68.182.176/api/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        return retrofit.create(SaYouGiService.class);
    }

    public interface SaYouGiService {
        @POST("places")
        Call<String> getPlacesJson(@Query("page") int page);
        @POST("themes")
        Call<String> getThemesJson(@Query("page") int page);
        @POST("theme/{theme}/places")
        Call<String> getThemePlaceJson(@Path("theme") String id);
        @POST("report")
        Call<String> reportJson(@Query("title") String title, @Query("content") String content, @Query("place_id") String placeId, @Query("theme_id") String themeId);
    }
}
