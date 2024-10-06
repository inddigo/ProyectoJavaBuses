package com.mycompany.siap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author joshu
 */
public class VentEliminarHora extends JDialog {

    Empresa empresa;

    public VentEliminarHora(Empresa emp) {
        this.empresa = emp;
        initComponents();
        setTitle("Eliminar Horario");
        setSize(400, 200); // Ajusta el tamaño según tus necesidades
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cierra solo este diálogo
        setModal(true); // Hacer que el diálogo sea modal
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        IngresarHrEliminar = new javax.swing.JTextField();
        botonCerrar = new javax.swing.JButton();
        bottonnGuardar = new javax.swing.JButton();

        jLabel1.setText("Ingrese el ID del Horario a Eliminar:");

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        bottonnGuardar.setText("Eliminar");
        bottonnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bottonnGuardarActionPerformed(evt);
            }
        });

        // Configurar el layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bottonnGuardar)
                        .addComponent(IngresarHrEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonCerrar))
                    .addContainerGap(370, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(IngresarHrEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(botonCerrar)
                        .addComponent(bottonnGuardar))
                    .addGap(0, 80, Short.MAX_VALUE))
        );

        pack();
    }

    private void botonCerrarActionPerformed(ActionEvent evt) {                                            
        this.dispose(); // Cierra el diálogo
    }                                           

    private void bottonnGuardarActionPerformed(ActionEvent evt) {                                               
        // Obtener el ID del horario que se desea eliminar desde el campo de texto
        String idStr = IngresarHrEliminar.getText();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el ID del horario a eliminar.");
            return;
        }

        try {
            int id = Integer.parseInt(idStr); // Convertir a entero
            eliminarHorario(id); // Llamar al método para eliminar

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido, debe ser un número entero.");
        }
        this.dispose();
    }

    private void eliminarHorario(int id) {
        Connection cone = empresa.getConexionBd();
        String query = "DELETE FROM Horarios WHERE idHorario = ?"; // Asegúrate de que el campo ID sea correcto
        try (PreparedStatement pstmt = cone.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int filasEliminadas = pstmt.executeUpdate();

            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(this, "Horario eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún horario con ese ID.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el horario: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField IngresarHrEliminar;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton bottonnGuardar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}