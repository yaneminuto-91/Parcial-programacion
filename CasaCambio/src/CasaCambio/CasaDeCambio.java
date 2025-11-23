package CasaCambio;

import java.util.ArrayList;

/**
 * <h1>Clase CasaDeCambio</h1>
 * <p>Representa el núcleo del sistema de la casa de cambio. 
 * Se encarga de manejar las operaciones de conversión de monedas y 
 * de mantener un registro de todas las transacciones realizadas.</p>
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class CasaDeCambio {

    /**
     * Lista privada que almacena todas las transacciones realizadas
     * en esta instancia de la casa de cambio.
     */
    private ArrayList<Transaccion> historial = new ArrayList<>();

    /**
     * Simula y calcula el monto resultante de una conversión sin registrarla.
     * La lógica de la conversión se delega a la moneda de origen.
     *
     * @param monto la cantidad de dinero a convertir.
     * @param origen el objeto Moneda que representa la moneda inicial.
     * @param destino el objeto Moneda a la que se desea convertir.
     * @return el monto convertido como un valor double.
     */
    public double simular(double monto, Moneda origen, Moneda destino) {
        return origen.convertirA(monto, destino);
    }

    /**
     * Realiza una conversión, calcula el resultado y registra la operación
     * completa como una nueva {@link Transaccion} en el historial.
     *
     * @param monto la cantidad de dinero a convertir.
     * @param origen el objeto Moneda que representa la moneda inicial.
     * @param destino el objeto Moneda a la que se desea convertir.
     */
    public void registrar(double monto, Moneda origen, Moneda destino) {
        double resultado = simular(monto, origen, destino);
        historial.add(new Transaccion(origen, destino, monto, resultado));
    }

    /**
     * Obtiene una lista de cadenas de texto (String) que representan
     * todas las transacciones almacenadas en el historial.
     *
     * @return un {@code ArrayList} de String con los detalles de cada transacción.
     */
    public ArrayList<String> obtenerHistorial() {
        ArrayList<String> datos = new ArrayList<>();
        for (Transaccion t : historial) {
            datos.add(t.toString());
        }
        return datos;
    }

    /**
     * Elimina permanentemente todas las transacciones almacenadas en el historial.
     */
    public void borrarHistorial() {
        historial.clear();
    }
}