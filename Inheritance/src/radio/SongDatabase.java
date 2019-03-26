package radio;

import java.util.ArrayList;
import java.util.List;

public class SongDatabase {
    private List<Song> songs;

    public SongDatabase() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
        System.out.println("Song added.");
    }

    public String getTotalLengthOfSongs() {

        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        for (int i = 0; i < this.songs.size(); i++) {
            String[] params = this.songs.get(i).getLength().split(":");
            int currMinutes = Integer.parseInt(params[0]);
            minutes += currMinutes;
            if (minutes > 59) {
                hours++;
                minutes -= 60;
            }
            seconds += Integer.parseInt(params[1]);
            if (seconds > 59) {
                minutes++;
                seconds -= 60;
            }
        }
        return "Songs added: " + this.songs.size() + String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }
}
