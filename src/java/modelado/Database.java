package modelado;

/**
 *
 * @author Fabian
 */
public class Database {
    
    private String driver;
    private String url;
    private String usuario;
    private String pass;

    public Database() {
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/ejemplo";
        this.usuario = "root";
        this.pass = "";
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }
    
    
}
