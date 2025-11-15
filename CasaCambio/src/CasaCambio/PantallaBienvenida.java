package CasaCambio;

import javax.swing.*;

public class PantallaBienvenida extends JFrame {

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

        btnIniciar.addActionListener(e -> {
            dispose();
            new Interfaz();
        });

        setVisible(true);
    }
}
