package CasaCambio;

/**
 * <h1>Clase Abstracta Moneda</h1>
 * <p>Define la estructura base para cualquier unidad monetaria (dólar, euro, peso, etc.) 
 * dentro del sistema de la Casa de Cambio.</p>
 * <p>Es una clase **abstracta**, lo que significa que no puede ser instanciada directamente, 
 * sino que debe ser extendida (heredada) por monedas específicas como {@code USD} o {@code EUR}.</p>
 * <p>Contiene la lógica fundamental para realizar la conversión entre cualquier par de monedas, 
 * utilizando el Peso Colombiano (COP) como moneda de referencia base.</p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public abstract class Moneda {

    /**
     * Nombre completo de la moneda (ej: "Dólar Americano").
     */
    private String nombre;
    /**
     * Código de tres letras de la moneda (ej: "USD", "COP").
     */
    private String codigo;
    /**
     * Valor de esta moneda con respecto a la moneda base (COP). 
     * Representa cuántos COP equivalen a 1 unidad de esta moneda.
     */
    private double valorEnCOP;

    /**
     * Constructor para inicializar una nueva instancia de Moneda (llamado por las subclases).
     *
     * @param nombre El nombre completo de la moneda.
     * @param codigo El código de tres letras de la moneda (ej: "USD").
     * @param valorEnCOP El valor de 1 unidad de esta moneda expresado en COP.
     */
    public Moneda(String nombre, String codigo, double valorEnCOP) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.valorEnCOP = valorEnCOP;
    }

    /**
     * Obtiene el nombre completo de la moneda.
     *
     * @return El nombre de la moneda.
     */
    public String getNombre() { return nombre; }
    
    /**
     * Obtiene el código de tres letras de la moneda.
     *
     * @return El código (ej: "USD").
     */
    public String getCodigo() { return codigo; }
    
    /**
     * Obtiene el valor de 1 unidad de esta moneda en términos de COP.
     *
     * @return El valor en COP.
     */
    public double getValorEnCOP() { return valorEnCOP; }

    /**
     * Realiza la conversión de un monto dado desde esta moneda hacia una moneda de destino.
     * <p>El cálculo se realiza en dos pasos:</p>
     * <ol>
     * <li>Convertir el {@code monto} de la moneda de origen a la moneda base (COP).</li>
     * <li>Convertir el monto resultante en COP a la moneda de {@code destino}.</li>
     * </ol>
     *
     * @param monto La cantidad de dinero a convertir.
     * @param destino El objeto Moneda al cual se desea convertir.
     * @return El monto convertido en la moneda de destino.
     */
    public double convertirA(double monto, Moneda destino) {
        double montoEnCOP = monto * valorEnCOP;
        return montoEnCOP / destino.valorEnCOP;
    }

    /**
     * Sobrescribe el método {@code toString()} para que, cuando se imprima o use en un JComboBox, 
     * solo muestre el código de la moneda.
     *
     * @return El código de la moneda (ej: "USD").
     */
    @Override
    public String toString() {
        return codigo;
    }
}