package CasaCambio;

import javax.swing.*;

/**
 * <h1>Clase PantallaBienvenida</h1>
 * <p>Representa la primera ventana que ve el usuario al iniciar la aplicación (Splash Screen).</p>
 * <p>Extiende de {@link JFrame} y su propósito es dar la bienvenida y proporcionar un botón 
 * para iniciar la interfaz principal de la Casa de Cambio.</p>
 *
 * @author Tu Nombre
 * @version 1.0
 * @see Interfaz
 */
public class PantallaBienvenida extends JFrame {

    /**
     * Constructor de la Pantalla de Bienvenida.
     * <p>Se encarga de configurar las propiedades básicas de la ventana (título, tamaño, cierre) 
     * y de inicializar y posicionar sus componentes gráficos: dos etiquetas de texto y el botón "Iniciar".</p>
     * <p>El botón "Iniciar" contiene un **ActionListener** que cierra esta ventana e inicia la {@link Interfaz} principal.</p>
     */
    public PantallaBienvenida() {

        setTitle("Casa de Cambio Yanne.Minuto");
        setSize(520, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Bienvenido a Casa de Cambio");
        lblTitulo.setBounds(150, 50, 300, 30);
        add(lblTitulo);

        JLabel lblTitulo2 = new JLabel("Yanne.Minuto");
        lblTitulo2.setBounds(200, 80, 200, 30);
        add(lblTitulo2);

        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(180, 150, 150, 40);
        add(btnIniciar);

        /**
         * Oyente de acción (ActionListener) para el botón "Iniciar".
         * Cuando se presiona el botón:
         * 1. Cierra ({@code dispose()}) la ventana de bienvenida actual.
         * 2. Crea e inicia la {@link Interfaz} principal de la aplicación.
         */
        btnIniciar.addActionListener(e -> {
            dispose();
            new Interfaz();
        });

        setVisible(true);
    }
}