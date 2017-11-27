package example.com.sayougi.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraDepthScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.model.RecommendCourse;

/**
 * Created by mansu on 2017-11-27.
 */

public class RecommendCourseFragment extends Fragment {
    @BindView(R.id.recommendCourseViewPager)
    UltraViewPager recommendCourseViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend_course, container, false);
        ButterKnife.bind(this, view);

        setRecommendCourseViewPager();

        return view;
    }

    private void setRecommendCourseViewPager() {
        recommendCourseViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        recommendCourseViewPager.setMultiScreen(0.6f);
        recommendCourseViewPager.setItemRatio(1.0f);
//                ultraViewPager.setRatio(2.0f);
//                ultraViewPager.setMaxHeight(800);
        recommendCourseViewPager.setPageTransformer(false, new UltraDepthScaleTransformer());
        List<RecommendCourse> recommendCourses = new ArrayList<>();
        recommendCourses.add(new RecommendCourse("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S"));
        recommendCourses.add(new RecommendCourse("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S"));
        recommendCourses.add(new RecommendCourse("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S"));
        recommendCourses.add(new RecommendCourse("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S"));
        recommendCourses.add(new RecommendCourse("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S"));
        recommendCourses.add(new RecommendCourse("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S"));
        recommendCourses.add(new RecommendCourse("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S"));
        recommendCourses.add(new RecommendCourse("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S"));
        recommendCourses.add(new RecommendCourse("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S"));
        recommendCourses.add(new RecommendCourse("http://korean.visitseoul.net/comm/getImage?srvcId=MEDIA&parentSn=166&fileTy=MEDIA&fileNo=1&thumbTy=S"));

        RecommendCourseAdapter recommendCourseAdapter = new RecommendCourseAdapter(getContext(), recommendCourses);
        recommendCourseViewPager.setAdapter(recommendCourseAdapter);
    }
}
