package repositories.jdbc;

import entidades.Relacion;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import repositories.interfaces.I_RelacionRepository;

public class RelacionRepository implements I_RelacionRepository{
    private Connection conn;

    public RelacionRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void crear(Relacion relacion) {
        if(relacion == null) return;
        try(PreparedStatement ps = conn.prepareStatement("insert into relaciones(codCartelera, codDetalle) values(?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS)){
            
            ps.setInt(1, relacion.getCodDetalle());
            ps.setInt(2, relacion.getCodCartelera());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                relacion.setIdRelacion(rs.getInt(1));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Relacion relacion) {
        if(relacion == null) return;
        try(PreparedStatement ps = conn.prepareStatement("update relaciones set codCartelera = ?, codDetalle = ? where idRelacion = ?")){
            ps.setInt(1, relacion.getCodCartelera());
            ps.setInt(2, relacion.getCodDetalle());
            ps.setInt(3, relacion.getIdRelacion());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(Relacion relacion) {
        if(relacion == null) return;
        try(PreparedStatement ps = conn.prepareStatement("delete from relaciones where idRelacion = ?")){
            ps.setInt(1, relacion.getIdRelacion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Relacion> getAll() {
        List<Relacion> list = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from relaciones")){
            while (rs.next()) {
                list.add(
                        new Relacion(
                                rs.getInt("idRelacion"), 
                                rs.getInt("codCartelera"), 
                                rs.getInt("codDetalle")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
