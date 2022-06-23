package br.com.petshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PetDTO {
    private Long id;
    private String nome;
    private String especie;
    private String porte;
    private LocalDate dataNascimento;
    private Boolean status;
}
