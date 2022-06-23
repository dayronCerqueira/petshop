package br.com.petshop.repository;

import br.com.petshop.entity.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {

    @Query(value = "SELECT p FROM Pet p WHERE p.nome = ?1")
    Pet findByNome(String nome);

    @Query(value = "SELECT p FROM Pet p WHERE p.nome = ?1 and p.id <> ?2")
    Pet findByNomeAndId(String nome, Long id);

    @Query(value = "SELECT p FROM Pet p WHERE p.status =?1")
    List<Pet> findByStatus(Boolean status);




}
