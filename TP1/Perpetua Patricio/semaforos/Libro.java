package semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bron
 */
public class Libro {

    /**
     * Esta clase libro es la variable compartida y por tanto, la que tenemos
     * que proteger de lectores/escritores para que el programa funcione
     * satisfactoriamente.
     *
     * Creamos todos los atributos necesarios para que el programa funcione,
     * incluyendo los locks para gestionar la entrada y salida de los escritores
     */
    private String libro;
    private Interfaz interfaz;
    private int lecturas;
    private Semaphore semaforoA;

    /**
     *
     * @param interfaz
     */
    public Libro(Interfaz interfaz, Semaphore semaforo) {

        /**
         * Creamos el constructor y inicializamos a lo que queremos.
         */
        this.interfaz = interfaz;
        libro = "";
        lecturas = 0;
        semaforoA = semaforo;
    }

    public void leerLibro(int identificador) {

        /*
         * Adquirimos sólo un semáforo porque pueden leer simultáneamente varios
         * lectores
         */

        try {
            semaforoA.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }

        interfaz.meterDatos(1, interfaz.leerDatos(1) + "" + identificador + " ");
        lecturas++;

        /*
         * Liberamos a los semáforos.
         */
    }

    public boolean libroTerminado() {

        /**
         * Si el libro ha llegado a 50 habremos terminado de leer y devolvemos
         * un valor booleano.
         */
        if (libro.length() == 50) {
            return true;
        } else {
            return false;
        }
    }

    public void terminarLeer(int identificador) {

        /**
         * Este método se encarga de terminar de leer los datos, libera el
         * semaforo de lectura cuando hemos terminado.
         */
        interfaz.meterDatos(1, interfaz.leerDatos(1).replaceAll("" + identificador + " ", ""));
        if (libroTerminado()) {
            interfaz.meterDatos(4, interfaz.leerDatos(4) + "Leido por " + identificador + ": " + libro + "\n");
        }
        semaforoA.release();
    }

    public void escribirLibro(int identificador) {

        /**
         * Este método se encarga de escribir en el libro, la estructura es como
         * la de lectura. Adquirimos el semáforo entero porque mientras se
         * escribe no se puede leer.
         */
        try {
            semaforoA.acquire(15);
        } catch (InterruptedException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }

        libro = libro + identificador;
        interfaz.meterDatos(2, interfaz.leerDatos(2) + identificador);
        interfaz.meterDatos(3, libro);

        /*
         * Liberamos el semáforo.
         */
    }

    public void terminarEscribir(int identificador) {

        /**
         * Método que termina de escribir un libro. Liberamos el semáforo de
         * escritura.
         */
        interfaz.meterDatos(2, interfaz.leerDatos(2).replaceAll("" + identificador, ""));
        semaforoA.release(15);
    }
}
