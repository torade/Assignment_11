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

/**
 * A fragment to display and manage a list of teams.
 */
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
        super.onViewCreated(view, savedInstanceState);
        teamRepository = new TeamRepository();

        // Initialize views
        recyclerView = view.findViewById(R.id.recycler_view);
        tvEmptyView = view.findViewById(R.id.tv_empty_view);
        Button btnShowAll = view.findViewById(R.id.btn_show_all);
        Button btnFilterTeams = view.findViewById(R.id.btn_filter_teams);
        Button btnSortByName = view.findViewById(R.id.btn_sort_by_name);
        Button btnTeamIterator = view.findViewById(R.id.btn_team_iterator);

        // Set up RecyclerView and adapter
        teamAdapter = new TeamAdapter(requireContext(), teamRepository.getAll(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(teamAdapter);

        // Set up button click listeners
        btnShowAll.setOnClickListener(v -> loadAllTeams());
        btnFilterTeams.setOnClickListener(v -> filterTeams());
        btnSortByName.setOnClickListener(v -> sortTeamsByName());
        btnTeamIterator.setOnClickListener(v -> demoTeamIterator());

        // Load all teams initially
        loadAllTeams();
    }

    /**
     * Loads all teams from the repository and updates the RecyclerView.
     */
    private void loadAllTeams() {
        List<Team> teams = teamRepository.getAll();
        updateRecyclerView(teams);
    }

    /**
     * Filters teams whose names start with "A" and updates the RecyclerView.
     */
    private void filterTeams() {
        List<Team> filteredTeams = teamRepository.filter(team -> team.getName().startsWith("A"));
        updateRecyclerView(filteredTeams);
    }

    /**
     * Sorts teams by name and updates the RecyclerView.
     */
    private void sortTeamsByName() {
        List<Team> sortedTeams = teamRepository.getAll().stream()
                .sorted(Comparator.comparing(Team::getName))
                .collect(Collectors.toList());
        updateRecyclerView(sortedTeams);
    }

    /**
     * Updates the RecyclerView with the given list of teams.
     *
     * @param teams The list of teams to display.
     */
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

    /**
     * Demonstrates the use of TeamIterator to iterate over the list of teams.
     */
    private void demoTeamIterator() {
        TeamIterator iterator = new TeamIterator(teamRepository.getAll());
        while (iterator.hasNext()) {
            Team team = iterator.next();
            Log.d("TeamIterator", "Team: " + team.getName());
        }
    }
}
