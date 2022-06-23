package br.com.petshop.controller;

import br.com.petshop.config.Constantes;
import br.com.petshop.dto.PetDTO;
import br.com.petshop.dto.PetRequestAtivarDesativarDTO;
import br.com.petshop.entity.Response;
import br.com.petshop.service.PetService;
import br.com.petshop.vo.PetVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api(value = "api", protocols = "https")
@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin(origins = "*")
public class PetController {

    @Autowired
    private PetService service;
    @Autowired
    Constantes constante;

    public PetController(PetService service) {
        this.service = service;
    }

    @ApiOperation(value = "Create new Pet", notes = "Method responsible for creating a Pet")
    @PostMapping(value = "/pet/cadastrar")
    public ResponseEntity<Response> post(@RequestBody PetDTO petDTO) {
        Response response = service.post(petDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Ativar ou Inativar Pet", notes = "")
    @PutMapping(value = "/pet/ativar_Inativar_pet")
    public ResponseEntity<Response> AtivarInativar(@RequestBody PetRequestAtivarDesativarDTO petDTO) {
        Response response = service.ativarInativarPet(petDTO);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Update Pet", notes = "Method responsible for Update a Pet")
    @PutMapping(value = "/pet/editar")
    public ResponseEntity<Response> put(@RequestBody PetDTO petDTO) {
        Response response = service.put(petDTO);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Find pets by Status", notes = "")
    @GetMapping(value = "/pet/buscar/{status}")
    public ResponseEntity<List<PetVO>> getDvrEventsByIdentifier(@PathVariable Boolean status) {
            List<PetVO> listPetVO = service.getByStatus(status);
        if (listPetVO.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok().body(listPetVO);
        }
    }

    @ApiOperation(value = "Delete Pet By Id", notes = "")
    @DeleteMapping(value = "/pet/deletar/{id}")
    public ResponseEntity<Response> getDvrEventsByIdentifier(@PathVariable Long id) {
       Response response = service.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
