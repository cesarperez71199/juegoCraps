/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craps;

import java.security.SecureRandom;

/**
 *
 * @author Cesar Perez
 */
public class Craps {
    

    /**
     * @param args the command line arguments
     */
    
    //Crea un generador de numeros aleatorios seguros para usarlo en el metodo tirarDado
    private static final SecureRandom numerosAleatorios= new SecureRandom();
    
    //Enumeracion con constantes que representan el estado del juego
    private enum Estado{Continua, GANO, PERDIO};
    
    
    //Constantes que representan tiros comunes del dado con los que perdera o ganara el juego en el primer tiro
    private static final int DOS_UNOS=2;
    private static final int TRES=3;
    private static final int SIETE=7;
    private static final int ONCE=11;
    private static final int DOCE=12;
    
        
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int miPunto=0;          //Si no gana o pierde en el primer tiro guardara el numero generado en miPunto
        Estado estadoJuego;     //puede contener CONTINUA, GANO O PERDIO
        
        int sumaDados= tirarDados();  //Primer tiro de dados
        
        
        //Determina el estado del juego y el punto con base en el primer tiro
        switch(sumaDados){
            
            case SIETE:     //gana con 7 en el primer tiro
            case ONCE:      //gana con 11 en el primer tiro
                estadoJuego= Estado.GANO;
                break;
                
            case DOS_UNOS:      //Pierde con 2 en el primer tiro
            case TRES:          //Pierde con 3 en primer tiro
            case DOCE:          //Pierde con 12 en el primer tiro
                estadoJuego= Estado.PERDIO;
                break;
                
            default:        //No gano ni perdio y guarda el numero en miPunto
                estadoJuego= Estado.Continua;   //Determina el estado del juego
                miPunto= sumaDados;            //Guarda el punto de los dados
                System.out.printf("El punto es %d%n", miPunto);
                break;
        }
        
        //mientras el juego no este terminado
        while (estadoJuego== Estado.Continua) {
            
            sumaDados= tirarDados();        //Tira los dados de nuevo
            
            //determina el estado del juego
            if (sumaDados== miPunto)        //Gana haciendo punto
                estadoJuego= Estado.GANO;
                
             else 
                if(sumaDados== SIETE)       //Pierde con 7 si sale antes de punto
                    estadoJuego= Estado.PERDIO;
            
        }
        
        //Muestra mensaje de que gano o perdio
        
        if(estadoJuego== Estado.GANO)
            System.out.println("El jugador gana");
        else
            System.out.println("El jugador pierde");
        
    }
    
    //Metodo que tira los dados, calcula la suma y muestra los resultado
    public static int tirarDados(){
        
        //Elige valores aleatorios para los dados
        int dado1= 1+ numerosAleatorios.nextInt(6);     //primer numero del dado
        int dado2= 1+ numerosAleatorios.nextInt(6);    // Segundo numero del dado
        
        int suma= dado1+ dado2;     //Suma los valores de los dos dados
        
        
        //Muestra los resultados de este tiro
        System.out.printf("El jugador tiro %d + %d = %d%n",dado1, dado2, suma);
        
        return suma;
        
    }
    
}
