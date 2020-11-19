package entidades;
public class Sala {
    private int numero;
    private Enum TipoSala;
    private int capacidad;
    private boolean transmitiendo = false;

    public Sala() {}

    public Sala(int numero, Enum TipoSala, int capacidad) {
        this.numero = numero;
        this.TipoSala = TipoSala;
        this.capacidad = capacidad;
    }

    public Sala(int numero, Enum TipoSala, int capacidad, boolean transmitiendo) {
        this.numero = numero;
        this.TipoSala = TipoSala;
        this.capacidad = capacidad;
        this.transmitiendo = transmitiendo;
    }

    @Override
    public String toString() {
        return numero + ", " + TipoSala + ", " + capacidad + ", " + transmitiendo;
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

    public boolean isTransmitiendo() {
        return transmitiendo;
    }

    public void setTransmitiendo(boolean transmitiendo) {
        this.transmitiendo = transmitiendo;
    }
}
