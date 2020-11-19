package test;

import connectors.Connector;
import entidades.Detalle;
import entidades.Pelicula;
import entidades.Relacion;
import entidades.Sala;
import enums.TipoSala;
import java.util.Date;
import repositories.interfaces.I_ClienteRepository;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_PeliculaRepository;
import repositories.interfaces.I_RelacionRepository;
import repositories.interfaces.I_SalaRepository;
import repositories.jdbc.ClienteRepository;
import repositories.jdbc.DetalleRepository;
import repositories.jdbc.PeliculaRepository;
import repositories.jdbc.RelacionRepository;
import repositories.jdbc.SalaRepository;

public class TestMetodos {
    public static void main(String[] args) {
//        I_SalaRepository sr = new SalaRepository(Connector.getConnection());
//        
//        Sala s1 = new Sala(2, TipoSala.DOSD , 100, 100);
//        
//        sr.crear(s1);
//        
//        I_PeliculaRepository pr = new PeliculaRepository(Connector.getConnection());
//        
//        Pelicula p1 = new Pelicula("Los juegos del hambre", 122, "Accion");
//        
//        pr.guardar(p1);
//        
//        pr.getAll().forEach(System.out::println);
//        
//        I_DetalleRepository dr = new DetalleRepository(Connector.getConnection());
//        
//        Detalle d1 = new Detalle(13, 2, new Date(2020-1900, 11, 15, 18, 30));
//        
//        dr.crear(d1);
//        
//        dr.getAll().forEach(System.out::println);
//        
//        I_RelacionRepository rr = new RelacionRepository(Connector.getConnection());
//        
//        Relacion r1 = new Relacion(1, 12);
//        
//        rr.crear(r1);
//        
//        rr.getAll().forEach(System.out::println);
//        
//        I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
//        
//        cr.getAll().forEach(System.out::println);
//        
//        System.out.println(cr.comprar(cr.getById(10), dr.getByCodDetalle(12), 100));
//        
//        System.out.println("***************************************************");
//        
//        System.out.println("Detalles que estan en la cartelera 1");
//        rr.getDetalleByCodCartelera(1).forEach(System.out::println);
//        
//        System.out.println("***************************************************");
//        System.out.println("Carteleras que contienen el detalle 12");
//        
//        rr.getCarteleraByCodDetalle(12).forEach(System.out::println);
    }
}
