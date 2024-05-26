package com.example.petstop;

public class SponsoredItem {
    private int imageResource;
    private String title;

    public SponsoredItem(int imageResource, String title) {
        this.imageResource = imageResource;
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }
}