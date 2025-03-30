package com.example.assignment_11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_11.R;
import com.example.assignment_11.model.Player;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder>
{
    private List<Player> data;
    private final Context context;
    private final OnItemClickListener listener;
    public interface OnItemClickListener { void onItemClick(String item); }

    /**
     * Constructor
     * @param data
     */
    public PlayerAdapter(Context context, List<Player> data, OnItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Player player = data.get(position);
        holder.tvItemName.setText(player.getName());
        holder.tvItemDetail.setText(player.getPosition());
        holder.tvItemExtra.setText(player.getTeam());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null)
                listener.onItemClick(player.getName());
        });
    }




    @Override
    public int getItemCount() { return data.size(); }

    /**
     * ViewHolder class for the adapter
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



    public void setPlayers(List<Player> newData) {
        this.data = newData;
        notifyDataSetChanged();
    }




}
