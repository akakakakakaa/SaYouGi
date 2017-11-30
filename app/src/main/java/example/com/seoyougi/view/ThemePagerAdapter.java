package example.com.seoyougi.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import example.com.seoyougi.R;
import example.com.seoyougi.model.Theme;

/**
 * Created by mansu on 2017-11-27.
 */

public class ThemePagerAdapter extends PagerAdapter {
    private Context context;
    private List<Theme> themes;

    public ThemePagerAdapter(@NonNull Context context) {
        this.context = context;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    @Override
    public int getCount() {
        if(themes == null)
            return 0;
        else
            return themes.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_theme, container, false);
        ImageView themeImage = (ImageView)view.findViewById(R.id.themeImage);
        Picasso.with(context).load(R.drawable.ic_launcher_background).into(themeImage);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ThemeDetailActivity.class);
                intent.putExtra("theme", themes.get(position));
                context.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
