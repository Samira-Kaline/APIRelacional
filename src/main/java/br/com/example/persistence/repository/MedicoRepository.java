package br.com.example.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.example.persistence.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {}
