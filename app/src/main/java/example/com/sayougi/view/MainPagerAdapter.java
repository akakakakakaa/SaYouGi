package example.com.sayougi.view;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by icns on 2017-11-24.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private Fragment currentFragment;

    MainPagerAdapter(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                currentFragment = new SightsListFragment();
                break;
            case 1:
                currentFragment = new ThemeFragment();
                break;
            case 2:
                //activity를 call할 위치
                currentFragment = new Fragment();
                break;
            case 3:
                currentFragment = new ThemeFragment();
                break;
            case 4:
                currentFragment = new ThemeFragment();
                break;
        }

        return currentFragment;
    }
}