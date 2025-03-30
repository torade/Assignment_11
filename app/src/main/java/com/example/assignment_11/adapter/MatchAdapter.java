package com.example.assignment_11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_11.R;
import com.example.assignment_11.model.Match;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {

    private List<Match> data;
    private final Context context;

    public MatchAdapter(Context context, List<Match> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_match, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Match match = data.get(position);
        holder.tvHomeTeam.setText(match.getHomeTeam());
        holder.tvAwayTeam.setText(match.getAwayTeam());
        holder.tvScore.setText(match.getScore());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHomeTeam, tvScore, tvAwayTeam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHomeTeam = itemView.findViewById(R.id.tv_home_team);
            tvScore = itemView.findViewById(R.id.tv_score);
            tvAwayTeam = itemView.findViewById(R.id.tv_away_team);
        }
    }

    public void setMatches(List<Match> newData) {
        this.data = newData;
        notifyDataSetChanged();
    }
}
