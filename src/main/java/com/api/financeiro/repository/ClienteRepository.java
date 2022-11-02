package com.api.financeiro.repository;

import com.api.financeiro.cliente.ClienteSaldo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface ClienteRepository extends JpaRepository<ClienteSaldo, Long> {

    List<ClienteSaldo> findByDataRecebimentoBetween(Date inicio, Date Fim);

}
