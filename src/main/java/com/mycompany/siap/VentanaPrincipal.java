package com.mycompany.siap;

public class VentanaPrincipal extends javax.swing.JFrame {

    private Empresa empresa; // Instancia de la clase Empresa que contiene la lógica del sistema

    // Constructor de la clase VentanaPrincipal que recibe una instancia de Empresa
    public VentanaPrincipal(Empresa emp)
    {
        empresa = emp; // Se asigna la empresa pasada como argumento
        initComponents(); // Inicializa los componentes de la interfaz gráfica
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    /**
     * Este método se llama dentro del constructor para inicializar los componentes.
     * WARNING: No modificar este código. Su contenido siempre es regenerado por el Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        realizarVenta = new javax.swing.JDialog(); // Diálogo para realizar ventas
        textoRutaRealizarV = new javax.swing.JTextField(); // Campo de texto para ingresar el ID de la ruta
        confirmarIngresarRuta = new javax.swing.JButton(); // Botón para confirmar la entrada de la ruta
        cancelarIngresarRuta = new javax.swing.JButton(); // Botón para cancelar la entrada de la ruta
        jLabel3 = new javax.swing.JLabel(); // Etiqueta para indicar que se debe ingresar la ID de la ruta
        JOptionPane = new javax.swing.JOptionPane(); // Componente para mostrar diálogos de alerta
        Titulo1 = new javax.swing.JLabel(); // Título principal de la ventana
        SubTitulo1 = new javax.swing.JLabel(); // Subtítulo con instrucciones
        botonGestionRutas = new javax.swing.JButton(); // Botón para gestionar rutas
        botonRealizarVenta = new javax.swing.JButton(); // Botón para realizar una venta
        botonGestionarBuses = new javax.swing.JButton(); // Botón para gestionar buses
        botonMenuListar = new javax.swing.JButton(); // Botón para acceder al menú de listado
        botonCerrar = new javax.swing.JButton(); // Botón para cerrar la aplicación
        jButton1 = new javax.swing.JButton(); // Botón para generar reportes
        botonGestionarHorariosS = new javax.swing.JButton(); // Botón para gestionar horarios

        realizarVenta.setName("Realizar Venta"); // Se le asigna un nombre al diálogo

        // Configuración del botón "Confirmar" en el diálogo de venta
        confirmarIngresarRuta.setText("Confirmar");
        confirmarIngresarRuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmarIngresarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarIngresarRutaActionPerformed(evt); // Acción al hacer clic en confirmar
            }
        });

        // Configuración del botón "Cancelar" en el diálogo de venta
        cancelarIngresarRuta.setText("Cancelar");
        cancelarIngresarRuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelarIngresarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarIngresarRutaActionPerformed(evt); // Acción al hacer clic en cancelar
            }
        });

        // Configuración de la etiqueta de instrucciones del diálogo de venta
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 30));
        jLabel3.setText("Ingrese la id de la ruta");

        // Diseño del layout del diálogo de venta
        javax.swing.GroupLayout realizarVentaLayout = new javax.swing.GroupLayout(realizarVenta.getContentPane());
        realizarVenta.getContentPane().setLayout(realizarVentaLayout);
        realizarVentaLayout.setHorizontalGroup(
                realizarVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(realizarVentaLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(realizarVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(realizarVentaLayout.createSequentialGroup()
                                                .addComponent(cancelarIngresarRuta)
                                                .addGap(207, 207, 207)
                                                .addComponent(confirmarIngresarRuta))
                                        .addGroup(realizarVentaLayout.createSequentialGroup()
                                                .addComponent(textoRutaRealizarV, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(115, 115, 115))
                                        .addComponent(jLabel3))
                                .addContainerGap(160, Short.MAX_VALUE))
        );
        realizarVentaLayout.setVerticalGroup(
                realizarVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(realizarVentaLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(textoRutaRealizarV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(realizarVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(confirmarIngresarRuta)
                                        .addComponent(cancelarIngresarRuta))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); // Configuración de la ventana principal al cerrar
        setTitle("Sistema de gestion de buses"); // Título de la ventana
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Define el cursor

        // Configuración del título principal de la ventana
        Titulo1.setFont(new java.awt.Font("Segoe UI", 0, 24));
        Titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo1.setText("Bienvenido Al Sistema De Gestion de buses");

        // Configuración del subtítulo con instrucciones
        SubTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SubTitulo1.setText("Haga Click en la opcion que desea");

        // Configuración del botón "Gestionar Rutas"
        botonGestionRutas.setText("Gestionar Rutas");
        botonGestionRutas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGestionRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionRutasActionPerformed(evt); // Acción al hacer clic en gestionar rutas
            }
        });

        // Configuración del botón "Realizar Venta"
        botonRealizarVenta.setText("Realizar Venta");
        botonRealizarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRealizarVentaActionPerformed(evt); // Acción al hacer clic en realizar venta
            }
        });

        // Configuración del botón "Gestionar Buses"
        botonGestionarBuses.setText("Gestionar Buses");
        botonGestionarBuses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGestionarBuses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionarBusesActionPerformed(evt); // Acción al hacer clic en gestionar buses
            }
        });

        // Configuración del botón "Menu Listar"
        botonMenuListar.setText("Menu Listar");
        botonMenuListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMenuListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuListarActionPerformed(evt); // Acción al hacer clic en el menú de listar
            }
        });

        // Configuración del botón "Cerrar"
        botonCerrar.setText("Cerrar");
        botonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt); // Acción al hacer clic en cerrar la aplicación
            }
        });

        // Configuración del botón "Realizar Reportes"
        jButton1.setText("Realizar Reportes");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt); // Acción al hacer clic en generar reportes
            }
        });

        // Configuración del botón "Gestionar Horarios"
        botonGestionarHorariosS.setText("Gestionar Horarios");
        botonGestionarHorariosS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionarHorariosSActionPerformed(evt); // Acción al hacer clic en gestionar horarios
            }
        });

        // Diseño del layout de la ventana principal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(293, 293, 293)
                                .addComponent(SubTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addGap(297, 297, 297))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(botonCerrar)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(180, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botonGestionRutas)
                                        .addComponent(jButton1)
                                        .addComponent(botonGestionarBuses))
                                .addGap(155, 155, 155)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(botonGestionarHorariosS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonRealizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addComponent(botonMenuListar, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(Titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SubTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonGestionRutas)
                                        .addComponent(botonRealizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonGestionarBuses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonMenuListar))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(botonGestionarHorariosS))
                                .addGap(150, 150, 150)
                                .addComponent(botonCerrar)
                                .addContainerGap())
        );

        pack(); // Ajusta el tamaño de la ventana automáticamente
    }

    // Método que abre la ventana para gestionar rutas
    private void botonGestionRutasActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaRuta vent = new VentanaRuta(empresa);
                vent.setVisible(true);
            }
        });
    }

    // Método que abre el diálogo para realizar una venta
    private void botonRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {
        realizarVenta.setSize(600, 400); // Establece el tamaño del diálogo
        realizarVenta.setLocationRelativeTo(null); // Centra el diálogo en la pantalla
        realizarVenta.setVisible(true); // Muestra el diálogo
    }

    // Método que abre la ventana para gestionar buses
    private void botonGestionarBusesActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaBuses vent = new VentanaBuses(empresa);
                vent.setVisible(true);
            }
        });
    }

    // Método para cerrar la aplicación
    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0); // Cierra la aplicación
    }

    // Método que abre el menú para listar
    private void botonMenuListarActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaListar vent = new VentanaListar(empresa);
                vent.setVisible(true);
            }
        });
    }

    // Método que confirma la ruta ingresada para la venta
    private void confirmarIngresarRutaActionPerformed(java.awt.event.ActionEvent evt) {
        String t = textoRutaRealizarV.getText(); // Obtiene el texto ingresado

        try {
            int id = Integer.parseInt(t); // Convierte el texto a un número entero

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    VentanaSelecccionarHorario vent = new VentanaSelecccionarHorario(empresa, id);
                    vent.setVisible(true); // Abre la ventana para seleccionar el horario
                }
            });

            realizarVenta.dispose(); // Cierra el diálogo de realizar venta

        } catch (NumberFormatException e) {
            // Manejo de excepción si el texto no es un número válido
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para la ruta.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Manejo de cualquier otra excepción
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para cancelar la entrada de la ruta
    private void cancelarIngresarRutaActionPerformed(java.awt.event.ActionEvent evt) {
        realizarVenta.dispose(); // Cierra el diálogo de realizar venta
    }

    // Método que abre la ventana de reportes
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentReportes vent = new VentReportes(empresa);
                vent.setVisible(true); // Abre la ventana de reportes
            }
        });
    }

    // Método que abre la ventana para gestionar horarios
    private void botonGestionarHorariosSActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Horarios ventanaHorarios = new Horarios(empresa);
                ventanaHorarios.setVisible(true); // Abre la ventana para gestionar horarios
                ventanaHorarios.setLocationRelativeTo(null); // Centra la ventana
            }
        });
    }

    // Declaración de variables de la interfaz gráfica
    private javax.swing.JOptionPane JOptionPane;
    private javax.swing.JLabel SubTitulo1;
    private javax.swing.JLabel Titulo1;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonGestionRutas;
    private javax.swing.JButton botonGestionarBuses;
    private javax.swing.JButton botonGestionarHorariosS;
    private javax.swing.JButton botonMenuListar;
    private javax.swing.JButton botonRealizarVenta;
    private javax.swing.JButton cancelarIngresarRuta;
    private javax.swing.JButton confirmarIngresarRuta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JDialog realizarVenta;
    private javax.swing.JTextField textoRutaRealizarV;
}
