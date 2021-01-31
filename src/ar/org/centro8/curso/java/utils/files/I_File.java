package ar.org.centro8.curso.java.utils.files;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface I_File {
    //Todas acciones que el usuario pueda realizar con esta clase debo expresarla 
    //y evitar resolverlas en el frontend. Esto esta pensado para trabajar con cualquier
    //tipo de archivo ya sea un archivo de disco duro, un archivo en la nube, 
    //archivo de base de datos, etc.
    
    //Todos los metodos que no impliquen abrir una conexion con una base de datos, una nube
    //un archivo se pueden resolver con un metodo default desde aca, si estas soluciones
    //tuvieran problemas de rendimiento pueden ser sobreescritas desde las implementaciones
    
    /**
     * Imprime el archivo
     */
    default void print(){                                   
        System.out.println(getText());
    }
    
    /**
     * Devuelve el archivo
     * @return 
     */
    String getText();                                       
    
    /**
     * borra lo anterior y escribe en el archivo
     * @param text 
     */
    void setText(String text);                              

    /**
     * borra el archivo
     */
    default void clear(){                                   
        setText("");
    }
    
    /**
     * escribe al final del archivo 
     * @param text 
     */
    void append(String text);                               
    
    /**
     * agrega una sola linea
     * @param line 
     */
    default void addLine(String line){                      
        append(line+"\n");
    }
    
    /**
     * ingresa una coleccion de lineas y las apendiza
     * @param lines 
     */
    default void addLines(List<String> lines){              
        lines.forEach(this::addLine);
    }                      
    
    /**
     * da la posibilidad de filtrar el texto con API Stream. Lee archivos de texto por eso es de tipo String
     * @return 
     */
    Stream<String> getStream();                                     
    
    /**
     * devuelve una lista con todas las lineas del archivo, esto lo que hace es 
    cargarlas en memoria, si tratamos con un archivo grande es mejor devolver 
    una lista vacia, una Exception o algo que indique que no se puede alojar 
    en memoria. Especial cuidado en Base de Datos.
     * @return 
     */
    default List<String> getAll(){                                  
        return this.getStream().collect(Collectors.toList());
    }
    
    /**
     * devuelve una lista de lineas que contiene la palabra que pidamos. 
    Indicamos "rojo" nos devuelve todas las lineas que contienen esa palabra
     * @param filter
     * @return 
     */
    default List<String> getByFilter(String filter){                
        return this
            .getStream()
            .filter(s->s.toLowerCase()
                .contains(filter.toLowerCase()))
            .collect(Collectors.toList());
    }
    
    /**
     * devuelve una lista con las lineas ordenadas
     * @return 
     */
    default List<String> getSortedLines(){                                  
        return this.getStream().sorted().collect(Collectors.toList());
    }
    
    /**
     * devuelve una lista con las lineas ordenadas al reves
     * @return 
     */
    default List<String> getReversedSortedLines(){                                                  
        return this.getStream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
    
    /**
     * devuelve el listado de lineas en el orden que estan en el archivo sin duplicados
     * @return 
     */
    default LinkedHashSet<String> getLinkedHashSetLines() {                                 
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        
        //addAll() admite una Collection, usamos nuestro metodo .getAll() que nos devuelve todo 
        //el archivo como Collection, lo almacenamos como LinkedHashSet y lo retornamos
        //Si usaramos Collectors.toSet() devuelve el Set pero desordenado, no nos sirve.
        set.addAll(getAll());
        return set;
    }
    
    /**
     * devuelve el listado de lineas ordenado alfabeticamente
     * @return 
     */
    default TreeSet<String> getTreeSetLines() {                         
        TreeSet<String> set = new TreeSet<String>();
        set.addAll(getAll());
        return set;
    }
    
    /**
     * elimina la linea que me ingresa por parametro
     * @param line 
     */
    default void remove(String line) {                                            
        //carga el archivo en una lista, borra la linea ingresada
        //borra el archivo, y carga en el archivo la lista sin esa
        //linea, problematico con archivos grandes, debido al uso
        //de memoria
        List<String> list = getAll();
        list.remove(line);
        clear();
        addLines(list);
    }
}
