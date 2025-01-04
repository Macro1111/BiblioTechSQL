package com.marco.biblioTechSQL.biblioTechSQL.model;

import com.marco.biblioTechSQL.biblioTechSQL.DTO.TituloLibroDTO;

import java.util.List;

public class AutorLibrosPrueba {

    private String autor;
    private String anhoNacimiento;
    private String anhoMuerte;
    private List<TituloLibroDTO> libros;

    public AutorLibrosPrueba(AutorCls autor, List<TituloLibroDTO> libros){
        this.autor = autor.getNombre();
        this.anhoNacimiento = autor.getAnhoNacimiento();
        this.anhoMuerte = autor.getAnhoMuerte();
        this.libros = libros;
    }

    public List<TituloLibroDTO> getLibros() {
        return libros;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "\n" + "Autor: " + autor +
                "\n" + "Año de Nacimiento: " + anhoNacimiento +
                "\n" + "Año Muerte: " + anhoMuerte +
                "\n" + "Libros: " + libros + "\n";
    }
}
