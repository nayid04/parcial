package co.edu.unicesar.persistencia;

import co.edu.unicesar.modelo.ListaPublicacion;
import co.edu.unicesar.modelo.Publicacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ArchivoTxt {
    
    public static FileWriter salvar;
    
    public ArchivoTxt(){
        
    }
    
    public static void limpiarText() {
        try {
            salvar = new FileWriter("datos.txt");
            salvar.write("");

            salvar.close();
        } catch (IOException x) {
            JOptionPane.showMessageDialog(null, "error");
        }
    }
    
    public void textPublicaciones(ListaPublicacion modelo) {

        try {
            salvar = new FileWriter("datos.txt");
            List<Publicacion> lista = modelo.leerPublicaciones();
            for (Publicacion p : lista) {
                salvar.write(p.getDataStringFormat());
                salvar.write("\n");
            }

            salvar.close();
        } catch (IOException x) {
            JOptionPane.showMessageDialog(null, "error");
        }

    }
    
    public void datosText(DefaultTableModel modelo_tabla) {
        BufferedReader bufferedReader = null;

        try {
            
            bufferedReader = new BufferedReader(new FileReader("datos.txt"));
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] rowfields = line.split(";");
                modelo_tabla.addRow(rowfields);
                line = bufferedReader.readLine();
            }

        } catch (IOException x) {
            JOptionPane.showMessageDialog(null, "error");
        }

    }
}
