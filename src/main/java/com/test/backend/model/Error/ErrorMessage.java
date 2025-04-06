package com.test.backend.model.Error;

public class ErrorMessage {
    
    private String titulo;

    private Integer status;

    private String mesagem;

    public ErrorMessage(String titulo, Integer status, String mesagem) {
        this.titulo = titulo;
        this.status = status;
        this.mesagem = mesagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMesagem() {
        return mesagem;
    }

    public void setMesagem(String mesagem) {
        this.mesagem = mesagem;
    }

    
}

   
    
