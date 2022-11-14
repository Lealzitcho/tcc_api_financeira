package com.api.financeiro.service;

import com.api.financeiro.cliente.ClienteFinanceiro;
import com.api.financeiro.cliente.ClienteSaldo;

import java.util.Date;
import java.util.List;

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
        clienteSaldo.setDataCadastro(new Date());
        clienteSaldo.setSaldoOuExtra(saldo);
        clienteSaldo.setEntrada(true);

        return clienteSaldo;

    }

    public static ClienteFinanceiro financeiro(List<ClienteSaldo> listar){

        float entrada = 0;

        ClienteFinanceiro clienteFinanceiro = new ClienteFinanceiro();

        for(ClienteSaldo cliente : listar){
            
            Boolean tipoEntrada = cliente.getEntrada();
            if(tipoEntrada){
                Float saldo = cliente.getSaldoOuExtra();
                entrada += saldo;
            }
            
        }

        clienteFinanceiro.setClienteEntrada(entrada);

        return clienteFinanceiro;
    }
}
