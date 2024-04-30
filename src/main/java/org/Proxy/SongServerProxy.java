package org.Proxy;

import org.Flyweight.CharacterFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SongServerProxy implements SongService{
    HashMap<Integer, Song> proxySongDatabase;

    public SongServerProxy() {
        this.proxySongDatabase = new HashMap<>();
    }

    public Song searchById(Integer songID) {
        if(proxySongDatabase.containsKey(songID))
            return proxySongDatabase.get(songID);

        Song receivedSong = SongServer.getInstance().searchById(songID);
        proxySongDatabase.put(receivedSong.getSongID(), receivedSong);
        return SongServer.getInstance().searchById(songID);
    }

    public List<Song> searchByTitle(String title) {
        List<Song> results = new ArrayList<>();
        proxySongDatabase.values().forEach(song -> {
            if(song.getTitle() == title) {
                results.add(song);
            }
        });
        if(results.size() == 0) {
            List<Song> receivedSongs = SongServer.getInstance().searchByTitle(title);
            receivedSongs.forEach(song -> {
                if(!proxySongDatabase.containsKey(song.getSongID()))
                    proxySongDatabase.put(song.getSongID(), song);
            });
            return receivedSongs;
        }

        return results;
    }
    public List<Song> searchByAlbum(String album) {
        List<Song> results = new ArrayList<>();
        proxySongDatabase.values().forEach(song -> {
            if(song.getAlbum() == album) {
                results.add(song);
            }
        });
        if(results.size() == 0) {
            List<Song> receivedSongs = SongServer.getInstance().searchByAlbum(album);
            receivedSongs.forEach(song -> {
                if(!proxySongDatabase.containsKey(song.getSongID()))
                    proxySongDatabase.put(song.getSongID(), song);
            });
            return receivedSongs;
        }
        return results;
    }
}
