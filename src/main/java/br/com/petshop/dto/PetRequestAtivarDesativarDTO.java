package br.com.petshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetRequestAtivarDesativarDTO {

    private Long id;
    private Boolean status;
}
