package br.com.example.service.mapper;

public interface Mapper<A,B> {
  B map(A input);
}
