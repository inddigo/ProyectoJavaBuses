import java.time.*;

public class Ticket {

    private LocalDateTime horaVenta;
    private Ruta ruta;
    private Bus bus;
    private String destino;
    private Pasajero pasajero;
    private int precio;



    public Ticket(Ruta ruta, Bus bus, Pasajero pasajero, LocalDateTime horaVenta) {
        this.ruta = ruta;
        this.bus = bus;
        this.pasajero = pasajero;
        this.horaVenta = horaVenta;
        this.precio = 6000;
        
        if (!bus.asignarPasajero(pasajero)) 
        {
            System.out.println("No se pudo crear el ticket, el bus está lleno.");
        }
    }

    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setFecha(LocalDateTime fecha) {
        this.horaVenta = fecha;
    }


    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

  


    public int getPrecio() {
        return precio;
    }
    public LocalDateTime getFecha() {
        return horaVenta;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public String toString() 
    {
        return "Ticket para " + pasajero.getNombre() + " en el bus " + bus.getPatente()
                + " con destino a " + ruta.getDestino() + ". Hora de salida: " + horaVenta;
    }




}