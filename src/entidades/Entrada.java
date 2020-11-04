package entidades;
public class Entrada {
    private int nroEntrada;
    private int idCliente;
    private int datosPeli;
    private double precio = 150;

    public Entrada() {}

    public Entrada(int idCliente, int datosPeli) {
        this.idCliente = idCliente;
        this.datosPeli = datosPeli;
    }

    public Entrada(int nroEntrada, int idCliente, int datosPeli) {
        this.nroEntrada = nroEntrada;
        this.idCliente = idCliente;
        this.datosPeli = datosPeli;
    }

    @Override
    public String toString() {
        return nroEntrada + ", " + idCliente + ", " + datosPeli + ", " + precio;
    }

    public int getNroEntrada() {
        return nroEntrada;
    }

    public void setNroEntrada(int nroEntrada) {
        this.nroEntrada = nroEntrada;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getDatosPeli() {
        return datosPeli;
    }

    public void setDatosPeli(int datosPeli) {
        this.datosPeli = datosPeli;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}