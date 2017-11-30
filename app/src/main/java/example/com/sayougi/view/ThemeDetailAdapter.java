package example.com.sayougi.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.model.Sights;

/**
 * Created by icns on 2017-11-28.
 */

public class ThemeDetailAdapter extends RecyclerView.Adapter<ThemeDetailAdapter.ViewHolder> {

    private Context context;
    private List<Sights> themeSights;

    public ThemeDetailAdapter(@NonNull Context context) {
        this.context = context;
    }

    public void setThemeSights(List<Sights> themeSights) {
        this.themeSights = themeSights;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_theme_detail_sights, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.themeDetailSightsName.setText(themeSights.get(position).getName());
        holder.themeDetailSightsAddress.setText(themeSights.get(position).getAddrNew());
        holder.themeDetailSightsDescription.setText(themeSights.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        if(themeSights == null)
            return 0;
        else
            return themeSights.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.themeDetailSightsName)
        TextView themeDetailSightsName;
        @BindView(R.id.themeDetailSightsAddress)
        TextView themeDetailSightsAddress;
        @BindView(R.id.themeDetailSightsDescription)
        TextView themeDetailSightsDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
