package CasaCambio;

/**
 * <h1>Clase EUR</h1>
 * <p>Representa la moneda "Euro" (EUR) dentro del sistema de Casa de Cambio.</p>
 * <p>Esta clase hereda de la clase {@link Moneda} y define los valores específicos
 * para el Euro, incluyendo su nombre, código y tasa de cambio (valor).</p>
 *
 * @author Tu Nombre (o el nombre del autor del proyecto)
 * @version 1.0
 * @see Moneda
 */
public class EUR extends Moneda {
    /**
     * Constructor por defecto para la moneda Euro.
     * Llama al constructor de la clase base (Moneda) para inicializar
     * los atributos con los valores fijos para el Euro.
     * <ul>
     * <li>Nombre: "Euro"</li>
     * <li>Código: "EUR"</li>
     * <li>Tasa (Valor de cambio): 4500</li>
     * </ul>
     */
    public EUR() {
        super("Euro", "EUR", 4500);
    }
}
