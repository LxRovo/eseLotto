/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author rovelli_andrea
 */
public class EseLotto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        Semaphore s4 = new Semaphore(-2);
        System.out.println("Inserire il numero di estrazioni che si desidera simulare");
        int nEstrazioni = input.nextInt();
        
        while(nEstrazioni <= 0){
            System.out.println("Scelta non valida, reinserire");
            nEstrazioni = input.nextInt();
        }
        
        System.out.println("Inserire il primo numero che si vuole scommettere");
        int primoNum = input.nextInt();
        
        while(primoNum < 1 && primoNum > 90 ){
            System.out.println("Scelta non valida, reinserire");
            primoNum = input.nextInt();
        }
        
        System.out.println("Inserire il secondo numero che si vuole scommettere");
        int secondoNum = input.nextInt();
        
        while(secondoNum < 1 && secondoNum > 90 && secondoNum != primoNum){
            System.out.println("Scelta non valida, reinserire");
            secondoNum = input.nextInt();
        }
        
        DatiCondivisi dati = new DatiCondivisi(nEstrazioni,primoNum,secondoNum,s1,s2,s3,s4);
        ThEstrai th1 = new ThEstrai(dati);
        ThCercaPrimo th2 = new ThCercaPrimo(dati);
        ThCercaSecondo th3 = new ThCercaSecondo(dati);
        
        th1.start();
        th2.start();
        th3.start();
        dati.waitSem4();
        System.out.println("Hai effettuato "+dati.getVincite()+" vincite");
        
    }
    
}
