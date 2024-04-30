package org.Proxy;
import org.Flyweight.CharacterFactory;

import java.util.*;

public class SongServer implements SongService{
    HashMap<Integer, Song> songDatabase = new HashMap<>();
    static SongServer instance = null;

    public SongServer() {

    }

    public static SongServer getInstance()
    {
        if(instance == null)
            instance = new SongServer();
        return instance;
    }

    public Song addSong(String title, String artist, String album, int duration)
    {
        Random rand = new Random();
        Integer uniqueID = rand.nextInt(99999999);
        Song createdSong = new Song(title, artist, album, duration, uniqueID);
        songDatabase.put(uniqueID, createdSong);
        return createdSong;

    }

    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        if(songDatabase.containsKey(songID))
            return songDatabase.get(songID);
        return null;
    }

    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> results = new ArrayList<>();
        songDatabase.values().forEach(song -> {
            if(song.getTitle() == title) {
                results.add(song);
            }
        });
        return results;
    }
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> results = new ArrayList<>();
        songDatabase.values().forEach(song -> {
            if(song.getAlbum() == album) {
                results.add(song);
            }
        });
        return results;
    }
}
