package entidades;

public class Pelicula {
    private int codigo;
    private String titulo;
    private String duracion;
    private String genero;
    private boolean esMas18;
    
    public Pelicula() {}

    public Pelicula(String titulo, String duracion, String genero) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
    }

    public Pelicula(int codigo, String titulo, String duracion, String genero, boolean esMas18) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.esMas18 = esMas18;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero + ", esMas18=" + esMas18;
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

    public boolean isEsMas18() {
        return esMas18;
    }

    public void setEsMas18(boolean esMas18) {
        this.esMas18 = esMas18;
    }
}
