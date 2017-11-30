package example.com.sayougi.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.model.Theme;

/**
 * Created by mansu on 2017-11-30.
 */

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ViewHolder> {

    private Context context;
    private List<Theme> themes;

    public ThemeAdapter(@NonNull Context context) {
        this.context = context;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_theme, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.themeDetail.setText(themes.get(position).getName());
        Picasso.with(context).load("http://115.68.182.176/api/place/"+ themes.get(position).getId()+"/thumbnail").into(holder.themeImage);
        holder.themeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ThemeDetailActivity.class);
                intent.putExtra("theme", themes.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(themes == null)
            return 0;
        else
            return themes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.themeImage)
        ImageView themeImage;
        @BindView(R.id.themeDetail)
        TextView themeDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
