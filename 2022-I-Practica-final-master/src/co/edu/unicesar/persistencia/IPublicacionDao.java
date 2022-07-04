/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicesar.persistencia;

import co.edu.unicesar.modelo.Publicacion;
import java.util.List;

/**
 *
 * @author JAIRO
 */
public interface IPublicacionDao {
    
    void insertarPublicacion(Publicacion p);
    List<Publicacion> leerPublicaciones();
    Publicacion buscarPublicacion(Publicacion p);
    Publicacion eliminarPublicacion(Publicacion p);
    
}
