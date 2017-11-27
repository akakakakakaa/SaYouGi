package example.com.sayougi.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import example.com.sayougi.R;
import example.com.sayougi.model.RecommendCourse;

/**
 * Created by mansu on 2017-11-27.
 */

public class RecommendCourseAdapter extends PagerAdapter {
    private Context context;
    private List<RecommendCourse> recommendCourses;

    public RecommendCourseAdapter(@NonNull Context context, @NonNull List<RecommendCourse> recommendCourses) {
        this.context = context;
        this.recommendCourses = recommendCourses;
    }

    @Override
    public int getCount() {
        return recommendCourses.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_course, null);
        Picasso.with(context).load(recommendCourses.get(position).getImageUrl()).into((ImageView)view.findViewById(R.id.recommendCourseImage));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
