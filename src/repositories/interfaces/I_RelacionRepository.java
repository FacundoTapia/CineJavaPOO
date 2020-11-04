package repositories.interfaces;

import entidades.Relacion;
import java.util.List;

public interface I_RelacionRepository {
    void crear(Relacion relacion);
    void actualizar(Relacion relacion);
    void borrar(Relacion relacion);
    List<Relacion> getAll();
}
