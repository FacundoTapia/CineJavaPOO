package entidades;

import java.util.Date;
import java.util.List;

public class Detalles {
    private int codDetalle;
    private int codPelicula;
    private int nroSala;
    private List<Date> fechas;

    public Detalles() {}

    public Detalles(int codPelicula, int nroSala, List<Date> fechas) {
        this.codPelicula = codPelicula;
        this.nroSala = nroSala;
        this.fechas = fechas;
    }

    public Detalles(int codDetalle, int codPelicula, int nroSala, List<Date> fechas) {
        this.codDetalle = codDetalle;
        this.codPelicula = codPelicula;
        this.nroSala = nroSala;
        this.fechas = fechas;
    }

    @Override
    public String toString() {
        return "codDetalle=" + codDetalle + ", codPelicula=" + codPelicula + ", nroSala=" + nroSala + ", fechas=" + fechas;
    }

    public int getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(int codDetalle) {
        this.codDetalle = codDetalle;
    }

    public int getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula = codPelicula;
    }

    public int getNroSala() {
        return nroSala;
    }

    public void setNroSala(int nroSala) {
        this.nroSala = nroSala;
    }

    public List<Date> getFechas() {
        return fechas;
    }

    public void setFechas(List<Date> fechas) {
        this.fechas = fechas;
    }
}
