package br.com.heitorflorido.interview.entrypoint.rest.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UsuarioRequest {
    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private String cidade;
    private String uf;
}