package example.com.sayougi.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.sayougi.R;

/**
 * Created by icns on 2017-11-28.
 */

public class ReportActivity extends AppCompatActivity {
    public static final int SELECT_PICTURE = 1;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.reportReport)
    public void reportClick(View view) {
        Toast.makeText(this, "제보되었습니다.", Toast.LENGTH_LONG).show();
    }
}
