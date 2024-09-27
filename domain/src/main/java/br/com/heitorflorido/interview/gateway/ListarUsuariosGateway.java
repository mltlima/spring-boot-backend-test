package br.com.heitorflorido.interview.gateway;

import br.com.heitorflorido.interview.model.Usuario;
import reactor.core.publisher.Flux;

public interface ListarUsuariosGateway {
    Flux<Usuario> execute();
}