package CasaCambio;

/**
 * Clase COP (Peso Colombiano)
 * Representa la moneda **Peso Colombiano** (COP) dentro del sistema 
 * de la Casa de Cambio.
 * Herencia simple: Esta clase extiende (hereda de) la clase {@link Moneda} para obtener 
 * las funcionalidades básicas de una unidad monetaria.
 *
 * @yane
 */
public class COP extends Moneda {
    /**
     * Constructor por defecto para la moneda Peso Colombiano (COP).
     * Inicializa la moneda llamando al constructor de la clase base {@code Moneda} 
     * con los siguientes valores fijos:
     * 
     * Nombre: "Peso Colombiano"
     * Código (abreviatura): "COP"
     * Tasa (Valor de cambio): 1.0 (Generalmente usada como referencia base)
     * 
     */
    public COP() {
        super("Peso Colombiano", "COP", 1.0);
    }
}