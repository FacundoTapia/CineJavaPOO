package ar.org.centro8.curso.java.utils.swing;

import java.lang.reflect.Field;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table <E> {
    //Clase encargado de rellenar las tablas que mostramos en los formularios
    //Cursos y Alumnos, manualmente es un proceso tedioso
    public void cargar(JTable tbl, List<E> lista){
        //A partir de la lista que nos pasen se rellenara el table
        if (tbl==null) return;
        //Creo un modelo de tabla, que contiene filas, columnas, etc
        DefaultTableModel dtm = new DefaultTableModel();
        //se lo agrego a la tabla que voy a rellenat
        tbl.setModel(dtm);
        
        if (lista==null || lista.isEmpty()) return;
        //Si la lista no es vacia, creo un obj E que haria referencia al primer
        //objeto de la lista que me pasaron, en tiempo de ejecucion tengo que
        //averiguar que campos tiene para poder armar las columnas
        E e=lista.get(0);
        //Mediante API Reflect obtengo la lista de los campos declarados de la
        //clase del objeto
        Field[] campos = e.getClass().getDeclaredFields();
        //recorro y agrego los nombres
        for(Field f: campos) dtm.addColumn(f.getName());
        
        //Tengo que cargar los registros para lo que necesito recorrerla lista
        //y obtener su valor en cada campo para formar el registro
        for(E ee: lista){
            //cada valor de un campo es un objeto, la longitud del vector depende 
            //de cuantos campos haya
            Object[] registro = new Object[campos.length];

            for(int i=0; i < campos.length; i++){
                Field f = campos[i];
                //al recorrer los campos necesito ejecutar el metodo getCampo para
                //obtener su valor y poder insertarlo en la tabla, realizamos este
                //proceso con API Reflect
                String metodo = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                //System.out.println(metodo);
                try {
                    registro[i] = e.getClass().getMethod(metodo, null).invoke(ee, null);
                } catch (Exception ex) {ex.printStackTrace();}
            }
            
            //Agrego el registro en forma de fila a la tabla
            dtm.addRow(registro);
        }
    }
}
