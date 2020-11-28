package repositories.interfaces;

import entidades.Cartelera;
import entidades.Detalle;
import entidades.Relacion;
import java.util.List;

public interface I_RelacionRepository {
    void crear(Relacion relacion);
    void actualizar(Relacion relacion);
    void borrar(Relacion relacion);
    Relacion getByIdRelacion(int idRelacion);
    List<Relacion> getAll();
    List<Detalle> getDetalleByCodCartelera(int codCartelera);
    List<Cartelera> getCarteleraByCodDetalle(int codDetalle);
    
}
