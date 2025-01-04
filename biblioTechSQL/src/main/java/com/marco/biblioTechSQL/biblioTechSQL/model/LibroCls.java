package com.marco.biblioTechSQL.biblioTechSQL.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Libros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroCls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;

    private String gutendex;

    @Column(unique = true)
    @JsonAlias("title") private String titulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_nombre", referencedColumnName = "nombre")
    @JsonIgnore
    private AutorCls autor;

    private String lenguaje;

    @JsonAlias("download_count")
    private double numeroDescargas;

    // Constructor sin argumentos (necesario para JPA y Jackson)
    public LibroCls() {
    }

    // Constructor completo
    public LibroCls(String gutendex, String titulo, AutorCls autor, String lenguaje, double numeroDescargas) {
        this.gutendex = gutendex;
        this.titulo = titulo;
        this.autor = autor;
        this.lenguaje = lenguaje;
        this.numeroDescargas = numeroDescargas;
    }

    // Getters y Setters
    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getGutendex() {
        return gutendex;
    }

    @JsonProperty("id")
    public void setGutendex(String gutendex) {
        this.gutendex = gutendex;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public AutorCls getAutor() {
        return autor;
    }

    public void setAutor(AutorCls autor) {
        this.autor = autor;
    }

    @JsonAlias("authors")
    public void setAutores(List<AutorCls> autores) {
        if (autores != null && !autores.isEmpty()) {
            this.autor = autores.get(0);
        }
    }

    public String getLenguaje() {
        return lenguaje;
    }

    @JsonAlias("languages")
    public void setLenguajes(List<String> lenguajes) {
        if (lenguajes != null && !lenguajes.isEmpty()) {
            this.lenguaje = lenguajes.get(0);
        }else{
            this.lenguaje = "No lenguaje especificado";
        }
    }

    public double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return "\n ID en gutendex: " + gutendex +
                "\n Titulo: " + titulo +
                "\n Autor: " + (autor != null ? autor : "Desconocido") +
                "\n Lenguaje: " + (lenguaje != null  ? lenguaje : "Sin lenguaje") +
                "\n Cantidad de descargas: " + numeroDescargas +
                "\n";
    }
}
