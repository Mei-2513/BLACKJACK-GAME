package logica;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BlackjackServer {
    private static final int PORT = 8084;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor en espera de conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuevo jugador conectado: " + clientSocket.getInetAddress().getHostAddress());

                // Manejar la conexión del jugador en un hilo separado
                Thread playerThread = new Thread(new PlayerHandler(clientSocket));
                playerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}