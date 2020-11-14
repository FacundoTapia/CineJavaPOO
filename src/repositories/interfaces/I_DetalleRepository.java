package repositories.interfaces;

import entidades.Detalle;
import java.util.List;

public interface I_DetalleRepository {
    void crear(Detalle detalle);
    void borrar(Detalle detalle);
    void actualizar(Detalle detalle);
    List<Detalle> getAll();
    Detalle getByCodDetalle(int codDetalle);
    List<Detalle> getDetallesByPelicula(int codPelicula);
}
