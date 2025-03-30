package com.example.assignment_11.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignment_11.fragment.TeamFragment;
import com.example.assignment_11.fragment.PlayerFragment;
import com.example.assignment_11.fragment.MatchFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new TeamFragment();
            case 1: return new PlayerFragment();
            case 2: return new MatchFragment();
            default: return new TeamFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
