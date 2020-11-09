package repositories.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import entidades.Cliente;
import entidades.Detalle;
import entidades.Entrada;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
    public Entrada comprar(Cliente cliente, Detalle detalle, int cantidad) {
        if (cliente == null || detalle == null) return new Entrada();
        
        SalaRepository sr = new SalaRepository(conn);
        int asientosDisp = sr.getByNumero(detalle.getNroSala()).getAsientosDisponibles();
        
        System.out.println("asientos disponibles de la sala: " + asientosDisp);
        
        //si hay mayor cantidad de asientos libres de la cantidad de entradas
        //que quiere comprar el cliente
        if (asientosDisp > cantidad) {
            //se genera la entrada con sus datos y los de la pelicula elegida
            Entrada entrada = new Entrada(cliente.getId(), detalle.getCodDetalle());
            //Reduzco la cantidad de entradas que fueron compradas
            sr.getByNumero(detalle.getNroSala()).setAsientosDisponibles(asientosDisp-cantidad);
            System.out.println("Asientos disponibles despues de vender las entradas: " + asientosDisp);            
            return entrada;
        } else {
            JOptionPane.showConfirmDialog(null, "No hay asientos disponibles para esa cantidad de entradas");
            return new Entrada();
        }
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