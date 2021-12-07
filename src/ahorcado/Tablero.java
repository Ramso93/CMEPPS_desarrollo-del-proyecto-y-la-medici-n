/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.util.ArrayList;

/**
 *
 * @author Ramso
 */
public class Tablero {
    private String[] adivinarWord;
    private String[] wordAdivinado;
    
    public Tablero(String word){
        adivinarWord = word.split("");
        wordAdivinado = new String[adivinarWord.length];
        //System.out.println("new tablero\n"+adivinarWord.toString()+"\n"+wordAdivinado.toString());
        limpiar();
    }
    public void limpiar(){
        //System.out.println("limpio");
        for(int i = 0; i<wordAdivinado.length; i++){
            wordAdivinado[i] = "";
        }
    }
    public void imprimir(){
        for(int i = 0; i<wordAdivinado.length; i++){
            if(wordAdivinado[i].equals("")){
                System.out.print("* ");
            }else{
                System.out.print(wordAdivinado[i]+" ");
            }
        }
        System.out.println("");
    }
    public void verificar(String letra){
        for(int i = 0; i<wordAdivinado.length; i++){
            if(adivinarWord[i].equalsIgnoreCase(letra)){
                wordAdivinado[i] = letra;
            }
        }
    }
    public int numOportunidades(){
        return adivinarWord.length;
    }
    public boolean verificarGanador(){
        boolean ganador = true;
        for(int i = 0; i<wordAdivinado.length; i++){
            if(wordAdivinado[i].equals("")){
                ganador = false;
            }
        }
        return ganador;
    }
}
