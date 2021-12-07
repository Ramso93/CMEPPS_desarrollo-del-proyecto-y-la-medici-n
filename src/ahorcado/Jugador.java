/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Ramso
 */
public class Jugador {
    private String nombre;
    public Jugador(String nombre){
        this.nombre = nombre;
    }
    
    public String pedirLetra(){
        String letra="";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println(nombre+" Introduzca letra: ");
            letra = br.readLine();
        } catch (Exception e) {}
        return letra;
    }
}
