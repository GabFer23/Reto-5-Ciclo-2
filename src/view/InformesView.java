package view;

import javax.swing.*;
import controller.InformesController;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import model.vo.*;

public class InformesView extends javax.swing.JFrame {

    DefaultTableModel modelo;

    public static final InformesController controlador = new InformesController();

    public InformesView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnInfoLider = new javax.swing.JButton();
        btnInfoProyecto = new javax.swing.JButton();
        btnInfoCompra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));

        btnInfoLider.setText("Informe Líderes");
        btnInfoLider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoLiderActionPerformed(evt);
            }
        });

        btnInfoProyecto.setText("Informe Proyectos");
        btnInfoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoProyectoActionPerformed(evt);
            }
        });

        btnInfoCompra.setText("Informe Compras");
        btnInfoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnInfoLider, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnInfoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnInfoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInfoLider, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInfoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInfoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblMostrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInfoLiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoLiderActionPerformed
        reiniciarTabla();
        informeLider();
    }//GEN-LAST:event_btnInfoLiderActionPerformed

    private void btnInfoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoProyectoActionPerformed
        reiniciarTabla();
        informeProyecto();
    }//GEN-LAST:event_btnInfoProyectoActionPerformed

    private void btnInfoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoCompraActionPerformed
        reiniciarTabla();
        informeCompra();
    }//GEN-LAST:event_btnInfoCompraActionPerformed

    private void informeLider() {
        try {
            ArrayList<InformeLiderVo> InformeLider = controlador.consultarInformeLider();

            Object[] datos = new Object[3];
            modelo = (DefaultTableModel) tblMostrar.getModel();

            String[] columnas = {"NOMBRE", "PRIMER APELLIDO", "CIUDAD RESIDENCIA"};
            
            crearColumnas(columnas);

            for (int i = 0; i < InformeLider.size(); i++) {
                datos[0] = InformeLider.get(i).getNombre();
                datos[1] = InformeLider.get(i).getPrimerApellido();
                datos[2] = InformeLider.get(i).getCiudad();

                modelo.addRow(datos);
            }

            tblMostrar.setModel(modelo);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void informeProyecto() {
        try {
            ArrayList<InformeProyectoVo> InformeProyecto = controlador.consultarInformeProyecto();

            Object[] datos = new Object[4];
            modelo = (DefaultTableModel) tblMostrar.getModel();

            String[] columnas = {"ID PROYECTO", "CONSTRUCTORA", "N° HABITACIONES", "CIUDAD"};
            
            crearColumnas(columnas);

            for (int i = 0; i < InformeProyecto.size(); i++) {
                datos[0] = InformeProyecto.get(i).getId();
                datos[1] = InformeProyecto.get(i).getConstructora();
                datos[2] = InformeProyecto.get(i).getNumHabitaciones();
                datos[3] = InformeProyecto.get(i).getCiudad();

                modelo.addRow(datos);
            }

            tblMostrar.setModel(modelo);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void informeCompra() {
        try {
            ArrayList<InformeCompraVo> InformeCompra = controlador.consultarInformeCompra();

            Object[] datos = new Object[3];
            modelo = (DefaultTableModel) tblMostrar.getModel();

            
            String[] columnas = {"ID COMPRA", "CONSTRUCTORA", "BANCO VINCULADO"};
            
            crearColumnas(columnas);

            for (int i = 0; i < InformeCompra.size(); i++) {
                datos[0] = InformeCompra.get(i).getId();
                datos[1] = InformeCompra.get(i).getConstructora();
                datos[2] = InformeCompra.get(i).getBancoVinculado();

                modelo.addRow(datos);
            }

            tblMostrar.setModel(modelo);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    void crearColumnas(String[] columnas){
        for (int i = 0; i < columnas.length; i++) {
            modelo.addColumn(columnas[i]);
        }
    }

    void reiniciarTabla() {
        if (modelo != null) {
            modelo.setRowCount(0);
            modelo.setColumnCount(0);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInfoCompra;
    private javax.swing.JButton btnInfoLider;
    private javax.swing.JButton btnInfoProyecto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMostrar;
    // End of variables declaration//GEN-END:variables
}
