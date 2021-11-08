package Class07_worktable;

public class Main {

    /*
    Em uma empresa, eles precisam plantar árvores para poder ver quanto espaço
    ocupariam. O programa que existe atualmente tem um alto consumo de recursos.
    Você precisa plantar 1.000.000 de árvores. O processo de plantação das árvores
    considera que cada árvore possui uma Altura, Largura, cor e tipo de árvore.

    1o ETAPA: Criar Classe Tree (type, height, width, color)

    Os tipos de árvores que existem são:
    Tipo Ornamentais
    Altura: 200.
    Largura: 400.
    Cor: verde.

    Tipo Frutíferas
    Altura: 500.
    Largura: 300.
    Cor: vermelho.

    Florífera
    Altura: 100.
    Largura: 200.
    Cor: azul.

    A floresta é um conjunto de árvores e permitirá o plantio de árvores. ArvoreFactory
    será o local onde os diferentes tipos de árvores serão armazenados.

    2o ETAPA: Criar Class TreeFactory (HashMap<String, Tree>)

    Isso permitirá, antes de criar o objeto, validar se já existe um idêntico ao que está
    sendo solicitado. Em caso afirmativo, retorna o objeto existente; se não existir,
    ele cria o novo objeto e o armazena em cache para ser reutilizado posteriormente.
    Você precisa de um sistema que mostre 1.000.000 de árvores, metade vermelhas e metade
    verdes e, em seguida, imprima na tela as árvores e quanta memória está sendo utilizada.

    Usando esta declaração, você pode ver a memória usada:
    Runtime runtime = Runtime.getRuntime();
    System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    As classes necessárias devem ser desenvolvidas para atingir o processo de preparação explicado.
    */

    public static void main(String[] args) {

        TreeFactory forestFactory = new TreeFactory();

        Tree tree1 = new Tree("Ornamentais", 200, 400, "verde");
        Tree tree2 = new Tree("Frutíferas", 500, 300, "vermelho");
        Tree tree3 = new Tree("Florífera", 100, 200, "azul");

        Forest forest = new Forest();


        for(int i = 1; i < 1000001; i++) {
//            System.out.println(i);
            forestFactory.getTreeType("Ornamentais", 200, 400, "verde");
            forestFactory.getTreeType("Frutíferas", 500, 300, "vermelho");
            forestFactory.getTreeType("Ornamentais", 100, 200, "azul");

            forest.creatingForest(tree1);
            forest.creatingForest(tree2);
            forest.creatingForest(tree3);

        }

//        for(Tree i : forest.getForest()) {
//            System.out.println(i);
//        }
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));


    }



}
