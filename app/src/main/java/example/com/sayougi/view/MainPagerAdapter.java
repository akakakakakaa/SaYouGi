package example.com.sayougi.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by icns on 2017-11-24.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    MainPagerAdapter(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ItemListFragment();
                break;
            case 1:
                fragment = new ThemeFragment();
                break;
            case 2:
                fragment = new RecommendCourseFragment();
                break;
            case 3:
                fragment = new ThemeFragment();
                break;
            case 4:
                fragment = new ThemeFragment();
                break;
        }

        return fragment;
    }
}