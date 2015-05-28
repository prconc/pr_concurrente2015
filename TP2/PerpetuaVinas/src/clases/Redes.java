package clases;

public class Redes 
{
    private int[][] iMarcado;
    private int[][] iIncidencia;
    
    int[][] iNuevoMarcado;
    
    public Redes(int[][] iMarcado, int[][] iIncidencia)
    {
        this.iNuevoMarcado = iMarcado;
        this.iMarcado = iMarcado;
        this.iIncidencia = iIncidencia;
    }

    public boolean ejecutar(int[][] iDisparo)
    {
        //Definición de las matrices
        Matriz oIncidencia = new Matriz(iIncidencia);
        Matriz oMarcadoinicial = new Matriz(iMarcado);
        Matriz oDisparo = new Matriz(iDisparo);
        Matriz oNuevoMarcado = new Matriz(iMarcado);
        
        //Operaciones sobre matrices
        Matriz oIncidenciaxDisparo = (oIncidencia.mult(oDisparo.transpose())).transpose();
        oNuevoMarcado = oNuevoMarcado.plus(oIncidenciaxDisparo);
        
        //Recorrido del nuevo marcado en busca de números negativos
        for (int i = 0; i < oNuevoMarcado.getFil(); i++) {
            for (int j = 0; j < oNuevoMarcado.getCol(); j++) {
                if((oNuevoMarcado.getVal(i, j))<0)
                {
//                    System.out.println("El disparo: {"+sDisparo+"}, NO se puede ejecutar\n");
                    return false;
                }
            }
        }
        
        
        for (int i = 0; i < oNuevoMarcado.getFil(); i++) {
            for (int j = 0; j < oNuevoMarcado.getCol(); j++) {
                iNuevoMarcado[i][j] = oNuevoMarcado.getVal(i, j);
            }
        }    
//        System.out.println("El disparo: {"+sDisparo+"}, SI se puede ejecutar\n");
        iMarcado = iNuevoMarcado;
        return true;
    }
    
    public int[][] getMarcadoInicial()
    {
        return iMarcado;
    }
}
