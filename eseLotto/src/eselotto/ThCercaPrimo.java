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
public class ThCercaPrimo extends Thread {

    private DatiCondivisi ptrDati;

    public ThCercaPrimo(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    @Override
    public void run() {
        
        
        
        int j = 1;
        int nEstrazioni = ptrDati.getnEstrazioni();

        while (j <= nEstrazioni) {
            
            ptrDati.waitSem1();
            Ruota r = ptrDati.getR();
            int primo = ptrDati.getPrimo();
            int maxElem = ptrDati.getMaxElem();
            for (int i = 0; i < maxElem; i++) {
                if (r.getEstratti()[i] == primo) {
                    ptrDati.setTrovatoPrimo(true);
                }
            }

            ptrDati.signalSem3();
            j++;
        }
        ptrDati.signalSem4();
    }

}
