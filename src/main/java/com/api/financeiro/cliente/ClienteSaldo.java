package com.api.financeiro.cliente;

import javax.persistence.*;
import java.util.Date;

@Entity(name="CLIENTE")
public class ClienteSaldo {

    private Long id;
    private String categoriaSaldo;
    private String descricaoSaldo;
    private Date dataRecebimento;
    private Double saldoOuExtra;

    @Id
    @Column(name="ID", unique=true, nullable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="CATEGORIA_SALDO")
    public String getCategoriaSaldo() {
        return categoriaSaldo;
    }

    public void setCategoriaSaldo(String categoriaSaldo) {
        this.categoriaSaldo = categoriaSaldo;
    }

    @Column(name="DESCRICAO_SALDO")
    public String getDescricaoSaldo() {
        return descricaoSaldo;
    }

    public void setDescricaoSaldo(String descricaoSaldo) {
        this.descricaoSaldo = descricaoSaldo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATA_RECEBIMENTO")
    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    @Column(name="SALDO_EXTRA")
    public Double getSaldoOuExtra(){
        return saldoOuExtra;
    }

    public void setSaldoOuExtra(Double saldoOuExtra) {
        this.saldoOuExtra = saldoOuExtra;
    }
}

