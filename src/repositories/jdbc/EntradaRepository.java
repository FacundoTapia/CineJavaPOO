package repositories.jdbc;

import entidades.Cartelera;
import entidades.Cliente;
import entidades.Entrada;
import java.util.List;
import repositories.interfaces.I_EntradaRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class EntradaRepository implements I_EntradaRepository{
    private Connection conn;

    public EntradaRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void crear(Entrada entrada) {
        try(PreparedStatement ps = conn.prepareStatement("insert into entradas(precio, idCliente, codCartelera) values(?, ?, ?)", 
                PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setDouble(1, entrada.getPrecio());
            ps.setInt(2, entrada.getIdCliente());
            ps.setInt(3, entrada.getCodCartelera());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                entrada.setNroEntrada(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(Entrada entrada) {
        try(PreparedStatement ps = conn.prepareStatement("delete from entradas where nroEntrada = ?")){
            ps.setInt(1, entrada.getNroEntrada());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Entrada entrada) {
        try(PreparedStatement ps = conn.prepareStatement("update entradas set precio = ?, idCliente = ?, codCartelera = ? where nroEntrada = ?")){
            ps.setDouble(1, entrada.getPrecio());
            ps.setInt(2, entrada.getIdCliente());
            ps.setInt(3, entrada.getCodCartelera());
            ps.setInt(4, entrada.getNroEntrada());
            ps.execute();
        } catch (Exception e) {
        }
    }

    @Override
    public List<Entrada> getAll() {
        List<Entrada> list = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from entradas")){
            while (rs.next()) {
                list.add(
                        new Entrada(
                                rs.getInt("nroEntrada"), 
                                rs.getInt("idCliente"), 
                                rs.getInt("codCartelera")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

    @Override
    public List<Entrada> getByCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Entrada> getByCartelera(Cartelera cartelera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
