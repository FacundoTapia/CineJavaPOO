package repositories.interfaces;

import entidades.Cartelera;
import entidades.Cliente;
import entidades.Entrada;
import java.util.List;

public interface I_ClienteRepository {
    void registrar(Cliente cliente);
    void borrar(Cliente cliente);
    Entrada comprar(Cliente cliente, Cartelera cartelera, int cant);
    List<Cliente> getAll();
    Cliente getById(int id);
}
