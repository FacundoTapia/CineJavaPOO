package entidades;
public class Relacion {
    private int idRelacion;
    private int codCartelera;
    private int codDetalle;

    public Relacion() {}

    public Relacion(int codCartelera, int codDetalle) {
        this.codCartelera = codCartelera;
        this.codDetalle = codDetalle;
    }

    public Relacion(int idRelacion, int codCartelera, int codDetalle) {
        this.idRelacion = idRelacion;
        this.codCartelera = codCartelera;
        this.codDetalle = codDetalle;
    }

    @Override
    public String toString() {
        return idRelacion + ", " + codCartelera + ", " + codDetalle;
    }

    public int getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(int idRelacion) {
        this.idRelacion = idRelacion;
    }

    public int getCodCartelera() {
        return codCartelera;
    }

    public void setCodCartelera(int codCartelera) {
        this.codCartelera = codCartelera;
    }

    public int getCodDetalle() {
        return codDetalle;
    }

    /**
     *
     * @param codDetalle
     */
    public void setCodDetalle(int codDetalle) {
        this.codDetalle = codDetalle;
    }
}
