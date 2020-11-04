package entidades;
public class Sala {
    private int numero;
    private Enum TipoSala;
    private int capacidad;
    private int asientosDisponibles;
    private boolean transmitiendo = false;

    public Sala() {}

    public Sala(int numero, Enum TipoSala, int capacidad, int asientosDisponibles) {
        this.numero = numero;
        this.TipoSala = TipoSala;
        this.capacidad = capacidad;
        this.asientosDisponibles = asientosDisponibles;
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", TipoSala=" + TipoSala + ", capacidad=" + capacidad + ", asientosDisponibles=" + asientosDisponibles;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public boolean isTransmitiendo() {
        return transmitiendo;
    }

    public void setTransmitiendo(boolean transmitiendo) {
        this.transmitiendo = transmitiendo;
    }
}
