import java.util.Arrays;

public class PlayList {
    // Private array to store song titles internally
    private final String[] songs;
    // Track the number of songs currently added
    private int count;

    // Constructor fixes the maximum capacity of the playlist
    public PlayList(int maxCapacity) {
        this.songs = new String[maxCapacity];
        this.count = 0;
    }

    // Adds a song title if maximum capacity has not been reached
    public void addSong(String songTitle) {
        if (count < songs.length) {
            songs[count] = songTitle;
            count++;
        }
    }

    // Defensive Copying: Returns a brand new array copy containing only added songs
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    // Returns a read-only count of how many songs are currently in the playlist
    public int getSongCount() {
        return count;
    }

    // Main method demonstrating sample usage and defensive copying requirement
    public static void main(String[] args) {
        PlayList p = new PlayList(10);
        p.addSong("Song A");
        p.addSong("Song B");

        // Retrieve copy of songs
        String[] copy = p.getSongs();
        System.out.println("Original 1st Song: " + p.getSongs()[0]); // Expected: Song A

        // Modify the returned array to test defensive copying
        copy[0] = "Hacked";

        // Verify real playlist contents are unaffected
        System.out.println("After modifying copy, 1st Song in Playlist: " + p.getSongs()[0]); // Expected: Song A
        System.out.println("Song Count: " + p.getSongCount()); // Expected: 2
    }
}