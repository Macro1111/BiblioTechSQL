package com.marco.biblioTechSQL.biblioTechSQL.principal;

import com.marco.biblioTechSQL.biblioTechSQL.service.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {

    Scanner teclado = new Scanner(System.in);

    @Autowired
    private ServicioLibros servicioLibros ;

    public void menu(){
        while (true){
            System.out.println("""
                    
                    Escoge una opcion:
                    1. Para buscar un libro especifico
                    2. Lista de libros
                    3. Lista de Autores
                    4. Auotres vivos por año
                    5. Libros por idioma
                    
                    0. Para salir
                    """);
            System.out.print("Ingresa tu opcion: ");
            String respuesta = teclado.nextLine();

            if (respuesta.equals("0")){
                System.out.println("Programa finalizado");
                break;
            }

            switch (respuesta) {
                case "1":
                    servicioLibros.obtenerLibro();
                    break;
                case "2":
                    servicioLibros.obtenerTodosLosLibros();
                    break;
                case "3":
                    servicioLibros.obtenerTodosLosAutores();
                    break;
                case "4":
                    servicioLibros.obtenerAutoresVivosPorAño();
                    break;
                case "5":
                    servicioLibros.obtenerLibrosPorIdioma();
                    break;
            }
        }
    }

}
