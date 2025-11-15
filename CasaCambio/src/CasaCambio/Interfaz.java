package CasaCambio;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Interfaz extends JFrame {

    private CasaDeCambio casa = new CasaDeCambio();
    private JTextField campoMonto;
    private JComboBox<Moneda> boxOrigen;
    private JComboBox<Moneda> boxDestino;

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

    private void abrirHistorial() {
        VentanaHistorial v = new VentanaHistorial(casa);
        String texto = "";

        for (String t : casa.obtenerHistorial()) {
            texto += t + "\n";
        }

        v.setTextoHistorial(texto);
    }

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
