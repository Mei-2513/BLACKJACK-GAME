package logica;

import java.io.Serializable;

public class PlayerInfo implements Serializable {
    private static final long serialVersionUID = 1L; // Añade esta línea para evitar warnings

    private String playerName;
    private String serverIP;
    private int serverPort;

    public PlayerInfo(String playerName, String serverIP, int serverPort) {
        this.playerName = playerName;
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getServerIP() {
        return serverIP;
    }

    public int getServerPort() {
        return serverPort;
    }
}
