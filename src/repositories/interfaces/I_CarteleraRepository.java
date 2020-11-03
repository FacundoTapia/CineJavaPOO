package repositories.interfaces;

import entidades.Cartelera;
import entidades.Pelicula;
import entidades.Sala;
import java.util.Date;
import java.util.List;

public interface I_CarteleraRepository {
    void crear(Cartelera cartelera);
    void borrar(Cartelera cartelera);
    void actualizar(Cartelera cartelera);
    List<Cartelera> getAll();
    Cartelera getByCodEstreno(int id);
    List<Cartelera> getByFecha(Date fecha);
    List<Cartelera> getBySala(Sala sala);
    List<Cartelera> getByPelicula(Pelicula pelicula);
    String formateoFecha(Date date);
}
