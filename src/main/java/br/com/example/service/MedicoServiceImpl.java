package br.com.example.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.example.model.request.MedicoRequest;
import br.com.example.model.responce.MedicoResponce;
import br.com.example.persistence.entity.Medico;
import br.com.example.persistence.repository.MedicoRepository;
import br.com.example.service.mapper.Mapper;

@Service
public class MedicoServiceImpl implements MedicoService{

  private static final Logger LOGGER = LoggerFactory.getLogger(MedicoService.class);

  @Autowired
  private MedicoRepository medicoRepository;

  @Autowired
  private Mapper<MedicoRequest,Medico> requestMapper;

  @Autowired
  private Mapper<Medico, MedicoResponce> responceMapper;


  @Override
  public MedicoResponce create(MedicoRequest medicoRequest) {
    LOGGER.info("Criando um registro");
    Assert.notNull(medicoRequest, "Request Invalido!");
    Medico medico = this.requestMapper.map(medicoRequest);
    return medicoRepository.saveAndFlush(medico).map((Medico input)-> this.responceMapper.map(input));
  }

  @Override
  public boolean delete(Long id) {
    LOGGER.info("Deletando um registro");
    Assert.notNull(id, "Id Invalido!");
    try{
      medicoRepository.deleteById(id);
      return true;
    }catch(Exception e){
      LOGGER.warn("Erro ao deletar o registro {}",id);
      return false;
    }
  }

  @Override
  public Page<MedicoResponce> getAll(Pageable pageable) {
    LOGGER.info("Buscando todos os registros");
    Assert.notNull(pageable, "Busca Invalida!");
    return medicoRepository.findAll(pageable).map(medico -> this.responceMapper.map(medico));
  }

  @Override
  public Optional<MedicoResponce> getById(Long id) {
    LOGGER.info("Buscando um registro");
    Assert.notNull(id, "Id Invalido!");
    return medicoRepository.findById(id).map(this.responceMapper::map);
  }

  @Override
  public Optional<MedicoResponce> update(Long id, MedicoRequest medicoRequest) {
    LOGGER.info("Atualizando um registro");
    Assert.notNull(id, "Id Invalido");

    Medico novoMedico = this.requestMapper.map(medicoRequest);
    return medicoRepository.findById(id).map(
      medico ->{
        medico.setNome(novoMedico.getNome());
        medico.setEspecialidade(novoMedico.getEspecialidade());
        medico.setCrm(novoMedico.getCrm());
        return this.responceMapper.map(medicoRepository.saveAndFlush(medico));
      });
  }
  
}
