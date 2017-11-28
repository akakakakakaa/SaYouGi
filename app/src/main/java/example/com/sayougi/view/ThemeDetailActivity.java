package example.com.sayougi.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.skp.Tmap.TMapView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.http.HttpRequest;
import example.com.sayougi.model.Theme;
import retrofit2.Call;

/**
 * Created by icns on 2017-11-28.
 */

public class ThemeDetailActivity extends AppCompatActivity {
    @BindView(R.id.themeDetailTMap)
    TMapView themeDetailTMap;
    @BindView(R.id.themeDetailSights)
    RecyclerView themeDetailSights;

    private Theme theme;
    private ThemeDetailAdapter themeDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_detail);
        ButterKnife.bind(this);

        theme = (Theme)getIntent().getSerializableExtra("theme");

        setThemeDetailTMap();
        setThemeDetailSights();
    }

    private void setThemeDetailTMap() {
        themeDetailTMap.setSKPMapApiKey("d150ad83-ba12-3429-9ace-db72ff7f4c7d");
        themeDetailTMap.setCompassMode(true);
        themeDetailTMap.setIconVisibility(true);
        themeDetailTMap.setZoomLevel(15);
        themeDetailTMap.setMapType(TMapView.MAPTYPE_STANDARD);
        themeDetailTMap.setLanguage(TMapView.LANGUAGE_KOREAN);
        themeDetailTMap.setTrackingMode(true);
        themeDetailTMap.setSightVisible(true);
    }

    private void setThemeDetailSights() {
        themeDetailSights.setLayoutManager(new LinearLayoutManager(this));
        themeDetailAdapter = new ThemeDetailAdapter(this);
        themeDetailSights.setAdapter(themeDetailAdapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest.SaYouGiService service = HttpRequest.getSaYouGiService();
                Call<String> request = service.getThemePlaceJson(theme.getId());
                try {
                    String json = request.execute().body();
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = (JSONArray)jsonObject.get("data");

                    for(int i=0; i<jsonArray.length(); i++) {
                        JSONObject data = (JSONObject)jsonArray.get(i);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch(JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}