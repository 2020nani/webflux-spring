package br.com.webflux.controller;

import br.com.webflux.document.Playlist;
import br.com.webflux.service.PlaylistService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
public class PlaylistController {

    private PlaylistService service;

    public PlaylistController(PlaylistService service) {
        this.service = service;
    }

    @PostMapping("/playlist")
    public Mono<Playlist> save(@RequestBody PlaylistForm playlistform){
        Playlist playlist = playlistform.converte();
        return service.save(playlist);
    }

    @GetMapping("/playlist")
    public Flux<Playlist> findAll(){
        return service.findAll();
    }

    @GetMapping("/playlist/{id}")
    public Mono<Playlist> findById(@PathVariable("id") String id){
        return service.findById(id);
    }

    @GetMapping(value = "/playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> findPlaylistsByEvents(){
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> events = service.findAll();
        System.out.println("Passou aqui events");
        return Flux.zip(interval, events);
    }
}
