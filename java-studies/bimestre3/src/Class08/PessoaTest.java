package Class08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    Pessoa pessoa;
    Pessoa pessoa1;
    Pessoa pessoa2;
    Pessoa pessoa3;
    Pessoa pessoa4;
    Pessoa pessoa5;
    Pessoa pessoa6;
    Pessoa pessoa7;
    Pessoa pessoa8;
    Pessoa pessoa9;
    List<Pessoa> pessoas = new ArrayList<>();

    @BeforeEach
    void doBefore() {
        pessoa = new Pessoa("Tom");
        pessoa.setIdade(LocalDate.of(1990, 1, 11));
        pessoas.add(pessoa);
        pessoa1 = new Pessoa("Caio");
        pessoa1.setIdade(LocalDate.of(1990, 2, 12));
        pessoas.add(pessoa1);
        pessoa2 = new Pessoa("Noa");
        pessoa2.setIdade(LocalDate.of(1978, 3, 13));
        pessoas.add(pessoa2);
        pessoa3 = new Pessoa("Hugo");
        pessoa3.setIdade(LocalDate.of(1978, 4, 14));
        pessoas.add(pessoa3);
        pessoa4 = new Pessoa("Nair");
        pessoa4.setIdade(LocalDate.of(1978, 5, 15));
        pessoas.add(pessoa4);
        pessoa5 = new Pessoa("Alice");
        pessoa5.setIdade(LocalDate.of(1978, 6, 16));
        pessoas.add(pessoa5);
        pessoa6 = new Pessoa("Patricia");
        pessoa6.setIdade(LocalDate.of(1978, 7, 17));
        pessoas.add(pessoa6);
        pessoa7 = new Pessoa("Moacir");
        pessoa7.setIdade(LocalDate.of(2017, 8, 18));
        pessoas.add(pessoa7);
        pessoa8 = new Pessoa("Pikachu");
        pessoa8.setIdade(LocalDate.of(2016, 9, 19));
        pessoas.add(pessoa8);
        pessoa9 = new Pessoa("Charmander");
        pessoa9.setIdade(LocalDate.of(2015, 10, 29));
        pessoas.add(pessoa9);

    }


    @Test
    void getCalcular() {

        assertEquals(false, pessoa.calcularNome());
        assertEquals(false, pessoa1.calcularNome());
        assertEquals(false, pessoa2.calcularNome());
        assertEquals(false, pessoa3.calcularNome());
        assertEquals(false, pessoa4.calcularNome());
        assertEquals(true, pessoa5.calcularNome());
        assertEquals(true, pessoa6.calcularNome());
        assertEquals(true, pessoa7.calcularNome());
        assertEquals(true, pessoa8.calcularNome());
        assertEquals(true, pessoa9.calcularNome());

    }

    @Test
    void getIdadeDeIdade() {

        assertEquals(pessoa.maiorDeIdade(), true);
        assertEquals(pessoa1.maiorDeIdade(), true);
        assertEquals(pessoa2.maiorDeIdade(), true);
        assertEquals(pessoa3.maiorDeIdade(), true);
        assertEquals(pessoa4.maiorDeIdade(), true);
        assertEquals(pessoa5.maiorDeIdade(), true);
        assertEquals(pessoa6.maiorDeIdade(), true);
        assertEquals(pessoa7.maiorDeIdade(), false);
        assertEquals(pessoa8.maiorDeIdade(), false);
        assertEquals(pessoa9.maiorDeIdade(), false);

    }

    @Test
    void getLista() {
        Pessoa pessoaTest = new Pessoa("Teste");
        assertEquals(2, pessoaTest.verificarPessoas(pessoas).size());

    }

}