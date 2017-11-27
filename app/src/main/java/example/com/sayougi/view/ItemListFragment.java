package example.com.sayougi.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.model.RecommendItem;

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

        setItemListRecyclerView();

        return view;
    }

    private void setItemListRecyclerView() {
        itemListRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        List<RecommendItem> recommendItems = new ArrayList<>();
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        recommendItems.add(new RecommendItem("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S", "sadapovioineobineoabineorb"));
        ItemListAdapter itemListAdapter = new ItemListAdapter(getContext(), recommendItems);
        itemListRecyclerView.setAdapter(itemListAdapter);
    }
}