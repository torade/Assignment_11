package com.example.assignment_11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.assignment_11.adapter.Adapter;
import com.example.assignment_11.adapter.ViewPagerAdapter;
import com.example.assignment_11.model.Team;
import com.example.assignment_11.repository.Repository;
import com.example.assignment_11.repository.TeamRepository;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener{

    private RecyclerView recyclerView;
    private TextView tvEmptyView;
    private Adapter adapter;
    private TeamRepository teamRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        TabLayout tabLayout = findViewById(R.id.tab_layout);
//        ViewPager2 viewPager = findViewById(R.id.view_pager);
//
//        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(this);
//        viewPager.setAdapter(pagerAdapter);
//
//        new TabLayoutMediator(tabLayout, viewPager,
//                (tab, position) -> {
//                    switch (position) {
//                        case 0: tab.setText("Teams"); break;
//                        case 1: tab.setText("Players"); break;
//                        case 2: tab.setText("Matches"); break;
//                    }
//                }).attach();


        // Initialize UI components
        recyclerView = findViewById(R.id.recycler_view);
        tvEmptyView = findViewById(R.id.tv_empty_view);
        Button btnShowAll = findViewById(R.id.btn_show_all);
        Button btnFilterTeams = findViewById(R.id.btn_filter_teams);
        Button btnSortByName = findViewById(R.id.btn_sort_by_name);

        // Initialize repository and adapter
        teamRepository = new TeamRepository();
        adapter = new Adapter(this, teamRepository.getAll().stream()
                .map(Team::getName)
                .collect(Collectors.toList()), this);

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Load initial data
        loadAllTeams();

        // Set up button click listeners
        btnShowAll.setOnClickListener(v -> loadAllTeams());
        btnFilterTeams.setOnClickListener(v -> filterTeams());
        //btnSortByName.setOnClickListener(v -> sortTeamsByName());
    }

    private void loadAllTeams() {
        List<Team> teams = teamRepository.getAll();
        updateRecyclerView(teams);
    }

    private void filterTeams() {
        List<Team> filteredTeams = teamRepository.filter(team -> team.getName().startsWith("A")); // Example filter
        updateRecyclerView(filteredTeams);
    }

//    private void sortTeamsByName() {
//        List<Team> sortedTeams = teamRepository.sortByName();
//        updateRecyclerView(sortedTeams);
//    }

    private void updateRecyclerView(List<Team> teams) {
        if (teams.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            tvEmptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            tvEmptyView.setVisibility(View.GONE);
            adapter.setTeams(teams.stream()
                    .map(Team::getName)
                    .collect(Collectors.toList()));
        }
    }


    @Override
    public void onItemClick(String item) {
        Toast.makeText(this, "Clicked: " + item, Toast.LENGTH_SHORT).show();
    }
}