package br.com.example.service.mapper;

import org.springframework.stereotype.Component;

import br.com.example.model.request.MedicoRequest;
import br.com.example.persistence.entity.Medico;

@Component
public class MedicoRequestMapper implements Mapper<MedicoRequest,Medico> {

  @Override
  public Medico map(MedicoRequest input) {
    if(input == null){return null;}
    Medico m = new Medico();
    m.setNome(input.getNome());
    m.setEspecialidade(input.getEspecialidade());
    m.setCrm(input.getCrm());

    return m;
  }
  
}
