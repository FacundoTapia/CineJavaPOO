package repositories.jdbc;
import connectors.Connector;
import entidades.Detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_SalaRepository;
public class DetalleRepository implements I_DetalleRepository{
    private Connection conn;

    public DetalleRepository(Connection conn) {
        this.conn = conn;
    }
    
    public java.sql.Date LocalDateConverter(LocalDate ld){
        return java.sql.Date.valueOf(ld);
    }
    
    public java.sql.Time LocalTimeConverter(LocalTime lt){
        return java.sql.Time.valueOf(lt);
    }
    
    public int getCapacidadByNroSala(int nroSala){
        I_SalaRepository sr = new SalaRepository(Connector.getConnection());
        return sr.getByNumero(nroSala).getCapacidad();
    }
    
    @Override
    public void crear(Detalle detalle) {
        if(detalle == null) {System.out.println("sale por null"); return;}
        if (comprobarDuplicado(detalle)) {System.out.println("sale por duplicado"); return;}
        
        try(PreparedStatement ps = conn.prepareStatement("insert into detalles(codPelicula, nroSala, entradasDisponibles, fecha, horario) values(?, ?, ?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){
            
            ps.setInt(1, detalle.getCodPelicula());
            ps.setInt(2, detalle.getNroSala());
            ps.setInt(3, getCapacidadByNroSala(detalle.getNroSala()));
            ps.setDate(4, LocalDateConverter(detalle.getFecha()));
            ps.setTime(5, LocalTimeConverter(detalle.getHorario()));
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
        
        try(PreparedStatement ps = conn.prepareStatement("update detalles set codPelicula = ?, nroSala = ?, entradasDisponibles = ?, fecha = ?, horario = ? where codDetalle = ?")){
            ps.setInt(1, detalle.getCodPelicula());
            ps.setInt(2, detalle.getNroSala());
            ps.setInt(3, detalle.getEntradasDisponibles());
            ps.setDate(4, LocalDateConverter(detalle.getFecha()));
            ps.setTime(5, LocalTimeConverter(detalle.getHorario()));
            ps.setInt(6, detalle.getCodDetalle());
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
                                rs.getInt("entradasDisponibles"),
                                rs.getDate("fecha").toLocalDate(),
                                rs.getTime("horario").toLocalTime()
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
                d.getFecha().isEqual(detalle.getFecha()) &&
                detalle.getHorario().equals(d.getHorario())
                )
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

    @Override
    public Detalle getByFecha(LocalDate ld) {
        Detalle de = new Detalle();
        
        for(Detalle d : getAll()){
            if (d.getFecha().equals(ld)) {
                de = d;
            }
        }
        
        return de;
    }
}
