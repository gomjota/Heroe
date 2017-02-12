package com.github.juan1393.heroe.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.juan1393.heroe.R;
import com.github.juan1393.heroe.ui.adapter.displayModel.ComicsDisplayModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Juan Gómez on 12/2/17.
 */

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ViewHolder> {

    private Context context;
    private ComicsDisplayModel comics;

    public ComicsAdapter(Context context, ComicsDisplayModel comics) {
        this.context = context;
        this.comics = comics;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comic, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ComicsDisplayModel.ComicDisplayModel comic
                = comics.get(position);

        Picasso.with(context)
                .load(comic.getThumbnail())
                .into(holder.image);

        holder.title.setText(comic.getTitle());
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.comic_image)
        ImageView image;
        @BindView(R.id.comic_title)
        TextView title;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}