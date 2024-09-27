package br.com.heitorflorido.interview.usecase;

import br.com.heitorflorido.interview.gateway.ListarUsuariosGateway;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class ListarUsuariosUseCase {

    private final ListarUsuariosGateway listarUsuariosGateway;

    public Flux<Usuario> execute() {
        return listarUsuariosGateway.execute();
    }
}