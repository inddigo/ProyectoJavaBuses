package com.mycompany.siap;





import java.util.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.awt.BorderLayout;

import javax.swing.Timer;
import java.time.*;


public class Empresa {

    private List<Bus> listaBuses;
    private List<Pasajero>listaPasajeros;
    private List<Ruta>listaRutas;
    private Connection conexion;
    private List<Ticket> ticketsTotales;


    public Empresa()
    {

        listaBuses = new ArrayList<>();
        listaPasajeros = new ArrayList<>();
        listaRutas = new ArrayList<>();
        ticketsTotales = new ArrayList<>();

        this.conexion = cargarBaseDeDatos();
        if (this.conexion == null)
        JOptionPane.showMessageDialog(null, "Error al cargar la base de datos", "Error", JOptionPane.ERROR_MESSAGE);

    }

    public void setConexion(Connection cone)
    {
        this.conexion = cone;
    }
    public Connection getConexionBd()
    {
        return this.conexion;
    }

    public void setListaPasajeros(List<Pasajero> listaPasajeros)
    {
         this.listaPasajeros = listaPasajeros;

    }

    public Connection getConexion() {
        return this.conexion;
    }

    public List<Pasajero> getListaPasajeros()
    {
        return listaPasajeros;
    }

    public List<Bus> getListaBuses()
    {
        return listaBuses;
    }


    public void setListaBuses(List<Bus> listaBuses) {
        this.listaBuses = listaBuses;
    }



    public List<Ruta> getListaRutas() {
        return listaRutas;
    }

    public void setListaRutas(List<Ruta> listaRutas) {
        this.listaRutas = listaRutas;
    }

    public void agregarTicket(Ticket nuevoTicket)
    {
    if (!this.ticketsTotales.contains(nuevoTicket))
    {
        this.ticketsTotales.add(nuevoTicket);
    }
}


    public List<Ticket> obtenerTickets()
    {
        return this.ticketsTotales;
    }
    public void AgregarPasajeroEmpresa()
    {

    }


    public Pasajero obtenerPasajeroEmpresa(String Rut)
    {

        for (Pasajero pasa : listaPasajeros)
        {
            if (pasa.getRut().equals(Rut))
            {
                return pasa;
            }

        }

      return null;
    }




    public boolean eliminarPasajeroEmpresa(Pasajero Pasa)
    {

        if(listaPasajeros.contains(Pasa))
        {
            listaPasajeros.remove(Pasa);
            return true;


        }
        return false;

    }


   public void agregarBusEmpresa(Bus bus, int idRuta)
   {
    if (bus != null)
    {
        Ruta ruta;
        try
        {
            ruta = obtenerRuta(idRuta);


            ruta.agregarBusARuta(bus);
            listaBuses.add(bus);



        }



         catch (RutaNoEncontradaException ex)
        {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
}

    public void agregarBusEmpresa(String patente, int capacidad, int pasajerosActuales, double costoMantencion,int idruta)
    {
        Ruta ruta = null;
        try
        {
           ruta = obtenerRuta(idruta);
        }
        catch(RutaNoEncontradaException e)
        {
             JOptionPane.showMessageDialog(null, e.getMessage());
        }

        if(ruta != null)
        {
            Bus nuevoBus = new Bus();
            nuevoBus.setCapacidad(capacidad);
            nuevoBus.setPasajerosActuales(pasajerosActuales);
            nuevoBus.setPatente(patente);
            nuevoBus.setCostoMantencion(costoMantencion);
            ruta.agregarBusARuta(nuevoBus);
            listaBuses.add(nuevoBus);

        }


    }



    public boolean eliminarBusEmpresa(Bus busAEliminar)
    {
        int i;
        for(i = 0 ; i < listaRutas.size();i++)
        {
            Ruta ruta = listaRutas.get(i);
            List<Bus> buses = ruta.getBuses();
            if(buses.contains(busAEliminar))
            {
                listaBuses.remove(busAEliminar);
                buses.remove(busAEliminar);
                return true;
            }


        }
        return false;

    }

    public void modificarBus(String patente, int nuevaCapacidad, double nuevoCostoMantencion)
{
    boolean encontrado = false;

    for (int i = 0; i < listaBuses.size(); i++)
    {
        Bus bus = listaBuses.get(i);
        if (bus.getPatente().equals(patente))
        {

            encontrado = true;
            break;
        }
    }
    if (encontrado)
    {
        for (Ruta ruta : listaRutas)
        {
            List<Bus> buses = ruta.getBuses();
            for (int j = 0; j < buses.size(); j++)
            {
                Bus bus = buses.get(j);
                if (bus.getPatente().equals(patente))
                {
                    bus.setCapacidad(nuevaCapacidad);

                    bus.setCostoMantencion(nuevoCostoMantencion);
                    return;
                }
            }
        }
    }


}





    public Bus obtenerBusEmpresa(String patente)
    {
        for (Bus bus : listaBuses)
        {
            if (bus.getPatente().equals(patente))
        {
            return bus;
        }

        }


      return null;
    }






    public  void agregarRutaEmpresa(Ruta ruta)
    {
        int idRuta;
        idRuta = ruta.getId();
       if(buscarRutaEnEmpresa(idRuta) == true)
       {

       }
       else
       {
           listaRutas.add(ruta);

       }


    }


    public  void agregarRutaEmpresa(int id, String destino, double distancia,String Origen)
    {
       Ruta nuevaRuta = new Ruta(id,destino,distancia,Origen);

       if(buscarRutaEnEmpresa(id))
       {

       }
       else
       {
           listaRutas.add(nuevaRuta);

       }


    }

    public void agregarRutaEmpresa(List<Ruta> rutas)
    {
        int i;
       for(i = 0; i < rutas.size();i++)
       {
           Ruta compRuta = rutas.get(i);
           if(buscarRutaEnEmpresa(compRuta))
           {
           }
           else
           {

               listaRutas.add(compRuta);


           }
       }
    }


    public  void agregarRutaEmpresa(int id, String destino, double distancia,List<Bus> busesR,String origen)
    {
       Ruta nuevaRuta = new Ruta(id,destino,distancia,origen);

      for(int i = 0; i < busesR.size();i++)
      {
          Bus nuevoB = busesR.get(i);
          nuevaRuta.setBuses(nuevoB);
      }

       if(buscarRutaEnEmpresa(id))
       {

       }
       else
       {
           listaRutas.add(nuevaRuta);

       }


    }
    public  void agregarRutaEmpresa(int id, String destino, double distancia,Bus busesR,String origen)
    {
       Ruta nuevaRuta = new Ruta(id,destino,distancia,origen);
       nuevaRuta.setBuses(busesR);


       if(buscarRutaEnEmpresa(id))
       {
           return;
       }
       else
       {
           listaRutas.add(nuevaRuta);
       }


    }








    public  void eliminarRutaEmpresa(int id)
    {

        int i;
        Ruta compararR;
        if(buscarRutaEnEmpresa(id))
        {
            for(i = 0; i < listaRutas.size();i++)
            {
            compararR = listaRutas.get(i);
            if(compararR.getId() == id)
            {
                listaRutas.remove(i);
                return;
            }

            }

        }

    }


    public boolean eliminarRutaEmpresa(Ruta rutaAEliminar)
    {

        if(listaRutas.contains(rutaAEliminar))
        {
            listaRutas.remove(rutaAEliminar);
            return true;


        }
        else
        {
            return false;

        }

    }

    public  void modificarRutaEmpresa(int idRuta,String nuevoDestino,double nuevaDistancia,String NuevoOrigen)
    {

        if(buscarRutaEnEmpresa(idRuta))
        {
            for(Ruta ruta : listaRutas)
            {

                if(ruta.getId() == idRuta)
                {

                    ruta.setDestino(nuevoDestino);
                    ruta.setOrigen(NuevoOrigen);
                    ruta.setDistancia(nuevaDistancia);
                    return;
                }
            }
        }
    }




    public boolean  buscarRutaEnEmpresa(int IdRuta)
    {
        for(Ruta ruta : listaRutas)
        {
            if(ruta.getId() == IdRuta)
            {
                return true;
            }
        }
        return false;

    }
     public boolean  buscarRutaEnEmpresa(Ruta ruta)
    {
        return listaRutas.contains(ruta);

    }

     public Ruta obtenerRuta(int idBuscado) throws RutaNoEncontradaException
     {
        if(buscarRutaEnEmpresa(idBuscado))
        {
            int i;
            for(i = 0; i < listaRutas.size();i++)
            {
               Ruta buscado = listaRutas.get(i);
               if(buscado.getId() == idBuscado)
               {
                   Ruta ruta = listaRutas.get(i);

                   return ruta;
               }
            }
        }
        else
        {
            throw new RutaNoEncontradaException("Ruta con ID " + idBuscado + " no encontrada.");

        }
         return null;
     }

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




    private void  cargarBusesBd()
    {
       try {
            Thread.sleep(300);  // 2 segundos para simular la carga
        } catch (InterruptedException e) {
        }

        String query = "SELECT ruta_id, patente, capacidad, pasajeros_actuales, costo_mantencion FROM Buses";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(query))
        {
            while (rs.next())
            {
                int idRuta = rs.getInt("ruta_id");
                int capacidad = rs.getInt("capacidad");
                int pasajerosActuales = rs.getInt("pasajeros_actuales");
                double costoMantencion = rs.getDouble("costo_mantencion");
               Ruta r = null;
                try
                {
                    r = obtenerRuta(idRuta);
                }
                catch(RutaNoEncontradaException e)
                {
                     JOptionPane.showMessageDialog(null, e.getMessage());
                }
                String patente = rs.getString("patente");
                Bus bus = new Bus(patente, capacidad, pasajerosActuales, costoMantencion);
                if(r != null)
                {
                    r.agregarBusARuta(bus);

                }

                listaBuses.add(bus);

            }

        }
        catch (SQLException e)
        {
             JOptionPane.showMessageDialog(null, "Error al cargar los Buses: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarRutasBd()
    {
        try
        {
            Thread.sleep(300);  // 2 segundos para simular la carga
        } catch (InterruptedException e) {
        }
        String query = "SELECT idRutas , destino , distancia, origen FROM Rutas";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(query))
        {
            while (rs.next())
            {
                int idRuta = rs.getInt("idRutas");

                String destino = rs.getString("destino");
                String origen = rs.getString("origen");
                double distancia = rs.getDouble("distancia");

                Ruta ruta = new Ruta (idRuta, destino,distancia,origen);
                listaRutas.add(ruta);

            }

        }
        catch (SQLException e)
        {
             JOptionPane.showMessageDialog(null, "Error al cargar las rutas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void cargarPasajerosBd()
    {
       String query = "SELECT Pasajeros.rut, Pasajeros.nombre, Buses.patente " +
               "FROM Pasajeros " +
               "INNER JOIN Tickets ON Pasajeros.idPasajero = Tickets.pasajero_id " +
               "INNER JOIN Buses ON Tickets.bus_id = Buses.idBus";

            try
            {
                Statement stmt = conexion.createStatement();

                ResultSet rs = stmt.executeQuery(query);
                while (rs.next())
                {

                    String rut = rs.getString("rut");
                    String nombre = rs.getString("nombre");
                    String patenteBus = rs.getString("patente");

                    // Crear el pasajero
                    Pasajero pasajero = new Pasajero(rut, nombre);
                    listaPasajeros.add(pasajero);

                    // Asignar el pasajero al bus correcto
                    Bus bus = obtenerBusEmpresa(patenteBus);
                    if (bus != null && bus.getPasajerosActuales() < bus.getCapacidad())

                    {
                        bus.asignarPasajero(pasajero);

                    }

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los pasajeros: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
    }


    private void cargarHorariosDesdeBD()
    {
        try {
            Thread.sleep(300);  // Simula una carga con un pequeño retraso
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Restaurar el estado de interrupción
        }

        String sql = "SELECT ruta_id, fecha, horario FROM Horarios";

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idRuta = rs.getInt("ruta_id");
                String fecha = rs.getString("fecha");  // Mantener fecha como String
                String horario = rs.getString("horario");  // Mantener horario como String

                Ruta ruta = null;
                try {
                    ruta = this.obtenerRuta(idRuta);  // Obtener la ruta usando el id
                } catch (RutaNoEncontradaException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

                if (ruta != null) {
                    // Almacenar el horario como cadenas (String)
                    ruta.agregarHorario(fecha, horario);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los horarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private  void cargarTicketsDesdeBD()
    {

         try {
            Thread.sleep(300);  // 2 segundos para simular la carga
        } catch (InterruptedException e) {
        }
            String sql = "SELECT Pasajeros.Rut,Tickets.ruta_id, Buses.patente, precio, fecha_venta " +
                 "FROM Tickets "+
                 "INNER JOIN Pasajeros ON Pasajeros.idPasajero = Tickets.pasajero_id "+
                 "INNER JOIN Buses ON Tickets.bus_Id = Buses.idBus";

            try
            {
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next())
                {

                    int idRuta = rs.getInt("ruta_id");
                    String patente = rs.getString("patente");
                    String rut = rs.getString("Rut");
                    double precio = rs.getDouble("precio");

                    LocalDate fechaVenta = LocalDate.parse(rs.getString("fecha_venta"));

                    Ruta ruta = null;
                        try
                        {
                             ruta = this.obtenerRuta(idRuta);
                        }
                        catch(RutaNoEncontradaException e)
                        {
                             JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    Bus bus = this.obtenerBusEmpresa(patente); // Método que obtiene el bus por su ID
                    Pasajero pasajero = this.obtenerPasajeroEmpresa(rut); // Método para obtener pasajero

                    if (pasajero != null)
                    {

                        Ticket ticket = new Ticket(ruta, bus, pasajero, fechaVenta);
                        ticket.setPrecio(precio);

                        this.agregarTicket(ticket);
                        pasajero.setTicket(ticket);// Método para añadir el ticket a la lista de la empresa



                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo encontrar el bus o el pasajero.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los tickets: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
    }




      public boolean calcularViabilidadViaje(Ruta ruta, double precioCombustible, double costoPapeleo, double ingresoPasajero)
      {
        double distancia = ruta.getDistancia();
        double costoCombustible = calcularCostoCombustible(distancia, precioCombustible);
        double costoTotal = costoCombustible + costoPapeleo;

        double ingresoTotal = ingresoPasajero * ruta.getBuses().size();


        return ingresoTotal > costoTotal;
    }

    private double calcularCostoCombustible(double distancia, double precioCombustible)
    {

        double consumoPorLitro = 5.0;
        return (distancia / consumoPorLitro) * precioCombustible;
    }

    public static class VentanaGestionarHorariios {
    }
}


