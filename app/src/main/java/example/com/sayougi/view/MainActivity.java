package example.com.sayougi.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.mainViewPager)
    NonSwipeableViewPager mainViewPager;

    @BindView(R.id.mainBottomNavigation)
    BottomNavigationBar mainBottomNavigation;

    private MainPagerAdapter mainPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setViewPager();
        setNavigationBar();
    }

    private void setViewPager() {
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(mainPagerAdapter);
    }

    private void setNavigationBar() {
        mainBottomNavigation
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_background, "Main"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_background, "Theme"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_background, "Course"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_background, "Movies & TV"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_background, "Games"))
                .initialise();

        mainBottomNavigation.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            int prevPosition;
            @Override
            public void onTabSelected(int position) {
                this.prevPosition = position;

                if(position == 2) {
                    Intent intent = new Intent(MainActivity.this, ReportActivity.class);
                    startActivity(intent);
                }
                else
                    mainViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
}