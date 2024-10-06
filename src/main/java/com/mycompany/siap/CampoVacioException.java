
package com.mycompany.siap;
import java.lang.*;
public class CampoVacioException extends Exception 
{
    // Constructor que acepta un mensaje de error
    public CampoVacioException(String mensaje) {
        super(mensaje);
    }
}
