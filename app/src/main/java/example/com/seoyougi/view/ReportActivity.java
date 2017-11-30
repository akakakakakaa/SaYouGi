package example.com.seoyougi.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.seoyougi.R;
import example.com.seoyougi.http.HttpRequest;

/**
 * Created by icns on 2017-11-28.
 */

public class ReportActivity extends AppCompatActivity {
    @BindView(R.id.reportTitle)
    TextView reportTitle;
    @BindView(R.id.reportContent)
    TextView reportContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.reportReport)
    public void reportClick(View view) {
        HttpRequest.SaYouGiService service = HttpRequest.getSaYouGiService();

        String title = reportTitle.getText().toString();
        String content = reportContent.getText().toString();
        service.reportJson(title, content, null, null);
        Toast.makeText(this, "제보되었습니다.", Toast.LENGTH_LONG).show();
        finish();
    }

    @OnClick(R.id.reportBack)
    public void reportBackClicked() {
        finish();
    }
}
