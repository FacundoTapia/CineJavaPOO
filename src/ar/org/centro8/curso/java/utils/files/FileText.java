package ar.org.centro8.curso.java.utils.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FileText implements I_File{
    private File file;
    
    //recibe el file directamente
    public FileText(File file) {
        this.file = file;
    }
    
    //recibe un String con la ruta del archivo, inicializa este con esa ruta
    public FileText(String file){
        this.file = new File(file);
    }
    
    
    @Override
    public String getText() {
        /*
        Abre un archivo para la lectura, si este no existe lanza una Exception.
        Se puede abrir multiples canales de lectura a la vez, pueden haber varios
        programas que abran el mismo archivo para la lectura
        Esto es una regla común de todos los File System de los Sistemas Operativos
        */

        int car;
        //String texto = "";
        StringBuilder sb = new StringBuilder();
        
        //inicializo en un try with resource, asi resuelvo el problema
        //de no cerrar los archivos
        try(FileReader in = new FileReader(file, StandardCharsets.ISO_8859_1);){
            //no tengo un metodo que me lea todo de golpe    
            //.read() me lee de a un caracter, lo devuelve, si devuelve -1
            //significa que se llegó al final de la lectura, por eso
            //mientras lo q devuelve .read() sea diferente de -1
            //se agrega lo leido al String texto.
            //Uso un int para guardar el caracter y para agregarlo al String
            //lo casteo como char
            while ((car=in.read()) != -1){
                //texto += (char)car;
                sb.append((char)car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sb.toString();
    }

    @Override
    public void setText(String text) {
        /*
        Abre un archivo para la escritura, si este no existe, lo crea.
        NO se puede abrir mas de un canal de esctritura a la vez sobre un archivo,
        al abrirse este canal, se "bloquea" el archivo para otros hilos o programas
        cuando este canal es cerrado, vuelve a ser accesible para los demas.
        Si nunca es cerrado, al pasar un tiempo lanza una Exception.
        Esto es una regla común de todos los File System de los Sistemas Operativos
        */
        
        try(FileWriter in = new FileWriter(file, StandardCharsets.ISO_8859_1);){
            in.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void append(String text) {
        //al agregarla "true" creando el FileWriter, no sobreescribe el texto anterior
        try(FileWriter in = new FileWriter(file, true);){
            in.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public Stream<String> getStream() {
        try {
            /*
            BufferedReader me permite con .readLine() leer una linea entera
            en vez de leer un caracter con .read(), este metodo, lee todas
            las lineas hasta encontrar un null(que significaria el final del archivo)
            pero si usamos este metodo, necesitariamos un while para que siga
            leyendo mientras la lectura no sea null.
            
            En cambio, con el metodo .lines() nos devuelve directamente el 
            Stream que es lo que necesitamos en este metodo.
            */
            return new BufferedReader(new FileReader(file, StandardCharsets.ISO_8859_1)).lines();
            //return (Stream<String>) Files.newBufferedReader((Path) new InputStreamReader(new FileInputStream(file.getPath())), StandardCharsets.ISO_8859_1);
            //return new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)).lines();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
