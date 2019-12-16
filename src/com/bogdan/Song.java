package com.bogdan;

public class Song implements Comparable<Song>{
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }

    @Override
    public int compareTo(Song song) {
        return title.compareToIgnoreCase(song.getTitle());
    }
}
