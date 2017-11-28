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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sayougi.R;
import example.com.sayougi.model.Sights;

/**
 * Created by icns on 2017-11-24.
 */

public class SightsListAdapter extends RecyclerView.Adapter<SightsListAdapter.ViewHolder> {
    private Context context;
    private List<Sights> sights;

    public SightsListAdapter(@NonNull Context context) {
        this.context = context;
        this.sights = new ArrayList<>();
    }

    public void setSights(List<Sights> sights) {
        this.sights = sights;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sights, parent, false);
        return new SightsListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.sightsDetail.setText(sights.get(position).getDescription());
        Picasso.with(context).load("http://115.68.182.176/api/places/"+ sights.get(position).getId()+"/thumbnail").into(holder.sightsImage);
        holder.sightsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SightsDetailActivity.class);
                intent.putExtra("sights", sights.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sights.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sightsImage)
        ImageView sightsImage;

        @BindView(R.id.sightsDetail)
        TextView sightsDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
