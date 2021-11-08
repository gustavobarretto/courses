package Class07_challenge;

import java.util.ArrayList;
import java.util.HashMap;

public class Playlist {

    private String name;
    private HashMap<Music, Music> musics = new HashMap<>();

    public Playlist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HashMap<Music, Music> getMusics() {
        return musics;
    }

    public void addingMusicToPlayList(String musicName, MusicFactory factory) {
        Music newMusic = factory.getMusic(musicName);
        Music musicConference = musics.get(newMusic);
        if (musicConference ==  null) {
            musics.put(newMusic, newMusic);
        } else {
            System.out.println("Essa música já está na sua playlist!");
        }
    }
}
