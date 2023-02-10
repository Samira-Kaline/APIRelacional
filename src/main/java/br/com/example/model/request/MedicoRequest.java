package br.com.example.model.request;

import jakarta.validation.constraints.NotBlank;

public class MedicoRequest {
  @NotBlank
  private String nome;

  @NotBlank
  private String especialidade;

  @NotBlank
  private String crm;

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
