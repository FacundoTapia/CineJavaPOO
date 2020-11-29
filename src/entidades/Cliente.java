package entidades;
public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String codigoRecuperacion;

    public Cliente() {}

    public Cliente(String nombre, String apellido, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
    }

    public Cliente(String nombre, String apellido, String usuario, String password, String codigoRecuperacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.codigoRecuperacion = codigoRecuperacion;
    }
    
    public Cliente(int id, String nombre, String apellido, String usuario, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
    }

    public Cliente(int id, String nombre, String apellido, String usuario, String password, String codigoRecuperacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.codigoRecuperacion = codigoRecuperacion;
    }

    @Override
    public String toString() {
        return id + ", " + nombre + ", " + apellido + ", " + usuario + ", " + password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodigoRecuperacion() {
        return codigoRecuperacion;
    }

    public void setCodigoRecuperacion(String codigoRecuperacion) {
        this.codigoRecuperacion = codigoRecuperacion;
    }
}
