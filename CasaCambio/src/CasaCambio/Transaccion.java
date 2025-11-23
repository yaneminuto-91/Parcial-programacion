package CasaCambio;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * <h1>Clase Transaccion</h1>
 * <p>Define un objeto que representa una **operación de cambio de moneda** completada.</p>
 * <p>Esta clase se utiliza para almacenar los detalles de cada conversión realizada, 
 * lo que permite a la {@code CasaDeCambio} mantener un historial.</p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Transaccion {

    /**
     * Objeto Moneda que representa la moneda inicial de la conversión.
     */
    private Moneda origen;
    /**
     * Objeto Moneda que representa la moneda final de la conversión.
     */
    private Moneda destino;
    /**
     * El monto de dinero ingresado por el usuario en la moneda de origen.
     */
    private double monto;
    /**
     * El resultado de la conversión en la moneda de destino.
     */
    private double resultado;

    /**
     * Constructor para inicializar una nueva Transacción.
     * Guarda los detalles completos de la operación de cambio.
     *
     * @param origen La moneda de origen (objeto Moneda).
     * @param destino La moneda de destino (objeto Moneda).
     * @param monto La cantidad original convertida.
     * @param resultado La cantidad obtenida después de la conversión.
     */
    public Transaccion(Moneda origen, Moneda destino, double monto, double resultado) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
        this.resultado = resultado;
    }

    /**
     * Sobrescribe el método {@code toString()} para formatear la transacción en una cadena de texto 
     * clara y legible, ideal para mostrar en un historial.
     * <p>El formato utilizado es: [Monto Formateado] [Código Origen] → [Resultado Formateado] [Código Destino]</p>
     *
     * @return Una cadena de texto que describe la transacción con los montos formateados como moneda.
     */
    @Override
    public String toString() {
        
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "us"));
        
        return formatoMoneda.format(monto) + " " + origen.getCodigo() +
                " → " + formatoMoneda.format(resultado) + " " + destino.getCodigo();
    }
}