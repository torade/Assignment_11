package com.example.assignment_11.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignment_11.fragment.MatchFragment;
import com.example.assignment_11.fragment.PlayerFragment;
import com.example.assignment_11.fragment.TeamFragment;

/**
 * An adapter for managing fragments in a ViewPager2.
 */
public class ViewPagerAdapter extends FragmentStateAdapter {

    /**
     * Constructor to initialize the adapter with a fragment activity.
     *
     * @param fragmentActivity The activity that hosts the ViewPager2.
     */
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**
     * Creates a fragment for the given position.
     *
     * @param position The position of the fragment to create.
     * @return The fragment corresponding to the position.
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new TeamFragment();
            case 1:
                return new PlayerFragment();
            case 2:
                return new MatchFragment();
            default:
                return new TeamFragment(); // Default to TeamFragment if position is invalid
        }
    }

    /**
     * Returns the total number of fragments.
     *
     * @return The number of fragments.
     */
    @Override
    public int getItemCount() {
        return 3; // Number of fragments to display
    }
}
