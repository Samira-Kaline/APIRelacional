package br.com.example.service.mapper;

import org.springframework.stereotype.Component;

import br.com.example.model.responce.MedicoResponce;
import br.com.example.persistence.entity.Medico;

@Component
public class MedicoResponceMapper implements Mapper<Medico,MedicoResponce> {

  @Override
  public MedicoResponce map(Medico input) {
    if(input == null){return null;}

    MedicoResponce m = new MedicoResponce();
    m.setId(input.getId());
    m.setNome(input.getNome());
    m.setEspecialidade(input.getEspecialidade());
    m.setCrm(input.getCrm());

    return m;
  }
  
}
