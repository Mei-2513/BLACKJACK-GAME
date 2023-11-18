package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConfigFrame extends JFrame {
    private JTextField ipField;
    private JTextField portField;
    private JTextField playerNameField;
    private boolean configured = false;
    private String playerName; // Almacena el nombre ingresado por el usuario


    public ConfigFrame() {
        super("Configuración de conexión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new GridLayout(4, 3));
        setLocationRelativeTo(null);

        ipField = new JTextField();
        portField = new JTextField();
        playerNameField = new JTextField();
        add(new JLabel("Ingrese su nombre:"));
        add(playerNameField);
        add(new JLabel("Dirección IP del servidor:"));
        add(ipField);
        add(new JLabel("Puerto del servidor:"));
        add(portField);

        JButton connectButton = new JButton("Conectar");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configured = true;
                playerName = playerNameField.getText(); // Almacena el nombre ingresado
                dispose(); // Cierra la ventana después de la configuración
            }
        });

        add(connectButton);
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getServerIP() {
        return ipField.getText();
    }

    public int getServerPort() {
        return Integer.parseInt(portField.getText());
    }

    public boolean isConfigured() {
        return configured;
    }
}