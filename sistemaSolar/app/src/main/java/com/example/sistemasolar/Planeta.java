package com.example.sistemasolar;

public class Planeta {
    private String nome;
    private String descricao;
    private int imagemResId; // ID do recurso de imagem

    public Planeta(String nome, String descricao, int imagemResId) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagemResId = imagemResId;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImagemResId() {
        return imagemResId;
    }
}
