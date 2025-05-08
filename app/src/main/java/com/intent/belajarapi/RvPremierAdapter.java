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

public class RvPremierAdapter extends RecyclerView.Adapter<RvPremierAdapter.ViewHolder> {

    private List<ModelClass> teamList;

    public RvPremierAdapter(PremierActivity premierActivity, List<ModelClass> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass team = teamList.get(position);
        holder.txtTeam.setText(team.getStrTeam());
        holder.txtStadium.setText(team.getStrStadium());

        // Load image with Glide
        Glide.with(holder.itemView.getContext())
                .load(team.getStrBadge())
                .into(holder.ivBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTeam;
        private TextView txtStadium;
        private ImageView ivBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTeam = itemView.findViewById(R.id.txtTeam);
            txtStadium = itemView.findViewById(R.id.txtStadium);
            ivBadge = itemView.findViewById(R.id.ivBadge);
        }
    }
}
