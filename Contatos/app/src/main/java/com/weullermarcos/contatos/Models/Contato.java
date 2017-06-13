package com.weullermarcos.contatos.Models;

/**
 * Created by weullermarcos on 29/05/17.
 */

public class Contato {

    String nome;

    public Contato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
