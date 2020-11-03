package connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String vendor = "mysql";
    private static String server = "localhost";
    private static String port = "3306";
    private static String db = "cine";
    private static String params = "";
    private static String user = "root";
    private static String pass = "root";
    
    private static String url = "jdbc:"+vendor+"://"+server+":"+port+"/"+db+params;
    
    private static Connection conn = null;

    private Connector() {}
    
    public synchronized static Connection getConnection(){
        try {
            if (conn == null || conn.isClosed()) {
                
                Class.forName(driver);
                
                conn = DriverManager.getConnection(url, user, pass);
            }
        } 
        catch (Exception e) { e.printStackTrace(); }
        
        return conn;
    }
}
