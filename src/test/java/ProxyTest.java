import org.Proxy.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class ProxyTest {
    @Test
    public void addSongTest() {
        SongServer exampleSongServer = SongServer.getInstance();

        Song exampleSong = exampleSongServer.addSong("My name is John", "John Hickenlooper", "John Album", 230);

        System.out.println(exampleSong.getSongID());

        Assertions.assertEquals(exampleSongServer.searchById(exampleSong.getSongID()), exampleSong);
    }

    @Test
    public void searchSongByTitleTest() {
        SongServer exampleSongServer = SongServer.getInstance();

        Song exampleSong = exampleSongServer.addSong("My name is John", "John Hickenlooper", "John Album", 230);
        Song exampleSong2 = exampleSongServer.addSong("My name is John", "John Hic", "Album", 210);
        Song exampleSong3 = exampleSongServer.addSong("My name is John", "Hickenlooper", "JAlbum", 220);

        System.out.println(exampleSong.getSongID());

        Assertions.assertEquals(exampleSongServer.searchByTitle("My name is John").size(), 3);
    }

    @Test
    public void searchSongByTitleProxyTest() {
        SongServer exampleSongServer = SongServer.getInstance();
        SongService exampleSongProxyServer = new SongServerProxy();

        Assertions.assertEquals(exampleSongProxyServer.searchByTitle("My name is John").size(), 4);
    }
}
