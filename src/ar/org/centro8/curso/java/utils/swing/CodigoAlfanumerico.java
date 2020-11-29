package ar.org.centro8.curso.java.utils.swing;

import java.util.Random;

public class CodigoAlfanumerico {
    public String generar(){
        Random random = new Random();
        
        char[] letras = "abcdefghijklmnñopqrstuvwxyz".toUpperCase().toCharArray();
        char[] numeros = "0123456789".toCharArray();
        
        StringBuilder sb = new StringBuilder(10);
        
        for (int i = 0; i < 10; i++) {
            if (random.nextInt(2) == 0) {
                sb.append(letras[random.nextInt(letras.length)]);
            } else {
                sb.append(numeros[random.nextInt(numeros.length)]);
            }
        }
        
        return sb.toString();
    }
}
