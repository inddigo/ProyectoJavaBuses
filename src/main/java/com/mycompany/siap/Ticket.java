package com.mycompany.siap;

import com.mycompany.siap.Bus;
import com.mycompany.siap.Pasajero;
import com.mycompany.siap.Ruta;

import java.time.*;

public class Ticket {

    private String fechaVenta;
    private Ruta ruta;
    private Bus bus;
    private String origen;
    private String destino;
    private Pasajero pasajero;
    private int numeroAsiento;
    private double precio;
    private int idTicket;

    // Constructor que inicializa un ticket con la ruta, bus, pasajero, y la fecha de venta
    public Ticket(Ruta ruta, Bus bus, Pasajero pasajero, String horaVenta) {
        this.ruta = ruta;
        this.bus = bus;
        this.pasajero = pasajero;
        this.fechaVenta = horaVenta;
        this.precio = 6000;
        idTicket = 0;// Precio predeterminado del ticket

        // Asigna un pasajero al bus si aún hay capacidad
        if (bus.getPasajerosActuales() < bus.getCapacidad()) {
            bus.asignarPasajero(pasajero);
        } else
            throw new IllegalStateException("El bus está lleno, no se puede asignar más pasajeros.");
    }


    public Ticket(Ruta ruta, Bus bus, Pasajero pasajero, String horaVenta,int idTicket)
    {
        this.ruta = ruta;
        this.bus = bus;
        this.pasajero = pasajero;
        this.fechaVenta = horaVenta;
        this.precio = 6000;
        this.idTicket = idTicket;// Precio predeterminado del ticket

        // Asigna un pasajero al bus si aún hay capacidad
        if (bus.getPasajerosActuales() < bus.getCapacidad()) {
            bus.asignarPasajero(pasajero);
        } else
            throw new IllegalStateException("El bus está lleno, no se puede asignar más pasajeros.");
    }

    // Setters
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFecha(String fecha) {
        this.fechaVenta = fecha;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public void setNumeroAsiento(String numero) {
        int n = Integer.parseInt(numero);
        this.numeroAsiento = n;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    // Getters
    public String getDestino() {
        return this.destino;
    }

    public String getOrigen() {
        return this.origen;
    }

    public double getPrecio() {
        return precio;
    }

    public  Bus getBus()
    {
        return bus;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setIdTicket(int idTicket)
    {
        this.idTicket = idTicket;

    }

    public  int getIdTicket()
    {return idTicket;}

    public Pasajero getPasajero()
    {
        return pasajero;
    }

    // Método que devuelve una representación en cadena del ticket
    @Override
    public String toString() {
        return "Ticket para " + pasajero.getNombre() + " en el bus " + bus.getPatente()
                + " con destino a " + ruta.getDestino() + ". Hora de salida: " + fechaVenta;
    }

    public String getFechaVenta()
    {
        return  fechaVenta;
    }
}