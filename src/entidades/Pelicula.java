package entidades;

public class Pelicula {
    private int codigo;
    private String titulo;
    private String duracion;
    private String genero;

    public Pelicula() {}

    public Pelicula(String titulo, String duracion, String genero) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
    }

    public Pelicula(int codigo, String titulo, String duracion, String genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return codigo + ", " + titulo + ", " + duracion + ", " + genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
