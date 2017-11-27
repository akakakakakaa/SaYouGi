package example.com.sayougi.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.model.Theme;

/**
 * Created by mansu on 2017-11-27.
 */

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ViewHolder> {

    private Context context;
    private List<Theme> themes;

    public ThemeAdapter(@NonNull Context context, List<Theme> themes) {
        this.context = context;
        this.themes = themes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_theme, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.themeName.setText(themes.get(position).getName());
        holder.themeImagesRecyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        holder.themeImagesRecyclerView.addItemDecoration(new SpacesItemDecoration(10));
        ThemeImageAdapter themeImageAdapter = new ThemeImageAdapter(context, themes.get(position).getImageUrls());
        holder.themeImagesRecyclerView.setAdapter(themeImageAdapter);
    }

    @Override
    public int getItemCount() {
        return themes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.themeName)
        TextView themeName;
        @BindView(R.id.themeImagesRecyclerView)
        RecyclerView themeImagesRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
