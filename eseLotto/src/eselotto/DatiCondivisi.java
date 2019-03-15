/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rovelli_andrea
 */
public class DatiCondivisi {

    private Semaphore s1, s2, s3,s4;
    private Ruota r;
    private int maxElem, primo, secondo, nEstrazioni, vincite;
    private boolean trovatoPrimo, trovatoSecondo;

    public DatiCondivisi(int nEstrazioni, int primo, int secondo, Semaphore s1, Semaphore s2, Semaphore s3,Semaphore s4) {
        this.nEstrazioni = nEstrazioni;
        this.r = new Ruota("Milano");
        maxElem = 5;
        this.primo = primo;
        this.secondo = secondo;
        this.trovatoPrimo = false;
        this.trovatoSecondo = false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.vincite = 0;

    }

    public synchronized Ruota getR() {
        return r;
    }

    public synchronized int getnEstrazioni() {
        return nEstrazioni;
    }

    public synchronized int getMaxElem() {
        return maxElem;
    }

    public synchronized int getPrimo() {
        return primo;
    }

    public synchronized int getSecondo() {
        return secondo;
    }

    public synchronized boolean isTrovatoPrimo() {
        return trovatoPrimo;
    }

    public synchronized void setTrovatoPrimo(boolean trovatoPrimo) {
        this.trovatoPrimo = trovatoPrimo;
    }

    public synchronized boolean isTrovatoSecondo() {
        return trovatoSecondo;
    }

    public synchronized void setTrovatoSecondo(boolean trovatoSecondo) {
        this.trovatoSecondo = trovatoSecondo;
    }

    public synchronized void waitSem1() {
        try {
            s1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void signalSem1() {
        s1.release();
    }

    public synchronized void waitSem2() {
        try {
            s2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void signalSem2() {
        s2.release();
    }
    
    public synchronized void waitSem3() {
        try {
            s3.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void signalSem3() {
        s3.release();
    }
    
    public synchronized void waitSem4() {
        try {
            s4.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void signalSem4() {
        s4.release();
    }

    public void azzeraDati() {
        int t[] = new int[maxElem];
        this.r.setEstratti(t);
    }

    
    public void controllaVincita(){
        
        if(trovatoPrimo == true && trovatoSecondo == true){
            vincite++;
        }
    }

    public synchronized int getVincite() {
        return vincite;
    }
    
    
    
}
