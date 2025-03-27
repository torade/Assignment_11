package com.example.assignment_11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_11.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    private final List<String> data;
    private final Context context;
    private final OnItemClickListener listener;
    public interface OnItemClickListener { void onItemClick(String item); }

    /**
     * Constructor
     * @param data
     */
    public Adapter(Context context, List<String> data, OnItemClickListener listener)
    {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        //bind data to views
        String item = data.get(position);
        holder.itemTextView.setText(item);

        /**
         * Set click listener for the item using lambda expression
         */
        holder.itemView.setOnClickListener(v ->
        {
            if (listener != null)
                listener.onItemClick(item);
        });

    }

    @Override
    public int getItemCount() { return data.size(); }

    /**
     * ViewHolder class for the adapter
     */
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView itemTextView;
        public ViewHolder(@NonNull View itemView) { super(itemView); }
    }
}
