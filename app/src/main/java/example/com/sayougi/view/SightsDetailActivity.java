package example.com.sayougi.view;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.skp.Tmap.TMapMarkerItem;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.sayougi.R;
import example.com.sayougi.http.HttpRequest;
import example.com.sayougi.model.Sights;
import retrofit2.Call;

/**
 * Created by mansu on 2017-11-27.
 */

public class SightsDetailActivity extends AppCompatActivity {
    @BindView(R.id.sightsDetailTitle)
    TextView sightsDetailTitle;
    @BindView(R.id.sightsDetailTMapView)
    TMapView sightsDetailTMapView;
    @BindView(R.id.sightsDetailOldAddress)
    TextView sightsDetailOldAddress;
    @BindView(R.id.sightsDetailNewAddress)
    TextView sightsDetailNewAddress;
    @BindView(R.id.sightsDetailDescription)
    TextView sightsDetailDescription;

    private Sights sights;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights_detail);
        ButterKnife.bind(this);

        sights = (Sights)getIntent().getSerializableExtra("sights");

        setSightsInfo();
        setSightsDetailTMapView();
    }

    @OnClick(R.id.sightsBack)
    public void backClicked() {
        finish();
    }

    private void setSightsInfo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest.SaYouGiService service = HttpRequest.getSaYouGiService();
                Call<String> json = service.getPlaceJson(sights.getId());
                try {
                    String result = json.execute().body();
                    final JSONObject object = new JSONObject(result);
                    final JSONObject object2 = new JSONObject(object.getString("extra"));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String detail = object2.getString("주요내용");
                                String detail2 = object2.getString("자세히보기(모바일바로가기)");
                                String detail3 = object2.getString("자세히보기(홈페이지바로가기)");
                                sightsDetailDescription.setText(((detail != null) ? detail : "") + "\n" + ((detail2 != null) ? detail2 : "") + "\n" + ((detail3 != null) ? detail3 : ""));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        sightsDetailTitle.setText(sights.getName());
        sightsDetailOldAddress.setText(sights.getAddrOld());
        sightsDetailNewAddress.setText(sights.getAddrNew());
        //sightsDetailDescription.setText(sights.getExtra());
    }

    private void setSightsDetailTMapView() {
        sightsDetailTMapView.setSKPMapApiKey("d150ad83-ba12-3429-9ace-db72ff7f4c7d");
        sightsDetailTMapView.setCompassMode(true);
        sightsDetailTMapView.setIconVisibility(true);
        sightsDetailTMapView.setZoomLevel(15);
        sightsDetailTMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        sightsDetailTMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        sightsDetailTMapView.setTrackingMode(true);
        sightsDetailTMapView.setSightVisible(true);
        sightsDetailTMapView.setLocationPoint(Float.parseFloat(sights.getCoordX()), Float.parseFloat(sights.getCoordY()));
        TMapMarkerItem item = new TMapMarkerItem();
        item.setTMapPoint(new TMapPoint(Float.parseFloat(sights.getCoordX()), Float.parseFloat(sights.getCoordY())));
        item.setVisible(item.VISIBLE);
        item.setCalloutRightButtonImage(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        sightsDetailTMapView.addMarkerItem("marker", item);
    }
}
