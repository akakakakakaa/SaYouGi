package example.com.sayougi.view;

import android.content.Context;
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
import example.com.sayougi.model.RecommendItem;

/**
 * Created by icns on 2017-11-24.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    private Context context;
    private List<RecommendItem> recommendItems;

    public ItemListAdapter(@NonNull Context context, @NonNull List<RecommendItem> recommendItems) {
        this.context = context;
        this.recommendItems = recommendItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommend, parent, false);
        return new ItemListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load(recommendItems.get(position).getImageUrl()).into(holder.recommendImage);
        holder.recommendDetail.setText(recommendItems.get(position).getDetail());
    }

    @Override
    public int getItemCount() {
        return recommendItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recommendImage)
        ImageView recommendImage;

        @BindView(R.id.recommendDetail)
        TextView recommendDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
