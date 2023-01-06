// Name: Jun Bruttomesso
// Date: 12/8/2022
// Class: CSE 122
// TA: Colton Harris
// Program: OOP It!
import java.util.*;

// This class contains the playlist and history of songs
// played. The class also contains actions that could 
// happen, if called, and change what the playlist and history of songs contain.
public class MusicPlaylist {
    private Queue<String> playList;
    private Stack<String> listenHistory;

    // This constructor initializes an empty playList Queue
    // and an empty listenHistory Stack
    public MusicPlaylist() {
        playList = new LinkedList<>();
        listenHistory = new Stack<>();
    }

    // Getter method that returns the listening history
    public Stack<String> showListenHistory(){
        return listenHistory;
    }

    // Getter method that returns the list of songs in playlist
    public Queue<String> showPlayList(){
        return playList;
    }

    // This instance method prints out the options of actions that can be taken
    // from the user.
    public void introPar(){
        System.out.println("1. Add song");
        System.out.println("2. Play song");
        System.out.println("3. Print history");
        System.out.println("4. Clear history");
        System.out.println("5. Delete from history");
        System.out.println("6. Quit");
        System.out.println();
    }

    // This instance method adds the given song to the playList
    // Parameter:
    //      - song: gives us the name of the song the user wants on their playList
    public void add(String song) {
        playList.add(song);
    }

    // This instance method removes the song being played from the playList and 
    // puts it in the listenHistory. Also, it displays to the user the
    // current song being played.
    // IllegalStateException for when the user's playlist for songs is empty
    public void songPlay() {
        if (playList.isEmpty()){
            throw new IllegalStateException();
        }
        String songPlaying = playList.remove();
        System.out.println("Playing song: " + songPlaying);
        listenHistory.push(songPlaying);
    }

    // This instance method creates a temporary stack, printingStorage, where it has the same
    // variables, same order too, compared to our listenHistory so it can be used by the user and 
    // not have our actual history of songs played stack potentially messed with.
    // The temporary stack is returned so the user can use it in main.
    // throw IllegalStateExcpetion if the history of songs played is empty
    public Stack<String> history() {
        if (listenHistory.isEmpty()){
            throw new IllegalStateException();
        }
        Stack<String> temporaryStorage = new Stack<>();
        Stack<String> printingStorage = new Stack<>();
        while (!listenHistory.isEmpty()){
            temporaryStorage.push(listenHistory.pop());
        }
        while (!temporaryStorage.isEmpty()){
            String removeSong = temporaryStorage.pop();
            listenHistory.push(removeSong);
            printingStorage.push(removeSong);
        }
        return printingStorage;
    }

    // This instance method clears the whole history of songs played.
    public void clearAllHistory() {
        while(!listenHistory.isEmpty()){
            listenHistory.pop();
        }
    }


    // This instance method deletes certain songs, user chosen number, from 
    // the user's history of songs. If the user inputs a positive number it will 
    // delete from the most recent played songs. However, if the user inputs a 
    // negative number it will delete from the first song played.
    // Parameter:
    //      - numOfDelete: user chosen positive or negative number to show which songs to delete
    public void deleteFromHistory(int numOfDelete) {
        if (listenHistory.size() < Math.abs(numOfDelete)){
            throw new IllegalArgumentException();
        }
        Stack<String> negativeDelete = new Stack<>();
        if (numOfDelete < 0){
            while(!listenHistory.isEmpty()){
                String negativeSongRemove = listenHistory.pop();
                negativeDelete.push(negativeSongRemove);
            }
            for (int i = 0; i < Math.abs(numOfDelete); i++){
                negativeDelete.pop();
            }
            while(!negativeDelete.isEmpty()){
                listenHistory.push(negativeDelete.pop());
            }
        }
        else if (numOfDelete > 0){
                for (int i = 0; i < numOfDelete; i++){
                    listenHistory.pop();
                }
        }
    }
}