package repositories.interfaces;
import entidades.Cliente;
import entidades.Detalle;
import entidades.Entrada;
import java.util.ArrayList;
public interface I_ClienteRepository {
    void registrar(Cliente cliente);
    void borrar(Cliente cliente);
    boolean cambiarContraseña(Cliente cliente, String codigo);
    Cliente getByUsuario(String usuario);
    ArrayList<Entrada> comprar(Cliente cliente, Detalle detalle, int cantidad);
    ArrayList<Cliente> getAll();
    Cliente getById(int id);
}