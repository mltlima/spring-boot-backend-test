package br.com.heitorflorido.interview.entrypoint.rest;

import br.com.heitorflorido.interview.entrypoint.rest.model.UsuarioResponse;
import br.com.heitorflorido.interview.entrypoint.rest.model.UsuarioRequest;
import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class AuthController {

    private final ObterUsuarioUseCase obterUsuarioUseCase;
    private final ListarUsuariosUseCase listarUsuariosUseCase;
    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;

    @GetMapping
    public Flux<UsuarioResponse> listarUsuarios() {
        return listarUsuariosUseCase.execute()
                .map(UsuarioResponse::toUsuarioResponse);
    }

    @GetMapping("/{id}")
    public Mono<UsuarioResponse> obterUsuario(@PathVariable Long id) {
        return obterUsuarioUseCase.execute(id)
                .map(UsuarioResponse::toUsuarioResponse);
    }

    @PostMapping
    public Mono<UsuarioResponse> criarUsuario(@RequestBody UsuarioRequest request) {
        Usuario usuario = Usuario.builder()
                .nome(request.getNome())
                .dataNascimento(request.getDataNascimento())
                .cep(request.getCep())
                .cidade(request.getCidade())
                .uf(request.getUf())
                .build();
        return criarUsuarioUseCase.execute(usuario)
                .map(UsuarioResponse::toUsuarioResponse);
    }

    @PutMapping("/{id}")
    public Mono<UsuarioResponse> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequest request) {
        Usuario usuario = Usuario.builder()
                .id(id)
                .nome(request.getNome())
                .dataNascimento(request.getDataNascimento())
                .cep(request.getCep())
                .cidade(request.getCidade())
                .uf(request.getUf())
                .build();
        return atualizarUsuarioUseCase.execute(id, usuario)
                .map(UsuarioResponse::toUsuarioResponse);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletarUsuario(@PathVariable Long id) {
        return deletarUsuarioUseCase.execute(id);
    }
}