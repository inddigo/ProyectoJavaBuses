package com.mycompany.siap;

// Clase que extiende de Exception
public class RutaNoEncontradaException extends Exception {
    
    // Constructor que recibe un mensaje
    public RutaNoEncontradaException(String mensaje) {
        super(mensaje); // Llama al constructor de la clase padre
    }

    // Constructor que recibe un mensaje y una causa
    public RutaNoEncontradaException(String mensaje, Throwable causa) {
        super(mensaje, causa); // Llama al constructor de la clase padre
    }
}
