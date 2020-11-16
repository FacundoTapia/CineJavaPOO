package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Detalle {
    private int codDetalle;
    private int codPelicula;
    private int nroSala;
    private Date fecha;

    public Detalle() {}

    public Detalle(int codPelicula, int nroSala, Date fecha) {
        this.codPelicula = codPelicula;
        this.nroSala = nroSala;
        this.fecha = fecha;
    }

    public Detalle(int codDetalle, int codPelicula, int nroSala, Date fecha) {
        this.codDetalle = codDetalle;
        this.codPelicula = codPelicula;
        this.nroSala = nroSala;
        this.fecha = fecha;
    }

    public String formatoFecha(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEEEEE, dd/MM HH:mm");
        return sdf.format(date);
    }
    
    @Override
    public String toString() {
        return codDetalle + ", " + codPelicula + ", " + nroSala + ", " + formatoFecha(fecha);
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
