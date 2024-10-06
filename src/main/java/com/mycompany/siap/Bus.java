package com.mycompany.siap;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Bus {

    // Atributos de la clase Bus
    private String patente; // Patente del bus
    private int capacidad; // Capacidad máxima de pasajeros del bus
    private int pasajerosActuales; // Número de pasajeros actualmente en el bus
    private double costoMantencion; // Costo de mantención del bus
    private Map<Integer, Pasajero> asientos; // Mapa que asocia números de asiento con objetos Pasajero

    // Constructor vacío
    public Bus() {
        this.patente = null; // Inicializa la patente a null
        this.capacidad = 44; // Capacidad predeterminada
        this.pasajerosActuales = 0; // No hay pasajeros inicialmente
        this.costoMantencion = 0.0; // Costo de mantención predeterminado
        this.asientos = new HashMap<>(); // Inicializa el mapa de asientos
    }

    // Constructor que inicializa el bus con todos los atributos
    public Bus(String patente, int capacidad, int pasajerosActuales, double costoMantencion) {
        this.patente = patente;
        this.capacidad = capacidad;
        this.pasajerosActuales = pasajerosActuales;
        this.costoMantencion = costoMantencion;
        this.asientos = new HashMap<>(); // Inicializa el mapa de asientos
    }

    // Constructor que inicializa el bus con capacidad predeterminada
    public Bus(String patente, double costoMantencion) {
        this.patente = patente;
        this.capacidad = 44; // Capacidad predeterminada
        this.pasajerosActuales = 0; // No hay pasajeros inicialmente
        this.costoMantencion = costoMantencion;
        this.asientos = new HashMap<>(); // Inicializa el mapa de asientos
    }

    // Constructor que permite definir capacidad y costo de mantención
    public Bus(String patente, int capacidad, double costoMantencion) {
        this.patente = patente;
        this.capacidad = capacidad;
        this.pasajerosActuales = 0; // No hay pasajeros inicialmente
        this.costoMantencion = costoMantencion;
        this.asientos = new HashMap<>();
    }

    // Getters y Setters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPasajerosActuales() {
        return pasajerosActuales;
    }

    public void setPasajerosActuales(int pasajerosActuales) {
        this.pasajerosActuales = pasajerosActuales;
    }

    public double getCostoMantencion() {
        return costoMantencion;
    }

    public void setCostoMantencion(double costoMantencion) {
        this.costoMantencion = costoMantencion;
    }

    // Método para verificar si un asiento está ocupado
    public boolean asientoOcupado(int numeroAsiento) {
        return asientos.containsKey(numeroAsiento); // Verifica si el asiento ya tiene un pasajero asignado
    }


    // Método para asignar un pasajero a un asiento específico
    public void asignarPasajero(Pasajero pasajero, int asiento) {
        if (asiento < 1 || asiento > capacidad) {
            JOptionPane.showMessageDialog(null, "Número de asiento no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (asientos.containsKey(asiento)) {
            JOptionPane.showMessageDialog(null, "El asiento ya está ocupado.", "Asignación fallida", JOptionPane.WARNING_MESSAGE);
        } else {
            if (pasajerosActuales < capacidad) {
                asientos.put(asiento, pasajero); // Asigna el pasajero al asiento
                pasajerosActuales++; // Incrementa el número de pasajeros actuales
            } else {
                JOptionPane.showMessageDialog(null, "Bus lleno, no se puede asignar más pasajeros.", "Asignación fallida", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void asignarPasajero(Pasajero pasajero)
    {
        // Verifica si hay capacidad en el bus
        if (pasajerosActuales < capacidad)
        {
            // Verifica que el pasajero no esté ya asignado
            if (!asientos.containsValue(pasajero))
            {
                // Encuentra un asiento libre (el primer asiento disponible)
                for (int i = 1; i <= capacidad; i++)
                {
                    if (!asientos.containsKey(i)) { // Si el asiento no está ocupado
                        asientos.put(i, pasajero); // Asigna el pasajero al asiento
                        pasajerosActuales++; // Incrementa el número de pasajeros actuales
                        JOptionPane.showMessageDialog(null, "Pasajero asignado al asiento " + i, "Asignación exitosa", JOptionPane.INFORMATION_MESSAGE);
                        return; // Sale del método después de la asignación
                    }
                }
            }
            else
            {
                // Muestra un mensaje si el pasajero ya está en el bus
                JOptionPane.showMessageDialog(null, "El pasajero ya está asignado a este bus.", "Asignación fallida", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            // Muestra un mensaje si el bus está lleno
            JOptionPane.showMessageDialog(null, "Bus lleno, no se puede asignar más pasajeros.", "Asignación fallida", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void liberarAsiento(int asientoSeleccionado) {
        // Verifica si el número de asiento es válido
        if (asientoSeleccionado < 1 || asientoSeleccionado > capacidad) {
            JOptionPane.showMessageDialog(null, "Número de asiento no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Sale del método si el asiento no es válido
        }

        // Verifica si el asiento está ocupado
        if (asientos.containsKey(asientoSeleccionado)) {
            // Libera el asiento, eliminando al pasajero del mapa
            Pasajero pasajero = asientos.remove(asientoSeleccionado); // Elimina al pasajero del asiento
            pasajerosActuales--; // Decrementa el número de pasajeros actuales
            JOptionPane.showMessageDialog(null, "El asiento " + asientoSeleccionado + " ha sido liberado.", "Liberación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Muestra un mensaje si el asiento no está ocupado
            JOptionPane.showMessageDialog(null, "El asiento " + asientoSeleccionado + " ya está libre.", "Liberación fallida", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void liberarAsiento(Pasajero pasajero) {
        // Encontrar el asiento ocupado por el pasajero
        for (Map.Entry<Integer, Pasajero> entry : asientos.entrySet()) {
            if (entry.getValue().equals(pasajero)) {
                asientos.remove(entry.getKey()); // Libera el asiento
                pasajerosActuales--; // Decrementa el número de pasajeros actuales
                JOptionPane.showMessageDialog(null, "El asiento ha sido liberado para el pasajero " + pasajero.getNombre(), "Liberación exitosa", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El pasajero no ocupa ningún asiento.", "Liberación fallida", JOptionPane.WARNING_MESSAGE);
    }

    public int getAsientosDisponibles()
    {
        return capacidad - pasajerosActuales; // Calcula los asientos disponibles
    }



    public void incrementarPasajeros()
    {
        pasajerosActuales++;

    }
}
