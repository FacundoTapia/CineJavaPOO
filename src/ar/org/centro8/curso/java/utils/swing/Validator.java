package ar.org.centro8.curso.java.utils.swing;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Validator {
    private JTextField txt;

    public Validator(JTextField txt) {
        this.txt = txt;
    }
 
    private boolean error(String msj){
        txt.requestFocus();
        JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
        
        return false;
    }
    
    public boolean lenght(int min, int max){
        if (txt.getText().length()>=min && txt.getText().length()<=max) return true;
        
        //return error("El texto debe tener entre " + min + " y " + max + " caracteres!");
        return false;
    }   
    
    public boolean isInteger(){
        try {
            //Intentamos parsear el texto, si lo logra significa que es un entero
            Integer.parseInt(txt.getText());
            return true;
        } catch (Exception e) {
            return error("El valor debe ser un número entero");
        }
    }
    
    public boolean isInteger(int min, int max){
        if (!isInteger()) return false;
        int valor = Integer.parseInt(txt.getText());
        
        if (valor>=min && valor<=max) return true;
        return error("El valor debe ser entre " + min + " y "+ max);
    }
    
    public boolean soloLetras(KeyEvent evt){
        char caracter = evt.getKeyChar();
        
        return Character.isLetter(caracter);
    }
}
