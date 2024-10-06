package com.mycompany.siap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Clase que extiende JDialog para crear un formulario de agregar horario
public class AgregarHorario extends JDialog {

    Empresa empresa; // Instancia de la clase Empresa para acceder a la lógica de negocio

    // Constructor que recibe una instancia de Empresa
    public AgregarHorario(Empresa emp) {
        this.empresa = emp; // Asigna la empresa recibida al atributo de la clase
        initComponents(); // Inicializa los componentes de la interfaz gráfica
        setTitle("Agregar Horario"); // Define el título de la ventana
        setSize(400, 300); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Define el comportamiento al cerrar la ventana
        setModal(true); // Define el diálogo como modal para bloquear la interacción con otras ventanas
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        // Inicialización de etiquetas y campos de texto
        jLabel1 = new javax.swing.JLabel();
        agregarHora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        agregarFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        agregarRId = new javax.swing.JTextField();
        botonCerrar = new javax.swing.JButton();
        botonParaGuardar = new javax.swing.JButton();

        // Texto de la etiqueta para ingresar la hora
        jLabel1.setText("Agrege La Hora (HH:MM)");

        // Texto de la etiqueta para ingresar la fecha
        jLabel2.setText("Agrege La Fecha (YYYY-MM-DD)");

        // Texto de la etiqueta para ingresar el ID de la ruta
        jLabel3.setText("Agrege El Id de la ruta");

        // Configuración del botón "Cerrar"
        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonCerrarActionPerformed(evt); // Método que cierra el formulario
            }
        });

        // Configuración del botón "Guardar"
        botonParaGuardar.setText("Guardar");
        botonParaGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonParaGuardarActionPerformed(evt); // Método que guarda el horario
            }
        });

        // Diseño del layout para organizar los componentes en la ventana
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

        pack(); // Ajusta el tamaño de la ventana a sus componentes
    }

    // Método para guardar el horario en la base de datos

    private void guardarHorario(ActionEvent evt) {
        Connection cone = null; // Inicializamos la conexión
        try {
            cone = empresa.getConexionBd(); // Obtiene la conexión a la base de datos

            // Obtiene los valores ingresados por el usuario
            String hora = agregarHora.getText().trim(); // Elimina los espacios en blanco
            String fecha = agregarFecha.getText().trim();
            String rutaIdStr = agregarRId.getText().trim();

            // Verifica si algún campo está vacío
            if (hora.isEmpty() || fecha.isEmpty() || rutaIdStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
                return;
            }

            // Convierte el ID de la ruta a un número entero
            int rutaId;
            try {
                rutaId = Integer.parseInt(rutaIdStr); // Intenta convertir el ID a entero
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El ID de la ruta debe ser un número entero.");
                return; // Detiene la ejecución si la conversión falla
            }

            // Verifica si la ruta existe
            Ruta ruta;
            try {
                ruta = empresa.obtenerRuta(rutaId); // Este método puede lanzar RutaNoEncontradaException
            } catch (RutaNoEncontradaException e) {
                // Maneja la excepción mostrando un mensaje al usuario
                JOptionPane.showMessageDialog(this, e.getMessage());
                return; // Detiene la ejecución si la ruta no existe
            }

            // Obtiene un bus_id aleatorio para la ruta
            int busId = obtenerBusIdAleatorio(rutaId);
            if (busId == -1) { // Verifica si no se encontró un bus disponible
                JOptionPane.showMessageDialog(this, "No hay buses disponibles para la ruta.");
                return; // Detiene la ejecución si no hay buses
            }

            // Agrega el horario a la ruta
            ruta.agregarHorario(fecha, hora);

            // Inserta el nuevo horario en la base de datos
            String query = "INSERT INTO Horarios (ruta_id, fecha, horario, bus_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = cone.prepareStatement(query)) {
                pstmt.setInt(1, rutaId);
                pstmt.setString(2, fecha);
                pstmt.setString(3, hora);
                pstmt.setInt(4, busId); // Inserta el bus_id asociado

                pstmt.executeUpdate(); // Ejecuta la consulta
                JOptionPane.showMessageDialog(this, "Horario guardado exitosamente");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el horario: " + e.getMessage());
            }
        } finally {
            // No cerramos la conexión aquí, ya que no deseas cerrarla en este método.
        }
    }

    // Método que obtiene un bus_id automáticamente de la base de datos

    private int obtenerBusIdAleatorio(int rutaId) {
        Connection cone = empresa.getConexionBd(); // Obtiene la conexión a la base de datos
        List<Integer> busIds = new ArrayList<>(); // Lista para almacenar los busIds disponibles

        // Consulta para obtener todos los buses disponibles para la ruta
        String query = "SELECT idBus FROM Buses WHERE ruta_id = ?";

        try (PreparedStatement pstmt = cone.prepareStatement(query)) {
            pstmt.setInt(1, rutaId);
            ResultSet rs = pstmt.executeQuery();

            // Agregar todos los busIds a la lista
            while (rs.next()) {
                busIds.add(rs.getInt("idBus"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener bus_id: " + e.getMessage());
        }

        // Seleccionar un busId aleatorio de la lista
        if (!busIds.isEmpty()) {
            Random random = new Random();
            return busIds.get(random.nextInt(busIds.size())); // Retorna un busId aleatorio
        }

        return -1; // Retorna -1 si no se encontraron buses
    }

    // Método que se ejecuta al presionar el botón "Cerrar"
    private void botonCerrarActionPerformed(ActionEvent evt) {
        this.dispose(); // Cierra la ventana
    }

    // Método que se ejecuta al presionar el botón "Guardar"
    private void botonParaGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        guardarHorario(evt); // Llama al método para guardar el horario
        this.dispose(); // Cierra la ventana después de guardar
    }

    // Declaración de variables de la interfaz gráfica
    private javax.swing.JTextField agregarFecha;
    private javax.swing.JTextField agregarHora;
    private javax.swing.JTextField agregarRId;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonParaGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // Fin de la declaración de variables
}
