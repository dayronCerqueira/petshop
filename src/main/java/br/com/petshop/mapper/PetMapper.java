package br.com.petshop.mapper;

import br.com.petshop.dto.PetDTO;
import br.com.petshop.entity.Pet;
import br.com.petshop.vo.PetVO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PetMapper {

    public static Pet toEntity(PetDTO petDTO){
        Pet pet = new Pet();
        pet.setId(petDTO.getId());
        pet.setEspecie(petDTO.getEspecie());
        pet.setDataNascimento(petDTO.getDataNascimento());
        pet.setPorte(petDTO.getPorte());
        pet.setNome(petDTO.getNome());
        pet.setStatus(petDTO.getStatus());
        return pet;
    }

    public static PetVO toVO(Pet pet){
        PetVO petVO = new PetVO();
        petVO.setId(pet.getId());
        petVO.setEspecie(pet.getEspecie());
        petVO.setDataNascimento(pet.getDataNascimento());
        petVO.setPorte(pet.getPorte());
        petVO.setNome(pet.getNome());
        petVO.setStatus(pet.getStatus());
        petVO.setQtAnos(pet.getDataNascimento().until(LocalDate.now(), ChronoUnit.YEARS));
        petVO.setQtDias(pet.getDataNascimento().until(LocalDate.now(), ChronoUnit.DAYS));
        petVO.setQtMeses(pet.getDataNascimento().until(LocalDate.now(), ChronoUnit.MONTHS));
        return petVO;
    }
}
