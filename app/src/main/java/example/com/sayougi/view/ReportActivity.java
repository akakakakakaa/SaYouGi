package example.com.sayougi.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.sayougi.R;

/**
 * Created by icns on 2017-11-28.
 */

public class ReportActivity extends AppCompatActivity {
    @BindView(R.id.reportAddImage)
    ImageButton reportAddImage;

    public static final int SELECT_PICTURE = 1;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.reportAddImage)
    public void addImageClick(View view) {
        if(bitmap == null) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
        }
        else {
            bitmap = null;
        }
    }

    @OnClick(R.id.reportReport)
    public void reportClick(View view) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE && data != null) {
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, reportAddImage.getWidth(), reportAddImage.getHeight(), true);
                    reportAddImage.setImageBitmap(scaledBitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
