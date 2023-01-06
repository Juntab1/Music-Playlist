// Name: Jun Bruttomesso
// Date: 12/8/2022
// Class: CSE 122
// TA: Colton Harris
// Program: OOP It!
import java.util.*;

// This class is a place the user could create a music playlist. 
// It has many functions, in this main but also called from the MusicPlaylist class,
// like the user could add songs to their playlist, play the songs in their playlist, show the
// history of songs played, and delete their whole history of songs played or parts of it.
public class MusicPlaylistMain {
    public static void main(String[] args){
        MusicPlaylist playList = new MusicPlaylist();
        Scanner console = new Scanner(System.in);
        String userChoice = " ";
        System.out.println("Welcome to the CSE 122 Music Playlist!");
        userChoice = introPar(console, userChoice, playList);
        while (!userChoice.equals("6")){
            if (userChoice.equals("1")){
                addSong(console, playList);
            }
            else if (userChoice.equals("2")){
                playList.songPlay();
            }
            else if (userChoice.equals("3")){
                historyPrint(playList);
            }
            else if (userChoice.equals("4")){
                playList.clearAllHistory();
            }
            else if (userChoice.equals("5")){
                deleteFromHistory(console, playList);
            }
            System.out.println();
            userChoice = introPar(console, userChoice, playList);
        }
    }

    // This method contains the choices the user has
    // and prints out to the user what they are.
    // Also, it asks the user for their choice and returns their choice.
    // parameter:
    //      - console: scanner lets user type in the console box so we can get user input
    //      - userChoice: string of the user's input, choice of what to do 
    //      - playlist: gives us access to the MusicPlaylist class 
    public static String introPar(Scanner console, String userChoice, MusicPlaylist playList){
        playList.introPar();
        System.out.print("Enter your choice: ");
        userChoice = console.nextLine();
        return userChoice;
    }

    // This method asks the user for a name of a song
    // and adds that song to a playlist.
    // parameter:
    //      - console: scanner lets user type in the console box so we can get user input
    //      - playlist: gives us access to the MusicPlaylist class to use instance methods
    public static void addSong(Scanner console, MusicPlaylist playList){
        System.out.print("Enter song name: ");
        String userSong = console.nextLine();
        playList.add(userSong);
        System.out.println("Successfully added " + userSong);
    }

    // This method prints out to the user a list of songs the user played from
    // the latest song the user has played, first, to then the first song the user
    // played from their playlist, last.
    // parameter:
    //      - playlist: gives us access to the MusicPlaylist class to use instance methods
    public static void historyPrint(MusicPlaylist playList){
        Stack<String> historyList = playList.history();
        while (!historyList.isEmpty()){
            String removeSongHistory = historyList.pop();
            System.out.println("    " + removeSongHistory);
        }
    }

    // This method lets the user delete certain songs from the user's history of songs.
    // If the user inputs a positive number it will delete from the most recent played
    // songs. However, if the user input is a negative number it will delete from 
    // the first song played.
    // parameter:
    //      - console: scanner lets user type in the console box so we can get user input
    //      - playList: gives us access to the MusicPlaylist class to use instance methods
    public static void deleteFromHistory(Scanner console, MusicPlaylist playList){
        System.out.println("A positive number will delete from recent history.");
        System.out.println("A negative number will delete from the beginning of history");
        System.out.print("Enter number of songs to delete: ");
        String numberDelete = console.nextLine();
        int numOfDelete = Integer.parseInt(numberDelete);
        playList.deleteFromHistory(numOfDelete);
    }
}