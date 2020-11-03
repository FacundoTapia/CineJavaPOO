package repositories.interfaces;

import entidades.Pelicula;
import java.util.List;
import java.util.stream.Stream;

public interface I_PeliculaRepository {
    void guardar(Pelicula pelicula);
    void borrar(Pelicula pelicula);
    List<Pelicula> getAll();
    default Stream<Pelicula> getStream(){
        return getAll().stream();
    }
    Pelicula getByCodigo(int codigo);
}
