package com.api.financeiro.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class ClienteCustomRepository {

    private final EntityManager em;

    public ClienteCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<String> find(Date inicio, Date fim){

        String query = "select C.categoriaSaldo from CLIENTE as C where C.entrada = true and C.dataRecebimento between :inicio and :fim group by C.categoriaSaldo order by count (C.id) desc";

        TypedQuery<String> q = em.createQuery(query, String.class);

        q.setParameter("inicio", inicio);
        q.setParameter("fim", fim);

        return q.getResultList();
    }
}
