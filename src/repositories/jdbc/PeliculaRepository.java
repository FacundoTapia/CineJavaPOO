package repositories.jdbc;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import entidades.Pelicula;
import java.util.ArrayList;
import java.util.List;
import repositories.interfaces.I_PeliculaRepository;

public class PeliculaRepository implements I_PeliculaRepository{
    private Connection conn;

    public PeliculaRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void guardar(Pelicula pelicula) {
        if (pelicula == null) return;
        try(PreparedStatement ps = conn.prepareStatement("insert into peliculas(titulo, duracion, genero, esMas18) values(?, ?, ?, ?)",
        PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, pelicula.getTitulo());
            ps.setInt(2, pelicula.getDuracion());
            ps.setString(3, pelicula.getGenero());
            ps.setBoolean(4, pelicula.isEsMas18());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                pelicula.setCodigo(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(Pelicula pelicula) {
        if (pelicula == null) return;
        try(PreparedStatement ps = conn.prepareStatement("delete from peliculas where codigo = ?")){
            ps.setInt(1, pelicula.getCodigo());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pelicula> getAll() {
        List<Pelicula> list = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from peliculas")){
            while (rs.next()) {
                list.add(
                        new Pelicula(
                                rs.getInt("codigo"), 
                                rs.getString("titulo"), 
                                rs.getInt("duracion"), 
                                rs.getString("genero"),
                                rs.getBoolean("esMas18")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

    @Override
    public Pelicula getByCodigo(int codigo) {
        Pelicula pel = null;
        for(Pelicula p : getAll()){
            if (p.getCodigo()==codigo) {
                pel = p;
            }
        }
        return pel;
    }
}
