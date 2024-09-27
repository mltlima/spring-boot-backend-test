package br.com.heitorflorido.interview.gateway.database;

import br.com.heitorflorido.interview.gateway.AtualizarUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class AtualizarUsuarioDatabaseGateway implements AtualizarUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Mono<Usuario> execute(Long id, Usuario usuario) {
        return usuarioRepository.findById(id)
            .flatMap(existingUser -> {
                UsuarioData updatedUser = UsuarioData.builder()
                    .id(id)
                    .nome(usuario.getNome())
                    .cidade(usuario.getCidade())
                    .uf(usuario.getUf())
                    .build();
                return usuarioRepository.save(updatedUser);
            })
            .map(UsuarioData::toUsuario);
    }
}