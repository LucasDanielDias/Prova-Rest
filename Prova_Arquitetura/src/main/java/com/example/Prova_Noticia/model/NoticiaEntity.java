package com.example.Prova_Noticia.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bd-noticia")
public class NoticiaEntity {

    private String titulo;
    private String introducao;
    private String data_publicacao;
    private  String editoras;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIntroducao() {
        return introducao;
    }

    public void setIntroducao(String introducao) {
        this.introducao = introducao;
    }

    public String getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(String data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public String getEditoras() {
        return editoras;
    }

    public void setEditoras(String editoras) {
        this.editoras = editoras;
    }
}