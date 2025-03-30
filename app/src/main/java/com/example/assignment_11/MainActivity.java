package com.example.assignment_11;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.assignment_11.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    // Constants for tab titles
    private static final String TAB_TITLE_TEAMS = "Teams";
    private static final String TAB_TITLE_PLAYERS = "Players";
    private static final String TAB_TITLE_MATCHES = "Matches";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TabLayout and ViewPager2
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        // Set up the adapter for ViewPager2
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Connect TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, this::setTabTitle).attach();
    }

    /**
     * Sets the title for each tab based on its position.
     *
     * @param tab The tab to set the title for.
     * @param position The position of the tab.
     */
    private void setTabTitle(TabLayout.Tab tab, int position) {
        switch (position) {
            case 0:
                tab.setText(TAB_TITLE_TEAMS);
                break;
            case 1:
                tab.setText(TAB_TITLE_PLAYERS);
                break;
            case 2:
                tab.setText(TAB_TITLE_MATCHES);
                break;
        }
    }
}
