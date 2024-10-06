package com.mycompany.siap;

import java.util.*;

public class Pasajero {

    private String rut;
    private String nombre;
    private List<Ticket> tickets;

    // Constructor que inicializa un pasajero con su RUT y nombre
    public Pasajero(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        this.tickets = new ArrayList<>();  // Inicializa la lista de tickets
    }

    // Constructor vacío que inicializa un pasajero sin datos
    public Pasajero() {
        this.rut = null;
        this.nombre = null;
        this.tickets = new ArrayList<>();  // Inicializa la lista de tickets
    }

    // Método setter para establecer el RUT del pasajero
    public void setRut(String rut) {
        this.rut = rut;
    }

    // Método setter para establecer el nombre del pasajero
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para añadir un ticket a la lista de tickets del pasajero
    public void setTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    // Método getter para obtener el RUT del pasajero
    public String getRut() {
        return this.rut;
    }

    // Método getter para obtener el nombre del pasajero
    public String getNombre() {
        return this.nombre;
    }

    // Método getter para obtener la lista de tickets del pasajero
    public List<Ticket> getTickets() {
        return tickets;
    }

    // Método que devuelve una representación en cadena del pasajero
    @Override
    public String toString() {
        return "Pasajero: " + nombre + " (RUT: " + rut + ")";
    }

    public void eliminarTicket(Ticket ticket)
    {
        tickets.remove(ticket); // Eliminar el ticket de la lista de tickets del pasajero
    }
}
