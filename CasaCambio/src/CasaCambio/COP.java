package CasaCambio;

/**
 * <h1>Clase COP (Peso Colombiano)</h1>
 * <p>Representa la moneda **Peso Colombiano** (COP) dentro del sistema 
 * de la Casa de Cambio.</p>
 * <p>Esta clase extiende (hereda de) la clase {@link Moneda} para obtener 
 * las funcionalidades básicas de una unidad monetaria.</p>
 *
 * @author Tu Nombre
 * @version 1.0
 * @see Moneda
 */
public class COP extends Moneda {
    /**
     * Constructor por defecto para la moneda Peso Colombiano (COP).
     * <p>Inicializa la moneda llamando al constructor de la clase base {@code Moneda} 
     * con los siguientes valores fijos:</p>
     * <ul>
     * <li>Nombre: "Peso Colombiano"</li>
     * <li>Código (abreviatura): "COP"</li>
     * <li>Tasa (Valor de cambio): 1.0 (Generalmente usada como referencia base)</li>
     * </ul>
     */
    public COP() {
        super("Peso Colombiano", "COP", 1.0);
    }
}