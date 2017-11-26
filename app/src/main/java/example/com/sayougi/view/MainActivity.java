package example.com.sayougi.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setViewPager();
        setNavigationBar();
    }

    private void setViewPager() {
        List<Class<? extends Fragment>> fragments = new ArrayList<>();
        fragments.add(ItemListFragment.class);

        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        mainViewPager.setAdapter(mainPagerAdapter);
    }

    private void setNavigationBar() {
        /*
        mainBottomNavigation
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books"))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music"))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "Movies & TV"))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "Games"))
                .initialise();
        */
        mainBottomNavigation.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                mainViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                mainViewPager.setCurrentItem(position);
            }
        });
    }
}