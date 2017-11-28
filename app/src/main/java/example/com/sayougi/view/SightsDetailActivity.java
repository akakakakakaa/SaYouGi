package example.com.sayougi.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.skp.Tmap.TMapView;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.model.Sights;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights_detail);
        ButterKnife.bind(this);

        setSights();
    }

    private void setSights() {
        Sights sights = (Sights)getIntent().getSerializableExtra("sights");
        sightsDetailTitle.setText(sights.getName());
        sightsDetailOldAddress.setText(sights.getAddrOld());
        sightsDetailNewAddress.setText(sights.getAddrNew());
        sightsDetailDescription.setText(sights.getDescription());
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
    }
}
