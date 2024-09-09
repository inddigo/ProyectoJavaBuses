
import java.io.*;
import java.util.*;
import java.time.format.*;
import java.time.*;


public class SIAP 
{

   
    public static void main (String arg[]) throws IOException{
        

        Scanner input = new Scanner(System.in);
        
        
        Empresa nuevaEmpresa = new Empresa();
        nuevaEmpresa.inicializarDatosPorDefecto();
        
        
        
        int opcion;
        
        do
        {
            menuOpciones(nuevaEmpresa);
            System.out.println("Desea Seguir Con las Operaciones?");
            System.out.println("1.SI");
            System.out.println("2.No");
            opcion = input.nextInt();
            input.nextLine();
            
            
            
        }while(opcion != 2);




    }

    public static void menuOpciones(Empresa empresa)
    {


        Scanner input = new Scanner(System.in);
         
        System.out.println();
        System.out.println("(ID SOLO EN NUMEROS)");
        System.out.println("Que opcion desea");
        System.out.println("1.Menu Buses");
        System.out.println("2.Menu Rutas");
        System.out.println("3.Menu pasajeros");
        System.out.println("4.Menu Horarios");
        System.out.println("5.Menu Listar");
        System.out.println("6.Calcular Viabilidad Ruta");
        
       
        int opcion = input.nextInt();
        input.nextLine();

        switch(opcion){

            case 1:

                menuPrimarios(empresa);
                break;

            case 2:

                menuRutasPrimario(empresa);
                break;


            case 3:

                menuPasajeros(empresa);
                 break;

            case 4:
                menuHorarios(empresa);
                 break;
            
                 
            case 5:
            {
                menuListarDatos(empresa);
                break;
                
            }
            
            case 6:
            {
                 
                esViableElViaje(empresa);
                break;
                
            }
            
            default:
                
                break;
        }




    }



    public static void menuPrimarios(Empresa empresa)
    {
       
        Scanner input  = new Scanner(System.in);

        System.out.println("Que opcion desea");
        System.out.println("1.Agregar Bus");
        System.out.println("2.Eliminar Bus");
        System.out.println("3.Modificar Bus");
        System.out.println("4.Buscar Y Mostrar Bus");
        

        int opcion = input.nextInt();
        input.nextLine();


        switch(opcion)
                {

            case 1:
            {
                agregarBus(empresa);
                break;
            }   
                
            case 2:
            {
                eliminarBus(empresa);
                break;
            }
                    
                
                
            case 3:
            {
                modificarBus(empresa);
                break;
            }
                
            case 4:
            {
                buscarBusYmostrar(empresa);
                break;
            }
                
           

            default:
                break;
        }
    }

    public static void agregarBus(Empresa empresa)
    {
        

        Scanner input  = new Scanner(System.in);

        Bus bus  = new Bus();
        
        int idRuta;
        
        System.out.println("Ingrese ID de la ruta en la cual ira el bus");
        idRuta = input.nextInt();
        input.nextLine();
        if(empresa.buscarRutaEnEmpresa(idRuta))
        {
            
            System.out.println("Ingrese Patente");
            String patente = input.next();
            input.nextLine();

            bus.setPatente(patente);
         
            empresa.agregarBusEmpresa(bus, idRuta);           
        }
        else
        {
            System.out.println("Ruta No Encontrada");
            
        }

    }

    public static void eliminarBus(Empresa empresa)
    {
        Scanner input  = new Scanner(System.in);
        
        System.out.println("Ingrese Patente del bus a eliminar");
        
        String patente = input.next();
        input.nextLine();
        
        Bus busAEliminar = empresa.obtenerBusEmpresa(patente);
        
        empresa.eliminarBusEmpresa(busAEliminar);

    }

    public static void modificarBus(Empresa empresa)
    {
        Scanner input  = new Scanner(System.in);
       
        System.out.println("Ingrese Patente del bus a  modificar");
        
        
        String patente = input.next();
        input.nextLine();
        
        System.out.println("Ingrese Nueva Capacidad del bus");
        int nuevaCapacidad = input.nextInt();
        input.nextLine();

        System.out.println("Ingrese Nueva cantidad De Pasajeros Actuales del bus");
        int nuevosPasajeros = input.nextInt();
        input.nextLine();

        System.out.println("Ingrese nuevo Costo de Mantencion del bus");
        double nuevoCostoMantencion = input.nextDouble();
        input.nextLine();
        
        empresa.modificarBus(patente, nuevaCapacidad, nuevosPasajeros, nuevoCostoMantencion);
        

        

    }

    public static void buscarBusYmostrar(Empresa empresa)
    {
        Scanner input  = new Scanner(System.in);
           
        System.out.println("Ingrese Patente del bus a  Mostrar");
        
        String patente = input.next();
        input.nextLine();
        
        Bus busBuscado = empresa.obtenerBusEmpresa(patente);
        
        empresa.buscarBusYmostrarEmpresa(busBuscado);


    }







    public static void menuRutasPrimario(Empresa empresa)
    {

        Scanner input = new Scanner(System.in);
        
       


        System.out.println("Que opcion desea");
        System.out.println("1.Agregar Ruta");
        System.out.println("2.Eliminar Ruta");
        System.out.println("3.Modificar Ruta");
        System.out.println("4.Buscar Ruta");
        
        int opcion = input.nextInt();
        input.nextLine();
        
        
        switch(opcion)
        {

            case 1:
                agregarRuta(empresa);
                break;
               

            case 2:
                eliminarRuta(empresa);
                break;

                

            case 3:

                modificarRuta(empresa);
                break;

                


            case 4:

                buscarRuta(empresa);
                break;

                
           
            default:
                break;

        }
        

    }

    
    public static void agregarRuta(Empresa empresa)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la ID de la ruta");
        int idNuevo = input.nextInt();
        input.nextLine();


        System.out.println("Ingrese el destino de la ruta");
        String nuevoDestino = input.next();
        input.nextLine();

        System.out.println("Ingrese la distancia");
        
        double nuevaDistancia = input.nextDouble();
        
        input.nextLine();
        
        empresa.agregarRutaEmpresa(idNuevo, nuevoDestino, nuevaDistancia);
    
    }


    public static void eliminarRuta(Empresa empresa)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la ID de la ruta a eliminar");
        int idAEliminar = input.nextInt();
        input.nextLine();

        empresa.eliminarRutaEmpresa(idAEliminar);


    }

    public static void modificarRuta(Empresa empresa)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la ID de la ruta");
        int idNuevo = input.nextInt();
        input.nextLine();
        if(empresa.buscarRutaEnEmpresa(idNuevo))
        {
            System.out.println("Ingrese el destino de la ruta");
            String nuevoDestino = input.next();
            input.nextLine();

            System.out.println("Ingrese la distancia\n\n");
            double nuevaDistancia = input.nextDouble();
            input.nextLine();
            empresa.modificarRutaEmpresa(idNuevo, nuevoDestino, nuevaDistancia);
        
            
        }
        else System.out.println("ID NO ENCONTRADA");


      
        

    }

    public static void buscarRuta(Empresa empresa)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la ID de la ruta");
        int idRutaBuscar = input.nextInt(); 
        Ruta ruta;
        ruta = empresa.obtenerRuta(idRutaBuscar);
        if(ruta != null)
        {
            System.out.println("ID de La Ruta:"+ruta.getId());
            System.out.println("Destino:"+ruta.getDestino());
            System.out.println("Distacia:"+ruta.getDistancia());
            System.out.println(ruta.getBuses());
        }
        
       
                
    }


    public static void menuPasajeros(Empresa empresa)
    {

        Scanner input = new Scanner(System.in);
        
        System.out.println("Que Opcion Desea:");
        
        System.out.println("1.Agregar Pasajero");
        
        int opcion = input.nextInt();
        input.nextLine();

        

        switch(opcion)
        {

            case 1:
            {
                int id;
                System.out.println("Ingrese el ID de la ruta");
                id = input.nextInt();
                input.nextLine();
                Ruta ruta = empresa.obtenerRuta(id);
                if(ruta != null)
                {
                    String patente;
                    System.out.println("Ingrese el La Patente del Bus");
                    patente = input.next();
                    input.nextLine();
                
                    Bus bus = empresa.obtenerBusEmpresa(patente);
                    if(bus!=null)
                    {
                        crearPasajero(input,ruta,bus);
                           
                    }
                
                    
                }
              
                
                
                break;
            }
                



        }




    }
    
    public static void menuListarDatos(Empresa empresa) {
    Scanner input = new Scanner(System.in);
    int opcion;
    
    do {
        System.out.println("Que datos desea listar");
        System.out.println("1. Listar Buses");
        System.out.println("2. Listar Rutas");
        System.out.println("3. Listar Pasajeros");
        System.out.println("4. Salir");

        opcion = input.nextInt();
        input.nextLine();

        switch(opcion) {
            case 1:
                listarBuses(empresa);
                break;
            case 2:
                listarRutas(empresa);
                break;
            case 3:
                listarPasajeros(empresa);
                break;
            case 4:
                System.out.println("Saliendo del menu de listar datos...");
                break;
            default:
                System.out.println("Opcion no valida. Por favor, intente nuevamente.");
        }
    } while (opcion != 4);
}
public static void listarPasajeros(Empresa empresa) 
{
    System.out.println("Pasajeros en la empresa:");
    
    for (Pasajero pasajero : empresa.getListaPasajeros()) 
    {
        System.out.println("Nombre: " + pasajero.getNombre() + ", RUT: " + pasajero.getRut());
    }
    System.out.println("----------------------------");
}

public static void listarRutas(Empresa empresa) 
{
    System.out.println("Rutas en la empresa:");
    for (Ruta ruta : empresa.getListaRutas()) 
    {
        System.out.println("ID de Ruta: " + ruta.getId());
        
        System.out.println("Destino: " + ruta.getDestino());
        
        System.out.println("Distancia: " + ruta.getDistancia() + " km");
        
        System.out.println("Buses en esta ruta:");
        
        for (Bus bus : ruta.getBuses()) 
        {
            System.out.println(" - Bus Patente: " + bus.getPatente());
        }

        System.out.println("Horarios:");
        for (Map.Entry<LocalDate, List<LocalDateTime>> entry : ruta.getHorariosPorFecha().entrySet())
        {
            LocalDate fecha = entry.getKey();
            
            List<LocalDateTime> horarios = entry.getValue();
            
            System.out.println(" - Fecha: " + fecha + ", Horarios: ");
            
            for (LocalDateTime horario : horarios) 
            {
                System.out.println("   * " + horario.toLocalTime());
            }
        }
        System.out.println("----------------------------");
    }
}

public static void listarBuses(Empresa empresa) 
{
    System.out.println("Buses en la empresa:");
    for (Bus bus : empresa.getListaBuses())
    {
        System.out.println("Patente: " + bus.getPatente());
        
        System.out.println("Capacidad: " + bus.getCapacidad());
        
        System.out.println("Pasajeros Actuales: " + bus.getPasajerosActuales());
        
        System.out.println("Costo de Mantencion: " + bus.getCostoMantencion());
        
        System.out.println("Pasajeros en el Bus:");
        
        for (Pasajero pasajero : bus.getMapaBus().values()) 
        {
            System.out.println(" - Pasajero: " + pasajero.getNombre() + ", RUT: " + pasajero.getRut());
        }
        System.out.println("----------------------------");
    }
}







    public static void esViableElViaje(Empresa empresa)
    {
        Scanner input =new Scanner(System.in);
        int id;
        double precioCombustible = 800.0;
        double costoPapeleo = 5000.0;
        double ingresoPasajero = 10000.0;

        System.out.println("Ingrese el ID de la ruta");
        id = input.nextInt();
        input.nextLine();
        Ruta ruta = empresa.obtenerRuta(id);
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

    private static void menuHorarios(Empresa empresa) 
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Que Opcion Desea:");
        
        System.out.println("1.Agregar Horarios");
        System.out.println("2.Consultar Horarios");
        
        int opcion = input.nextInt();
        input.nextLine();

        

        switch(opcion)
        {

            case 1:
            {
                int id;
                System.out.println("Ingrese el ID de la ruta a agregar horario");
                id = input.nextInt();
                input.nextLine();
                Ruta ruta = empresa.obtenerRuta(id);
                if(ruta != null)
                {
                    
                    agregarHorarios(ruta);
                    
                }
                
                
                break;
            }
            case 2:
            {
                int id;
                System.out.println("Ingrese el ID de la ruta para consultar sus horarios");
                id = input.nextInt();
                input.nextLine();
                Ruta ruta = empresa.obtenerRuta(id);
                if(ruta != null)
                {
                    consultarHorarios(ruta,input);
                }
                
                break;
                        
            }
                



        }
        
        
        
        
        
    }
    
    public static void crearTicket(Ticket ticket)
    {

        Scanner input =new Scanner(System.in);
        LocalDate fecha;

        System.out.println("Ingrese los Datos del Pasajero");

    }



    public static void agregarHorarios(Ruta ruta)
    {
        

        Scanner input = new Scanner(System.in);
        DateTimeFormatter fechaformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter tiempoFormatter = DateTimeFormatter.ofPattern("HH:mm");

        String respuesta;
        boolean continuar = true;


        while(continuar)
        {
            try 
            {

                System.out.println("Ingrese la fecha del horario (dd/MM/yyyy):");
                String inputFecha = input.nextLine();
                LocalDate fecha = LocalDate.parse(inputFecha, fechaformatter);

                System.out.println("Ingrse la hora del horario (HH:mm):");
                String inputHora = input.nextLine();
                LocalTime hora = LocalTime.parse(inputHora, tiempoFormatter);
                LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);
                ruta.agregarHorario(fecha, fechaHora);

                System.out.println("Desea agregar otro horario");
                respuesta = input.nextLine();

                if(respuesta.equalsIgnoreCase("no")){
                    continuar = false;
                }


            } catch (Exception e) {
                System.out.println("Error al ingresar datos. Por favor, intente denuevo");
            }
        }
    }

    public static void consultarHorarios(Ruta ruta, Scanner input)
    {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Ingrese la fecha de viaje para consultar horario (dd/mm/yyyy):");
        String inputFechaConsulta = input.nextLine();



        LocalDate fechaConsulta = LocalDate.parse(inputFechaConsulta, dateFormatter);


        List<LocalDateTime> horarios = ruta.getHorarios(fechaConsulta);

        if(horarios.isEmpty())
        {

            System.out.println("no hay horarios para esa fecha");
        }

        else
        {
            System.out.println("Horarios disponibles para" +fechaConsulta+":");
            for(LocalDateTime horario : horarios){

                System.out.println(horario.toLocalTime());
            }
        }
    }

    
public static void crearPasajero(Scanner input, Ruta ruta, Bus bus) 
{
    LocalDateTime horaVenta = LocalDateTime.now();
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

