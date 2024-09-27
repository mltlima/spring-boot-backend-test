package br.com.heitorflorido.interview.model;

import lombok.Builder;
import lombok.Value;
import java.time.LocalDate;

@Value
@Builder(toBuilder = true)
public class Usuario {

    Long id;
    String nome;
    LocalDate dataNascimento;
    String cep;
    String cidade;
    String uf;
}
