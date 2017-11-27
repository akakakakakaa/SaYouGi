package example.com.sayougi.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.model.Theme;

/**
 * Created by mansu on 2017-11-27.
 */

public class ThemeFragment extends Fragment {
    @BindView(R.id.themeRecyclerView)
    RecyclerView themeRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_theme, container, false);
        ButterKnife.bind(this, view);

        setThemeRecyclerView();

        return view;
    }

    private void setThemeRecyclerView() {
        themeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //get data from server
        List<Theme> themes = new ArrayList<>();
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://upload.wikimedia.org/wikipedia/commons/d/db/Patern_test.jpg");
        imageUrls.add("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S");
        imageUrls.add("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S");
        imageUrls.add("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S");
        imageUrls.add("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S");
        imageUrls.add("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S");
        imageUrls.add("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S");
        imageUrls.add("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S");
        imageUrls.add("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S");
        themes.add(new Theme("1", imageUrls));
        themes.add(new Theme("2", imageUrls));
        themes.add(new Theme("3", imageUrls));
        themes.add(new Theme("4", imageUrls));
        themes.add(new Theme("5", imageUrls));
        themes.add(new Theme("6", imageUrls));
        ThemeAdapter themeAdapter = new ThemeAdapter(getContext(), themes);
        themeRecyclerView.setAdapter(themeAdapter);
    }
}
