package CasaCambio;

import javax.swing.*;
import java.awt.*;

public class VentanaHistorial extends JFrame {

    private JTextArea areaHistorial;
    private CasaDeCambio casa;

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

        btnCerrar.addActionListener(e -> dispose());

        btnBorrar.addActionListener(e -> borrarHistorial());

        setVisible(true);
    }

    public void setTextoHistorial(String texto) {
        areaHistorial.setText(texto);
    }

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
