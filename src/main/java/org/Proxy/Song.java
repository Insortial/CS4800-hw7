package org.Proxy;

public class Song {
    private String title;
    private String artist;
    private Integer songID;
    private String album;
    private int duration;

    public Song(String title, String artist, String album, int duration, Integer songID)
    {
        this.songID = songID;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Integer getSongID() {
        return songID;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }
}
