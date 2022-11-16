package com.api.financeiro.service;

import com.api.financeiro.cliente.ClienteFinanceiro;
import com.api.financeiro.cliente.ClienteRelatorio;
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

    public static ClienteSaldo salvarSaida(ClienteSaldo cliente){

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
        clienteSaldo.setEntrada(false);

        return clienteSaldo;

    }

    public static ClienteFinanceiro financeiro(List<ClienteSaldo> listar){

        float entrada = 0;
        float saida = 0;

        ClienteFinanceiro clienteFinanceiro = new ClienteFinanceiro();

        for(ClienteSaldo cliente : listar){
            
            Boolean tipoEntrada = cliente.getEntrada();
            if(tipoEntrada){
                Float saldo = cliente.getSaldoOuExtra();
                entrada += saldo;
            }
            else {
                Float saldoSaida = cliente.getSaldoOuExtra();
                saida += saldoSaida;
            }
            
        }

        clienteFinanceiro.setClienteEntrada(entrada);
        clienteFinanceiro.setClienteSaida(saida);

        return clienteFinanceiro;
    }

    public static ClienteRelatorio relatorio(List<ClienteSaldo> listar, String categoria){

        float entrada = 0;

        ClienteRelatorio clienteRelatorio = new ClienteRelatorio();

        for(ClienteSaldo cliente : listar){

            Boolean tipoEntrada = cliente.getEntrada();
            if(tipoEntrada){
                Float saldo = cliente.getSaldoOuExtra();
                entrada += saldo;
            }

        }

        clienteRelatorio.setValor(entrada);
        clienteRelatorio.setDescricao(categoria);

        return clienteRelatorio;
    }

    public static ClienteRelatorio relatorioSaida(List<ClienteSaldo> listar, String categoria){

        float saida = 0;

        ClienteRelatorio clienteRelatorio = new ClienteRelatorio();

        for(ClienteSaldo cliente : listar){

            Boolean tipoEntrada = cliente.getEntrada();
            if(tipoEntrada == false){
                Float saldo = cliente.getSaldoOuExtra();
                saida += saldo;
            }

        }

        clienteRelatorio.setValor(saida);
        clienteRelatorio.setDescricao(categoria);

        return clienteRelatorio;
    }
}
