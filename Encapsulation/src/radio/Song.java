package radio;

public class Song {
    private String artistName;
    private String songName;
    private String length;

    public Song(String artistName, String songName, String length) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    private void setArtistName(String name) {
        if (name.length() < 3 || name.length() > 20) {
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = name;
    }

    private void setSongName(String name) {
        if (name.length() < 3 || name.length() > 30) {
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }

        this.songName = name;
    }


    private void setLength(String length) {

        String[] songParams = length.split(":");
        int songMinutes = Integer.parseInt(songParams[0]);
        int songSeconds = Integer.parseInt(songParams[1]);

        int totalSeconds = songMinutes * 60 + songSeconds;

        if (totalSeconds < 0 || totalSeconds > 899) {
            throw new IllegalArgumentException("Invalid song length.");
        } else if (songMinutes < 0 || songMinutes > 14) {
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        } else if (songSeconds < 0 || songSeconds > 59) {
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
        this.length = length;
    }

    protected String getLength() {
        return length;
    }
}
