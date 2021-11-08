package Class08;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private LocalDate idade;

    public Pessoa(String nome) {
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public boolean calcularNome() {
        return this.nome.length() >= 5;
    }

    public boolean maiorDeIdade() {
        return Period.between(this.idade, LocalDate.now()).getYears() >= 18;
    }

    public List<Pessoa> verificarPessoas(List<Pessoa> pessoas) {
        List<Pessoa> pessoaMaior = new ArrayList<>();
        pessoas.forEach( pessoa -> {
            if(pessoa.calcularNome() && pessoa.maiorDeIdade())
                pessoaMaior.add(pessoa);
        });
        return pessoaMaior;
    }

}
