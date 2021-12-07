/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ramso
 */
public class Jugar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Tablero tablero = null;
        Jugador gamer1 = new Jugador("Osmar");
        Jugador gamer2 = new Jugador("Ramso");
        boolean ganador = false;
        int turnoGamer = 1;    // 1:gamer1 2:gamer2
        int i = 0, oportunidades;
        int turnoAnt, totalPartidas = 5, mejorde5 = 0, totalGanadas1 = 0, totalGanadas2 = 0;
        int quienAdivina = 1;
        do{
            System.out.println("\tPartida numero "+mejorde5);
            String palabra="";
            switch(quienAdivina){
                case 1:
                    System.out.println("Jugador 1 Introduzca palabra: ");
                    palabra = br.readLine();
                    //tablero = new Tablero(palabra);
                    quienAdivina = 2;
                    break;
                case 2:
                    System.out.println("Jugador 2 Introduzca palabra: ");
                    palabra = br.readLine();
                    //tablero = new Tablero(palabra2);
                    quienAdivina = 1;
                    break;
            }
            tablero = new Tablero(palabra);
            //oportunidades = tablero.numOportunidades() * 2;
            oportunidades = 6;
            //System.out.println("oportunidades: "+oportunidades);
            tablero.imprimir();
            while(i<oportunidades && !ganador){
                String letra = "";
                turnoAnt = turnoGamer;
                switch(quienAdivina){
                    case 1: letra = gamer1.pedirLetra();
                        turnoGamer = 2;
                        break;
                    case 2: letra = gamer2.pedirLetra();
                        turnoGamer = 1;
                        break;
                }
                tablero.verificar(letra);
                tablero.imprimir();
                if(tablero.verificarGanador()){
                    ganador = true;
                    System.out.println("PALABRA ADIVINADA");
                }
                i++;
                //System.out.println("turno: "+i);
            }
            
            if(mejorde5%2==0){
                if(ganador){
                    totalGanadas2++;
                }
            }else{
                if(ganador){
                    totalGanadas1++;
                }
            }
            i = 0;
            ganador = false;
            mejorde5++;
        }while(mejorde5 < totalPartidas);
        
        System.out.println("Jugador 1 ha adivinado "+totalGanadas1+" palabra/s");
        System.out.println("Jugador 2 ha adivinado "+totalGanadas2+" palabra/s");
    }
    
}
