package com.api.financeiro.repository;

import com.api.financeiro.cliente.ClienteSaldo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<ClienteSaldo, Long> {

}
