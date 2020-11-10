package repositories.jdbc;

import entidades.Cartelera;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        try(PreparedStatement ps = conn.prepareStatement("insert into carteleras(codCartelera, nombre) values(?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, cartelera.getCodCartelera());
            ps.setString(2, cartelera.getNombre());
            ps.execute();            
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
        if (cartelera == null) return;
        try(PreparedStatement ps = conn.prepareStatement("update carteleras set nombre = ? where codCartelera = ?")){
            ps.setString(1, cartelera.getNombre());
            ps.setInt(2, cartelera.getCodCartelera());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cartelera> getAll() {
        List<Cartelera> lista = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from carteleras")){
            while (rs.next()) {
                lista.add(
                    new Cartelera(
                                    rs.getInt("codCartelera"),
                                    rs.getString("nombre")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }  

    @Override
    public Cartelera getByCodCartelera(int codCartelera) {
        Cartelera c = new Cartelera();
        
        for(Cartelera car : getAll()){
            if (car.getCodCartelera() == codCartelera) {
                c = car;
            }
        }
        
        return c;
    }
}
