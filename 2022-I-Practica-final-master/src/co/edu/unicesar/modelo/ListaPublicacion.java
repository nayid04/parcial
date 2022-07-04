package co.edu.unicesar.modelo;

import co.edu.unicesar.persistencia.*;
import java.util.List;

/**
 *
 * @author JAIRO
 */
public class ListaPublicacion implements IPublicacionDao {
    
    private IPublicacionDao registroPublicaciones;

    public ListaPublicacion() {
        this.registroPublicaciones = new ArrayListPublicacion();
    }
    
    
    @Override
    public void insertarPublicacion(Publicacion p) {
        
        this.registroPublicaciones.insertarPublicacion(p);
        
    }

    @Override
    public List<Publicacion> leerPublicaciones() {
        
        return this.registroPublicaciones.leerPublicaciones();
        
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) {
        
        return this.registroPublicaciones.buscarPublicacion(p);
        
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion p) {
        
        return this.registroPublicaciones.eliminarPublicacion(p);
        
    }
    
}
