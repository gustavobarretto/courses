package Class07_challenge;


import java.util.ArrayList;
import java.util.HashMap;

public class MusicFactory {

    private HashMap<String, Music> m = new HashMap<>(); //

    public Music getMusic(String musicName) {
        Music musicRequired = (Music) this.m.get(musicName);

        if(musicRequired == null) {
            musicRequired = new Music (musicName);
            m.put(musicName, musicRequired);
            System.out.println("Criando a música de nome " + musicName + ".");
        } else {
            System.out.println("Essa música já existe em alguma das playlists. Adicionando nesta...");
        }
        return musicRequired;
    }
}
