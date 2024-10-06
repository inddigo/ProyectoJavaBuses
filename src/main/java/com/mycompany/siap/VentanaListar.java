package com.mycompany.siap;

import java.text.DecimalFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class VentanaListar extends javax.swing.JFrame {

    private Empresa empresa;
   
    public VentanaListar(Empresa emp)
           
    {
        this.empresa = emp;
        initComponents();
        
 
        setLocationRelativeTo(null);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonesListar = new javax.swing.JPanel();
        botonListarRutas = new javax.swing.JButton();
        botonListarBuses = new javax.swing.JButton();
        botonListarPasajeros = new javax.swing.JButton();
        panelListar = new javax.swing.JPanel();
        panelBase = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBase = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        PanelBuses = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBuses = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        panelRutas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaListarRutas = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        panelPasajeros = new javax.swing.JPanel();
        comboBoxPasajeros = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPasajeros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana Listar");

        botonListarRutas.setText("Listar Rutas");
        botonListarRutas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonListarRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarRutasActionPerformed(evt);
            }
        });

        botonListarBuses.setText("Listar Buses");
        botonListarBuses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonListarBuses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarBusesActionPerformed(evt);
            }
        });

        botonListarPasajeros.setText("Listar Pasajeros");
        botonListarPasajeros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonListarPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarPasajerosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botonesListarLayout = new javax.swing.GroupLayout(botonesListar);
        botonesListar.setLayout(botonesListarLayout);
        botonesListarLayout.setHorizontalGroup(
            botonesListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesListarLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(botonListarRutas)
                .addGap(219, 219, 219)
                .addComponent(botonListarBuses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(botonListarPasajeros)
                .addGap(56, 56, 56))
        );
        botonesListarLayout.setVerticalGroup(
            botonesListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesListarLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(botonesListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonListarRutas)
                    .addComponent(botonListarBuses)
                    .addComponent(botonListarPasajeros))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelListar.setLayout(new java.awt.CardLayout());

        tablaBase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBase.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaBase);

        jButton4.setText("Cerrar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBaseLayout = new javax.swing.GroupLayout(panelBase);
        panelBase.setLayout(panelBaseLayout);
        panelBaseLayout.setHorizontalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBaseLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(12, 12, 12))
        );

        panelListar.add(panelBase, "card5");

        tablaBuses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Patente", "Pasajeros Actuales", "Capacidad", "Costo Mantencion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBuses.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaBuses);

        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBusesLayout = new javax.swing.GroupLayout(PanelBuses);
        PanelBuses.setLayout(PanelBusesLayout);
        PanelBusesLayout.setHorizontalGroup(
            PanelBusesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        PanelBusesLayout.setVerticalGroup(
            PanelBusesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusesLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jButton5)
                .addContainerGap())
        );

        panelListar.add(PanelBuses, "card2");

        tablaListarRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Origen", "Destino", "Distancia", "Cantiada de Buses"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListarRutas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaListarRutas);

        jButton6.setText("Cerrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRutasLayout = new javax.swing.GroupLayout(panelRutas);
        panelRutas.setLayout(panelRutasLayout);
        panelRutasLayout.setHorizontalGroup(
            panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRutasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelRutasLayout.setVerticalGroup(
            panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRutasLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jButton6)
                .addContainerGap())
        );

        panelListar.add(panelRutas, "card3");

        comboBoxPasajeros.setText("Cerrar");
        comboBoxPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPasajerosActionPerformed(evt);
            }
        });

        tablaPasajeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Rut", "Cantiadad Total Tickets"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPasajeros.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tablaPasajeros);

        javax.swing.GroupLayout panelPasajerosLayout = new javax.swing.GroupLayout(panelPasajeros);
        panelPasajeros.setLayout(panelPasajerosLayout);
        panelPasajerosLayout.setHorizontalGroup(
            panelPasajerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPasajerosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPasajerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxPasajeros)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelPasajerosLayout.setVerticalGroup(
            panelPasajerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPasajerosLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(comboBoxPasajeros)
                .addContainerGap())
        );

        panelListar.add(panelPasajeros, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(botonesListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(botonesListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(panelListar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonListarRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarRutasActionPerformed
       panelListar.removeAll();
       panelListar.add(panelRutas);
       llenarTablaRutas();
       panelListar.revalidate();
    }//GEN-LAST:event_botonListarRutasActionPerformed

    private void botonListarBusesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarBusesActionPerformed
       panelListar.removeAll();
       panelListar.add(PanelBuses);
        llenarTablaBuses(); 
       
       panelListar.revalidate();
                                         
    }//GEN-LAST:event_botonListarBusesActionPerformed

    private void botonListarPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarPasajerosActionPerformed
       panelListar.removeAll();
       panelListar.add(panelPasajeros);
       llenarTablaPasajeros();

       panelListar.revalidate();
                                           
    }//GEN-LAST:event_botonListarPasajerosActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void comboBoxPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPasajerosActionPerformed
         this.dispose();
    }//GEN-LAST:event_comboBoxPasajerosActionPerformed

    private void llenarTablaPasajeros() 
    {
    // Definir las columnas para la tabla de pasajeros
        String[] columnas = {"Nombre", "Rut", "Cantidad Total Tickets"}; // Ajusta según tus atributos

        // Crear un modelo de tabla basado en los datos
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Obtener la lista de pasajeros desde la empresa
        List<Pasajero> pasajeros = empresa.getListaPasajeros();  // Método para obtener los pasajeros desde la empresa

        // Agregar las filas al modelo
        for (Pasajero pasajero : pasajeros) 
        {
            modelo.addRow(new Object[]{pasajero.getNombre(), pasajero.getRut(), pasajero.getTickets().size()});
        }

        // Asignar el modelo a la tabla
        tablaPasajeros.setModel(modelo);
    }
    private void llenarTablaBuses() 
    {
    
    String[] columnas = {"Patente", "Pasajeros Actuales", "Capacidad", "Costo Mantenimiento"};

    // Crear un modelo de tabla basado en los datos
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    // Obtener la lista de buses desde la empresa
    List<Bus> buses = empresa.getListaBuses();  // Método para obtener los buses desde la empresa

    // Agregar las filas al modelo
    for (Bus bus : buses) {
        // Extraer los valores de cada atributo del bus
        Object[] fila = {
            bus.getPatente(),
            bus.getPasajerosActuales(),
            bus.getCapacidad(),
            bus.getCostoMantencion(),
            
        };
        modelo.addRow(fila);  // Agregar la fila con los datos a la tabla
    }

    // Asignar el modelo a la tabla
    tablaBuses.setModel(modelo);
}
   
    private void llenarTablaRutas() 
    {
        // Definir las columnas para la tabla de rutas
        String[] columnas = {"ID Ruta", "Origen", "Destino", "Distancia", "Cantidad de Buses"}; // Ajusta según tus atributos

        // Crear un modelo de tabla basado en los datos
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Obtener la lista de rutas desde la empresa
        List<Ruta> rutas = empresa.getListaRutas();  // Método para obtener las rutas desde la empresa

        // Agregar las filas al modelo
        for (Ruta ruta : rutas) 
        {
            double distancia = ruta.getDistancia();
            DecimalFormat df = new DecimalFormat("#.###");
            String distanciaFormat = df.format(distancia);
            modelo.addRow(new Object[]{ruta.getId(), ruta.getOrigen(), ruta.getDestino(), distanciaFormat, ruta.getBuses().size()});
        }

        // Asignar el modelo a la tabla
        tablaListarRutas.setModel(modelo);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBuses;
    private javax.swing.JButton botonListarBuses;
    private javax.swing.JButton botonListarPasajeros;
    private javax.swing.JButton botonListarRutas;
    private javax.swing.JPanel botonesListar;
    private javax.swing.JButton comboBoxPasajeros;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelListar;
    private javax.swing.JPanel panelPasajeros;
    private javax.swing.JPanel panelRutas;
    private javax.swing.JTable tablaBase;
    private javax.swing.JTable tablaBuses;
    private javax.swing.JTable tablaListarRutas;
    private javax.swing.JTable tablaPasajeros;
    // End of variables declaration//GEN-END:variables
}
