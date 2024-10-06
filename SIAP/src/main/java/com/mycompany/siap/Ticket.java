package com.mycompany.siap;



import java.time.*;

public class Ticket {

    private LocalDate fechaVenta;
    private Ruta ruta;
    private Bus bus;
    private String origen;
    private String destino;
    private Pasajero pasajero;
    private int numeroAsiento;
    private double precio;



    public Ticket(Ruta ruta, Bus bus, Pasajero pasajero, LocalDate horaVenta) {
        this.ruta = ruta;
        this.bus = bus;
        this.pasajero = pasajero;
        this.fechaVenta = horaVenta;
        this.precio = 6000;
        
        if (bus.getCapacidad() < bus.getPasajerosActuales())
        {
            bus.asignarPasajero(pasajero);              
        
            
        }
    }

    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setFecha(LocalDate fecha) {
        this.fechaVenta = fecha;
    }


    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
    public void setNumeroAsiento(String numero)
            
    {
        int n = Integer.parseInt(numero);
        this.numeroAsiento = n;
        
    }
    public void setDestino(String Destino)
    {
        this.destino = Destino;
    }
     public void setOrigen(String o)
    {
        this.origen = o;
    }
     
    public String getDestino()
    {
        return this.destino;
    }
    
       public String getOrigen()
    {
        return this.origen;
    }
    

  


    public double getPrecio() {
        return precio;
    }
    public LocalDate getFecha() {
        return fechaVenta;
    }

    public Ruta getRuta() {
        return ruta;
    }
    public int setNumeroAsiento()
            
    {
        return numeroAsiento;
        
    }

    public String toString() 
    {
        return "Ticket para " + pasajero.getNombre() + " en el bus " + bus.getPatente()
                + " con destino a " + ruta.getDestino() + ". Hora de salida: " + fechaVenta;
    }




}