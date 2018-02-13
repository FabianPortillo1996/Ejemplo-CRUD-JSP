package modelado;

import java.util.List;

/**
 *
 * @author Fabian
 */
public interface Operaciones {
    
    public String insertar(Object obj);
    public String eliminar(Object obj);
    public String modificar(Object obj);
    public List<?> consultar(); 
    
}
