package com.example.assignment_11.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_11.R;
import com.example.assignment_11.adapter.TeamAdapter;
import com.example.assignment_11.iterator.TeamIterator;
import com.example.assignment_11.model.Team;
import com.example.assignment_11.repository.TeamRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TeamFragment extends Fragment implements TeamAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private TextView tvEmptyView;
    private TeamAdapter teamAdapter;
    private TeamRepository teamRepository;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        teamRepository = new TeamRepository();

        //get all views from layout
        recyclerView = view.findViewById(R.id.recycler_view);
        tvEmptyView = view.findViewById(R.id.tv_empty_view);
        Button btnShowAll = view.findViewById(R.id.btn_show_all);
        Button btnFilterTeams = view.findViewById(R.id.btn_filter_teams);
        Button btnSortByName = view.findViewById(R.id.btn_sort_by_name);
        Button btnTeamIterator = view.findViewById(R.id.btn_team_iterator);
        btnTeamIterator.setOnClickListener(v -> demoTeamIterator());


        //set up adapter and RecyclerView
        teamAdapter = new TeamAdapter(requireContext(), teamRepository.getAll(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(teamAdapter);

        //set up logic
        loadAllTeams();

        btnShowAll.setOnClickListener(v -> loadAllTeams());
        btnFilterTeams.setOnClickListener(v -> filterTeams());
        btnSortByName.setOnClickListener(v -> sortTeamsByName());
    }


    private void loadAllTeams() {
        List<Team> teams = teamRepository.getAll();
        updateRecyclerView(teams);
    }

    private void filterTeams() {
        List<Team> filteredTeams = teamRepository.filter(team -> team.getName().startsWith("A"));
        updateRecyclerView(filteredTeams);
    }

    private void sortTeamsByName() {
        List<Team> sortedTeams = teamRepository.getAll().stream()
                .sorted(Comparator.comparing(Team::getName))
                .collect(Collectors.toList());
        updateRecyclerView(sortedTeams);
    }

    private void updateRecyclerView(List<Team> teams) {
        if (teams.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            tvEmptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            tvEmptyView.setVisibility(View.GONE);
            teamAdapter.setTeams(teams);
        }
    }


    @Override
    public void onItemClick(String item) {
        Toast.makeText(getContext(), "Clicked: " + item, Toast.LENGTH_SHORT).show();
    }

    private void demoTeamIterator() {
        TeamIterator iterator = new TeamIterator(teamRepository.getAll());
        while (iterator.hasNext()) {
            Team t = iterator.next();
            Log.d("TeamIterator", "Team: " + t.getName());
        }
    }

}
