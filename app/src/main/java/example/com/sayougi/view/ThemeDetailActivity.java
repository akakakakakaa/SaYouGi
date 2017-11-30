package example.com.sayougi.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.skp.Tmap.TMapMarkerItem;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.sayougi.R;
import example.com.sayougi.http.HttpRequest;
import example.com.sayougi.model.Sights;
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

    @OnClick(R.id.themeBack)
    public void themeBackClicked() {
        finish();
    }

    private void setThemeDetailTMap() {
        themeDetailTMap.setSKPMapApiKey("d150ad83-ba12-3429-9ace-db72ff7f4c7d");
        themeDetailTMap.setZoomLevel(15);
        themeDetailTMap.setMapType(TMapView.MAPTYPE_STANDARD);
        themeDetailTMap.setLanguage(TMapView.LANGUAGE_KOREAN);
        themeDetailTMap.setTrackingMode(false);
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
                    JSONArray jsonArray = new JSONArray(json);

                    final List<Sights> themeSights = new ArrayList<>();
                    for(int i=0; i<jsonArray.length(); i++) {
                        JSONObject data = (JSONObject)jsonArray.get(i);
                        themeSights.add(new Sights(data.getString("id"),
                                data.getString("lang"),
                                data.getString("name"),
                                data.getString("coord_x"),
                                data.getString("coord_y"),
                                data.getString("addr_new"),
                                data.getString("addr_old"),
                                data.getString("addr_region"),
                                data.getString("contact"),
                                data.getString("description"),
                                data.getString("content"),
                                data.getString("updated_at"),
                                data.getString("extra")));
                    }
                    themeDetailAdapter.setThemeSights(themeSights);

                    double centerX = 0;
                    double centerY = 0;
                    for(int i=0; i<themeSights.size(); i++) {
                        TMapMarkerItem markerItem1 = new TMapMarkerItem();

                        TMapPoint tMapPoint1 = new TMapPoint(Double.parseDouble(themeSights.get(i).getCoordX()), Double.parseDouble(themeSights.get(i).getCoordY())); // SKT타워
                        // 마커 아이콘

                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_pin);
                        markerItem1.setIcon(bitmap); // 마커 아이콘 지정
                        markerItem1.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
                        markerItem1.setTMapPoint(tMapPoint1); // 마커의 좌표 지정
                        markerItem1.setName(themeSights.get(i).getName()); // 마커의 타이틀 지정
                        themeDetailTMap.addMarkerItem("markerItem1", markerItem1); // 지도에 마커 추가

                        centerX += Double.parseDouble(themeSights.get(i).getCoordX());
                        centerY += Double.parseDouble(themeSights.get(i).getCoordY());
                    }
                    themeDetailTMap.setCenterPoint(Double.parseDouble(themeSights.get(0).getCoordX()), Double.parseDouble(themeSights.get(0).getCoordY()));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            double centerX = 0;
                            double centerY = 0;
                            themeDetailAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } catch(JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}