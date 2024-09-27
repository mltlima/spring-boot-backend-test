package br.com.heitorflorido.interview.gateway.database;

import br.com.heitorflorido.interview.gateway.ListarUsuariosGateway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class ListarUsuariosDatabaseGateway implements ListarUsuariosGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Flux<Usuario> execute() {
        return usuarioRepository.findAll()
            .map(UsuarioData::toUsuario);
    }
}