package repositories.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import entidades.Cartelera;
import entidades.Cliente;
import entidades.Entrada;
import java.util.ArrayList;
import java.util.List;
import repositories.interfaces.I_ClienteRepository;
public class ClienteRepository implements I_ClienteRepository {
    private Connection conn;

    public ClienteRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void registrar(Cliente cliente) {
        if (cliente == null) return;   
        try(PreparedStatement ps = conn.prepareStatement("insert into clientes(nombre, apellido, edad) values (?, ?, ?)", 
                PreparedStatement.RETURN_GENERATED_KEYS))
        {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getEdad());
            ps.execute();
            
            //Obtengo el id generado por la base de datos para el registro y se lo
            //inserto al objeto que lo representa
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                cliente.setId(rs.getInt(1));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
        

    @Override
    public void borrar(Cliente cliente) {
        if (cliente == null) return; 
        try(PreparedStatement ps = conn.prepareStatement("delete from clientes where id = ?")){
            ps.setInt(1, cliente.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Entrada comprar(Cliente cliente, Cartelera cartelera, int cant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> lista = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from clientes")){
            while (rs.next()) {
                lista.add(
                        new Cliente(
                                rs.getInt("id"), 
                                rs.getString("nombre"), 
                                rs.getString("apellido"), 
                                rs.getInt("edad")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public Cliente getById(int id) {
        Cliente c1 = new Cliente();
        
        for(Cliente CL: getAll()){
            if (CL.getId() == id) {
                c1 = CL;
            }
        }
        
        return c1;
    }    
}