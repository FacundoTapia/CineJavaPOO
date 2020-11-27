package repositories.interfaces;

import entidades.Detalle;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface I_DetalleRepository {
    void crear(Detalle detalle);
    void borrar(Detalle detalle);
    void actualizar(Detalle detalle);
    List<Detalle> getAll();
    Detalle getByCodDetalle(int codDetalle);
    List<Detalle> getLikeFechaYHorario(LocalDate ld, LocalTime lt);
    List<Detalle> getDetallesByPelicula(int codPelicula);
    List<Detalle> getDetallesByFecha(LocalDate ld);
    List<Detalle> getDetallesByFechaYTitulo(LocalDate fecha, String titulo);
    Detalle getByFechaHorarioSala(LocalDate fecha, LocalTime horario, int nroSala);
    Detalle getByFechaTituloHorario(LocalDate fecha, LocalTime horario, String titulo);
}
