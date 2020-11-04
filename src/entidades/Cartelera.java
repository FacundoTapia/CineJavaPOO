package entidades;
public class Cartelera {
    private int codCartelera;
    private String nombre;

    public Cartelera() {}

    public Cartelera(int codCartelera, String nombre) {
        this.codCartelera = codCartelera;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return codCartelera + ", " + nombre;
    }

    public int getCodCartelera() {
        return codCartelera;
    }

    public void setCodCartelera(int codCartelera) {
        this.codCartelera = codCartelera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}