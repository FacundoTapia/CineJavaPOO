package repositories.interfaces;

import entidades.Cartelera;
import entidades.Cliente;
import entidades.Entrada;
import java.util.List;

public interface I_EntradaRepository {
    void crear(Entrada entrada);
    void borrar(Entrada entrada);
    void actualizar(Entrada entrada);
    List<Entrada> getAll();
    List<Entrada> getByCliente(Cliente cliente);
    List<Entrada> getByCartelera(Cartelera cartelera);
}
