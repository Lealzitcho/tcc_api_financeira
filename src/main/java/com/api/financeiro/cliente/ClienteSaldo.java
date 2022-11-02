package com.api.financeiro.cliente;

import javax.persistence.*;
import java.util.Date;

@Entity(name="CLIENTE")
public class ClienteSaldo {

    private Long id;
    private String categoriaSaldo;
    private String descricaoSaldo;
    private Date dataRecebimento;
    private Date dataCadastro;
    private Float saldoOuExtra;
    private Boolean entrada;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATA_CADASTRO")
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Column(name="SALDO_EXTRA")
    public Float getSaldoOuExtra(){
        return saldoOuExtra;
    }

    public void setSaldoOuExtra(Float saldoOuExtra) {
        this.saldoOuExtra = saldoOuExtra;
    }

    @Column(name="ENTRADA")
    public Boolean getEntrada(){
        return entrada;
    }

    public void setEntrada(Boolean entrada) {
        this.entrada = entrada;
    }
}

