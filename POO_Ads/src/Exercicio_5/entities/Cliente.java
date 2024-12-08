package Exercicio_5.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    private int Id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private List<Conta> contas;

    public Cliente(int id, String nome, String cpf, Date dataNascimento) {
        Id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.contas = new ArrayList<>();
    }

    public int getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public List<Conta> getContas() {
        return contas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", contas=" + contas +
                '}';
    }
}
