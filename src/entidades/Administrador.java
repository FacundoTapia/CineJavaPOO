package entidades;
public class Administrador {
    private int idAdmin;
    private String usuario;
    private String password;

    public Administrador(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Administrador(int idAdmin, String usuario, String password) {
        this.idAdmin = idAdmin;
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public String toString() {
        return idAdmin + ", " + usuario + ", " + password;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
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
}
