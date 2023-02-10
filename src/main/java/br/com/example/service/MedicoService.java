package br.com.example.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.example.model.request.MedicoRequest;
import br.com.example.model.responce.MedicoResponce;


public interface MedicoService {
  MedicoResponce create(MedicoRequest MmdicoRequest);

  Page<MedicoResponce> getAll(Pageable Pageable);

  Optional<MedicoResponce> update(Long id,MedicoRequest MedicoRequest);

  Optional<MedicoResponce> getById(Long id);

  boolean delete(Long id);
}
