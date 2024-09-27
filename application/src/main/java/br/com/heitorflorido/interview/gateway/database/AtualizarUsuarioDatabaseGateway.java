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
                    .id(existingUser.getId())
                    .nome(usuario.getNome() != null ? usuario.getNome() : existingUser.getNome())
                    .dataNascimento(usuario.getDataNascimento() != null ? usuario.getDataNascimento() : existingUser.getDataNascimento())
                    .cep(usuario.getCep() != null ? usuario.getCep() : existingUser.getCep())
                    .cidade(usuario.getCidade() != null ? usuario.getCidade() : existingUser.getCidade())
                    .uf(usuario.getUf() != null ? usuario.getUf() : existingUser.getUf())
                    .build();
                return usuarioRepository.save(updatedUser);
            })
            .map(UsuarioData::toUsuario);
    }
}