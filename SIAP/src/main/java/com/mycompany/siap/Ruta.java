package com.mycompany.siap;

import java.util.*;

public class Ruta {

    private int id;
    private String origen;
    private String destino;
    private double distancia;
    private List<Bus> buses;

    // Mapa que utiliza Strings para representar las fechas y listas de horarios
    private Map<String, List<String>> horariosPorFecha;

    // Constructores
    public Ruta(int id, String destino, double distancia, String origen) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.horariosPorFecha = new HashMap<>();
        this.buses = new ArrayList<>();
    }

    public Ruta() {
        this.id = 0;
        this.destino = "none";
        this.origen = "none";
        this.distancia = 0.0;
        this.buses = new ArrayList<>();
        this.horariosPorFecha = new HashMap<>();
    }

    // Setters y Getters
    public void setId(int id) {
        this.id = id;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setBuses(Bus bus) {
        buses.add(bus);
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public String getOrigen() {
        return origen;
    }

    // Métodos para agregar, eliminar y mostrar buses en la ruta
    public void agregarBusARuta(String patente, int capacidad, int pasajerosActuales, double costoMantencion) {
        Bus nuevoBus = new Bus();
        nuevoBus.setCapacidad(capacidad);
        nuevoBus.setPasajerosActuales(pasajerosActuales);
        nuevoBus.setPatente(patente);
        nuevoBus.setCostoMantencion(costoMantencion);

        if (!seEncuentraEnRuta(patente)) {
            buses.add(nuevoBus);
        }
    }

    public void agregarBusARuta(Bus bus) {
        if (!seEncuentraEnRuta(bus.getPatente())) { // Cambiado a 'no se encuentra'
            buses.add(bus); // Agregar el bus a la lista de buses de la ruta
        }
    }

    public void mostrarBusesRuta() {
        System.out.println("Ruta: " + id);
        for (Bus bus : buses) {
            System.out.println("Bus: " + bus);
        }
    }

    public boolean seEncuentraEnRuta(String patente) {
        for (Bus bus : buses) {
            if (bus.getPatente().equals(patente)) {
                return true; // El bus ya está en la ruta
            }
        }
        return false; // El bus no se encontró en la ruta
    }

    public void eliminarBusRuta(String patente) {
        buses.removeIf(bus -> bus.getPatente().equals(patente));
    }

    public void eliminarBusRuta(Bus bus) {
        buses.remove(bus);
    }

    // Métodos para gestionar horarios

    // Método para agregar un horario a la ruta (tanto fecha como horario son Strings)
    public void agregarHorario(String fecha, String horario) {
        horariosPorFecha.computeIfAbsent(fecha, k -> new ArrayList<>()).add(horario);
    }

    // Método para obtener los horarios de una fecha específica (retorna una lista de Strings)
    public List<String> getHorarios(String fecha) {
        return horariosPorFecha.getOrDefault(fecha, new ArrayList<>());
    }

    // Devuelve todo el Map de horarios por fecha (utilizando Strings)
    public Map<String, List<String>> getHorariosPorFecha() {
        return horariosPorFecha;
    }

    // Método para eliminar un horario específico en una fecha dada
    public void eliminarHorario(String fecha, String horario) {
        List<String> horarios = horariosPorFecha.get(fecha);
        if (horarios != null) {
            horarios.remove(horario);
            // Si ya no quedan horarios en esa fecha, eliminar la entrada del mapa
            if (horarios.isEmpty()) {
                horariosPorFecha.remove(fecha);
            }
        }
    }
}