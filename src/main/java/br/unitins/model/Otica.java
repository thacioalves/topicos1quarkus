package br.unitins.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity 
public class Otica extends PanacheEntity {
    private String modelo;
    private String marca;
    private String lente;
    private String fornecedor;
    private String tamanho;

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getLente() {
        return lente;
    }
    public void setLente(String lente) {
        this.lente = lente;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
}
