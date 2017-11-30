package example.com.sayougi.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.model.ThemeSights;

/**
 * Created by icns on 2017-11-28.
 */

public class ThemeDetailAdapter extends RecyclerView.Adapter<ThemeDetailAdapter.ViewHolder> {

    private Context context;
    private List<ThemeSights> themeSights;

    public ThemeDetailAdapter(@NonNull Context context) {
        this.context = context;
        themeSights = new ArrayList<>();
    }

    public void addThemeSights(ThemeSights themeSights) {
        this.themeSights.add(themeSights);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_theme_detail_sights, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return themeSights.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
