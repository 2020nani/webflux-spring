package br.com.webflux.service;

import br.com.webflux.document.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.management.monitor.MonitorNotification;

public interface PlaylistService {

    Flux<Playlist> findAll();

    Mono<Playlist> findById(String id);

    Mono<Playlist> save(Playlist playlist);
}
