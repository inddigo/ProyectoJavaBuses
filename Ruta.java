
import java.io.*;
import java.time.*;
import java.util.*;

public class Ruta 
{


    private int id;
    private String destino;
    private double distancia;
    private List<Bus> buses;
    
    private Map<LocalDate, List<LocalDateTime>> horariosPorFecha;

    public Ruta(int id, String destino, double distancia)
    {
        this.id = id;
        this.destino = destino;
        this.distancia = distancia;
        this.horariosPorFecha = new HashMap<>();
        this.buses = new ArrayList<>();
    }
    
    
     public Ruta()
    {
        this.id = 0;
        this.destino = "none";
        this.distancia = 0.0;
        this.buses = new ArrayList<>();
    }


    public void setId(int id)
    {
        this.id = id;
    }
    public void setDestino(String destino)
    {
        this.destino = destino;
    }
    public void setDistancia(double distancia)
    {
        this.distancia = distancia;
    }
    public void setBuses(Bus bus)
    {
         buses.add(bus);
    }

   
    public int getId()
    {
        return id;
    }
    public String getDestino()
    {
        return destino;
    }
    public double getDistancia()
    {
        return distancia;
    }
    public List<Bus> getBuses()
    {
        return buses;
    }
    

    

}