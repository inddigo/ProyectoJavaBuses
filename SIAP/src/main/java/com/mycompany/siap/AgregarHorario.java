package com.mycompany.siap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgregarHorario extends JDialog {

    Empresa empresa;

    public AgregarHorario(Empresa emp) {
        this.empresa = emp;
        initComponents();
        setTitle("Agregar Horario");
        setSize(400, 300); // Ajusta el tamaño según tus necesidades
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cierra solo este diálogo
        setModal(true); // Hacer que el diálogo sea modal
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        agregarHora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        agregarFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        agregarRId = new javax.swing.JTextField();
        botonCerrar = new javax.swing.JButton();
        botonParaGuardar = new javax.swing.JButton();

        jLabel1.setText("Agrege La Hora (HH:MM)");

        jLabel2.setText("Agrege La Fecha (YYYY-MM-DD)");

        jLabel3.setText("Agrege El Id de la ruta");

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        botonParaGuardar.setText("Guardar");
        botonParaGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonParaGuardarActionPerformed(evt);
            }
        });

        // Configurar el layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonParaGuardar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botonCerrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregarHora, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addComponent(agregarFecha, GroupLayout.Alignment.LEADING)
                        .addComponent(agregarRId, GroupLayout.Alignment.LEADING))
                    .addContainerGap(370, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregarHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregarFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregarRId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(botonCerrar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonParaGuardar))
                    .addContainerGap(179, Short.MAX_VALUE))
        );

        pack();
    }

   private void guardarHorario(ActionEvent evt) throws RutaNoEncontradaException {
    Connection cone = empresa.getConexionBd();

    // Obtener los valores de las cajas de texto
    String hora = agregarHora.getText().trim(); // Usar trim() para eliminar espacios
    String fecha = agregarFecha.getText().trim();  
    String rutaIdStr = agregarRId.getText().trim();

    // Validaciones de campos vacíos
    if (hora.isEmpty() || fecha.isEmpty() || rutaIdStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        return;
    }

    // Convertir el ID de ruta a entero
    int rutaId;
    try {
        rutaId = Integer.parseInt(rutaIdStr); // Intentar convertir a entero
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El ID de la ruta debe ser un número entero.");
        return; // Salir del método si la conversión falla
    }

    // Verificar que la ruta existe en el sistema antes de proceder
    Ruta ruta = empresa.obtenerRuta(rutaId);
    if (ruta == null) {
        JOptionPane.showMessageDialog(this, "Ruta no encontrada.");
        return; // Salir del método si no se encuentra la ruta
    }

    // Asignar un bus_id automáticamente
    int busId = obtenerBusIdAutomáticamente(rutaId); // Método para obtener un bus_id disponible

    if (busId == -1) { // -1 indica que no se encontró un bus disponible
        JOptionPane.showMessageDialog(this, "No hay buses disponibles para la ruta.");
        return; // Salir si no hay buses disponibles
    }

    // Agregar horario a la ruta
    ruta.agregarHorario(fecha, hora); 

    // Consulta SQL para insertar el horario en la base de datos
    String query = "INSERT INTO Horarios (ruta_id, fecha, horario, bus_id) VALUES (?, ?, ?, ?)";
    
    try (PreparedStatement pstmt = cone.prepareStatement(query)) {
        pstmt.setInt(1, rutaId);
        pstmt.setString(2, fecha); 
        pstmt.setString(3, hora); 
        pstmt.setInt(4, busId); // Incluir bus_id en la inserción

        pstmt.executeUpdate(); 

        JOptionPane.showMessageDialog(this, "Horario guardado exitosamente");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar el horario: " + e.getMessage());
    }
}

private int obtenerBusIdAutomáticamente(int rutaId) {
    Connection cone = empresa.getConexionBd();
    int busId = -1; // Valor predeterminado si no se encuentra un bus

    String query = "SELECT idBus FROM Buses WHERE ruta_id = ? LIMIT 1"; // Obtener el primer bus disponible para la ruta
    try (PreparedStatement pstmt = cone.prepareStatement(query)) {
        pstmt.setInt(1, rutaId);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            busId = rs.getInt("idBus"); // Asignar el bus_id encontrado
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al obtener bus_id: " + e.getMessage());
    }

    return busId; // Retornar el bus_id o -1 si no se encontró
}


    private void botonCerrarActionPerformed(ActionEvent evt) {                                             
        this.dispose();
    }                                           

    private void botonParaGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        try {
            guardarHorario(evt);
        } catch (RutaNoEncontradaException ex) {
            Logger.getLogger(AgregarHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField agregarFecha;
    private javax.swing.JTextField agregarHora;
    private javax.swing.JTextField agregarRId;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonParaGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration                   

}
