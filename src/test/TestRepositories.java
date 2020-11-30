package test;
import java.sql.ResultSet;
import connectors.Connector;
import entidades.Cartelera;
import entidades.Cliente;
import entidades.Detalle;
import entidades.Entrada;
import entidades.Pelicula;
import entidades.Relacion;
import entidades.Sala;
import enums.TipoSala;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import repositories.interfaces.I_CarteleraRepository;
import repositories.interfaces.I_ClienteRepository;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_EntradaRepository;
import repositories.interfaces.I_PeliculaRepository;
import repositories.interfaces.I_RelacionRepository;
import repositories.interfaces.I_SalaRepository;
import repositories.jdbc.CarteleraRepository;
import repositories.jdbc.ClienteRepository;
import repositories.jdbc.DetalleRepository;
import repositories.jdbc.EntradaRepository;
import repositories.jdbc.PeliculaRepository;
import repositories.jdbc.RelacionRepository;
import repositories.jdbc.SalaRepository;

public class TestRepositories {
    public static void main(String[] args) throws SQLException {
        I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
        
        Cliente cliente = new Cliente("Facundo", "Tapia", "tapita", "1234");
        
        cr.registrar(cliente);
        
        System.out.println(cliente);
        
        cr.borrar(cr.getById(2));
        
        System.out.println("**************** CLIENTES *************************");
        
        cr.getAll().forEach(System.out::println);
        
        System.out.println("**************** PELICULAS *************************");
        
        I_PeliculaRepository pr = new PeliculaRepository(Connector.getConnection());
        
        Pelicula pelicula = new Pelicula("Avengers", 200, "Ciencia Ficcion", false, "asd", "/imagenes/avengers.jpg");
        
        pr.guardar(pelicula);
        
        System.out.println(pelicula);
        
        System.out.println("****************************************************");
        
        pr.getAll().forEach(System.out::println);
        
        System.out.println("**************** SALAS *************************");
        
        I_SalaRepository sr = new SalaRepository(Connector.getConnection());
        
        Sala sala = new Sala(8, TipoSala.DOSD, 70);
        
        //sr.crear(sala);
        
        System.out.println(sala);
        
        System.out.println(sr.getByNumero(1));
        
        sr.borrar(sr.getByNumero(2));
        
        System.out.println("****************************************************");
        
        sr.getAll().forEach(System.out::println);
        
        System.out.println("**************** DETALLE *************************");
        
        I_DetalleRepository dr = new DetalleRepository(Connector.getConnection());
        
        Detalle detalle = new Detalle(1, 1, LocalDate.of(2020, Month.NOVEMBER, 30), LocalTime.of(22, 30));
        
        dr.crear(detalle);
        
        System.out.println(detalle);
        
        System.out.println("****************************************************");
        
        dr.getAll().forEach(System.out::println);
        
        System.out.println("**************** CARTELERA *************************");
        
        I_CarteleraRepository car = new CarteleraRepository(Connector.getConnection());
        
        Cartelera cartelera = new Cartelera(4, "Cartelera Recoleta");
        
        //car.crear(cartelera);
        
        System.out.println(cartelera);
        
        System.out.println("**************** RELACIONES *************************");

        I_RelacionRepository rr = new RelacionRepository(Connector.getConnection());
        
        Relacion relacion = new Relacion(4, 8);
        
        rr.crear(relacion);
        
        System.out.println(relacion);
        
        System.out.println("****************************************************");
        
        rr.getAll().forEach(System.out::println);        
        
        System.out.println("**************** ENTRADA *************************");
        
        I_EntradaRepository er = new EntradaRepository(Connector.getConnection());
        
        Entrada entrada = new Entrada(4, 8);
        
        er.crear(entrada);
        
        System.out.println(entrada);
        
        System.out.println("****************************************************");
        
        er.getAll().forEach(System.out::println);
    }
}
