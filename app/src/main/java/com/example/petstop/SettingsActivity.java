package com.example.petstop;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        // Настройка элементов на странице настроек

        RecyclerView rvSponsored = findViewById(R.id.rvSponsored);
        rvSponsored.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        SponsoredAdapter sponsoredAdapter = new SponsoredAdapter(getSponsoredItems());
        rvSponsored.setAdapter(sponsoredAdapter);
    }

    private List<SponsoredItem> getSponsoredItems() {
        // Replace this with your actual data fetching logic
        return Arrays.asList(
                new SponsoredItem(R.drawable.sponsored_pic1, "Dog 1"),
                new SponsoredItem(R.drawable.sponsored_pic2, "Dog 2"),
                new SponsoredItem(R.drawable.sponsored_pic3, "Dog 3")
        );
    }
}