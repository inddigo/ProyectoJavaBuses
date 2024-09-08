
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
    
    public void agregarBusARuta(String patente, int capacidad, int pasajerosActuales, double costoMantencion)
    {
        Bus nuevoBus = new Bus();
            nuevoBus.setCapacidad(capacidad);
            nuevoBus.setPasajerosActuales(pasajerosActuales);
            nuevoBus.setPatente(patente);
            nuevoBus.setCostoMantencion(costoMantencion);
            
            
         if(seEncuentraEnRuta(patente) == false)
        {
            return;
        }
        else
        {
            buses.add(nuevoBus);
            
        }   
    }
     public void agregarBusARuta(Bus bus)
    {
        Bus nuevoBus = bus;
                     
            
         if(seEncuentraEnRuta(nuevoBus.getPatente()) == false)
        {
            return;
        }
        else
        {
            buses.add(nuevoBus);
   
        }   
    }
    
    public void mostrarBusesRuta()
    {
        int i;
        System.out.println("Ruta: "+ id);
        for(i = 0;i < buses.size();i++)
        {
            System.out.println("Bus"+": "+buses.get(i));
           
            
        }
            
    }
   
    
  
    public boolean seEncuentraEnRuta(String patente)
    {
        int i;
        for(i = 0;i < buses.size();i++)
        {
            Bus busAcomparar;
            busAcomparar =  buses.get(i);
            String nPatente;
            nPatente = busAcomparar.getPatente();
            if(nPatente.equals(patente))
            {
                return true;
                
            }
            else System.out.println("El Bus no se encuentra en la ruta");
           
           
        }
        
        return false;
    }
    
    
    public void eliminarBusRuta(String patente)
    {
        int i;
        for(i = 0 ; i < buses.size();i++)
        {
            Bus busAcomparar;
            busAcomparar =  buses.get(i);
            String nPatente;
            nPatente = busAcomparar.getPatente();
            if(nPatente.equals(patente))
            {
                buses.remove(i);
            }
        }
    }
    
   public void eliminarBusRuta(Bus bus) 
   {
    if (buses.contains(bus)) 
    {
        buses.remove(bus);
        System.out.println("Bus eliminado de la ruta.");
    } 
    else 
    {
        System.out.println("El bus no se encuentra en esta ruta.");
    }
    
   
   }
   
   
    public void agregarHorario(LocalDate fecha, LocalDateTime horario)
    {
        horariosPorFecha.computeIfAbsent(fecha, k -> new ArrayList<>()).add(horario);
    }

    public List<LocalDateTime> getHorarios(LocalDate fecha) 
    {
        return horariosPorFecha.getOrDefault(fecha, new ArrayList<>());
    }

    
    public Map<LocalDate, List<LocalDateTime>> getHorariosPorFecha() 
    {
    return horariosPorFecha;
    }



}