package br.com.petshop.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PetVO {
    private Long id;
    private String nome;
    private String especie;
    private String porte;
    private LocalDate dataNascimento;
    private Long qtAnos;
    private Long qtMeses;
    private Long qtDias;
    private Boolean status;
}
