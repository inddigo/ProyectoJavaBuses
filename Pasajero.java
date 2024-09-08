

import java.time.*;
import java.util.*;

public class Pasajero 
{

    private String rut;
    private String nombre;
    private List<Ticket> tickets;

    public Pasajero(String rut, String nombre) 
    {

        this.rut = rut;
        this.nombre = nombre;
        this.tickets = new ArrayList<>();
    }

    public Pasajero() 
    {

        this.rut = null;
        this.nombre = null;
        this.tickets = new ArrayList<>();
    }


    
    public void setRut(String rut) 
    {

        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public void setTicket(Ticket ticket) {
        tickets.add(ticket);
    }


    public String getRut() {
        return this.rut;
    }

    public String getNombre() {
        return this.nombre;
    }


    public List<Ticket> getTickets() {
        return tickets;
    }
    
    
   
public String toString() 
{
    return "Pasajero: " + nombre + " (RUT: " + rut + ")";
}




}
