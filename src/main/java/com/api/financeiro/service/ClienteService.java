package com.api.financeiro.service;

import com.api.financeiro.cliente.ClienteSaldo;

import java.util.Date;

public class ClienteService {

    public static ClienteSaldo salvarEntrada(ClienteSaldo cliente){

        ClienteSaldo clienteSaldo = new ClienteSaldo();

        String categoriaGasto = cliente.getCategoriaSaldo();
        String descricaoGasto = cliente.getDescricaoSaldo();
        Date dataRecebimento = cliente.getDataRecebimento();
        Float saldo = cliente.getSaldoOuExtra();

        clienteSaldo.setCategoriaSaldo(categoriaGasto);
        clienteSaldo.setDescricaoSaldo(descricaoGasto);
        clienteSaldo.setDataRecebimento(dataRecebimento);
        clienteSaldo.setSaldoOuExtra(saldo);
        clienteSaldo.setEntrada(true);

        return clienteSaldo;

    }
}
