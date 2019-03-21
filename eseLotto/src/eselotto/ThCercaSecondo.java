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
public class ThCercaSecondo extends Thread {

    private DatiCondivisi ptrDati;

    public ThCercaSecondo(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    @Override
    public void run() {
        
        
        int j = 1;
        int nEstrazioni = ptrDati.getnEstrazioni();

        while (j <= nEstrazioni) {
            
            ptrDati.waitSem2();
            
            Ruota r = ptrDati.getR();
            int secondo = ptrDati.getSecondo();
            int maxElem = ptrDati.getMaxElem();
            for (int i = 0; i < maxElem; i++) {
                if (r.getEstratti()[i] == secondo) {
                    ptrDati.setTrovatoSecondo(true);
                }
            }

            ptrDati.signalSem3();
            j++;
        }
        ptrDati.signalSem4();
    }

}
