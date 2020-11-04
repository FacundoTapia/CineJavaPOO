package repositories.interfaces;
import entidades.Cliente;
import entidades.Detalle;
import entidades.Entrada;
import java.util.List;
public interface I_ClienteRepository {
    void registrar(Cliente cliente);
    void borrar(Cliente cliente);
    Entrada comprar(Cliente cliente, Detalle detalle, int cant);
    List<Cliente> getAll();
    Cliente getById(int id);
}
