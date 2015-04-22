package semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron
 */
public class Gestion {

    /**
     * Esta clase es la que gestiona los botones de reanudar y parar.
     */
    private Semaphore semaforo;
    public boolean pausar;

    public Gestion() {
        semaforo = new Semaphore(1, true);
    }

    public void reanudar() {

        /*
         * Si pulsamos el botón reanudar pondremos pausar a falso y el programa
         * continuará, liberamos el semáforo.
         */

        pausar = false;
        semaforo.release();
    }

    public void detener() {

        /**
         * Si pulsamos el botón detener, pondremos pausar a true y activaremos
         * el semáforo.
         */
        try {
            semaforo.acquire();
            pausar = true;
        } catch (InterruptedException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void parar() {

        /*
         * Analizamos la condicion de pausar. Si es true activamos el semáforo y
         * a continuación lo liberamos..
         */

        if (pausar) {
            try {
                semaforo.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
            }
            semaforo.release();
        }
    }
}
