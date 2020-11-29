package repositories.interfaces;
import entidades.Cliente;
import entidades.Detalle;
import entidades.Entrada;
import java.util.List;
public interface I_ClienteRepository {
    void registrar(Cliente cliente);
    void borrar(Cliente cliente);
    boolean cambiarContraseña(Cliente cliente, String codigo);
    Cliente getByUsuario(String usuario);
    List<Entrada> comprar(Cliente cliente, Detalle detalle, int cantidad);
    List<Cliente> getAll();
    Cliente getById(int id);
}