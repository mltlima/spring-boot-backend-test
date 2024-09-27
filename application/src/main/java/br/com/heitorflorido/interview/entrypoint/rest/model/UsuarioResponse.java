package br.com.heitorflorido.interview.entrypoint.rest.model;

import br.com.heitorflorido.interview.model.Usuario;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Builder(toBuilder = true)
@Data
public class UsuarioResponse {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private String cidade;
    private String uf;

    public static UsuarioResponse toUsuarioResponse(final Usuario usuario) {

        return UsuarioResponse.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .dataNascimento(usuario.getDataNascimento())
            .cep(usuario.getCep())
            .cidade(usuario.getCidade())
            .uf(usuario.getUf())
            .build();
    }
}
