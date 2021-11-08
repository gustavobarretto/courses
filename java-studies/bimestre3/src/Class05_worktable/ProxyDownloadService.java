package Class05_worktable;

public class ProxyDownloadService implements IDownloadService {

    private SpotfyUser userRequester;

    public ProxyDownloadService() {
    }

    @Override
    public String downloadMusic(String music, SpotfyUser user) {
        this.userRequester = user;
        if(user.getUserType().equalsIgnoreCase("Premium")) {
            return "Download realizado com sucesso!";
        }
        return "Download não autorizado.\nFaça o upgrade para a conta premium" +
                " para ter acesso às nossas funcionalidades!";
    }
}
