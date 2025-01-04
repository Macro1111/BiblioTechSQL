package com.marco.biblioTechSQL.biblioTechSQL.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Autores")
public class AutorCls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @JsonAlias("name") private String nombre;

    @JsonAlias("birth_year") private String anhoNacimiento;

    @JsonAlias("death_year") private String anhoMuerte;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LibroCls> libros;

    // Constructor sin argumentos (necesario para JPA y Jackson)
    public AutorCls() {
    }

    // Constructor completo
    public AutorCls(String nombre, String anhoNacimiento, String anhoMuerte, List<LibroCls> libros) {
        this.nombre = nombre;
        this.anhoNacimiento = anhoNacimiento;
        this.anhoMuerte = anhoMuerte;
        this.libros = libros;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnhoNacimiento() {
        return anhoNacimiento;
    }

    public void setAnhoNacimiento(String anhoNacimiento) {
        this.anhoNacimiento = anhoNacimiento;
    }

    public String getAnhoMuerte() {
        return anhoMuerte;
    }

    public void setAnhoMuerte(String anhoMuerte) {
        this.anhoMuerte = anhoMuerte;
    }

    public List<LibroCls> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroCls> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return nombre +
                " Año de Nacimiento: " + anhoNacimiento +
                " Año de muerte: " + anhoMuerte;
    }


}

