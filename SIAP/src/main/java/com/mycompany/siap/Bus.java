package com.mycompany.siap;



import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

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
        this.mapaBus = new HashMap<>();
    }
    public Bus(String patente,int capacidad , int pasajerosActuales , double costoMantencion) 
    {

        this.patente = patente;
        
        this.capacidad = capacidad;
        this.pasajerosActuales = pasajerosActuales;
        this.costoMantencion = costoMantencion;
        this.mapaBus = new HashMap<>();
    }
     public Bus(String patente,int capacidad , double costoMantencion) 
    {

        this.patente = patente;
        
        this.capacidad = capacidad;
        this.pasajerosActuales = 0;
        this.costoMantencion = costoMantencion;
        this.mapaBus = new HashMap<>();
    }


    public Bus(String patente, int pasajerosActuales) 
    {


        this.patente = patente;
        this.pasajerosActuales = pasajerosActuales;
        capacidad = 44;
        mapaBus = new HashMap<>();
        this.costoMantencion = 0;
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



     public void asignarPasajero(String rut, Pasajero pasajero) 
    {
        mapaBus.put(rut, pasajero);
    }
     
    public Pasajero obtenerPasajero(String rut) 
    {
        return mapaBus.get(rut);
    }

    public void asignarPasajero(Pasajero pasajero) 
    {
    if (pasajerosActuales < capacidad) 
    { // Verifica que el bus no esté lleno
        if (!mapaBus.containsKey(pasajero.getRut())) 
            
        { // Verifica que el pasajero no esté ya asignado
            mapaBus.put(pasajero.getRut(), pasajero); // Asigna el pasajero al bus
            pasajerosActuales++; // Incrementa el conteo de pasajeros actuales
            
            
        } else 
        {
            JOptionPane.showMessageDialog(null, "El pasajero ya está asignado a este bus.", "Asignación fallida", JOptionPane.WARNING_MESSAGE);
            
        }
    } 
    else 
    {
        JOptionPane.showMessageDialog(null, "Bus lleno, no se puede asignar más pasajeros.", "Asignación fallida", JOptionPane.ERROR_MESSAGE);
    }
}



    public Map<String, Pasajero> getMapaBus() 
    {
        return mapaBus;
    }

}

