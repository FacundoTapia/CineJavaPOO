package entidades;

import connectors.Connector;
import java.time.LocalDate;
import java.time.LocalTime;
import repositories.interfaces.I_SalaRepository;
import repositories.jdbc.SalaRepository;

public class Detalle {
    private int codDetalle;
    private int codPelicula;
    private int nroSala;
    private int entradasDisponibles;
    private LocalDate fecha;
    private LocalTime horario;

    public Detalle() {}

    public Detalle(int codPelicula, int nroSala, LocalDate fecha, LocalTime horario) {
        this.codPelicula = codPelicula;
        this.nroSala = nroSala;
        setEntradasDisponiblesByCapacidad(nroSala);
        this.fecha = fecha;
        this.horario = horario;
    }

    public Detalle(int codDetalle, int codPelicula, int nroSala, LocalDate fecha, LocalTime horario) {
        this.codDetalle = codDetalle;
        this.codPelicula = codPelicula;
        this.nroSala = nroSala;
        setEntradasDisponiblesByCapacidad(nroSala);
        this.fecha = fecha;
        this.horario = horario;
    }

    public Detalle(int codDetalle, int codPelicula, int nroSala, int entradasDisponibles, LocalDate fecha, LocalTime horario) {
        this.codDetalle = codDetalle;
        this.codPelicula = codPelicula;
        this.nroSala = nroSala;
        this.entradasDisponibles = entradasDisponibles;
        this.fecha = fecha;
        this.horario = horario;
    }
    
    @Override
    public String toString() {
        return codDetalle + ", " + codPelicula + ", " + nroSala + ", " + entradasDisponibles + ", " + fecha + ", " + horario;
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

    public int getEntradasDisponibles() {
        return entradasDisponibles;
    }

    public void setEntradasDisponibles(int entradasDisponibles) {
        this.entradasDisponibles = entradasDisponibles;
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
    
    public void setEntradasDisponiblesByCapacidad(int nroSala){
        I_SalaRepository sr = new SalaRepository(Connector.getConnection());
        
        this.entradasDisponibles =  sr.getByNumero(nroSala).getCapacidad();
    }
}
