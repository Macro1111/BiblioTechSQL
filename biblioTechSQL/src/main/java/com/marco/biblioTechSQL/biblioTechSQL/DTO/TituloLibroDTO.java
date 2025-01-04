package com.marco.biblioTechSQL.biblioTechSQL.DTO;

import com.marco.biblioTechSQL.biblioTechSQL.model.LibroCls;

public class TituloLibroDTO{
    private String titulo;

    public TituloLibroDTO(LibroCls libro){
        this.titulo = libro.getTitulo();
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
