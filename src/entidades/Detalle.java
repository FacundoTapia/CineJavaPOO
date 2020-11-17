package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Detalle {
    private int codDetalle;
    private int codPelicula;
    private int nroSala;
    private LocalDate fecha;
    private LocalTime horario;

    public Detalle() {}

    public Detalle(int codPelicula, int nroSala, LocalDate fecha, LocalTime horario) {
        this.codPelicula = codPelicula;
        this.nroSala = nroSala;
        this.fecha = fecha;
        this.horario = horario;
    }

    public Detalle(int codDetalle, int codPelicula, int nroSala, LocalDate fecha, LocalTime horario) {
        this.codDetalle = codDetalle;
        this.codPelicula = codPelicula;
        this.nroSala = nroSala;
        this.fecha = fecha;
        this.horario = horario;
    }

    @Override
    public String toString() {
        return codDetalle + ", " + codPelicula + ", " + nroSala + ", " + fecha + ", " + horario;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}
