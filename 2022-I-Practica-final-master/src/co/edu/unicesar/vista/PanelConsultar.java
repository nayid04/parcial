/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicesar.vista;

import co.edu.unicesar.modelo.*;
import co.edu.unicesar.persistencia.*;
import co.edu.unicesar.utilidades.Consola;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LENOVO
 */
public class PanelConsultar extends javax.swing.JPanel {

    /**
     * Creates new form PanelConsultar
     */
    public static ArchivoTxt archivo;
    private ListaPublicacion modelo;
    public static DefaultTableModel modelo_tabla;
    TableRowSorter trs;
    private String titulosTabla[] = {"ISBN", "TIPO", "TITULO", "AUTOR", "ANIO", "COSTO", "No PAG", "EDICION", "FORMATO", "DURACION", "PESO"};
    

    public PanelConsultar() {
        initComponents();
        archivo = new ArchivoTxt();
        this.modelo = new ListaPublicacion();
        //leerPublicaciones();
        modelo_tabla = new DefaultTableModel();
        for (int i = 0; i < titulosTabla.length; i++) {
            modelo_tabla.addColumn(titulosTabla[i]);
        }
        this.tabla.setModel(modelo_tabla);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        textConsultar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonEliminar1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TIPO", "ISBN", "TITULO", "AUTOR", "No PAG", "EDICION", "ANIO", "COSTO", "DURACION", "PESO", "FORMATO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla.setFocusable(false);
        tabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabla.setRowHeight(25);
        tabla.setSelectionBackground(new java.awt.Color(43, 42, 77));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 566, 310));

        textConsultar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        textConsultar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textConsultar.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(43, 42, 77), 1, true), "INGRESE UN ISBN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        textConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textConsultarKeyTyped(evt);
            }
        });
        bg.add(textConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 470, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("CONSULTAR");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 33, -1, -1));

        botonEliminar1.setBackground(new java.awt.Color(43, 42, 77));
        botonEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminar1MouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ELIMINAR");

        javax.swing.GroupLayout botonEliminar1Layout = new javax.swing.GroupLayout(botonEliminar1);
        botonEliminar1.setLayout(botonEliminar1Layout);
        botonEliminar1Layout.setHorizontalGroup(
            botonEliminar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonEliminar1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        botonEliminar1Layout.setVerticalGroup(
            botonEliminar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonEliminar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bg.add(botonEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 100, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textConsultarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textConsultarKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!(numeros)) {
            evt.consume();
        }

        textConsultar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + textConsultar.getText(), 0));
            }
        });
        trs = new TableRowSorter(modelo_tabla);
        tabla.setRowSorter(trs);
    }//GEN-LAST:event_textConsultarKeyTyped

    private void botonEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminar1MouseClicked

    

    public void guardarText() {
        try {
            FileWriter guar = new FileWriter("datos.txt");
            for (int i = 0; i < this.tabla.getRowCount(); i++) {
                for (int a = 0; a < this.tabla.getColumnCount(); a++) {
                    guar.write(modelo_tabla.getValueAt(i, a).toString() + ";");
                }
                guar.write("\n");
            }

            guar.close();
        } catch (IOException x) {
            JOptionPane.showMessageDialog(null, "error");
        }
    }

    public void eliminarPublicacion(String isbn) {

        Publicacion pBusqueda = new Libro(isbn);

        Publicacion pEliminada = PanelInsertar.modelo.eliminarPublicacion(pBusqueda);
        if (pEliminada != null) {
            JOptionPane.showMessageDialog(null, "\n!! Publicacion eliminada ¡¡");
        } else {
            JOptionPane.showMessageDialog(null, "\n!! La Publicacion no se encuentra registrada ¡¡");
        }

    }

    public void limpiar() {
        int a = modelo_tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo_tabla.removeRow(modelo_tabla.getRowCount() - 1);

            //cargaTicket();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel botonEliminar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField textConsultar;
    // End of variables declaration//GEN-END:variables
}
