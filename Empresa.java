

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


    
   public void agregarBusEmpresa(Bus bus, int idRuta) 
   {
    if (bus != null) 
    {
        Ruta ruta = obtenerRuta(idRuta);
        
        if (ruta != null) 
        {
            ruta.agregarBusARuta(bus);
            listaBuses.add(bus);
            System.out.println("Bus agregado exitosamente a la ruta: " + idRuta);
        } else 
        {
            System.out.println("No se encontró la ruta con ID: " + idRuta);
        }
    }
}

    public void agregarBusEmpresa(String patente, int capacidad, int pasajerosActuales, double costoMantencion,int idruta) 
    {
        Ruta ruta = obtenerRuta(idruta);
        if(ruta != null)
        {    
            Bus nuevoBus = new Bus();
            nuevoBus.setCapacidad(capacidad);
            nuevoBus.setPasajerosActuales(pasajerosActuales);
            nuevoBus.setPatente(patente);
            nuevoBus.setCostoMantencion(costoMantencion);
            ruta.agregarBusARuta(nuevoBus);
            listaBuses.add(nuevoBus);
            System.out.println("Bus agregado exitosamente a la ruta: " + idruta);
        }
        else System.out.println("No se encontró la ruta con ID: " + idruta);
        
    }
            

    
    public void eliminarBusEmpresa(Bus busAEliminar)
    {
        int i;
        for(i = 0 ; i < listaRutas.size();i++)
        {
            Ruta ruta = listaRutas.get(i);
            List<Bus> buses = ruta.getBuses();
            if(buses.contains(busAEliminar))
            {
                listaBuses.remove(busAEliminar);
                buses.remove(busAEliminar);
            }
            
            
        }
       
    }
    
    public void modificarBus(String patente, int nuevaCapacidad, int nuevosPasajeros, double nuevoCostoMantencion) 
{
    boolean encontrado = false;
    
    for (int i = 0; i < listaBuses.size(); i++) 
    {
        Bus bus = listaBuses.get(i);
        if (bus.getPatente().equals(patente)) 
        {
            bus.setCapacidad(nuevaCapacidad);
            bus.setPasajerosActuales(nuevosPasajeros);
            bus.setCostoMantencion(nuevoCostoMantencion);
            encontrado = true;
            break;
        }
    }
    if (encontrado) 
    {
        for (Ruta ruta : listaRutas) 
        {
            List<Bus> buses = ruta.getBuses();
            for (int j = 0; j < buses.size(); j++) 
            {
                Bus bus = buses.get(j);
                if (bus.getPatente().equals(patente)) 
                {
                    bus.setCapacidad(nuevaCapacidad);
                    bus.setPasajerosActuales(nuevosPasajeros);
                    bus.setCostoMantencion(nuevoCostoMantencion);
                    System.out.println("Bus con patente " + patente + " modificado exitosamente");
                    return;
                }
            }
        }
    }

    if (!encontrado) 
        System.out.println("Bus con patente " + patente + " no encontrado.");
    
}


    
    public void buscarBusYmostrarEmpresa(Bus bus)
    
    {
        if(listaBuses.contains(bus))
        {
            System.out.println("Bus:");
            System.out.println("Patente: "+bus.getPatente());
            System.out.println("Capacidad:"+bus.getCapacidad());
            System.out.println("Cantidad De Pasajeros Actuales:"+bus.getPasajerosActuales());
            
        }
        else System.out.println("Bus No esta en lista");
        

    }
    
    public Bus obtenerBusEmpresa(String patente)
    {
        for (Bus bus : listaBuses)
        {
            if (bus.getPatente().equals(patente)) 
        {
            return bus;
        }
            
        }

       
        System.out.println("Bus con patente " + patente + " no encontrado.");
    
      return null; 
    }
        
        
    
    
    
  
    public  void agregarRutaEmpresa(Ruta ruta)
    {  
        int idRuta;
        idRuta = ruta.getId();
       if(buscarRutaEnEmpresa(idRuta) == true) 
       {
           System.out.println("La Ruta De ID: "+idRuta+" Ya Esta en la empresa");
           
       }
       else
       {
           listaRutas.add(ruta);
           System.out.println("La Ruta de ID: "+idRuta+" Fue Agregada Exitosamente");
           
       }
           

    }
    
    
    public  void agregarRutaEmpresa(int id, String destino, double distancia)
    {  
       Ruta nuevaRuta = new Ruta(id,destino,distancia);
        
       if(buscarRutaEnEmpresa(id)) 
       {
           System.out.println("La Ruta De ID: "+id+" Ya Esta en la empresa");
           
       }
       else
       {
           listaRutas.add(nuevaRuta);
           System.out.println("La Ruta de ID: "+id+" Fue Agregada Exitosamente");
           
       }
           

    }
    
    public void agregarRutaEmpresa(List<Ruta> rutas)
    {
        int i;
       for(i = 0; i < rutas.size();i++)    
       {
           Ruta compRuta = rutas.get(i);
           if(buscarRutaEnEmpresa(compRuta))
           {
               System.out.println("La Ruta : "+compRuta.getId()+" Ya Esta en la empresa!!");
           }
           else
           {
               
               listaRutas.add(compRuta);
               System.out.println("La Ruta : "+compRuta.getId()+" Fue Agregada Exitosamente");
               
               
           }
       }
    }
    
    
    public  void agregarRutaEmpresa(int id, String destino, double distancia,List<Bus> busesR)
    {  
       Ruta nuevaRuta = new Ruta(id,destino,distancia);
       
      for(int i = 0; i < busesR.size();i++)
      {
          Bus nuevoB = busesR.get(i);
          nuevaRuta.setBuses(nuevoB);
      }
        
       if(buscarRutaEnEmpresa(id)) 
       {
           System.out.println("La Ruta De ID: "+id+" Ya Esta en la empresa");
           
       }
       else
       {
           listaRutas.add(nuevaRuta);
             System.out.println("La Ruta de ID: "+id+" Fue Agregada Exitosamente");
           
       }
           

    }
    public  void agregarRutaEmpresa(int id, String destino, double distancia,Bus busesR)
    {  
       Ruta nuevaRuta = new Ruta(id,destino,distancia);
       nuevaRuta.setBuses(busesR);
     
        
       if(buscarRutaEnEmpresa(id)) 
       {
           System.out.println("La Ruta De ID: "+id+" Ya Esta en la empresa");
           
       }
       else
       {
           listaRutas.add(nuevaRuta);
           System.out.println("La Ruta de ID: "+id+" Fue Agregada Exitosamente");
       }
           

    }
    
    
    
    
    
  


    public  void eliminarRutaEmpresa(int id)
    {
        
        int i;
        Ruta compararR;
        if(buscarRutaEnEmpresa(id))
        {
            for(i = 0; i < listaRutas.size();i++)
            {
            compararR = listaRutas.get(i);
            if(compararR.getId() == id)
            {
                listaRutas.remove(i);
                return;
            }
               
            }
        
        } 
        else
        {
            System.out.println("La Ruta No esta registrada por ende no puede ser eliminada");
        }
    }
    
    
    public void eliminarRutaEmpresa(Ruta rutaAEliminar)
    {
        
        if(listaRutas.contains(rutaAEliminar))
        {
            listaRutas.remove(rutaAEliminar);
            System.out.println("La Ruta fue Eliminada con exito");
           
            
        }
        else
        {
            System.out.println("La Ruta No esta registrada por ende no puede ser eliminada");
           
        }
        
    }

    public  void modificarRutaEmpresa(int idRuta,String nuevoDestino,double nuevaDistancia)
    {
        
        if(buscarRutaEnEmpresa(idRuta))
        {
            for(Ruta ruta : listaRutas)
            {
              
                if(ruta.getId() == idRuta)
                {

                    ruta.setDestino(nuevoDestino);
                    ruta.setDistancia(nuevaDistancia);
                    System.out.println("Ruta modificada exitosamente.");
                    return;
                }               
            }              
        }
        else
        {
            System.out.println("Ruta No Encontrada.");
        }
        
    }
    
    
    
    
    public boolean  buscarRutaEnEmpresa(int IdRuta)
    { 
        for(Ruta ruta : listaRutas)
        {      
            if(ruta.getId() == IdRuta)
            {
                return true;
            }   
        }
        return false;
        
    }
     public boolean  buscarRutaEnEmpresa(Ruta ruta)
    {   
        return listaRutas.contains(ruta);
     
    }
     
     public Ruta obtenerRuta(int idBuscado)
     {
        if(buscarRutaEnEmpresa(idBuscado))
        {
            int i;
            for(i = 0; i < listaRutas.size();i++)
            {
               Ruta buscado = listaRutas.get(i);
               if(buscado.getId() == idBuscado)
               {
                   Ruta ruta = listaRutas.get(i);
                  
                   return ruta;
               }
            }
        }
        else
        {
            System.out.println("La Ruta No esta Registrada en la Empresa\n");
            return null;
        }
         return null;
     } 
     
     public void inicializarDatosPorDefecto() 
        {
            agregarRutaEmpresa(101, "Santiago", 400.0);
            agregarRutaEmpresa(202, "Valparaí¿iso", 120.0);
            agregarRutaEmpresa(303, "Concepción", 500.0);
            agregarRutaEmpresa(404, "La Serena", 470.0);
            agregarRutaEmpresa(505, "Antofagasta", 1300.0);
            agregarRutaEmpresa(606, "Iquique", 1500.0);
            agregarRutaEmpresa(707, "Puerto Montt", 1000.0);
            agregarRutaEmpresa(808, "Temuco", 800.0);
                    
                    
            agregarBusEmpresa("ABC123", 44, 20, 5000, 101);
            agregarBusEmpresa("XYZ789", 50, 40, 7000, 202);
            agregarBusEmpresa("LMN456", 30, 15, 3000, 303);
            agregarBusEmpresa("DEF101", 60, 50, 9000, 404);
            agregarBusEmpresa("GHI202", 40, 35, 6000, 505);
            agregarBusEmpresa("JKL303", 35, 30, 6500, 606);
            agregarBusEmpresa("MNO404", 45, 25, 4000, 707);
            agregarBusEmpresa("PQR505", 55, 45, 8500, 808);


           


            Pasajero pasajero1 = new Pasajero("12345678-9", "Juan Perez");
            Pasajero pasajero2 = new Pasajero("98765432-1", "Maria Gonzalez");
            Pasajero pasajero3 = new Pasajero("11223344-5", "Carlos Sanchez");
            Pasajero pasajero4 = new Pasajero("12312312-6", "Ana Lopez");
            Pasajero pasajero5 = new Pasajero("45678912-3", "Pedro Romero");
            Pasajero pasajero6 = new Pasajero("78912345-0", "Luis Fernandez");
            Pasajero pasajero7 = new Pasajero("23456789-8", "Marta Salinas");
            Pasajero pasajero8 = new Pasajero("87654321-2", "Jorge Valdes");
            Pasajero pasajero9 = new Pasajero("34567890-7", "Clara Ortiz");
            Pasajero pasajero10 = new Pasajero("56789012-3", "Roberto Gutierrez");

            listaPasajeros.add(pasajero1);
            listaPasajeros.add(pasajero2);
            listaPasajeros.add(pasajero3);
            listaPasajeros.add(pasajero4);
            listaPasajeros.add(pasajero5);
            listaPasajeros.add(pasajero6);
            listaPasajeros.add(pasajero7);
            listaPasajeros.add(pasajero8);
            listaPasajeros.add(pasajero9);
            listaPasajeros.add(pasajero10);


            Bus bus1 = obtenerBusEmpresa("ABC123");
            Bus bus2 = obtenerBusEmpresa("XYZ789");
            Bus bus3 = obtenerBusEmpresa("LMN456");
            Bus bus4 = obtenerBusEmpresa("DEF101");
            Bus bus5 = obtenerBusEmpresa("GHI202");
            Bus bus6 = obtenerBusEmpresa("JKL303");
            Bus bus7 = obtenerBusEmpresa("MNO404");
            Bus bus8 = obtenerBusEmpresa("PQR505");

            if (bus1 != null) {
                bus1.asignarPasajero(pasajero1);
                bus1.asignarPasajero(pasajero2);
            }

            if (bus2 != null) {
                bus2.asignarPasajero(pasajero3);
                bus2.asignarPasajero(pasajero4);
                bus2.asignarPasajero(pasajero5);
            }

            if (bus3 != null) {
                bus3.asignarPasajero(pasajero6);
                bus3.asignarPasajero(pasajero7);
            }

            if (bus4 != null) {
                bus4.asignarPasajero(pasajero8);
                bus4.asignarPasajero(pasajero9);
            }

            if (bus5 != null) {
                bus5.asignarPasajero(pasajero10);
            }

            if (bus6 != null) {
                bus6.asignarPasajero(pasajero1);
            }

            if (bus7 != null) {
                bus7.asignarPasajero(pasajero2);
            }

            if (bus8 != null) {
                bus8.asignarPasajero(pasajero3);
            }

            
            Ruta ruta1 = obtenerRuta(101);
            Ruta ruta2 = obtenerRuta(202);
            Ruta ruta3 = obtenerRuta(303);
            Ruta ruta4 = obtenerRuta(404);
            Ruta ruta5 = obtenerRuta(505);
            Ruta ruta6 = obtenerRuta(606);
            Ruta ruta7 = obtenerRuta(707);
            Ruta ruta8 = obtenerRuta(808);

            if (ruta1 != null) {
                
                ruta1.agregarHorario(LocalDate.of(2024, 9, 10), LocalDateTime.of(2024, 9, 10, 8, 0));
                ruta1.agregarHorario(LocalDate.of(2024, 9, 11), LocalDateTime.of(2024, 9, 11, 9, 0));
            }

            if (ruta2 != null) 
            {
                ruta2.agregarHorario(LocalDate.of(2024, 9, 12), LocalDateTime.of(2024, 9, 12, 14, 0));
                ruta2.agregarHorario(LocalDate.of(2024, 9, 13), LocalDateTime.of(2024, 9, 13, 15, 30));
            }

            if (ruta3 != null) 
            {
                ruta3.agregarHorario(LocalDate.of(2024, 9, 15), LocalDateTime.of(2024, 9, 15, 9, 0));
                ruta3.agregarHorario(LocalDate.of(2024, 9, 16), LocalDateTime.of(2024, 9, 16, 10, 0));
            }

            if (ruta4 != null)
            {
                ruta4.agregarHorario(LocalDate.of(2024, 9, 17), LocalDateTime.of(2024, 9, 17, 8, 30));
            }

            if (ruta5 != null) 
            {
                ruta5.agregarHorario(LocalDate.of(2024, 9, 20), LocalDateTime.of(2024, 9, 20, 7, 0));
            }

            if (ruta6 != null) 
            {
                ruta6.agregarHorario(LocalDate.of(2024, 9, 21), LocalDateTime.of(2024, 9, 21, 8, 0));
            }

            if (ruta7 != null) 
            {
                ruta7.agregarHorario(LocalDate.of(2024, 9, 22), LocalDateTime.of(2024, 9, 22, 9, 30));
            }

            if (ruta8 != null) 
            {
                ruta8.agregarHorario(LocalDate.of(2024, 9, 23), LocalDateTime.of(2024, 9, 23, 10, 0));
            }

        System.out.println("Datos predeterminados cargados exitosamente.");
    }
     
     
      public boolean calcularViabilidadViaje(Ruta ruta, double precioCombustible, double costoPapeleo, double ingresoPasajero) 
      {
        double distancia = ruta.getDistancia();
        double costoCombustible = calcularCostoCombustible(distancia, precioCombustible);
        double costoTotal = costoCombustible + costoPapeleo;

        double ingresoTotal = ingresoPasajero * ruta.getBuses().size();


        return ingresoTotal > costoTotal;
    }

    private double calcularCostoCombustible(double distancia, double precioCombustible) 
    {
        
        double consumoPorLitro = 5.0;
        return (distancia / consumoPorLitro) * precioCombustible;
    }
   
}