package com.mycompany.siap;


import java.io.*;
import java.util.*;
import java.time.format.*;
import java.time.*;
import javax.swing.*;




public class SIAP {

    public static void main(String arg[]) {

        Scanner input = new Scanner(System.in);


        Empresa nuevaEmpresa = new Empresa();

        nuevaEmpresa.cargarDatosConProgreso();

        List<Ticket> t = nuevaEmpresa.obtenerTickets();
        for (Ticket td : t) {
            System.out.println(td.getPasajero().getRut());
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaPrincipal vent = new VentanaPrincipal(nuevaEmpresa);

                vent.setVisible(true);
            }

        });

    }}