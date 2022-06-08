package br.com.webflux.service;

import br.com.webflux.document.Playlist;
import br.com.webflux.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImplement implements PlaylistService{

    private PlaylistRepository playlistRepository;

    public PlaylistServiceImplement(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public Flux<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
