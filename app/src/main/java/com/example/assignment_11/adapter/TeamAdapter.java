package com.example.assignment_11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_11.R;
import com.example.assignment_11.model.Team;

import java.util.List;

/**
 * An adapter for displaying a list of teams in a RecyclerView.
 */
public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private List<Team> data;
    private final Context context;
    private final OnItemClickListener listener;

    /**
     * Interface for handling item click events.
     */
    public interface OnItemClickListener {
        void onItemClick(String item);
    }

    /**
     * Constructor to initialize the adapter with context, data, and a click listener.
     *
     * @param context  The context of the activity or fragment.
     * @param data     The list of teams to display.
     * @param listener The listener for item click events.
     */
    public TeamAdapter(Context context, List<Team> data, OnItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = data.get(position);

        holder.tvItemName.setText(team.getName());
        holder.tvItemDetail.setText(team.getLeague());
        holder.tvItemExtra.setText(team.getCountry());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(team.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * ViewHolder class for holding references to the views in the card item layout.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemName, tvItemDetail, tvItemExtra;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemName = itemView.findViewById(R.id.tv_item_name);
            tvItemDetail = itemView.findViewById(R.id.tv_item_detail);
            tvItemExtra = itemView.findViewById(R.id.tv_item_extra);
        }
    }

    /**
     * Updates the list of teams and notifies the adapter of the data change.
     *
     * @param newData The new list of teams to display.
     */
    public void setTeams(List<Team> newData) {
        this.data = newData;
        notifyDataSetChanged();
    }
}
