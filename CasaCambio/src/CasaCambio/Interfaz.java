package CasaCambio;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * <h1>Clase Interfaz</h1>
 * <p>Representa la Ventana Principal (GUI) de la Casa de Cambio.</p>
 * <p>Esta clase extiende de {@link JFrame} y se encarga de construir todos los elementos visuales 
 * (botones, campos de texto, listas) y manejar la interacción del usuario para las conversiones y el historial.</p>
 *
 * @yane
 */
public class Interfaz extends JFrame {

    /**
     * Instancia de la clase CasaDeCambio. Es el objeto que contiene la lógica para realizar conversiones y manejar el historial.
     */
    private CasaDeCambio casa = new CasaDeCambio();
    /**
     * Campo de texto donde el usuario ingresa el monto de dinero a convertir.
     */
    private JTextField campoMonto;
    /**
     * Lista desplegable (ComboBox) para que el usuario seleccione la moneda de origen.
     */
    private JComboBox<Moneda> boxOrigen;
    /**
     * Lista desplegable (ComboBox) para que el usuario seleccione la moneda de destino.
     */
    private JComboBox<Moneda> boxDestino;

    /**
     * Constructor de la Interfaz.
     * <p>Configura la ventana (título, tamaño, layout) y se encarga de la **inicialización** * y el **posicionamiento** de todos los componentes de la interfaz gráfica (Swing).</p>
     * <p>También **instancia las monedas** (COP, USD, EUR) y asigna los **oyentes de eventos (listeners)** * a los botones.</p>
     */
    public Interfaz() {

        setTitle("Casa de Cambio Yanne.Minuto");
        setSize(550, 480);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblSaludo = new JLabel("Bienvenido(a) a Casa de Cambio Yanne.Minuto");
        lblSaludo.setBounds(120, 10, 400, 30);
        add(lblSaludo);

        JLabel lblMonto = new JLabel("Monto:");
        lblMonto.setBounds(50, 60, 150, 25);
        add(lblMonto);

        campoMonto = new JTextField();
        campoMonto.setBounds(200, 60, 200, 25);
        add(campoMonto);

        JLabel lblOrigen = new JLabel("Origen:");
        lblOrigen.setBounds(50, 120, 150, 25);
        add(lblOrigen);

        boxOrigen = new JComboBox<>();
        boxOrigen.setBounds(200, 120, 200, 25);
        add(boxOrigen);

        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setBounds(50, 180, 150, 25);
        add(lblDestino);

        boxDestino = new JComboBox<>();
        boxDestino.setBounds(200, 180, 200, 25);
        add(boxDestino);

        // Monedas (herencia y polimorfismo)
        Moneda cop = new COP();
        Moneda usd = new USD();
        Moneda eur = new EUR();

        boxOrigen.addItem(cop);
        boxOrigen.addItem(usd);
        boxOrigen.addItem(eur);

        boxDestino.addItem(cop);
        boxDestino.addItem(usd);
        boxDestino.addItem(eur);

        // Botones
        JButton btnSimular = new JButton("Simular");
        btnSimular.setBounds(50, 240, 150, 40);
        add(btnSimular);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(240, 240, 150, 40);
        add(btnRegistrar);

        JButton btnHistorial = new JButton("Ver Historial");
        btnHistorial.setBounds(50, 310, 150, 40);
        add(btnHistorial);

        JButton btnBorrar = new JButton("Borrar Historial");
        btnBorrar.setBounds(240, 310, 150, 40);
        add(btnBorrar);

        // Eventos
        btnSimular.addActionListener(e -> simular());
        btnRegistrar.addActionListener(e -> registrar());
        btnHistorial.addActionListener(e -> abrirHistorial());
        btnBorrar.addActionListener(e -> borrarHistorial());

        setVisible(true);
    }

    // ---------------- MÉTODOS ---------------------

    /**
     * Método privado asociado al botón "Simular".
     * <p>Lee el monto y las monedas seleccionadas, utiliza el objeto {@code casa} para calcular la conversión 
     * sin guardarla, y muestra el resultado formateado al usuario.</p>
     * <p>Contiene un bloque {@code try-catch} para manejar la excepción si el monto no es un número válido.</p>
     */
    private void simular() {
        try {
            double monto = Double.parseDouble(campoMonto.getText());
            Moneda origen = (Moneda) boxOrigen.getSelectedItem();
            Moneda destino = (Moneda) boxDestino.getSelectedItem();

            double resultado = casa.simular(monto, origen, destino);

            // Formato que evita notación científica
            NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "us"));

            JOptionPane.showMessageDialog(this,
                    "Resultado: " + formatoMoneda.format(resultado) + " " + destino.getCodigo());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Monto inválido");
        }
    }

    /**
     * Método privado asociado al botón "Registrar".
     * <p>Similar a {@code simular()}, pero llama al método {@code casa.registrar()} para guardar la transacción 
     * en el historial después de calcular el resultado.</p>
     * <p>Contiene un bloque {@code try-catch} para manejo de errores de entrada de monto.</p>
     */
    private void registrar() {
        try {
            double monto = Double.parseDouble(campoMonto.getText());
            Moneda origen = (Moneda) boxOrigen.getSelectedItem();
            Moneda destino = (Moneda) boxDestino.getSelectedItem();

            double resultado = casa.simular(monto, origen, destino);
            casa.registrar(monto, origen, destino);

            // Formato perfecto sin notación científica
            NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "us"));

            JOptionPane.showMessageDialog(this,
                    "Transacción registrada.\nResultado: "
                    + formatoMoneda.format(resultado) + " " + destino.getCodigo());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Monto inválido");
        }
    }

    /**
     * Método privado asociado al botón "Ver Historial".
     * <p>Crea una nueva instancia de {@code VentanaHistorial} (asumiendo que existe) 
     * y le pasa el historial de transacciones obtenido de la {@code CasaDeCambio} para ser visualizado.</p>
     */
    private void abrirHistorial() {
        VentanaHistorial v = new VentanaHistorial(casa);
        String texto = "";

        for (String t : casa.obtenerHistorial()) {
            texto += t + "\n";
        }

        v.setTextoHistorial(texto);
    }

    /**
     * Método privado asociado al botón "Borrar Historial".
     * <p>Muestra un cuadro de diálogo de confirmación al usuario antes de llamar al método 
     * {@code casa.borrarHistorial()} para limpiar el registro de transacciones.</p>
     */
    private void borrarHistorial() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Seguro que deseas borrar todo el historial?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            casa.borrarHistorial();
            JOptionPane.showMessageDialog(this, "Historial borrado exitosamente.");
        }
    }
}