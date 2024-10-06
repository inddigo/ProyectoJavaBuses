package com.mycompany.siap;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.Timer;

public class Empresa {

    // Atributos de la clase Empresa
    private List<Bus> listaBuses; // Lista de buses en la empresa
    private List<Pasajero> listaPasajeros; // Lista de pasajeros en la empresa
    private List<Ruta> listaRutas; // Lista de rutas en la empresa
    private Connection conexion; // Conexión a la base de datos
    private List<Ticket> ticketsTotales; // Lista de tickets emitidos en la empresa

    // Constructor de Empresa que inicializa las listas y carga la base de datos
    public Empresa()
    {
        listaBuses = new ArrayList<>(); // Inicializa la lista de buses
        listaPasajeros = new ArrayList<>(); // Inicializa la lista de pasajeros
        listaRutas = new ArrayList<>(); // Inicializa la lista de rutas
        ticketsTotales = new ArrayList<>(); // Inicializa la lista de ticket
        this.conexion = cargarBaseDeDatos(); // Carga la base de datos al crear la empresa
        if (this.conexion == null)
            JOptionPane.showMessageDialog(null, "Error al cargar la base de datos", "Error", JOptionPane.ERROR_MESSAGE); // Mensaje de error si no se puede cargar
    }

    // Métodos para establecer y obtener la conexión a la base de datos
    public void setConexion(Connection cone) {
        this.conexion = cone;
    }

    public Connection getConexionBd() {
        return this.conexion;
    }

    // Métodos para establecer y obtener la lista de pasajeros
    public void setListaPasajeros(List<Pasajero> listaPasajeros) {
        this.listaPasajeros = listaPasajeros;
    }

    public List<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }

    // Métodos para obtener y establecer la lista de buses
    public List<Bus> getListaBuses() {
        return listaBuses;
    }

    public void setListaBuses(List<Bus> listaBuses) {
        this.listaBuses = listaBuses;
    }

    // Métodos para obtener y establecer la lista de rutas
    public List<Ruta> getListaRutas() {
        return listaRutas;
    }

    public void setListaRutas(List<Ruta> listaRutas) {
        this.listaRutas = listaRutas;
    }

    // Método para agregar un ticket a la lista si no está ya presente
    public void agregarTicket(Ticket nuevoTicket) {
        if (!this.ticketsTotales.contains(nuevoTicket)) {
            this.ticketsTotales.add(nuevoTicket);
        }
    }

    // Método para obtener la lista total de tickets
    public List<Ticket> obtenerTickets() {
        return this.ticketsTotales;
    }

    // Método para agregar un pasajero a la empresa (sin implementación)
    public void AgregarPasajeroEmpresa(Pasajero pasajero) {}

    // Método para obtener un pasajero a partir de su RUT
    public Pasajero obtenerPasajeroEmpresa(String Rut) {
        for (Pasajero pasa : listaPasajeros) {
            if (pasa.getRut().equals(Rut)) {
                return pasa; // Devuelve el pasajero si se encuentra
            }
        }
        return null; // Devuelve null si no se encuentra
    }

    // Método para eliminar un pasajero de la empresa
    public boolean eliminarPasajeroEmpresa(Pasajero Pasa) {
        if (listaPasajeros.contains(Pasa)) {
            listaPasajeros.remove(Pasa);
            return true; // Devuelve true si se elimina
        }
        return false; // Devuelve false si no se elimina
    }

    // Método para agregar un bus a la empresa y asignarlo a una ruta específica
    public void agregarBusEmpresa(Bus bus, int idRuta) {
        if (bus != null) {
            Ruta ruta;
            try {
                ruta = obtenerRuta(idRuta); // Obtiene la ruta por ID
                ruta.agregarBusARuta(bus); // Asigna el bus a la ruta
                listaBuses.add(bus); // Añade el bus a la lista de buses
            } catch (RutaNoEncontradaException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    // Método sobrecargado para agregar un bus a la empresa especificando varios atributos
    public void agregarBusEmpresa(String patente, int capacidad, int pasajerosActuales, double costoMantencion, int idruta) {
        Ruta ruta = null;
        try {
            ruta = obtenerRuta(idruta);
        } catch (RutaNoEncontradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        if (ruta != null) {
            Bus nuevoBus = new Bus(); // Crea un nuevo bus
            nuevoBus.setCapacidad(capacidad);
            nuevoBus.setPasajerosActuales(pasajerosActuales);
            nuevoBus.setPatente(patente);
            nuevoBus.setCostoMantencion(costoMantencion);
            ruta.agregarBusARuta(nuevoBus); // Agrega el bus a la ruta
            listaBuses.add(nuevoBus); // Añade el bus a la lista de buses
        }
    }

    // Método para eliminar un bus de la empresa y de su ruta
    public boolean eliminarBusEmpresa(Bus busAEliminar) {
        for (Ruta ruta : listaRutas) {
            List<Bus> buses = ruta.getBuses();
            if (buses.contains(busAEliminar)) {
                listaBuses.remove(busAEliminar); // Elimina el bus de la lista de buses
                buses.remove(busAEliminar); // Elimina el bus de la ruta
                return true; // Devuelve true si se eliminó
            }
        }
        return false; // Devuelve false si no se eliminó
    }

    // Método para modificar la capacidad y el costo de mantención de un bus
    public void modificarBus(String patente, int nuevaCapacidad, double nuevoCostoMantencion) {
        for (Bus bus : listaBuses) {
            if (bus.getPatente().equals(patente)) {
                bus.setCapacidad(nuevaCapacidad); // Actualiza la capacidad
                bus.setCostoMantencion(nuevoCostoMantencion); // Actualiza el costo de mantención
                return;
            }
        }
    }

    // Método para obtener un bus a partir de su patente
    public Bus obtenerBusEmpresa(String patente) {
        for (Bus bus : listaBuses) {
            if (bus.getPatente().equals(patente)) {
                return bus; // Devuelve el bus si se encuentra
            }
        }
        return null; // Devuelve null si no se encuentra
    }

    // Método para agregar una ruta a la empresa
    public void agregarRutaEmpresa(Ruta ruta) {
        int idRuta = ruta.getId();
        if (!buscarRutaEnEmpresa(idRuta)) {
            listaRutas.add(ruta); // Añade la ruta si no existe
        }
    }

    // Método sobrecargado para agregar una ruta con varios atributos
    public void agregarRutaEmpresa(int id, String destino, double distancia, String origen) {
        if (!buscarRutaEnEmpresa(id)) {
            Ruta nuevaRuta = new Ruta(id, destino, distancia, origen);
            listaRutas.add(nuevaRuta); // Añade la nueva ruta
        }
    }

    // Método para eliminar una ruta a partir de su ID
    public void eliminarRutaEmpresa(int id) {
        for (Ruta ruta : listaRutas) {
            if (ruta.getId() == id) {
                listaRutas.remove(ruta); // Elimina la ruta si se encuentra
                return;
            }
        }
    }

    // Método para modificar los atributos de una ruta
    public void modificarRutaEmpresa(int idRuta, String nuevoDestino, double nuevaDistancia, String nuevoOrigen) {
        for (Ruta ruta : listaRutas) {
            if (ruta.getId() == idRuta) {
                ruta.setDestino(nuevoDestino); // Actualiza el destino
                ruta.setDistancia(nuevaDistancia); // Actualiza la distancia
                ruta.setOrigen(nuevoOrigen); // Actualiza el origen
                return;
            }
        }
    }

    // Método para buscar una ruta en la empresa a partir de su ID
    public boolean buscarRutaEnEmpresa(int IdRuta) {
        for (Ruta ruta : listaRutas) {
            if (ruta.getId() == IdRuta) {
                return true; // Devuelve true si se encuentra la ruta
            }
        }
        return false; // Devuelve false si no se encuentra
    }

    // Método para obtener una ruta a partir de su ID
    public Ruta obtenerRuta(int idBuscado) throws RutaNoEncontradaException
    {
        for (Ruta ruta : listaRutas) {
            if (ruta.getId() == idBuscado) {
                return ruta; // Devuelve la ruta si se encuentra
            }
        }
        throw new RutaNoEncontradaException("Ruta con ID " + idBuscado + " no encontrada.");
    }

    // Método para cargar la base de datos
     
    private Connection cargarBaseDeDatos () 
    {
        Connection cone = null;
       
        try 
        {
            // Establecer la conexión con SQLite
            String url = "jdbc:sqlite:base_de_datos_buses.db";
            cone = DriverManager.getConnection(url);



        }
            
        
        catch (SQLException e) 
        {
            
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           
        } finally 
        {
            if (cone == null) 
            {
                
                JOptionPane.showMessageDialog(null, "No se pudo establecer conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
      return cone;      
     } 
       
  
    public void cargarDatosConProgreso() {
        // Crear una ventana para mostrar el progreso
        JFrame frame = new JFrame("Cargando datos...");
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        frame.setLayout(new BorderLayout());
        frame.add(progressBar, BorderLayout.CENTER);
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Cambiar a DO_NOTHING_ON_CLOSE
        frame.setVisible(true);

        // Simulación de una barra de progreso que avanza
        Timer timer = new Timer(50, e -> 
        {
            int progress = progressBar.getValue();
            if (progress < 100) {
                progressBar.setValue(progress + 5);  // Actualiza el progreso
            } else {
                ((Timer) e.getSource()).stop();
                frame.dispose();  // Cierra la ventana de la barra de progreso
                JOptionPane.showMessageDialog(null, "Base de datos cargada exitosamente", "Carga completada", JOptionPane.INFORMATION_MESSAGE);
                frame.setExtendedState(JFrame.NORMAL);
            }
        });

        // Inicia el temporizador para simular el progreso
        timer.start();

        // Cargar datos desde la base de datos
        this.cargarRutasBd();
        this.cargarBusesBd();
        this.cargarPasajerosBd();
        this.cargarHorariosDesdeBD();
        this.cargarTicketsDesdeBD();

        // Simular que el progreso se completa
        progressBar.setValue(100);   
    }

    
    

    // Método privado para cargar los datos de los buses desde la base de datos
    private void  cargarBusesBd() {
        try {
            // Simula una pausa de 300 milisegundos para la carga de datos
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // Captura la excepción en caso de que el hilo sea interrumpido durante el sleep
        }

        // Consulta SQL para obtener los datos de los buses desde la base de datos
        String query = "SELECT ruta_id, patente, capacidad, pasajeros_actuales, costo_mantencion FROM Buses";
        String qq ="ALTER TABLE Tickets ADD COLUMN asiento INTEGER";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            // Recorre los resultados de la consulta
            while (rs.next()) {
                // Obtiene los datos de cada columna del resultado
                int idRuta = rs.getInt("ruta_id");
                int capacidad = rs.getInt("capacidad");
                int pasajerosActuales = rs.getInt("pasajeros_actuales");
                double costoMantencion = rs.getDouble("costo_mantencion");

                // Inicializa una referencia de Ruta como null
                Ruta r = null;
                try {
                    // Intenta obtener la ruta correspondiente al idRuta
                    r = obtenerRuta(idRuta);
                } catch (RutaNoEncontradaException e) {
                    // Muestra un mensaje de error si la ruta no es encontrada
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

                // Obtiene la patente del bus
                String patente = rs.getString("patente");
                // Crea una nueva instancia de Bus con los datos obtenidos
                Bus bus = new Bus(patente, capacidad, pasajerosActuales, costoMantencion);

                // Si la ruta fue encontrada (no null), agrega el bus a la ruta
                if (r != null) {
                    r.agregarBusARuta(bus);
                }

                // Agrega el bus a la lista de buses
                listaBuses.add(bus);
            }
        } catch (SQLException e) {
            // Muestra un mensaje de error en caso de que ocurra una excepción SQL
            JOptionPane.showMessageDialog(null, "Error al cargar los Buses: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarRutasBd()
    {
        try {
            // Simula una pausa de 300 milisegundos para la carga de datos
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // Captura la excepción en caso de que el hilo sea interrumpido durante el sleep
        }

        // Consulta SQL para obtener los datos de las rutas desde la base de datos
        String query = "SELECT idRutas, destino, distancia, origen FROM Rutas";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            // Recorre los resultados de la consulta
            while (rs.next()) {
                // Obtiene los datos de cada columna del resultado
                int idRuta = rs.getInt("idRutas");
                String destino = rs.getString("destino");
                String origen = rs.getString("origen");
                double distancia = rs.getDouble("distancia");

                // Crea una nueva instancia de Ruta con los datos obtenidos
                Ruta ruta = new Ruta(idRuta, destino, distancia, origen);
                // Agrega la ruta a la lista de rutas
                listaRutas.add(ruta);
            }
        } catch (SQLException e) {
            // Muestra un mensaje de error en caso de que ocurra una excepción SQL
            JOptionPane.showMessageDialog(null, "Error al cargar las rutas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método privado para cargar los datos de los pasajeros desde la base de datos
    private void cargarPasajerosBd() {
        // Consulta SQL para obtener los datos de los pasajeros, buses y asientos
        String query = "SELECT Pasajeros.rut, Pasajeros.nombre, Buses.patente, Tickets.asiento " +
                "FROM Pasajeros " +
                "INNER JOIN Tickets ON Pasajeros.idPasajero = Tickets.pasajero_id " +
                "INNER JOIN Buses ON Tickets.bus_id = Buses.idBus";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Recorremos los resultados de la consulta
            while (rs.next()) {
                String rut = rs.getString("rut");
                String nombre = rs.getString("nombre");
                String patenteBus = rs.getString("patente");
                int asiento = rs.getInt("asiento");

                // Crear el pasajero
                Pasajero pasajero = new Pasajero(rut, nombre);
                listaPasajeros.add(pasajero);

                // Obtener el bus correspondiente por la patente
                Bus bus = obtenerBusEmpresa(patenteBus);
                if (bus != null && bus.getPasajerosActuales() < bus.getCapacidad()) {
                    // Asignar el pasajero al asiento correspondiente en el bus
                    bus.asignarPasajero(pasajero, asiento);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los pasajeros: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Método privado para cargar los datos de los horarios desde la base de datos
    private void cargarHorariosDesdeBD() {
        try {
            // Simula una carga con un pequeño retraso de 300 milisegundos
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // Restaurar el estado de interrupción del hilo
            Thread.currentThread().interrupt();
        }

        // Consulta SQL para obtener los datos de los horarios desde la base de datos
        String sql = "SELECT ruta_id, fecha, horario FROM Horarios";

        try {
            // Crear un statement para ejecutar la consulta
            Statement stmt = conexion.createStatement();
            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = stmt.executeQuery(sql);

            // Recorre los resultados de la consulta
            while (rs.next()) {
                // Obtiene los datos de cada columna del resultado
                int idRuta = rs.getInt("ruta_id");
                String fecha = rs.getString("fecha");  // Mantener fecha como String
                String horario = rs.getString("horario");  // Mantener horario como String

                // Inicializa una referencia de Ruta como null
                Ruta ruta = null;
                try {
                    // Intenta obtener la ruta correspondiente al idRuta
                    ruta = this.obtenerRuta(idRuta);
                } catch (RutaNoEncontradaException e) {
                    // Muestra un mensaje de error si la ruta no es encontrada
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

                // Si la ruta fue encontrada (no null)
                if (ruta != null) {
                    // Almacenar el horario como cadenas (String)
                    ruta.agregarHorario(fecha, horario);
                }
            }
        } catch (SQLException e) {
            // Muestra un mensaje de error en caso de que ocurra una excepción SQL
            JOptionPane.showMessageDialog(null, "Error al cargar los horarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método privado para cargar los datos de los tickets desde la base de datos
    private void cargarTicketsDesdeBD() {
        try {
            // Simula una carga con un pequeño retraso de 300 milisegundos
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // Captura la excepción en caso de que el hilo sea interrumpido durante el sleep
        }

        // Consulta SQL para obtener los datos de los tickets desde la base de datos
        String sql = "SELECT Pasajeros.Rut, Tickets.ruta_id, Buses.patente, precio, fecha_venta " +
                "FROM Tickets " +
                "INNER JOIN Pasajeros ON Pasajeros.idPasajero = Tickets.pasajero_id " +
                "INNER JOIN Buses ON Tickets.bus_Id = Buses.idBus";

        try {
            // Crear un statement para ejecutar la consulta
            Statement stmt = conexion.createStatement();
            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = stmt.executeQuery(sql);

            // Recorre los resultados de la consulta
            while (rs.next()) {
                // Obtiene los datos de cada columna del resultado
                int idRuta = rs.getInt("ruta_id");
                String patente = rs.getString("patente");
                String rut = rs.getString("Rut");
                double precio = rs.getDouble("precio");
                String fechaVenta =(rs.getString("fecha_venta"));

                // Inicializa una referencia de Ruta como null
                Ruta ruta = null;
                try {
                    // Intenta obtener la ruta correspondiente al idRuta
                    ruta = this.obtenerRuta(idRuta);
                } catch (RutaNoEncontradaException e) {
                    // Muestra un mensaje de error si la ruta no es encontrada
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

                // Obtiene el bus correspondiente a la patente
                Bus bus = this.obtenerBusEmpresa(patente);
                // Obtiene el pasajero correspondiente al rut
                Pasajero pasajero = this.obtenerPasajeroEmpresa(rut);

                // Verifica si el pasajero no es null
                if (pasajero != null) {
                    // Crea una nueva instancia de Ticket con los datos obtenidos
                    Ticket ticket = new Ticket(ruta, bus, pasajero, fechaVenta);
                    // Establece el precio del ticket
                    ticket.setPrecio(precio);

                    // Agrega el ticket a la lista de tickets
                    this.agregarTicket(ticket);
                    // Asigna el ticket al pasajero
                    pasajero.setTicket(ticket);
                } else {
                    // Muestra un mensaje de error si no se pudo encontrar el bus o el pasajero
                    JOptionPane.showMessageDialog(null, "No se pudo encontrar el bus o el pasajero.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            // Muestra un mensaje de error en caso de que ocurra una excepción SQL
            JOptionPane.showMessageDialog(null, "Error al cargar los tickets: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    // Método público para calcular la viabilidad de un viaje en una ruta específica
    public boolean calcularViabilidadViaje(Ruta ruta, double precioCombustible, double costoPapeleo, double ingresoPasajero) {
        // Obtiene la distancia de la ruta
        double distancia = ruta.getDistancia();
        // Calcula el costo del combustible para la distancia y precio dado
        double costoCombustible = calcularCostoCombustible(distancia, precioCombustible);
        // Calcula el costo total sumando el costo del combustible y el papeleo
        double costoTotal = costoCombustible + costoPapeleo;

        // Calcula el ingreso total multiplicando el ingreso por pasajero por el número de buses en la ruta
        double ingresoTotal = ingresoPasajero * ruta.getBuses().size();

        // Retorna true si el ingreso total es mayor que el costo total, indicando que el viaje es viable
        return ingresoTotal > costoTotal;
    }

    // Método privado para calcular el costo del combustible basado en la distancia y el precio por litro
    private double calcularCostoCombustible(double distancia, double precioCombustible) {
        // Consumo promedio de combustible por litro (ejemplo: 5 km por litro)
        double consumoPorLitro = 5.0;
        // Calcula y retorna el costo del combustible
        return (distancia / consumoPorLitro) * precioCombustible;
    }

    public boolean cancelarTicket(int idTicket) {
        String queryObtenerBus = "SELECT bus_id, asiento FROM Tickets WHERE idTicket = ?";
        String queryEliminarTicket = "DELETE FROM Tickets WHERE idTicket = ?";
        String queryActualizarBus = "UPDATE Buses SET pasajeros_actuales = pasajeros_actuales - 1 WHERE patente = ?";

        try (PreparedStatement pstmtObtenerBus = conexion.prepareStatement(queryObtenerBus)) {
            pstmtObtenerBus.setInt(1, idTicket);
            ResultSet rs = pstmtObtenerBus.executeQuery();

            if (rs.next()) {
                int idBus = rs.getInt("bus_id");
                int asiento = rs.getInt("asiento");

                // Eliminar el ticket
                try (PreparedStatement pstmtEliminar = conexion.prepareStatement(queryEliminarTicket)) {
                    pstmtEliminar.setInt(1, idTicket);
                    int filasEliminadas = pstmtEliminar.executeUpdate(); // Captura el número de filas eliminadas
                    if (filasEliminadas == 0) {
                        return false; // Si no se eliminó ninguna fila, retorna false
                    }
                }

                // Liberar el asiento en el bus
                Bus bus = obtenerBusPorId(idBus); // Asegúrate de que este método exista en tu clase Empresa
                if (bus != null) {
                    bus.liberarAsiento(asiento); // Asegúrate de que este método esté implementado
                }

                // Actualizar la cantidad de pasajeros en el bus
                try (PreparedStatement pstmtActualizarBus = conexion.prepareStatement(queryActualizarBus)) {
                    String patente = bus.getPatente(); // Asegúrate de que esto sea válido
                    pstmtActualizarBus.setString(1, patente); // Usamos la patente para actualizar
                    pstmtActualizarBus.executeUpdate();
                }

                return true; // Anulación exitosa
            } else {
                return false; // Ticket no encontrado
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
            return false;
        }
    }



    public int obtenerIdBusPorPatente(String patente)
    {
        String query = "SELECT idBus FROM Buses WHERE patente = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query))
        {
            pstmt.setString(1, patente);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("idBus"); // Retorna el ID del bus
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 si no se encuentra el bus
    }


    public Bus obtenerBusPorId(int idBus)
    {
        String query = "SELECT patente FROM Buses WHERE idBus = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, idBus); // Asignar el ID del bus en la consulta
            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                return obtenerBusEmpresa(rs.getString("patente")); // Retorna la patente del bus si se encuentra
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }

        return null; // Retorna null si no se encuentra el bus
    }



    public int obtenerIdPasajero(String rut)
    {
        String query = "SELECT idPasajero FROM Pasajeros WHERE rut = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query))
        {
            pstmt.setString(1, rut);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("idPasajero"); // Retorna el ID del bus
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 si no se encuentra el bus
    }


    // Método para eliminar un ticket de la lista
    public void eliminarTicket(Ticket ticket) {
        ticketsTotales.remove(ticket); // Remueve el ticket de la lista
    }


    public Ticket obtenerTicketPorId(int id)
    {
        // Busca en la lista de tickets totales
        for (Ticket ticket : ticketsTotales)
        {
            if (ticket.getIdTicket() == id)
            {
                return ticket; // Retorna el ticket encontrado
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public Ticket obtenerTicketPorRut(String rut)
    {
        // Busca en la lista de tickets totales
        for (Ticket ticket : ticketsTotales)
        {
            // Asegúrate de que el RUT se compare de manera insensible a mayúsculas
            if (ticket.getPasajero().getRut().equalsIgnoreCase(rut.trim())) {
                return ticket; // Retorna el ticket encontrado
            }
        }
        return null; // Retorna null si no se encuentra
    }
}









