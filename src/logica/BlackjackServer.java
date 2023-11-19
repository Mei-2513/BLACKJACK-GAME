package logica;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



public class BlackjackServer {
    private static final int PORT = 8085;
    private static int playerCount = 0; // Contador de jugadores
    private static List<Player> players = new ArrayList<>(); // Lista de jugadores conectados

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor en espera de conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                playerCount++; // Incrementa el contador de jugadores
                System.out.println("Nuevo jugador conectado: " + clientSocket.getInetAddress().getHostAddress());

                // Agrega el jugador a la lista de jugadores conectados
                PrintWriter playerOutput = new PrintWriter(clientSocket.getOutputStream(), true);
                Player player = new Player(clientSocket, playerOutput, "Player " + playerCount, false); // Jugador humano
                players.add(player);

                // Manejar la conexión del jugador en un hilo separado
                Thread playerThread = new Thread(new PlayerHandler(player));
                playerThread.start();

                // Añade el crupier y comienza el juego solo cuando se conecten exactamente dos jugadores humanos
                if (playerCount == 2 && players.size() == 2) {
                    Player dealer = new Player(null, null, "Dealer", true); // Crupier controlado por la máquina
                    players.add(dealer);
                    System.out.println("¡Dos jugadores conectados! Comenzando el juego...");
                    // Aquí puedes iniciar el juego
                    // game.start();
                }

                // Envía un mensaje a todos los jugadores conectados con la cantidad actual de jugadores
                for (Player p : players) {
                    p.getOutput().println("Jugadores conectados: " + playerCount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
