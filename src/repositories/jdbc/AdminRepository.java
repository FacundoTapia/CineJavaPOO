package repositories.jdbc;

import entidades.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    private Connection conn;

    public AdminRepository(Connection conn) {
        this.conn = conn;
    }
    
    public void crear(Administrador administrador){
        if (administrador == null) return;
        
        try(PreparedStatement ps = conn.prepareStatement("insert into admin(usuario, pass) values(?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, administrador.getUsuario());
            ps.setString(2, administrador.getPassword());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                administrador.setIdAdmin(rs.getInt(1));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void borrar(Administrador administrador){
        if (administrador == null) return;
        
        try(PreparedStatement ps = conn.prepareStatement("delete from admin where idAdmin = ?")){
            ps.setInt(1, administrador.getIdAdmin());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Administrador> getAll(){
        List<Administrador> list = new ArrayList<>();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from admin")){
            while (rs.next()) {
                list.add(
                        new Administrador(
                                rs.getInt("idAdmin"), 
                                rs.getString("usuario"), 
                                rs.getString("pass")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
