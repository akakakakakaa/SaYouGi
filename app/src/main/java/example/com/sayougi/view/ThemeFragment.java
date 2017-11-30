package example.com.sayougi.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tmall.ultraviewpager.UltraViewPager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.http.HttpRequest;
import example.com.sayougi.model.Theme;
import retrofit2.Call;

/**
 * Created by mansu on 2017-11-27.
 */

public class ThemeFragment extends Fragment {
    @BindView(R.id.themeRecyclerView)
    RecyclerView themeRecyclerView;

    private ThemeAdapter themeAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_theme, container, false);
        ButterKnife.bind(this, view);

        //setThemeViewPager();
        setThemeRecyclerView();
        return view;
    }

    private void setThemeRecyclerView() {
        themeRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        themeAdapter = new ThemeAdapter(getContext());
        themeRecyclerView.setAdapter(themeAdapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest.SaYouGiService service = HttpRequest.getSaYouGiService();
                Call<String> request = service.getThemesJson(1);
                try {
                    String json = request.execute().body();
                    System.out.println(json);
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = (JSONArray)jsonObject.get("data");

                    final List<Theme> themes = new ArrayList<>();
                    for(int i=0; i<jsonArray.length(); i++) {
                        JSONObject data = (JSONObject)jsonArray.get(i);
                        themes.add(new Theme(data.getString("id"),
                                data.getString("lang"),
                                data.getString("name"),
                                data.getString("count_place"),
                                data.getString("description"),
                                data.getString("updated_at")));
                    }
                    themeAdapter.setThemes(themes);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            themeAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    /*
    private void setThemeViewPager() {
        themeViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        themeViewPager.setMultiScreen(0.6f);
        themeViewPager.setItemRatio(1.0f);
        themeViewPager.setAutoMeasureHeight(true);

        themePagerAdapter = new ThemePagerAdapter(getContext());
        themeViewPager.setAdapter(themePagerAdapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest.SaYouGiService service = HttpRequest.getSaYouGiService();
                Call<String> request = service.getThemesJson(1);
                try {
                    String json = request.execute().body();
                    System.out.println(json);
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = (JSONArray)jsonObject.get("data");

                    final List<Theme> themes = new ArrayList<>();
                    for(int i=0; i<jsonArray.length(); i++) {
                        JSONObject data = (JSONObject)jsonArray.get(i);
                        themes.add(new Theme(data.getString("id"),
                                data.getString("lang"),
                                data.getString("name"),
                                data.getString("count_place"),
                                data.getString("description"),
                                data.getString("updated_at")));
                    }
                    themePagerAdapter.setThemes(themes);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            themePagerAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    */
}