package repositories.jdbc;

import entidades.Cartelera;
import entidades.Pelicula;
import entidades.Sala;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repositories.interfaces.I_CarteleraRepository;

public class CarteleraRepository implements I_CarteleraRepository {
    private Connection conn;

    public CarteleraRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void crear(Cartelera cartelera) {
        if (cartelera == null) return;
        try(PreparedStatement ps = conn.prepareStatement("insert into carteleras(codDetalle) values(?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, cartelera.getCodDetalle());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                cartelera.setCodCartelera(rs.getInt(1));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(Cartelera cartelera) {
        if (cartelera == null) return;
        try(PreparedStatement ps = conn.prepareStatement("delete from carteleras where codCartelera = ?")){
            ps.setInt(1, cartelera.getCodCartelera());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Cartelera cartelera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cartelera> getAll() {
        List<Cartelera> lista = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from carteleras")){
            while (rs.next()) {
                lista.add(
                    new Cartelera(
                                    rs.getInt("codCartelera"), 
                                    rs.getInt("codDetalle")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public Cartelera getByCodDetalle(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
