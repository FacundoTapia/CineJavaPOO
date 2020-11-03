package entidades;
public class Cartelera {
    private int codDetalle;
    private int codCartelera;

    public Cartelera() {}

    public Cartelera(int codDetalle, int codCartelera) {
        this.codDetalle = codDetalle;
        this.codCartelera = codCartelera;
    }

    @Override
    public String toString() {
        return "codDetalle=" + codDetalle + ", codCartelera=" + codCartelera;
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