/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.vista;

import co.edu.unicesar.modelo.*;
import co.edu.unicesar.utilidades.Consola;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JAIRO
 */
public class VistaConsola {

    private String opciones[] = {"1.Insertar Publicacion", "2.Leer Publicaciones", "3.Buscar Publicacion", "4.Eliminar Publicacion", "5. Salir"};
    private int seleccion;
    private ListaPublicacion modelo;

    public VistaConsola() {
        this.modelo = new ListaPublicacion();
    }

    public void verOpcionesMenu() {
        System.out.println("\n[   MENU DE OPCIONES  ]\n");
        for (String item : this.opciones) {
            System.out.println(item);
        }
        this.seleccion = Consola.getInteger("\nSeleccione una opcion: ");
        System.out.println("");
    }

    public void evaluarSeleccion() {

        if (this.seleccion < 5) {
            System.out.println(this.opciones[this.seleccion - 1].toUpperCase());
        }

        switch (this.seleccion) {
            case 1:
                this.registrarPublicacion();
                break;
            case 2:
                this.leerPublicaciones();
                break;
            case 3:
                this.buscarPublicacion();
                break;
            case 4:
                this.eliminarPublicacion();
                break;
            case 5:
                System.out.println("** Aplicacion finalizada ** ");
                break;
            default:
                System.out.println("La opcion no es valida, intente nuevamente");
        }
    }

    public void ejecutarMenu() {

        do {
            this.verOpcionesMenu();
            this.evaluarSeleccion();

        } while (this.seleccion != 5);

    }

    public void run() {
        this.ejecutarMenu();
    }

    public void leerPublicaciones() {

        System.out.println("Publicaciones registradas: ");
        System.out.printf("%-10s %-10s %-30s %-30s %-10s %-10s %-10s %-10s %-10s%n", "TIPO", "ISBN", "TITULO", "AUTOR", "NO PAG", "EDICION", "PESO", "DURACION", "FORMATO");
        System.out.println("-------------------------------------");
        List<Publicacion> lista = this.modelo.leerPublicaciones();
        for (Publicacion p : lista) {
            System.out.println(p.getStringFormat());
        }
        System.out.println("-------------------------------------");
        System.out.printf("Total %d publicaciones registradas%n", lista.size());

    }

    public void textPublicaciones() {

        try {
            FileWriter salvar = new FileWriter("datos.txt");
            List<Publicacion> lista = this.modelo.leerPublicaciones();
            for (Publicacion p : lista) {
                salvar.write(p.getDataStringFormat());
            }
            salvar.write("\n");

            salvar.close();
        } catch (IOException x) {
            JOptionPane.showMessageDialog(null, "error");
        }

    }

    public void registrarPublicacion() {

        Publicacion nuevaPublicacion = this.leerNuevaPublicacion();
        this.modelo.insertarPublicacion(nuevaPublicacion);
        System.out.println("\n!! Nueva publicacion registrada con exito ¡¡");
        textPublicaciones();
    }

    public Publicacion leerNuevaPublicacion() {
        Publicacion publicacion;

        String isbn = Consola.getString("Isbn: ", "%-15s");
        String titulo = Consola.getString("Titulo: ", "%-15s");
        String autor = Consola.getString("Autor: ", "%-15s");
        int anio = Consola.getInteger("Año pub: ", "%-15s");
        double costo = Consola.getDouble("Costo: $ ", "%-15s");
        int tipo;
        do {
            tipo = Consola.getInteger("Tipo? [1->Libro] [2->Audio Libro]: ", "%-15s");
        } while (tipo < 1 || tipo > 2);

        if (tipo == 1) {
            int nPag = Consola.getInteger("No de paginas: ", "%-15s");
            int edicion = Consola.getInteger("No edicion: ", "%-15s");

            publicacion = new Libro(nPag, edicion, isbn, titulo, autor, anio, costo);
        } else {
            String formato = Consola.getString("Formato: ", "%-15s");
            double duracion = Consola.getDouble("Duracion (seg): ", "%-15s");
            double peso = Consola.getDouble("Peso (Mb): ", "%-15s");
            publicacion = new AudioLibro(duracion, peso, formato, isbn, titulo, autor, anio, costo);
        }
        textPublicaciones();
        return publicacion;
    }

    public void buscarPublicacion() {
        String isbn = Consola.getString("Isbn a buscar: ", "%-15s");
        Publicacion pBusqueda = new Libro(isbn);

        Publicacion pResultado = this.modelo.buscarPublicacion(pBusqueda);
        if (pResultado != null) {
            System.out.println("\n!! Publicacion encontrada ¡¡");
            System.out.println(pResultado);
        } else {
            System.out.println("\n!! La Publicacion no se encuentra registrada ¡¡");
        }
    }

    public void eliminarPublicacion() {

        String isbn = Consola.getString("Isbn a eliminar: ", "%-15s");
        Publicacion pBusqueda = new Libro(isbn);

        Publicacion pEliminada = this.modelo.eliminarPublicacion(pBusqueda);
        if (pEliminada != null) {
            System.out.println("\n!! Publicacion eliminada ¡¡");
            System.out.println(pEliminada);
        } else {
            System.out.println("\n!! La Publicacion no se encuentra registrada ¡¡");
        }

    }

}
