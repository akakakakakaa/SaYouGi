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
    private Context context;
    private List<Class<? extends Fragment>> fragments;

    MainPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull List<Class<? extends Fragment>> fragments) {
        super(fragmentManager);
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        try {
            Fragment fragment = fragments.get(position).getConstructor(String.class).newInstance();
            return fragment;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}