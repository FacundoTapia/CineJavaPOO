package entidades;

import connectors.Connector;
import repositories.interfaces.I_ClienteRepository;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_EntradaRepository;
import repositories.interfaces.I_PeliculaRepository;
import repositories.interfaces.I_SalaRepository;
import repositories.jdbc.ClienteRepository;
import repositories.jdbc.DetalleRepository;
import repositories.jdbc.EntradaRepository;
import repositories.jdbc.PeliculaRepository;
import repositories.jdbc.SalaRepository;

public class Entrada {
    private int nroEntrada;
    private int idCliente;
    private int datosPeli;

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
        return nroEntrada + ", " + idCliente + ", " + datosPeli;
    }
    
    public String formatoEntrada(){
        if (this == null) return "entrada invalida";
        
        I_EntradaRepository er = new EntradaRepository(Connector.getConnection());
        I_DetalleRepository dr = new DetalleRepository(Connector.getConnection());
        I_PeliculaRepository pr = new PeliculaRepository(Connector.getConnection());
        I_SalaRepository sr = new SalaRepository(Connector.getConnection());
        I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
        
        Detalle dEntrada = dr.getByCodDetalle(this.datosPeli);
        Pelicula pEntrada = pr.getByCodigo(dEntrada.getCodPelicula());
        Sala sEntrada = sr.getByNumero(dEntrada.getNroSala());
        Cliente cEntrada = cr.getById(idCliente);
        
        String usuario = cEntrada.getUsuario();
        String tipoEntrada = sEntrada.getTipoSala().toString();
        String numeroSala = "SALA " + sEntrada.getNumero();
        String titulo = pEntrada.getTitulo();
        String fecha = dEntrada.getFecha().toString();
        String hora = dEntrada.getHorario().toString();
        
        String infoGral = numeroSala + ", " + titulo + ", " + tipoEntrada + ", " + fecha + ", " + hora;
        
        return infoGral;
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
}