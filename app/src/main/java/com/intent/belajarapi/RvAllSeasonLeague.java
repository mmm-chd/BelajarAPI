package com.intent.belajarapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RvAllSeasonLeague extends RecyclerView.Adapter<RvAllSeasonLeague.ViewHolder> {

    private List<ModelClass> teamList;

    public RvAllSeasonLeague(AllSeasonActivity allSeasonActivity, List<ModelClass> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_season, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass team = teamList.get(position);
        holder.txtSeason.setText(team.getStrSeason());
        // Load image with Glide
        Glide.with(holder.itemView.getContext())
                .load(team.getStrBadge())
                .error(R.drawable.unavailable)
                .into(holder.ivBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtSeason;
        ImageView ivBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSeason = itemView.findViewById(R.id.txtSeason);
            ivBadge = itemView.findViewById(R.id.ivBadge);
        }
    }
}
