
import java.util.*;
import java.time.*;

public class Empresa {

    private List<Bus> listaBuses;
    private List<Pasajero>listaPasajeros;
    private List<Ruta>listaRutas;


    public Empresa() 
    {

        listaBuses = new ArrayList<>();
        listaPasajeros = new ArrayList<>();
        listaRutas = new ArrayList<>();


    }
    
    public void setListaPasajeros(List<Pasajero> listaPasajeros)
    {
         this.listaPasajeros = listaPasajeros;
        
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


    

}