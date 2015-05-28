package clases;

public class Redes 
{
    private int[][] iMarcado;
    private int[][] iIncidencia;
    String sNuevoMarcado;
    
    public Redes(int[][] iMarcado, int[][] iIncidencia)
    {
        this.iMarcado = iMarcado;
        this.iIncidencia = iIncidencia;
    }

    public boolean ejecutar(int[][] iDisparo)
    {
        //Definición de las matrices
        Matriz oIncidencia = new Matriz(iIncidencia);
        Matriz oMarcadoinicial = new Matriz(iMarcado);
        Matriz oDisparo = new Matriz(iDisparo);
        
        //Operaciones sobre matrices
        Matriz oIncidenciaxDisparo = (oIncidencia.mult(oDisparo.transpose())).transpose();
        Matriz oNuevoMarcado = oMarcadoinicial.plus(oIncidenciaxDisparo);
        
        sNuevoMarcado = oNuevoMarcado.toString(); //Guardo el nuevo marcado en un string para poder imprimirlo en pantalla
        
        //Recorrido del nuevo marcado en busca de números negativos
        for (int i = 0; i < oNuevoMarcado.getFil(); i++) {
            for (int j = 0; j < oNuevoMarcado.getCol(); j++) {
                if((oNuevoMarcado.getVal(i, j))<0)
                {
                    System.out.println("El disparo NO se puede ejecutar");
                    return false;
                }
            }
        }
        System.out.println("El disparo SI se puede ejecutar");
        return true;   
    }
    
    public int[][] getMarcadoInicial()
    {
        return iMarcado;
    }
    
    public String getNuevoMarcado()
    {
        return sNuevoMarcado;
    }
}
