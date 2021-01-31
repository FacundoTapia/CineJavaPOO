package test;
import connectors.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
public class TestConnector {
    public static void main(String[] args) throws Exception {
        Connection conn = Connector.getConnection();
        
        String query = "insert into salas(numero, tipo, capacidad) values (6, 'DOSD', 100)";
        
        Connector.getConnection().createStatement().execute(query);
        
        ResultSet rs = conn.createStatement().executeQuery("select * from salas");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("numero")+", "+
                    rs.getString("tipo")+", "+
                    rs.getInt("capacidad")+", "+
                    rs.getBoolean("transmitiendo")
            );
        }
    }
}
