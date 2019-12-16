package com.bogdan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for(Song checkedSong: this.songs){
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }



    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber -1;
        if((index >= 0) && (index <= playList.size())){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayLis(String title, LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in the album");
        return false;
    }

//    public boolean searchSong(String title, double duration){
//        Song requestedSong = new Song(title, duration);
//        int foundSong = Collections.binarySearch(songs,requestedSong,null);
//        if(foundSong >=0){
//            return songs.get(foundSong).getTitle();
//        }
//
//    }






}
