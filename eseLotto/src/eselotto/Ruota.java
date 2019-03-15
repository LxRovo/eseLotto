/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

/**
 *
 * @author rovelli_andrea
 */
public class Ruota {

    private String nome;
    private int maxElem;
    private int[] estratti;
    

    public Ruota() {
        
        this.nome = "";
        this.maxElem = 5;
        estratti = new int[maxElem];
        for (int i = 0; i < maxElem; i++) {
            estratti[i] = 0;
        }
    }
    
    public Ruota(String nome) {
        
        this.nome = nome;
        this.maxElem = 5;
        estratti = new int[maxElem];
        for (int i = 0; i < maxElem; i++) {
            estratti[i] = 0;
        }
    }

   

    

    public synchronized int[] getEstratti() {
        return estratti;
    }

    public synchronized void setEstratti(int[] estratti) {
        this.estratti = estratti;
    }

}
