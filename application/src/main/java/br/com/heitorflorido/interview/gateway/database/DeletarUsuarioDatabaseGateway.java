package br.com.heitorflorido.interview.gateway.database;

import br.com.heitorflorido.interview.gateway.DeletarUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class DeletarUsuarioDatabaseGateway implements DeletarUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Mono<Void> execute(Long id) {
        return usuarioRepository.deleteById(id);
    }
}