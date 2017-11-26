package example.com.sayougi.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;

/**
 * Created by icns on 2017-11-24.
 */

public class ItemListFragment extends Fragment {
    @BindView(R.id.itemListRecyclerView)
    RecyclerView itemListRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    private void setItemListRecyclerView() {
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        itemListRecyclerView.setLayoutManager(manager);
    }
}