package com.mycompany.siap;


import java.io.*;
import java.util.*;
import java.time.format.*;
import java.time.*;
import javax.swing.*;




public class SIAP 
{
   
    public static void main (String arg[]) 
    {

        Scanner input = new Scanner(System.in);
        
        
        Empresa nuevaEmpresa = new Empresa();
        
       nuevaEmpresa.cargarDatosConProgreso();
        
        
       
     
        java.awt.EventQueue.invokeLater(new Runnable()
        {
                public void run()
                {
                    VentanaPrincipal vent = new VentanaPrincipal (nuevaEmpresa);
                    
                    vent.setVisible(true);
                }
                    
            });
        
    }



     


   
  
    public  void esViableElViaje(Empresa empresa)
    {
        Scanner input =new Scanner(System.in);
        int id;
        double precioCombustible = 800.0;
        double costoPapeleo = 5000.0;
        double ingresoPasajero = 10000.0;

        id = input.nextInt();
        input.nextLine();
        Ruta ruta = null;
        try 
        {
            ruta = empresa.obtenerRuta(id);
            // Lógica para manejar la ruta encontrada
        } catch (RutaNoEncontradaException e) 
        {
            // Manejo de la excepción
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        if(ruta != null)
        {
             boolean esViable = empresa.calcularViabilidadViaje(ruta, precioCombustible, costoPapeleo, ingresoPasajero);
             System.out.println("El viaje es viable? " + (esViable ? "Sí" : "No"));
       
            
        }
       

    }


 



    public static void rentabilidadDeViaje(Empresa empresa)
    {

        Scanner input =new Scanner(System.in);


        System.out.println("Ingrese los kilometreros del viaje");
        double km = input.nextDouble();
        input.nextLine();


        System.out.println("Ingrese los costo combustible");
        double combustible = input.nextDouble();
        input.nextLine();

        System.out.println("Ingrese los costo mantenimietno");
        double costMantenimiento = input.nextDouble();
        input.nextLine();

        System.out.println("Ingrese los costo seguro");
        double seguro = input.nextDouble();
        input.nextLine();

        System.out.println("Ingrese los costo impuestos");
        double impuesto = input.nextDouble();
        input.nextLine();

        System.out.println("Ingrese los costo peaje");
        double peaje = input.nextDouble();
        input.nextLine();

        System.out.println("Ingrese los costo ganancia total");
        double ganancia = input.nextDouble();
        input.nextLine();

        double costoTotal = combustible+costMantenimiento+seguro+impuesto+peaje;

        double costoTotalViaje = costoTotal*km;

        double gananciaNeta = ganancia-costoTotalViaje;

        double roi = (gananciaNeta/costoTotalViaje)*100;


    }

    
    public static void crearTicket(Ticket ticket)
    {

        Scanner input =new Scanner(System.in);
        LocalDate fecha;

        System.out.println("Ingrese los Datos del Pasajero");

    }



   
public static void crearPasajero(Scanner input, Ruta ruta, Bus bus) 
{
    LocalDate horaVenta = LocalDate.now();
    Pasajero pasajero = new Pasajero();

    System.out.println("Ingrese los Datos del Pasajero, rut");
    pasajero.setRut(input.nextLine());

    System.out.println("Ingrese los Datos del Pasajero, nombre");
    pasajero.setNombre(input.nextLine());

   
    System.out.println("Bus: " + bus.getPatente());
    
    Ticket ticket = new Ticket(ruta, bus, pasajero, horaVenta);

    System.out.println(ticket);

    System.out.println("Pasajeros en el bus " + bus.getPatente() + ":");
    for (Pasajero p : bus.getMapaBus().values()) 
    {
        System.out.println(p); 
    }
}


}   

