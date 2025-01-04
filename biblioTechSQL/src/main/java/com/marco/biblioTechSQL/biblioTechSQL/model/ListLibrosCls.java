package com.marco.biblioTechSQL.biblioTechSQL.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ListLibrosCls{

    @JsonAlias("results") List<LibroCls> libros;

    public ListLibrosCls(){};

    public ListLibrosCls(List<LibroCls> libros){
        this.libros = libros;
    }

    public List<LibroCls> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroCls> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Libro: " + libros;
    }
}