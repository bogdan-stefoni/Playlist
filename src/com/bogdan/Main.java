package com.bogdan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Meteora","Linkin park");
        album.addSong("From the inside", 4.55);
        album.addSong("Crawling",3.22);
        album.addSong("Pushing me away", 3.12);
        album.addSong("A place for my head", 4.42);
        album.addSong("Somewhere I belong", 3.55);
        album.addSong("Numb",3.45);
        album.addSong("Don\'t stay",3.10);
        album.addSong("Runaway",3.50);
        albums.add(album);

        album = new Album("For those about to rock","AC/DC");
        album.addSong("For those about to rock", 4.55);
        album.addSong("Hells Bells", 5.23);
        album.addSong("Highway to hell", 4.59);
        album.addSong("Thunderstruck", 3.44);
        album.addSong("Back in black", 3.55);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayLis("Crawling", playList);
        albums.get(0).addToPlayLis("A place for my head", playList);
        albums.get(0).addToPlayLis("From the inside", playList);
        albums.get(0).addToPlayLis("Pushing me away", playList);
        albums.get(0).addToPlayLis("Somewhere I belong", playList);
        albums.get(0).addToPlayLis("Numb",playList);
        albums.get(0).addToPlayLis("Runaway",playList);

        play(playList);

    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("No songs in the playlist");
            return;
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Bye!");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }
                    else{
                        System.out.println("Reached end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else {
                        System.out.println("At the start of the playlist");
                        forward = true;
                    }

                    break;
                case 3:
                    break;
//                case 4:
//                    printList(playList);
//                    break;
//                case 5:
//                    printMenu();
//                    break;

            }
        }
    }






}
