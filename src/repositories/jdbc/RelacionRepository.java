package repositories.jdbc;

import entidades.Cartelera;
import entidades.Detalle;
import entidades.Relacion;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import repositories.interfaces.I_CarteleraRepository;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_RelacionRepository;

public class RelacionRepository implements I_RelacionRepository{
    private Connection conn;

    public RelacionRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void crear(Relacion relacion) {
        if(relacion == null) {
            System.out.println("sale por null"); return;}
        if (comprobarDuplicado(relacion)) {
            System.out.println("sale por duplicado"); return;}
        
        try(PreparedStatement ps = conn.prepareStatement("insert into relaciones(codCartelera, codDetalle) values(?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS)){
            
            ps.setInt(1, relacion.getCodCartelera());
            ps.setInt(2, relacion.getCodDetalle());
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
        if(relacion == null) {
            System.out.println("sale por null"); return;}
        if (comprobarDuplicado(relacion)) {
            System.out.println("sale por duplicado"); return;}
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
    
    //Obtiene un codigo cartelera y devuelve los detalles relacionados con esa Cartelera
    @Override
    public List<Detalle> getDetalleByCodCartelera(int codCartelera) {
        List<Detalle> lista = new ArrayList();
        
        I_DetalleRepository dr = new DetalleRepository(conn);
        
        for(Relacion r : getAll()){
            if (r.getCodCartelera() == codCartelera) {
                lista.add(
                        dr.getByCodDetalle(r.getCodDetalle())
                );
            }
        }
        
        return lista;
    }

    @Override
    public List<Cartelera> getCarteleraByCodDetalle(int codDetalle) {
        List<Cartelera> lista = new ArrayList();
        
        I_CarteleraRepository cr = new CarteleraRepository(conn);
        
        for(Relacion r : getAll()){
            if (r.getCodDetalle() == codDetalle) {
                lista.add(
                        cr.getByCodCartelera(r.getCodCartelera())
                );
            }
        }
        
        return lista;        
    }
    
    private boolean comprobarDuplicado(Relacion relacion) {
        boolean yaExiste = false;
        for(Relacion r: getAll()){
            if (relacion.getCodCartelera() == r.getCodCartelera() && relacion.getCodDetalle() == r.getCodDetalle()) {
                yaExiste = true;
                return true;
            }
        }
        return false;
    }    
    
    @Override
    public Relacion getByIdRelacion(int idRelacion){
        Relacion relacion = new Relacion();
        
        for(Relacion r : getAll()){
            if (r.getIdRelacion() == idRelacion) {
                relacion = r;
            }
        }
        
        return relacion;
    }
}
