package com.example.assignment_11.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_11.R;
import com.example.assignment_11.adapter.Adapter;
import com.example.assignment_11.adapter.PlayerAdapter;
import com.example.assignment_11.model.Player;
import com.example.assignment_11.repository.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerFragment extends Fragment implements PlayerAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private TextView tvEmptyView;
    private PlayerAdapter adapter;
    private PlayerRepository playerRepository;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        playerRepository = new PlayerRepository();

        recyclerView = view.findViewById(R.id.recycler_view_player);
        tvEmptyView = view.findViewById(R.id.tv_empty_view_player);

        List<Player> players = playerRepository.getAll();

        adapter = new PlayerAdapter(requireContext(), players, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        if (players.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            tvEmptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            tvEmptyView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onItemClick(String item) {
        Toast.makeText(getContext(), "Clicked: " + item, Toast.LENGTH_SHORT).show();
    }

}
