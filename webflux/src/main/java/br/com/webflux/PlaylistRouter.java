package br.com.webflux;

import br.com.webflux.document.Playlist;
import br.com.webflux.service.PlaylistService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Configuration
public class PlaylistRouter {

    @Bean
    public RouterFunction<ServerResponse> route(PlaylistHandler playlistHandler){
        return RouterFunctions
                .route(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::findAll)
                .andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::findById)
                .andRoute(POST("/playlist").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::save);
    }
}
