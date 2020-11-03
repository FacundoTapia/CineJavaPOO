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
        try(PreparedStatement ps = conn.prepareStatement("insert into cartelera(fechaDisponible, sala, codPelicula) values(?, ?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setDate(1, (java.sql.Date)cartelera.getFechaEstreno());
            ps.setInt(2, cartelera.getNroSala());
            ps.setInt(3, cartelera.getCodPelicula());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                cartelera.setCodEstreno(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(Cartelera cartelera) {
        if (cartelera == null) return;
        try(PreparedStatement ps = conn.prepareStatement("delete from cartelera where codEstreno = ?")){
            ps.setInt(1, cartelera.getCodEstreno());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Cartelera cartelera) {
        if (cartelera == null) return;
        try(PreparedStatement ps = conn.prepareStatement("update cartelera set fechaDisponible = ?, sala = ?, codPelicula = ? where id = ?")){
            ps.setDate(1, (java.sql.Date)cartelera.getFechaEstreno());
            ps.setInt(2, cartelera.getNroSala());
            ps.setInt(3, cartelera.getCodPelicula());
            ps.setInt(4, cartelera.getCodEstreno());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cartelera> getAll() {
        List<Cartelera> list = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from cartelera")){
            while (rs.next()) {
                list.add(
                    new Cartelera(
                            rs.getInt("codEstreno"), 
                            rs.getDate("fechaDisponible"),
                            rs.getInt("sala"),
                            rs.getInt("codPelicula")
                    )
                );                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

    @Override
    public List<Cartelera> getByFecha(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cartelera> getBySala(Sala sala) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cartelera> getByPelicula(Pelicula pelicula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cartelera getByCodEstreno(int id) {
        Cartelera car = new Cartelera();
        for(Cartelera c : getAll()){
            if (c.getCodEstreno()==id) {
                car = c;
            }
        }
        return car;
    }

    @Override
    public String formateoFecha(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(date);
    }
}
