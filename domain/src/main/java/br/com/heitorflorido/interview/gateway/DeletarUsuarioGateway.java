package br.com.heitorflorido.interview.gateway;

import reactor.core.publisher.Mono;

public interface DeletarUsuarioGateway {
    Mono<Void> execute(Long id);
}