package CasaCambio;

/**
 * <h1>Clase Main</h1>
 * <p>Es la clase principal del proyecto y el **punto de inicio** de la aplicación Java.</p>
 * <p>Su única responsabilidad es iniciar la interfaz gráfica de usuario (GUI).</p>
 *
 * @yane
 */
public class Main {
    /**
     * El método principal (Main) que se ejecuta al iniciar el programa.
     * Crea una nueva instancia de {@code PantallaBienvenida}, lo que desencadena 
     * el inicio y la visualización de la interfaz gráfica de la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        new PantallaBienvenida();
    }
}