package br.com.heitorflorido.interview.usecase;

import br.com.heitorflorido.interview.gateway.DeletarUsuarioGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class DeletarUsuarioUseCase {

    private final DeletarUsuarioGateway deletarUsuarioGateway;

    public Mono<Void> execute(Long id) {
        return deletarUsuarioGateway.execute(id);
    }
}