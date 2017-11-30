package example.com.seoyougi.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.seoyougi.R;
import example.com.seoyougi.http.HttpRequest;
import example.com.seoyougi.model.Sights;
import retrofit2.Call;

/**
 * Created by icns on 2017-11-24.
 */

public class SightsListFragment extends Fragment {
    @BindView(R.id.sightsListRecyclerView)
    RecyclerView sightsListRecyclerView;

    private SightsListAdapter sightsListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sights_list, container, false);
        ButterKnife.bind(this, view);

        setSightsListRecyclerView();

        return view;
    }

    private void setSightsListRecyclerView() {
        sightsListRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        sightsListAdapter = new SightsListAdapter(getContext());
        sightsListRecyclerView.setAdapter(sightsListAdapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest.SaYouGiService service = HttpRequest.getSaYouGiService();
                Call<String> request = service.getPlacesJson(1);
                try {
                    String json = request.execute().body();
                    System.out.println(json);
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = (JSONArray)jsonObject.get("data");

                    List<Sights> sights = new ArrayList<>();
                    for(int i=0; i<jsonArray.length(); i++) {
                        JSONObject data = (JSONObject)jsonArray.get(i);
                        sights.add(new Sights(data.getString("id"),
                                data.getString("lang"),
                                data.getString("name"),
                                data.getString("coord_x"),
                                data.getString("coord_y"),
                                data.getString("addr_new"),
                                data.getString("addr_old"),
                                data.getString("addr_region"),
                                data.getString("contact"),
                                data.getString("description"),
                                data.getString("content"),
                                data.getString("updated_at"),
                                data.getString("extra")));
                    }
                    sightsListAdapter.setSights(sights);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            sightsListAdapter.notifyDataSetChanged();
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
}