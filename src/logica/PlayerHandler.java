package logica;

import java.io.*;
import java.net.Socket;

public class PlayerHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;

    public PlayerHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // Aquí manejas la comunicación con el jugador, envías y recibes mensajes
            // Puedes usar input.readLine() para leer mensajes del jugador
            // Y output.println() para enviar mensajes al jugador
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}