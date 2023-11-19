package logica;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BlackjackServer {
    private static final int PORT = 8084;
    private static int playerCount = 0; // Contador de jugadores
    private static List<PrintWriter> players = new ArrayList<>(); // Lista de jugadores conectados

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor en espera de conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                playerCount++; // Incrementa el contador de jugadores
                System.out.println("Nuevo jugador conectado: " + clientSocket.getInetAddress().getHostAddress());

                // Manejar la conexión del jugador en un hilo separado
                Thread playerThread = new Thread(new PlayerHandler(clientSocket));
                playerThread.start();

                // Agrega el jugador a la lista de jugadores conectados
                PrintWriter playerOutput = new PrintWriter(clientSocket.getOutputStream(), true);
                players.add(playerOutput);

                // Envía un mensaje a todos los jugadores conectados con la cantidad actual de jugadores
                for (PrintWriter player : players) {
                    player.println("Jugadores conectados: " + playerCount);
                }

                // Inicia el juego cuando se conecten 2 jugadores
                if (playerCount >= 2) {
                    // Aquí puedes iniciar el juego
                    System.out.println("¡Dos jugadores conectados! Comenzando el juego...");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}