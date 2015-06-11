/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.util.Calendar;

/**
 *
 * @author Pato
 */
public class Fechas 
{
    public String[] getFechayHora()
    {
        String [] fecha = new String[2];
        Calendar calendario = Calendar.getInstance();
        int h,m,s,d,me,a;
        String sh,sm,ss,sd,sme,sa;
        h = calendario.get(Calendar.HOUR);
        m = calendario.get(Calendar.MINUTE);
        s = calendario.get(Calendar.SECOND);
        d = calendario.get(Calendar.DAY_OF_MONTH);
        me = calendario.get(Calendar.MONTH)+1;
        a = calendario.get(Calendar.YEAR);
        if (h<10)
            sh="0"+h;
        else
            sh=""+h;
        if (m<10)
            sm="0"+m;
        else
            sm=""+m;
        if (s<10)
            ss="0"+s;
        else
            ss=""+s;
        if (d<10)
            sd="0"+d;
        else
            sd=""+d;
        if (me<10)
            sme="0"+me;
        else
            sme=""+me;
        if (a<10)
            sa="0"+a;
        else
            sa=""+a;
        fecha[0]=sa+"/"+sme+"/"+sd;
        fecha[1]=sh+":"+sm+":"+ss;
        return fecha;
    }
    
    public String GetFechayHora()
    {
        String [] fecha = new String[2];
        Calendar calendario = Calendar.getInstance();
        int h,m,s,d,me,a;
        String sh,sm,ss,sd,sme,sa;
        h = calendario.get(Calendar.HOUR);
        m = calendario.get(Calendar.MINUTE);
        s = calendario.get(Calendar.SECOND);
        d = calendario.get(Calendar.DAY_OF_MONTH);
        me = calendario.get(Calendar.MONTH)+1;
        a = calendario.get(Calendar.YEAR);
        if (h<10)
            sh="0"+h;
        else
            sh=""+h;
        if (m<10)
            sm="0"+m;
        else
            sm=""+m;
        if (s<10)
            ss="0"+s;
        else
            ss=""+s;
        if (d<10)
            sd="0"+d;
        else
            sd=""+d;
        if (me<10)
            sme="0"+me;
        else
            sme=""+me;
        if (a<10)
            sa="0"+a;
        else
            sa=""+a;
        fecha[0]=sa+"/"+sme+"/"+sd;
        fecha[1]=sh+":"+sm+":"+ss;
        String f = fecha[0] + " "+ fecha[1];
        return f;
    }
    
    public String getHora()
    {
        String sHora;
        Calendar calendario = Calendar.getInstance();
        int h,m,s;
        String sh,sm,ss;
        h = calendario.get(Calendar.HOUR);
        m = calendario.get(Calendar.MINUTE);
        s = calendario.get(Calendar.SECOND);
        if (h<10)
            sh="0"+h;
        else
            sh=""+h;
        if (m<10)
            sm="0"+m;
        else
            sm=""+m;
        if (s<10)
            ss="0"+s;
        else
            ss=""+s;
        sHora =sh+":"+sm+":"+ss;
        return sHora;
    }
    
    public String getFecha()
    {
        String fecha;
        Calendar calendario = Calendar.getInstance();
        int d,me,a;
        String sh,sm,ss,sd,sme,sa;
        d = calendario.get(Calendar.DAY_OF_MONTH);
        me = calendario.get(Calendar.MONTH)+1;
        a = calendario.get(Calendar.YEAR);        
        if (d<10)
            sd="0"+d;
        else
            sd=""+d;
        if (me<10)
            sme="0"+me;
        else
            sme=""+me;
        if (a<10)
            sa="0"+a;
        else
            sa=""+a;
        fecha=sa+"/"+sme+"/"+sd;
        return fecha;
    }
}
