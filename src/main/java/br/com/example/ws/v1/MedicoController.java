package br.com.example.ws.v1;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.model.request.MedicoRequest;
import br.com.example.model.responce.MedicoResponce;
import br.com.example.service.MedicoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
  private static final Logger LOGGER = LoggerFactory.getLogger(MedicoController.class);

  @Autowired
  private MedicoService medicoService;

  @PostMapping
  public ResponseEntity<MedicoResponce> create(@RequestBody MedicoRequest medicoRequest){
    LOGGER.info("Request recebida! {}",medicoRequest);
    return ResponseEntity.ok(medicoService.create(medicoRequest));
  }

  @GetMapping
  public ResponseEntity<Page<MedicoResponce>> getAll(Pageable pageable){
    LOGGER.info("Buscando!");
    Page<MedicoResponce> medicoResponce = medicoService.getAll(pageable);
    return ResponseEntity.ok(medicoResponce);
  }

  @PutMapping("/{id}")
  public ResponseEntity<MedicoResponce> update(@PathVariable("id") Long id,@RequestBody MedicoRequest medicoRequest){
    LOGGER.info("Atualizando o registro {}!",id);
    Optional<MedicoResponce> update = medicoService.update(id, medicoRequest);
    if(!update.isPresent()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(update.get());
  }

  @GetMapping("/{id}")
  public ResponseEntity<MedicoResponce> getById(@PathVariable("id") Long id){
    LOGGER.info("Buscando o registro {}!",id);
    Optional<MedicoResponce> medicoResponce= medicoService.getById(id);
    if(!medicoResponce.isPresent()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(medicoResponce.get());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id){
    LOGGER.info("Deletando o registro {}!",id);
    if(medicoService.delete(id)){
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.badRequest().build();
  }

}
