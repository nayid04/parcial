package co.edu.unicesar.utilidades;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class Interfaz {
    
    public Interfaz(){
        
    }
    
    public void habilitarPanel(JPanel p) {
        for (Component component : p.getComponents()) {
            component.setEnabled(true);
        }
    }

    public void deshabilitarPanel(JPanel p) {
        for (Component component : p.getComponents()) {
            component.setEnabled(false);
        }
    }
    
    public void showPanel(JPanel contenedor1,JPanel p){
         p.setSize(600,480);
         p.setLocation(0, 0);
         
         
         contenedor1.removeAll();
         contenedor1.add(p, BorderLayout.CENTER);
         contenedor1.revalidate();
         contenedor1.repaint();
    }
    
    public void soloTexto(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;

        if (!(minusculas || mayusculas)) {
            evt.consume();
        }
    }

    public void soloNumeros(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!(numeros)) {
            evt.consume();
        }
    }

    public void letrasYnumeros(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean numeros = key >= 48 && key <= 57;

        if (!(minusculas || mayusculas || numeros)) {
            evt.consume();
        }
    }

    public void letrasYespacios(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
    }

    public void lestrasYnumerosYespacios(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean numeros = key >= 48 && key <= 57;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || numeros || espacio)) {
            evt.consume();
        }
    }
}
