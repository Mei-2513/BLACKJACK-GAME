package logica;

import javax.swing.*;
import java.awt.*;

public class ConfigFrame extends JFrame {
    private JTextField ipField;
    private JTextField portField;
    private JTextField playerNameField;
    private boolean configured = false;
    private String playerName; // Almacena el nombre ingresado por el usuario

    private JRadioButton dealerButton;
    private JRadioButton playerButton;
    private ButtonGroup group;

    private JPanel serverPanel;
    private JPanel portPanel;

    public ConfigFrame() {
        super("Configuración de conexión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new GridLayout(6, 1));  // Cambia a un GridLayout con 6 filas y 1 columna
        setLocationRelativeTo(null);

        // Establece el color de fondo del panel
        getContentPane().setBackground(Color.DARK_GRAY);

        // Crea etiquetas con texto en blanco
        JLabel nameLabel = new JLabel("Ingrese su nombre:");
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);

        playerNameField = new JTextField(20);  // Ajusta el tamaño del campo de texto
        add(playerNameField);

        // Crea los botones de opción
        dealerButton = new JRadioButton("Jugar contra el crupier");
        playerButton = new JRadioButton("Jugar contra otro jugador");

        // Agrupa los botones de opción
        group = new ButtonGroup();
        group.add(dealerButton);
        group.add(playerButton);

        // Añade los botones de opción al panel
        add(dealerButton);
        add(playerButton);

        // Crea un panel para los campos del servidor
        serverPanel = new JPanel();
        serverPanel.add(new JLabel("Dirección IP del servidor:"));
        ipField = new JTextField(15);  // Ajusta el tamaño del campo de texto
        serverPanel.add(ipField);

        // Crea un panel para el campo del puerto
        portPanel = new JPanel();
        portPanel.add(new JLabel("Puerto del servidor:"));
        portField = new JTextField(5);  // Ajusta el tamaño del campo de texto
        portPanel.add(portField);

        // Añade los paneles al panel principal
        add(serverPanel);
        add(portPanel);

        JButton connectButton = new JButton("Conectar");
        connectButton.setBackground(Color.LIGHT_GRAY);
        connectButton.addActionListener(e -> {
            configured = true;
            playerName = playerNameField.getText(); // Almacena el nombre ingresado
            dispose(); // Cierra la ventana después de la configuración
        });

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

