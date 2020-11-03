package entidades;
public class Sala {
    private int numero;
    private Enum TipoSala;
    private int cantAsientos;
    private int asientosDisponibles;

    public Sala() {}

    public Sala(int numero, Enum TipoSala, int cantAsientos, int asientosDisponibles) {
        this.numero = numero;
        this.TipoSala = TipoSala;
        this.cantAsientos = cantAsientos;
        this.asientosDisponibles = asientosDisponibles;
    }

    @Override
    public String toString() {
        return numero + ", " + TipoSala + ", " + cantAsientos + ", " + asientosDisponibles + ", ";
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Enum getTipoSala() {
        return TipoSala;
    }

    public void setTipoSala(Enum TipoSala) {
        this.TipoSala = TipoSala;
    }

    public int getCantAsientos() {
        return cantAsientos;
    }

    public void setCantAsientos(int cantAsientos) {
        this.cantAsientos = cantAsientos;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }
}
