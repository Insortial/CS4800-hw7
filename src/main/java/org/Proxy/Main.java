package org.Proxy;

public class Main {
    public static void main(String[] args) {
        SongServer exampleSongServer = SongServer.getInstance();
        SongService exampleProxy = new SongServerProxy();

        Song exampleSong = exampleSongServer.addSong("My name is John", "John Hickenlooper", "John Album", 230);
        Song exampleSong2 = exampleSongServer.addSong("My name is John", "John Hic", "Album", 210);
        Song exampleSong3 = exampleSongServer.addSong("My name is John", "Hickenlooper", "JAlbum", 220);
        Song exampleSong4 = exampleSongServer.addSong("My name is John", "John Hickenlooper", "John Album", 230);
        Song exampleSong5 = exampleSongServer.addSong("My", "John Hic", "Album", 210);
        Song exampleSong6 = exampleSongServer.addSong("Mygreat", "Hickenlooper", "Album", 220);
        Song exampleSong7 = exampleSongServer.addSong("My g", "John Hickenlooper", "Album", 230);
        Song exampleSong8 = exampleSongServer.addSong("My bo", "John Hic", "Album", 210);
        Song exampleSong9 = exampleSongServer.addSong("My is bo", "Hickenlooper", "JAlbum", 220);

        System.out.println("Retrieving a song by ID without caching");
        System.out.println(exampleProxy.searchById(exampleSong.getSongID()).getTitle());
        System.out.println("Finished \n");

        System.out.println("Retrieving a song by ID with caching");
        System.out.println(exampleProxy.searchById(exampleSong.getSongID()).getTitle());
        System.out.println("Finished \n");

        System.out.println("Retrieving a song by title without caching");
        exampleProxy.searchByTitle("My name is John").forEach(song -> {
            System.out.println("Artist: " + song.getArtist());
        });
        System.out.println("Finished \n");

        System.out.println("Retrieving a song by ID with caching");
        exampleProxy.searchByTitle("My name is John").forEach(song -> {
            System.out.println("Artist: " + song.getArtist());
        });
        System.out.println("Finished \n");

        System.out.println("Retrieving a song by album without caching");
        exampleProxy.searchByAlbum("Album").forEach(song -> {
            System.out.println("Title: " + song.getTitle());
        });
        System.out.println("Finished \n");

        System.out.println("Retrieving a song by album with caching");
        exampleProxy.searchByAlbum("Album").forEach(song -> {
            System.out.println("Title: " + song.getTitle());
        });
        System.out.println("Finished \n");
    }
}
