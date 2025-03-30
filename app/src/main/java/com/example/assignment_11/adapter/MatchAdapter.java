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

/**
 * Adapter class for displaying a list of matches in a RecyclerView.
 */
public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {

    private List<Match> matches; // List of matches to be displayed
    private final Context context; // Context for inflating views

    /**
     * Constructor for MatchAdapter.
     *
     * @param context The context for inflating views.
     * @param matches The list of matches to be displayed.
     */
    public MatchAdapter(Context context, List<Match> matches) {
        this.context = context;
        this.matches = matches;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     *
     * @param parent   The ViewGroup into which the new View will be added.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_match, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Match match = matches.get(position);
        holder.bind(match);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return matches.size();
    }

    /**
     * Updates the list of matches and notifies the adapter that the data set has changed.
     *
     * @param newMatches The new list of matches to be displayed.
     */
    public void setMatches(List<Match> newMatches) {
        this.matches = newMatches;
        notifyDataSetChanged();
    }

    /**
     * ViewHolder class for holding the views of each item in the RecyclerView.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvHomeTeam; // TextView for displaying the home team name
        private final TextView tvScore; // TextView for displaying the score
        private final TextView tvAwayTeam; // TextView for displaying the away team name

        /**
         * Constructor for ViewHolder.
         *
         * @param itemView The root view of the item layout.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHomeTeam = itemView.findViewById(R.id.tv_home_team);
            tvScore = itemView.findViewById(R.id.tv_score);
            tvAwayTeam = itemView.findViewById(R.id.tv_away_team);
        }

        /**
         * Binds the match data to the views.
         *
         * @param match The match object containing the data to be displayed.
         */
        public void bind(Match match) {
            tvHomeTeam.setText(match.getHomeTeam());
            tvAwayTeam.setText(match.getAwayTeam());
            tvScore.setText(match.getScore());
        }
    }
}
