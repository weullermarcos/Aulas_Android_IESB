package com.example.weuller.exemplorecyclerview;

/**
 * Created by weuller on 30/05/2017.
 */

public class Contato {

    String nome;
    String email;

    public Contato(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
