package Class07_challenge;

import java.util.Map;

public class Main {

    /*
    Vamos pensar em um sistema para adicionar músicas a uma lista de reprodução.
    Uma música é composta por:
    Nome
    Artista
    Gênero
    Uma lista de reprodução é composta por:
    Nome
    Para adicionar uma música, você precisa criar a lista de reprodução.

    1o MÉTODO = ADICIONAR UMA MÚSICA EXIGE CRIAR UMA LISTA DE REPRODUÇÃO

    Você pode excluir e obter músicas. MusicFactory será o local onde
    as músicas serão armazenadas. Permitirá, antes de criar o objeto, validar
    se já existe um idêntico ao que está sendo solicitado. Em caso afirmativo,
    retorna o objeto existente; se não existir, cria o novo objeto e o armazena
    em cache para ser reutilizado posteriormente.

    ETAPAS
        1o INSTANCIAR LISTA DE REPRODUÇÃO
        2o ADICIONAR MÚSICAS NA LISTA DE REPRODUÇÃO PELO MUSICFACTORY
            2.1o ADICIONA MÚSICA PELO OBJETO MUSIC EM UM MÉTODO MUSICFACTORY
            2.2o O MÉTODO CONFERE NO HASHMAP DA PLAYLIST SE EXISTE ESSA MÚSICA
            2.3o SE NÃO EXISTE, O OBJETO É INSTANCIADO.
            2.4o SE EXISTE, RETORNA O OBJETO MUSIC INSTANCIADO NO HASHMAP


    Também gostaríamos de poder ver as listas de reprodução no console.
    Propomos que você faça um diagrama UML, e uma implementação em JAVA.*/

    public static void main(String[] args) {

        MusicFactory factory = new MusicFactory();

        Playlist playlist1 = new Playlist("Playlist do Gugu");

        playlist1.addingMusicToPlayList("Someone like You", factory);

        playlist1.addingMusicToPlayList("She will be loved", factory);

        playlist1.addingMusicToPlayList("Não existe amor em Sp", factory);

        playlist1.addingMusicToPlayList("Someone like You", factory);

        Playlist playlist2 = new Playlist("Playlist do Dudu");

        playlist2.addingMusicToPlayList("Não existe amor em Sp",factory);

        playlist2.addingMusicToPlayList("Duas cores", factory);

        playlist2.addingMusicToPlayList("She will be loved", factory);

        playlist2.addingMusicToPlayList("Garota de Ipanema", factory);

        System.out.println("A playlist do Gugu têm: ");
        for (Map.Entry<Music, Music> set : playlist1.getMusics().entrySet()) {
            System.out.println(set.getKey().getName());
        }

        System.out.println("A playlist do Dudu têm: ");
        for (Map.Entry<Music, Music> set : playlist2.getMusics().entrySet()) {
            System.out.println(set.getKey().getName());
        }







    }


}
