package com.example.assignment_11.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_11.R;
import com.example.assignment_11.adapter.MatchAdapter;
import com.example.assignment_11.model.Match;
import com.example.assignment_11.repository.MatchRepository;

import java.util.List;

public class MatchFragment extends Fragment {

    private RecyclerView recyclerView;
    private MatchAdapter adapter;
    private MatchRepository matchRepository;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_match, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view_match);
        matchRepository = new MatchRepository();

        List<Match> matches = matchRepository.getAll();

        adapter = new MatchAdapter(requireContext(), matches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}
