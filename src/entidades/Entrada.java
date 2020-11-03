package entidades;
public class Entrada {
    private int nroEntrada;
    private double precio = 100;
    private int idCliente;
    private int codCartelera;

    public Entrada() {}

    public Entrada(int idCliente, int codCartelera) {
        this.idCliente = idCliente;
        this.codCartelera = codCartelera;
    }

    public Entrada(int nroEntrada, int idCliente, int codCartelera) {
        this.nroEntrada = nroEntrada;
        this.idCliente = idCliente;
        this.codCartelera = codCartelera;
    }

    @Override
    public String toString() {
        return nroEntrada + ", " + precio + ", =" + idCliente + ", " + codCartelera;
    }

    public int getNroEntrada() {
        return nroEntrada;
    }

    public void setNroEntrada(int nroEntrada) {
        this.nroEntrada = nroEntrada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCodCartelera() {
        return codCartelera;
    }

    public void setCodCartelera(int codCartelera) {
        this.codCartelera = codCartelera;
    }
}
