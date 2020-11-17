package repositories.jdbc;
import entidades.Detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import repositories.interfaces.I_DetalleRepository;
public class DetalleRepository implements I_DetalleRepository{
    private Connection conn;

    public DetalleRepository(Connection conn) {
        this.conn = conn;
    }  
    
    public LocalTime salvarTiempo(LocalDateTime ldt){
        return ldt.toLocalTime();
    }
    
    public java.sql.Date LocalDateTimeConverter(LocalDateTime ldt){
        return java.sql.Date.valueOf(ldt.toLocalDate());
    }
    
    public LocalDateTime recuperarTiempo(LocalDate ld){
        
    }
    
    @Override
    public void crear(Detalle detalle) {
        if(detalle == null) {System.out.println("sale por null"); return;}
        if (comprobarDuplicado(detalle)) {System.out.println("sale por duplicado"); return;}
        
        try(PreparedStatement ps = conn.prepareStatement("insert into detalles(codPelicula, nroSala, fecha) values(?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, detalle.getCodPelicula());
            ps.setInt(2, detalle.getNroSala());
            
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                detalle.setCodDetalle(rs.getInt(1));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(Detalle detalle) {
        if(detalle == null) return;
        try(PreparedStatement ps = conn.prepareStatement("delete from detalles where codDetalle = ?")){
            ps.setInt(1, detalle.getCodDetalle());
            ps.execute();
        } catch (Exception e) {
        }
    }

    @Override
    public void actualizar(Detalle detalle) {
        if(detalle == null) {System.out.println("sale por null"); return;}
        if (comprobarDuplicado(detalle)) {System.out.println("sale por duplicado"); return;}
        
        try(PreparedStatement ps = conn.prepareStatement("update detalles set codPelicula = ?, nroSala = ?, fecha = ? where codDetalle = ?")){
            ps.setInt(1, detalle.getCodPelicula());
            ps.setInt(2, detalle.getNroSala());
            ps.setTimestamp(3, Timestamp.valueOf(formatoSQLFecha(utilDateToSqlDate(detalle.getFecha()))));
            ps.setInt(4, detalle.getCodDetalle());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Detalle> getAll() {
        List<Detalle> list = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from detalles")){
            while (rs.next()) {
                list.add(
                        new Detalle(
                                rs.getInt("codDetalle"), 
                                rs.getInt("codPelicula"), 
                                rs.getInt("nroSala"), 
                                rs.getTimestamp("fecha")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }   

    @Override
    public Detalle getByCodDetalle(int codDetalle) {
        Detalle de = new Detalle();
        for(Detalle d : getAll()){
            if (d.getCodDetalle() == codDetalle) {
                de = d;
            }
        }
        return de;        
    }
    
        private boolean comprobarDuplicado(Detalle detalle) {
        boolean yaExiste = false;
        for(Detalle d: getAll()){
            if (detalle.getCodPelicula() == d.getCodPelicula() &&
                detalle.getNroSala() == d.getNroSala() &&
                detalle.getFecha().equals(d.getFecha())) 
            {
                yaExiste = true;
                return true;
            }
        }
        return false;
    }  

    @Override
    public List<Detalle> getDetallesByPelicula(int codPelicula) {
        List<Detalle> lista = new ArrayList();
        
        for(Detalle d : getAll()){
            if (d.getCodPelicula() == codPelicula) {
                lista.add(d);
            }
        }
        
        return lista;
    }
}
