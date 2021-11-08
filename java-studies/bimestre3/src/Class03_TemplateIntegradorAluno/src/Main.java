public class Main {

    public static void main(String[] args) {
        /*Mofidicar o main para testar a lógica com o template method */
        Funcionario func1 = new Funcionario("Wheslley",2); func1.vender(2);
        Funcionario func2 = new Funcionario("Maria",1); func2.vender(1);

        Vendedor afi1 = new Afiliado("Ramon"); afi1.vender(4);
        Vendedor afi2 = new Afiliado("Paulo"); afi2.vender(1);

        Vendedor afi3 = new Estagiario("José"); afi3.vender(25);
        Vendedor afi4 = new Estagiario("Pedro"); afi4.vender(3);

        func1.addAfiliado(afi1);

        System.out.println(func1.mostrarCategoria());
        System.out.println(func2.mostrarCategoria());
        System.out.println(afi1.mostrarCategoria());

        System.out.println(afi3.mostrarCategoria());
        System.out.println(afi4.mostrarCategoria());

    }
}
