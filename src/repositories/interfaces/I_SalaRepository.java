package repositories.interfaces;

import entidades.Sala;
import java.util.List;

public interface I_SalaRepository {
    void crear(Sala sala);
    void borrar(Sala sala);
    List<Sala> getAll();
    Sala getByNumero(int numero);
}
