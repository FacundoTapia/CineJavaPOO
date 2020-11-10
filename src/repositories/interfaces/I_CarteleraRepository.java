package repositories.interfaces;

import entidades.Cartelera;
import java.util.Date;
import java.util.List;

public interface I_CarteleraRepository {
    void crear(Cartelera cartelera);
    void borrar(Cartelera cartelera);
    void actualizar(Cartelera cartelera);
    List<Cartelera> getAll();
    Cartelera getByCodCartelera(int codCartelera);
}
