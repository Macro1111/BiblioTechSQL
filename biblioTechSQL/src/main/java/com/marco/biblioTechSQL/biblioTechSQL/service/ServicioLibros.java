package com.marco.biblioTechSQL.biblioTechSQL.service;

import com.marco.biblioTechSQL.biblioTechSQL.model.*;
import com.marco.biblioTechSQL.biblioTechSQL.repository.IAutorRepository;
import com.marco.biblioTechSQL.biblioTechSQL.repository.ILibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class ServicioLibros {
    Scanner teclado = new Scanner(System.in);
    ConvierteDatos conversor = new ConvierteDatos();

    @Autowired
    private ILibroRepository libroRepository;

    @Autowired
    private IAutorRepository autorRepository;

    @Transactional
    public void obtenerLibro() {
        System.out.print("\n" + "Ingresa el nombre de el libro: ");
        String nombreLibro = teclado.nextLine();
        nombreLibro = nombreLibro.replace(" ", "%20");
        String url = "https://gutendex.com/books/?search=" + nombreLibro;

        try {
            Optional<LibroCls> respuesta = libroRepository.findByTituloContaining(nombreLibro);

            if (respuesta.isPresent()) {
                System.out.println(respuesta.get());
            } else {
                System.out.print("Libro no encontrado en la base de datos, deseas buscarlo en Gutendex, s para buscarlo n para no buscarlo: ");
                String buscarG = teclado.nextLine();
                if (buscarG.equals("s")) {
                    var json = ConsumoApi.obtenerDatos(url);
                    var libro2 = conversor.ObtenerDatos(json, ListLibrosCls.class);
                    var primero = libro2.getLibros().stream().findFirst();

                    if (primero.isEmpty()) {
                        System.out.println("No se encontraron libros.");
                        return;
                    }

                    LibroCls nuevoLibro = primero.get();
                    System.out.println(nuevoLibro);

                    System.out.print("Deseas guardar este libro en la base de datos, ingresa s para guardarlo, n para no guardarlo: ");
                    String continuar = teclado.nextLine();

                    if (continuar.equals("s")) {

                        Optional<AutorCls> autorExistente = autorRepository.findByNombre(nuevoLibro.getAutor().getNombre());
                        AutorCls autor = autorExistente.orElseGet(() -> autorRepository.save(nuevoLibro.getAutor()));

                        nuevoLibro.setAutor(autor);

                        libroRepository.save(nuevoLibro);

                        System.out.println(nuevoLibro);
                        System.out.println("Libro guardado");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Libro no encontrado");
        }
    }

    @Transactional
    public void obtenerTodosLosLibros() {
        var libros = libroRepository.findAll();
        for (LibroCls libro : libros) {
            System.out.println(libro);
        }
    }

    @Transactional
    public void obtenerTodosLosAutores(){
        var todosAutores = autorRepository.findAll();

        for (AutorCls autor : todosAutores){
            var nombreLibros = autorRepository.findLibrosByAutorNombre(autor.getNombre());
            AutorLibrosPrueba autoresLibros = new AutorLibrosPrueba(autor, nombreLibros);
            System.out.println(autoresLibros);
        }
    }

    @Transactional
    public void obtenerAutoresVivosPorAño(){
        System.out.println("Ingresa el año que deseas buscar: ");
        int año = teclado.nextInt();
        teclado.nextLine();

        var autoresVivos = autorRepository.findAutoresVivosEnAnio(año);

        for (AutorCls autor : autoresVivos){
            var nombreLibros = autorRepository.findLibrosByAutorNombre(autor.getNombre());
            AutorLibrosPrueba autoresLibros = new AutorLibrosPrueba(autor, nombreLibros);
            System.out.println(autoresLibros);
        }
    }

    @Transactional
    public void obtenerLibrosPorIdioma(){
        String idioma;
        String idiomaCompleto;

        System.out.println("""
                Escoge un idioma
                1. Español
                2. Portugues
                3. Ingles
                """);
        System.out.print("Ingresa tu opcion: ");
        var idiomaSeleccionado = teclado.nextLine();

        switch (idiomaSeleccionado){
            case "1":
                idioma = "es";
                idiomaCompleto = "Español";
                break;
            case "2":
                idioma = "pt";
                idiomaCompleto = "Portugues";
                break;
            case"3":
                idioma = "en";
                idiomaCompleto = "Ingles";
                break;
            default:
                System.out.println("Opcion no valida, se muestran los libros en Español por defecto");
                idioma = "es";
                idiomaCompleto = "Español";
                break;
        }

        var librosPorIdioma = libroRepository.findByLenguaje(idioma);
        for (LibroCls libro : librosPorIdioma ){
            System.out.println(libro);
        }

        System.out.println("Cantidad de libros en " + idiomaCompleto + " : " + librosPorIdioma.size());

    }
}