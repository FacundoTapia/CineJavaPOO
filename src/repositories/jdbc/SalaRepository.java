package repositories.jdbc;

import entidades.Sala;
import enums.TipoSala;
import java.util.List;
import repositories.interfaces.I_SalaRepository;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SalaRepository implements I_SalaRepository{
    private Connection conn;

    public SalaRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void crear(Sala sala) {
        if (sala == null) return;
        try(PreparedStatement ps = conn.prepareStatement("insert into salas(numero, tipo, capacidad, asientosDisponibles) values(?, ?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, sala.getNumero());
            ps.setString(2, sala.getTipoSala().toString());
            ps.setInt(3, sala.getCantAsientos());
            ps.setInt(4, sala.getAsientosDisponibles());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(Sala sala) {
        if (sala == null) return;
        try(PreparedStatement ps = conn.prepareStatement("delete from salas where numero = ?")){
            ps.setInt(1, sala.getNumero());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Sala> getAll() {
        List<Sala> list = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from salas")){
            while (rs.next()) {
                list.add(
                        new Sala(
                                rs.getInt("numero"), 
                                TipoSala.valueOf(rs.getString("tipo")),
                                rs.getInt("cantAsientos"), 
                                rs.getInt("asientosDisponibles")
                        )
                );
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Sala getByNumero(int numero) {
        Sala sa = new Sala();
        for(Sala s : getAll()){
            if (s.getNumero()==numero) {
                sa = s;
            }
        }
        return sa;
    }
    
}
