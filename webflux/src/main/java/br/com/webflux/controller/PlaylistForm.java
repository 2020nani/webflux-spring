package br.com.webflux.controller;

import br.com.webflux.document.Playlist;

public class PlaylistForm {

    private String id;

    private String nome;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PlaylistForm(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Playlist converte() {
        return new Playlist(id,nome);
    }
}
