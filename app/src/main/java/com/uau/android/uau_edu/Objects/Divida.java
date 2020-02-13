package com.uau.android.uau_edu.Objects;

public class Divida {

    private String titulo;
    private String contrato;
    private String data;
    private String valor;


    public Divida(String titulo, String contrato, String data, String valor) {
        this.titulo = titulo;
        this.contrato = contrato;
        this.data = data;
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
