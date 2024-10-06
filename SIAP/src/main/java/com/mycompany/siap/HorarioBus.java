/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.siap;




import java.time.LocalTime;

public class HorarioBus 
{
    private LocalTime hora;  // Hora del horario
    private Bus busAsignado;  // Bus asignado a este horario

    public HorarioBus(LocalTime hora, Bus busAsignado) {
        this.hora = hora;
        this.busAsignado = busAsignado;
    }

    // Getter para la hora
    public LocalTime getHora() {
        return hora;
    }

    // Setter para la hora
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    // Getter para el bus asignado
    public Bus getBusAsignado() {
        return busAsignado;
    }

    // Setter para el bus asignado
    public void setBusAsignado(Bus busAsignado) {
        this.busAsignado = busAsignado;
    }
    
}