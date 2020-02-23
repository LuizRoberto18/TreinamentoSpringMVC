package com.home_office.treinamento_spring_mvc.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Preco{
    
    @Column(scale = 2)
    private BigDecimal value;
    private TipoLivro tipoLivro;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TipoLivro getTipoLivro() {
        return tipoLivro;
    }

    public void setTipoLivro(TipoLivro tipoLivro) {
        this.tipoLivro = tipoLivro;
    }

    
}