package CasaCambio;

/**
 * <h1>Clase USD</h1>
 * <p>Representa la moneda **Dólar Americano** (USD) dentro del sistema de Casa de Cambio.</p>
 * <p>Esta clase hereda de la clase abstracta {@link Moneda} y define los valores específicos
 * para el Dólar, incluyendo su nombre, código y su valor de cambio respecto a la moneda base (COP).</p>
 *
 * @author Tu Nombre
 * @version 1.0
 * @see Moneda
 */
public class USD extends Moneda {
    /**
     * Constructor por defecto para la moneda Dólar Americano.
     * <p>Llama al constructor de la clase base (Moneda) para inicializar
     * los atributos con los siguientes valores fijos:</p>
     * <ul>
     * <li>Nombre: "Dólar Americano"</li>
     * <li>Código: "USD"</li>
     * <li>Tasa (Valor de cambio): 4000 (Asumido como el valor en COP por 1 USD)</li>
     * </ul>
     */
    public USD() {
        super("Dólar Americano", "USD", 4000);
    }
}