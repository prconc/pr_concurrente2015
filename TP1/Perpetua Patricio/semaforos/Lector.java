package semaforos;

/**
 *
 * @author Bron
 */
public class Lector extends Thread {

    /*
     * La clase lector se encargará de leer el libro, varios lectores pueden
     * leer el mismo libro simultáneamente.
     */
    private int identLector;
    private Libro libro;
    private Gestion gestion;

    public Lector(int identLector, Libro libro, Gestion gestion) {

        /**
         * Constructor de la clase lectores con atributos identificador, y las
         * clases libro y gestion.
         */
        this.identLector = identLector;
        this.libro = libro;
        this.gestion = gestion;
    }

    private void Esperar(int min, int max) {

        /*
         * Nos encargamos de proporcionar un tiempo aleatorio, creamos esta
         * función por comodidad y porque ya estaba en ejercicios anteriores.
         */

        try {
            sleep(min + (int) (max * Math.random()));
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {

        /*
         * El método run se ejecutará mientras que el libro no esté terminado.
         * La funcionalidad es la que se pide en el enunciado, con cada acción
         * llamamos a gestion.parar por si hemos pulsado el botón de pausa.
         */

        while (libro.libroTerminado() == false) {
            gestion.parar();
            Esperar(1000, 1000);
            gestion.parar();
            libro.leerLibro(identLector);
            gestion.parar();
            Esperar(500, 1000);
            gestion.parar();
            libro.terminarLeer(identLector);
        }
    }
}
