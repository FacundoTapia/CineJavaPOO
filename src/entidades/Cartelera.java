package entidades;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Cartelera {
    private int codEstreno;
    private Date fechaEstreno;
    private int nroSala;
    private int codPelicula;

    public Cartelera() {}

    public Cartelera(Date fechaEstreno, int nroSala, int codPelicula) {
        this.fechaEstreno = fechaEstreno;
        this.nroSala = nroSala;
        this.codPelicula = codPelicula;
    }

    public Cartelera(int codEstreno, Date fechaEstreno, int nroSala, int codPelicula) {
        this.codEstreno = codEstreno;
        this.fechaEstreno = fechaEstreno;
        this.nroSala = nroSala;
        this.codPelicula = codPelicula;
    }

    @Override
    public String toString() {
        return codEstreno + ", " + fechaEstreno + ", " + nroSala + ", " + codPelicula;
    }

    public int getCodEstreno() {
        return codEstreno;
    }

    public void setCodEstreno(int codEstreno) {
        this.codEstreno = codEstreno;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public int getNroSala() {
        return nroSala;
    }

    public void setNroSala(int nroSala) {
        this.nroSala = nroSala;
    }

    public int getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula = codPelicula;
    }
}