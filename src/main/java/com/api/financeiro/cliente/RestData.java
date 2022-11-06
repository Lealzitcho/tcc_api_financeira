package com.api.financeiro.cliente;

import java.util.Date;

public class RestData {

    private Date inicio;
    private Date fim;

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
}
