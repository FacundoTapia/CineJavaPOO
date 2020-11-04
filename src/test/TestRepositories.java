package test;
import java.sql.ResultSet;
import connectors.Connector;
import entidades.Cartelera;
import entidades.Cliente;
import entidades.Detalle;
import entidades.Entrada;
import entidades.Pelicula;
import entidades.Sala;
import enums.TipoSala;
import java.sql.SQLException;
import java.util.Date;
import repositories.interfaces.I_CarteleraRepository;
import repositories.interfaces.I_ClienteRepository;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_EntradaRepository;
import repositories.interfaces.I_PeliculaRepository;
import repositories.interfaces.I_SalaRepository;
import repositories.jdbc.CarteleraRepository;
import repositories.jdbc.ClienteRepository;
import repositories.jdbc.DetalleRepository;
import repositories.jdbc.EntradaRepository;
import repositories.jdbc.PeliculaRepository;
import repositories.jdbc.SalaRepository;

public class TestRepositories {
    public static void main(String[] args) throws SQLException {
        I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
        
        Cliente cliente = new Cliente("Martin", "Tapia", 21);
        
        cr.registrar(cliente);
        
        System.out.println("**************** CLIENTES *************************");
        
        ResultSet rs = Connector.getConnection().createStatement().executeQuery("select * from clientes");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id")+", "+
                    rs.getString("nombre")+", "+
                    rs.getString("apellido")+", "+
                    rs.getInt("edad")
            );
        }

        cr.borrar(cr.getById(3));
        
        System.out.println(cr.getById(8));
        System.out.println("****************************************************");
        
        cr.getAll().forEach(System.out::println);
        
        System.out.println("**************** PELCICULAS *************************");
        
        I_PeliculaRepository pr = new PeliculaRepository(Connector.getConnection());
        
        Pelicula pelicula = new Pelicula("Avengers", 180, "Ficción");
        
        pr.guardar(pelicula);
        
        System.out.println(pelicula);
        
        pr.borrar(pr.getByCodigo(2));
        
        System.out.println("****************************************************");
        
        pr.getAll().forEach(System.out::println);
        
        System.out.println("**************** SALAS *************************");
        
        I_SalaRepository sr = new SalaRepository(Connector.getConnection());
        
        Sala sala = new Sala(1, TipoSala.TRESD, 100, 100);
        
        sr.crear(sala);
        
        System.out.println(sala);
        
        System.out.println(sr.getByNumero(1));
        
        sr.borrar(sr.getByNumero(2));
        
        System.out.println("****************************************************");
        
        sr.getAll().forEach(System.out::println);
        
        System.out.println("**************** DETALLE *************************");
        
//        I_DetalleRepository dr = new DetalleRepository(Connector.getConnection());
//        
//        Detalle detalle = new Detalle(0, 0, fecha);
//        
//        System.out.println("**************** CARTELERA *************************");
//        
//        I_CarteleraRepository car = new CarteleraRepository(Connector.getConnection());
//        
//        Cartelera cartelera = new Cartelera(0, 0);
//        
//        car.crear(cartelera);
//        
//        System.out.println(cartelera);
//        
//        car.borrar(cartelera);
//        
//        System.out.println("****************************************************");
//        
//        car.getAll().forEach(System.out::println);
//        
//        System.out.println("**************** ENTRADA *************************");
//        
//        I_EntradaRepository er = new EntradaRepository(Connector.getConnection());
//        
//        Entrada entrada = new Entrada(cliente.getId(), cartelera.getNroSala());
//        
//        er.crear(entrada);
//        
//        System.out.println(entrada);
//        
//        er.borrar(entrada);
//        
//        System.out.println("****************************************************");
//        
//        er.getAll().forEach(System.out::println);
        
        
    }
}
