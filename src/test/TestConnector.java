package test;
import connectors.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
public class TestConnector {
    public static void main(String[] args) throws Exception {
        Connection conn = Connector.getConnection();
        
        String query = "insert into clientes(nombre, apellido, edad) values ('Facundo', 'Tapia', 20)";
        
        Connector.getConnection().createStatement().execute(query);
        
        ResultSet rs = conn.createStatement().executeQuery("select * from clientes");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id")+", "+
                    rs.getString("nombre")+", "+
                    rs.getString("apellido")+", "+
                    rs.getInt("edad")+", "
            );
        }
    }
}
