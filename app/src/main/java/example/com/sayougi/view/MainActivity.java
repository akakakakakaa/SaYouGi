package example.com.sayougi.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

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
                .setBarBackgroundColor(R.color.colorPrimary)
                .setInActiveColor(R.color.white)
                .setActiveColor(R.color.white)
                .addItem(new BottomNavigationItem(R.drawable.ic_location, "추천명소"))
                .addItem(new BottomNavigationItem(R.drawable.ic_theme, "테마"))
                .addItem(new BottomNavigationItem(R.drawable.ic_report, "신고"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_background, "로그아웃"))
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
                else if(position == 3)
                    finish();
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