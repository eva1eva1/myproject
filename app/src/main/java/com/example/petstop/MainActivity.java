package com.example.petstop;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return onNavigationItemSelectedInternal(item);
            }
        });

        int orangeColor = ContextCompat.getColor(MainActivity.this, R.color.orange);
        int peachColor = ContextCompat.getColor(MainActivity.this, R.color.icons);

        navigationView.setItemIconTintList(null);
        navigationView.setItemIconTintList(createColorStateList(orangeColor, peachColor));

    }

    private boolean onNavigationItemSelectedInternal(MenuItem item) {
        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.news) {
            selectedFragment = new FirstFragment();
        } else if (itemId == R.id.map) {
            selectedFragment = new SecondFragment();
        } else if (itemId == R.id.cards) {
            selectedFragment = new ThirdFragment();
        } else if (itemId == R.id.fav) {
            selectedFragment = new FourFragment();
        } else if (itemId == R.id.profile) {
            selectedFragment = new FifthFragment();
        }
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView3, selectedFragment).commit();
            return true;
        }
        return false;
    }

    private ColorStateList createColorStateList(int activeColor, int inactiveColor) {
        int[][] states = new int[][] {
                new int[] { android.R.attr.state_checked}, // активное состояние
                new int[] {-android.R.attr.state_checked} // неактивное состояние
        };
        int[] colors = new int[] {
                activeColor,
                inactiveColor
        };
        return new ColorStateList(states, colors);
    }
}