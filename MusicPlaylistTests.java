// Name: Jun Bruttomesso
// Date: 12/8/2022
// Class: CSE 122
// TA: Colton Harris
// Program: OOP It!

// imports used on the ED program
// import org.junit.jupiter.api.*;
// import static org.junit.jupiter.api.Assertions.*;

// this import works for tests
import org.junit.Test;
import static org.junit.Assert.assertEquals;
// DisplayName and BeforeEach import not working
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.BeforeEach;

// This class is to test if the instance methods
// of the MusicPlaylist class is correctly working.
public class MusicPlaylistTests {
    private MusicPlaylist playList;

    // Initializes playList so we can use methods of the MusicPlaylist class
    @BeforeEach
    public void setUp() {
        playList = new MusicPlaylist();
    }

    @Test
    @DisplayName("Test the history of songs after songs are played")
    public void getHistory() {
        playList.add("Hello");
        playList.add("Wow");
        playList.add("Apple");
        playList.songPlay();
        playList.songPlay();
        playList.songPlay();
        assertEquals("[Hello, Wow, Apple]", playList.history().toString());
    }

    @Test 
    @DisplayName("Test if adding songs to the playlist works")
    public void addSong() {
        playList.add("Hello");
        playList.add("Orange");
        assertEquals("[Hello, Orange]", playList.showPlayList().toString());
    }

    @Test 
    @DisplayName("Test if playing a song works and if adding the played song to history works")
    public void playSong() {
        playList.add("Hello");
        playList.songPlay();
        assertEquals("[Hello]", playList.showListenHistory().toString());
    }

    @Test 
    @DisplayName("Test if the history of songs is all cleared")
    public void emptyListenHistory() {
        playList.add("Hello");
        playList.songPlay();
        playList.clearAllHistory();
        assertEquals("[]", playList.showListenHistory().toString());
    }

    @Test 
    @DisplayName("Test if deleting certain songs are working using positive numbers")
    public void deleteHistoryCheckPostive() {
        playList.add("Hello");
        playList.add("Wow");
        playList.add("Apple");
        playList.songPlay();
        playList.songPlay();
        playList.songPlay();
        playList.deleteFromHistory(1);
        assertEquals("[Hello, Wow]", playList.showListenHistory().toString());
    }

    @Test 
    @DisplayName("Test if deleting certain songs are working using negative numbers")
    public void deleteHistoryCheckNegative() {
        playList.add("Hello");
        playList.add("Wow");
        playList.add("Apple");
        playList.songPlay();
        playList.songPlay();
        playList.songPlay();
        playList.deleteFromHistory(-1);
        assertEquals("[Wow, Apple]", playList.showListenHistory().toString());
    }
}
