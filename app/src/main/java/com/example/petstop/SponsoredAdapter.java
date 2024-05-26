package com.example.petstop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SponsoredAdapter extends RecyclerView.Adapter<SponsoredAdapter.SponsoredViewHolder> {

    private List<SponsoredItem> sponsoredItems;

    public SponsoredAdapter(List<SponsoredItem> sponsoredItems) {
        this.sponsoredItems = sponsoredItems;
    }

    @NonNull
    @Override
    public SponsoredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sponsored_item, parent, false);
        return new SponsoredViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SponsoredViewHolder holder, int position) {
        SponsoredItem item = sponsoredItems.get(position);
        holder.imageView.setImageResource(item.getImageResource());
        holder.textView.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return sponsoredItems.size();
    }

    public static class SponsoredViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public SponsoredViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sponsoredImageView);
            textView = itemView.findViewById(R.id.sponsoredTextView);
        }
    }
}