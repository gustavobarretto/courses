package Class05_worktable;

public class Main {
    /* No serviço Spotify pago, você pode baixar músicas
     para ouvir offline. Quando um usuário solicita o download
     de uma música, o serviço Spotify verifica se ele é um
     usuário premium para dar acesso a essa funcionalidade.
     Os usuários possuem um identificador e uma string com
     o tipo de usuário ("Free", "Premium").
     Implementar uma classe servicoDownload que permita
     baixar uma música e mediante o Proxy pattern comprovar
     se é possível fazê-lo.
     */

    public static void main(String[] args) {
        SpotfyUser user1 = new SpotfyUser(1, "Premium");
        SpotfyUser user2 = new SpotfyUser(1, "Free");
        IDownloadService proxy = new ProxyDownloadService();
        System.out.println(proxy.downloadMusic("Cachimbo da Paz", user1));
        System.out.println(proxy.downloadMusic("Cachimbo da Paz", user2));
    }
}
