package semaforos;

/**
 *
 * @author Bron
 */
public class Escritor extends Thread {

    /**
     * La clase escritor sólo podrá escribir el libro de 1 en 1 ya que estamos
     * en una región crítica con variables compartidas tal y como pone el
     * enunciado.
     */
    private int identEscritor;
    private Libro libro;
    private Gestion gestion;

    public Escritor(int identEscritor, Libro libro, Gestion gestion) {

        /**
         * Constructor de la clase Escritor, tenemos los atributos identificador
         * del escritor y luego le pasamos el libro y la gestión del libro por
         * si tenemos que parar
         */
        this.identEscritor = identEscritor;
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

        /**
         * Aquí tenemos todas las acciones que se piden en el enunciado con
         * respecto a los escritores.
         */
        
        for (int i = 0; i < 5; i++) {
            gestion.parar();
            Esperar(1000, 1000);
            gestion.parar();
            libro.escribirLibro(identEscritor);
            gestion.parar();
            Esperar(100, 0);
            libro.terminarEscribir(identEscritor);
        }
    }
}
