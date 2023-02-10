package br.com.example.model.responce;

public class MedicoResponce {
  private Integer id;

  private String especialidade;

  private String nome;

  private String crm;

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
