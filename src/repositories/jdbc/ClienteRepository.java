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
import repositories.interfaces.I_EntradaRepository;
import repositories.interfaces.I_SalaRepository;
public class ClienteRepository implements I_ClienteRepository {
    private Connection conn;

    public ClienteRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void registrar(Cliente cliente) {
        if (cliente == null) { System.out.println("sale por null"); return;}
        if (comprobarDuplicado(cliente)) { System.out.println("sale por duplicado"); return;}
        try(PreparedStatement ps = conn.prepareStatement("insert into clientes(nombre, apellido, usuario, password) values (?, ?, ?, ?)", 
                PreparedStatement.RETURN_GENERATED_KEYS))
        {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getUsuario());
            ps.setString(4, cliente.getPassword());
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
        if (cliente == null || detalle == null || cantidad <= 0) return new Entrada();
        
        I_SalaRepository sr = new SalaRepository(conn);
        //guardo en una variable los asientos disponibles de la sala donde se va a emitir la pelicula
        int asientosDisp = sr.getByNumero(detalle.getNroSala()).getAsientosDisponibles();
        
        System.out.println("asientos disponibles de la sala: " + asientosDisp);
        
        System.out.println("id cliente " + cliente.getId() + ", codDetalle " + detalle.getCodDetalle());
        
        //si hay mayor cantidad de asientos libres de la cantidad de entradas
        //que quiere comprar el cliente
        if (asientosDisp > cantidad) {
            //se genera la entrada con sus datos y los de la pelicula elegida
            Entrada entrada = new Entrada(cliente.getId(), detalle.getCodDetalle());
            
            //la envio a la bd
            I_EntradaRepository er = new EntradaRepository(conn);
            er.crear(entrada);
            
            //Reduzco la cantidad de entradas que fueron compradas
            sr.getByNumero(detalle.getNroSala()).setAsientosDisponibles(asientosDisp-=cantidad);
            System.out.println("Asientos disponibles despues de vender las entradas: " + asientosDisp);
            
            //envio la actualizacion del registro a la bd
            sr.update(sr.getByNumero(detalle.getNroSala()));
            
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
                                rs.getString("usuario"), 
                                rs.getString("password")
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

    public Cliente getByUsuario(String usuario) {
        Cliente c1 = new Cliente();
        
        for(Cliente CL: getAll()){
            if (CL.getUsuario().equalsIgnoreCase(usuario)) {
                c1 = CL;
            }
        }
        
        return c1;
    }
    
    private boolean comprobarDuplicado(Cliente cliente) {
        boolean yaExiste = false;
        for(Cliente c: getAll()){
            if (cliente.getNombre().equalsIgnoreCase(c.getNombre()) &&
                cliente.getApellido().equalsIgnoreCase(c.getApellido()) &&
                cliente.getUsuario().equalsIgnoreCase(c.getUsuario()))
            {
                yaExiste = true;
                //System.out.println("sale por duplicado");
                return true;
            }
        }
        return false;
    }      
    
//    public boolean login(String usuario, String pass){
//        if (usuario == null || pass == null) return false;
//        
//        try(ResultSet rs = conn.createStatement().executeQuery("select * from clientes where usuario = '" + usuario + "' and apellido = '" + pass + "'")){
//            while (rs.next()) {
//                rs.getString("usuario");
//                rs.getBlob("pass");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}