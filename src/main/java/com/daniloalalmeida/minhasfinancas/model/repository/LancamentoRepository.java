package com.daniloalalmeida.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniloalalmeida.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
