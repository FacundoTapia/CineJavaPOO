package entidades;

public class Pelicula {
    private int codigo;
    private String titulo;
    private int duracion;
    private String genero;
    private boolean esMas18;
    private String descripcion;
    private String rutaPortada;
    
    public Pelicula() {}

    public Pelicula(String titulo, int duracion, String genero, boolean esMas18, String descripcion) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.esMas18 = esMas18;
        this.descripcion = descripcion;
    }

    public Pelicula(String titulo, int duracion, String genero, boolean esMas18, String descripcion, String rutaPortada) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.esMas18 = esMas18;
        this.descripcion = descripcion;
        this.rutaPortada = rutaPortada;
    }

    public Pelicula(int codigo, String titulo, int duracion, String genero, boolean esMas18, String descripcion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.esMas18 = esMas18;
        this.descripcion = descripcion;
    }

    public Pelicula(int codigo, String titulo, int duracion, String genero, boolean esMas18, String descripcion, String rutaPortada) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.esMas18 = esMas18;
        this.descripcion = descripcion;
        this.rutaPortada = rutaPortada;
    }

    @Override
    public String toString() {
        return codigo + ", " + titulo + ", " + duracion + ", " + genero + ", " + esMas18 + ", " + descripcion;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean getEsMas18() {
        return esMas18;
    }

    public void setEsMas18(boolean esMas18) {
        this.esMas18 = esMas18;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaPortada() {
        return rutaPortada;
    }

    public void setRutaPortada(String rutaPortada) {
        this.rutaPortada = rutaPortada;
    }
}
