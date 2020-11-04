package entidades;
public class Cartelera {
    private int codDetalle;
    private int codCartelera = 1;

    public Cartelera() {}

    public Cartelera(int codDetalle) {
        this.codDetalle = codDetalle;
    }

    @Override
    public String toString() {
        return codCartelera + ", " + codDetalle;
    }

    public int getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(int codDetalle) {
        this.codDetalle = codDetalle;
    }

    public int getCodCartelera() {
        return codCartelera;
    }

    public void setCodCartelera(int codCartelera) {
        this.codCartelera = codCartelera;
    }
}