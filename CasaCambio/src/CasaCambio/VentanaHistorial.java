package CasaCambio;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>Clase VentanaHistorial 📜</h1>
 * <p>Representa una ventana secundaria ({@link JFrame}) dedicada exclusivamente a mostrar el 
 * historial de transacciones realizadas en la Casa de Cambio.</p>
 * <p>Permite visualizar, hacer scroll sobre la lista y ofrece una opción para borrar todo el historial.</p>
 *
 * @author Tu Nombre
 * @version 1.0
 * @see CasaDeCambio
 */
public class VentanaHistorial extends JFrame {

    /**
     * Área de texto donde se muestra la lista de transacciones registradas. 
     * Se configura como no editable.
     */
    private JTextArea areaHistorial;
    /**
     * Referencia al objeto principal {@code CasaDeCambio} para poder acceder 
     * a su funcionalidad de borrado de historial.
     */
    private CasaDeCambio casa;

    /**
     * Constructor de la Ventana Historial.
     * <p>Inicializa la ventana, configura su diseño ({@link BorderLayout}), 
     * crea el área de texto con scroll y añade los botones de "Borrar Historial" y "Cerrar".</p>
     *
     * @param casa La instancia de la clase CasaDeCambio de la cual se obtendrá y borrará el historial.
     */
    public VentanaHistorial(CasaDeCambio casa) {
        this.casa = casa;

        setTitle("Historial de Transacciones");
        setSize(450, 420);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        areaHistorial = new JTextArea();
        areaHistorial.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaHistorial);
        add(scroll, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton btnBorrar = new JButton("Borrar Historial");
        JButton btnCerrar = new JButton("Cerrar");

        panelBotones.add(btnBorrar);
        panelBotones.add(btnCerrar);

        add(panelBotones, BorderLayout.SOUTH);

        /**
         * Oyente para el botón "Cerrar". Cierra solo esta ventana ({@code dispose()}).
         */
        btnCerrar.addActionListener(e -> dispose());

        /**
         * Oyente para el botón "Borrar Historial". Llama al método {@code borrarHistorial()}.
         */
        btnBorrar.addActionListener(e -> borrarHistorial());

        setVisible(true);
    }

    /**
     * Establece el contenido de texto que se mostrará en el área de historial.
     * Este método es llamado por la {@code Interfaz} principal al abrir esta ventana.
     *
     * @param texto La cadena de texto que contiene todas las transacciones formateadas.
     */
    public void setTextoHistorial(String texto) {
        areaHistorial.setText(texto);
    }

    /**
     * Muestra un cuadro de diálogo de confirmación. Si el usuario confirma, 
     * llama al método {@code casa.borrarHistorial()} para limpiar el registro 
     * y actualiza el área de texto a vacío.
     */
    private void borrarHistorial() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Seguro que deseas borrar todo el historial?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            casa.borrarHistorial();
            areaHistorial.setText("");
            JOptionPane.showMessageDialog(this, "Historial borrado exitosamente.");
        }
    }
}