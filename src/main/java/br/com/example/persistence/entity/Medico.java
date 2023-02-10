package br.com.example.persistence.entity;

import java.util.function.Function;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medico {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "especialidade",nullable = false)
  private String especialidade;

  @Column(name = "nome",nullable = false)
  private String nome;

  @Column(name = "crm",nullable = false)
  private String crm;
  
  public <R> R map(Function<Medico,R> func) {
    return func.apply(this);
  }

  public Integer getId(){
    return this.id;
  }

  public void setId(Integer id){
    this.id = id;
  }

  public String getNome(){
    return this.nome;
}

public void setNome(String nome){
    this.nome = nome;
}

public String getEspecialidade(){
    return this.especialidade;
}

public void setEspecialidade(String especialidade){
    this.especialidade = especialidade;
}

public String getCrm(){
    return this.crm;
}

public void setCrm(String crm){
    this.crm = crm;
}
}
