package br.com.petshop.service;

import br.com.petshop.config.Constantes;
import br.com.petshop.dto.PetDTO;
import br.com.petshop.dto.PetRequestAtivarDesativarDTO;
import br.com.petshop.entity.Response;
import br.com.petshop.mapper.PetMapper;
import br.com.petshop.entity.Pet;
import br.com.petshop.repository.PetRepository;
import br.com.petshop.vo.PetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository repository;
    @Autowired
    Constantes constante;

    public Response post(PetDTO petDTO) {
        Response response = new Response();
        if(((!petDTO.getPorte().equals(constante.GRANDE))
                && (!petDTO.getPorte().equals(constante.MEDIO))
                && (!petDTO.getPorte().equals(constante.PEQUENO)))
                || (petDTO.getNome().equals(constante.VAZIA))
                || (petDTO.getNome().equals(constante.ESPACO))){

            response.setStatus(constante.BAD_REQUEST);
            response.setSuccess(false);
            response.setMessage("Porte Diferente de Médio, Grande ou Pequeno e ou Nome Vazio!");
            return response;
        }
        if(repository.findByNome(petDTO.getNome()) != null){
            response.setStatus(constante.BAD_REQUEST);
            response.setSuccess(false);
            response.setMessage("Nome do Pet Já Existe!");
            return response;
        }
        petDTO.setStatus(true);
        this.repository.save(PetMapper.toEntity(petDTO));
        response.setStatus(constante.OK);
        response.setSuccess(true);
        response.setMessage("Pet Cadastrado com Sucesso!");
        return response;
    }

    public Response ativarInativarPet(PetRequestAtivarDesativarDTO petDTO) {
        Response response = new Response();
        Optional<Pet> petOptional = this.repository.findById(petDTO.getId());
        Pet pet = petOptional.get();
        pet.setStatus(petDTO.getStatus());
        this.repository.save(pet);
        response.setStatus(constante.OK);
        response.setSuccess(true);
        response.setMessage("Pet Atualizado com Sucesso!");
        return response;
    }

    public Response put(PetDTO petDTO) {
        Response response = new Response();
        if (petDTO.getId() == null || !repository.findById(petDTO.getId()).isPresent()) {
            response.setStatus(constante.NO_CONTENT);
            response.setSuccess(false);
            response.setMessage("Pet Não Existe!");
            return response;
        } else {
            if (((!petDTO.getPorte().equals(constante.GRANDE))
                    && (!petDTO.getPorte().equals(constante.MEDIO))
                    && (!petDTO.getPorte().equals(constante.PEQUENO)))
                    || (petDTO.getNome().equals(constante.VAZIA))
                    || (petDTO.getNome().equals(constante.ESPACO))) {

                response.setStatus(constante.BAD_REQUEST);
                response.setSuccess(false);
                response.setMessage("Porte Diferente de Médio, Grande ou Pequeno e ou Nome Vazio!");
                return response;
            }
            if (repository.findByNomeAndId(petDTO.getNome(), petDTO.getId()) != null) {
                response.setStatus(constante.BAD_REQUEST);
                response.setSuccess(false);
                response.setMessage("Nome do Pet Já Existe em outro Cadastro!");
                return response;
            }
            petDTO.setStatus(true);
            this.repository.save(PetMapper.toEntity(petDTO));
            response.setStatus(constante.OK);
            response.setSuccess(true);
            response.setMessage("Pet Atualizado com Sucesso!");
            return response;
        }
    }

    public List<PetVO> getByStatus(Boolean status) {
        List<PetVO> listVO = new ArrayList<>();
        List<Pet> lista = this.repository.findByStatus(status);
        lista.forEach(pet -> listVO.add(PetMapper.toVO(pet)));
        return listVO;
    }

    public Response deleteById(Long id){
        Response response = new Response();
        if (!repository.findById(id).isPresent()) {
            response.setStatus(constante.NO_CONTENT);
            response.setSuccess(false);
            response.setMessage("Pet Não Existe!");
            return response;
        }else {
            this.repository.deleteById(id);
            response.setStatus(constante.ACCEPTED);
            response.setSuccess(false);
            response.setMessage("Pet Excluido!");
            return response;
        }
    }
}
