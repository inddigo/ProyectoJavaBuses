
import java.util.HashMap;
import java.util.Map;

public class Bus 
{

    private String patente;
    private int capacidad;
    private int pasajerosActuales;
    private double costoMantencion;
    private Map<String, Pasajero>mapaBus;

    public Bus(String patente, int pasajerosActuales, double costoMantencion, Map mapaBus) 
    {

        this.patente = patente;
        this.capacidad = 44;
        this.pasajerosActuales = pasajerosActuales;
        this.costoMantencion = costoMantencion;
        this.mapaBus = new HashMap<String, Pasajero>();
    }

    public Bus(String patente, int pasajerosActuales) 
    {


        this.patente = null;
        this.pasajerosActuales = 0;
        capacidad = 44;
    }




    public Bus() {

        this.patente = null;
        capacidad = 44;
        this.pasajerosActuales = 0;
        this.costoMantencion = 0;
        this.mapaBus = new HashMap();
    }





    public String getPatente()
    {
        return patente;
    }

    public void setPatente(String patente) 
    {
        this.patente = patente;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) 
    {
        this.capacidad = capacidad;
    }
    public int getPasajerosActuales() {
        return pasajerosActuales;

    }
    public void setPasajerosActuales(int PasajerosActuales) 
    {
        this.pasajerosActuales = PasajerosActuales;
    }
    public double getCostoMantencion() 
    {
        return costoMantencion;

    }
    public void setCostoMantencion(double costoMantencion) 
    {
        this.costoMantencion = costoMantencion;
    }

    public void setMapaBus(String key, Pasajero value)
    {

        mapaBus.put(key, value);
    }

    public void getMapaBus(String key){

        mapaBus.get(key);
    }

}
