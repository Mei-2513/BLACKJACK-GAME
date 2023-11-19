package logica;

import javax.swing.*;
import java.awt.*;

public class ConfigFrame extends JFrame {
    private JTextField ipField;
    private JTextField portField;
    private JTextField playerNameField;
    private boolean configured = false;
    private String playerName;

    private JRadioButton dealerButton;
    private JRadioButton playerButton;
    private ButtonGroup group;

    private JPanel serverPanel;
    private JPanel portPanel;

    public ConfigFrame() {
        super("Configuración de conexión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(7, 1));  // Ajusta el GridLayout
        setLocationRelativeTo(null);

        // Establece el color de fondo del panel principal
        getContentPane().setBackground(new Color(53, 101, 77));

        // Crea etiquetas con texto en negro y añádelas al panel principal
        add(createLabel("Ingrese su nombre:", Color.BLACK));

        playerNameField = createTextField(20);
        add(playerNameField);

        // Crea los botones de opción
        dealerButton = new JRadioButton("Jugar contra el crupier");
        playerButton = new JRadioButton("Jugar contra otro jugador");

        // Agrupa los botones de opción
        group = new ButtonGroup();
        group.add(dealerButton);
        group.add(playerButton);

        // Añade los botones de opción al panel principal
        add(dealerButton);
        add(playerButton);

        // Crea un panel para los campos del servidor
        serverPanel = new JPanel();
        serverPanel.add(createLabel("Dirección IP del servidor:", Color.BLACK));
        ipField = createTextField(15);
        serverPanel.add(ipField);

        // Crea un panel para el campo del puerto
        portPanel = new JPanel();
        portPanel.add(createLabel("Puerto del servidor:", Color.BLACK));
        portField = createTextField(5);
        portPanel.add(portField);

        // Añade los paneles al panel principal
        add(serverPanel);
        add(portPanel);

        JButton connectButton = createConnectButton("Conectar");
        add(connectButton);

        // Añade un ActionListener a los botones de opción para mostrar u ocultar los paneles
        dealerButton.addActionListener(e -> {
            serverPanel.setVisible(false);
            portPanel.setVisible(true);
        });
        playerButton.addActionListener(e -> {
            serverPanel.setVisible(true);
            portPanel.setVisible(true);
        });

        // Desmarca todos los botones de opción
        group.clearSelection();
    }

    private JLabel createLabel(String text, Color textColor) {
        JLabel label = new JLabel(text);
        label.setForeground(textColor);
        return label;
    }

    private JTextField createTextField(int columns) {
        JTextField textField = new JTextField(columns);
        return textField;
    }

    private JButton createConnectButton(String text) {
        JButton connectButton = new JButton(text);
        connectButton.setBackground(new Color(176, 224, 230)); // Color turquesa
        connectButton.addActionListener(e -> {
            configured = true;
            playerName = playerNameField.getText();
            dispose();
        });
        return connectButton;
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

    public boolean isPlayingAgainstDealer() {
        return dealerButton.isSelected();
    }
}

