package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

            // Envía un mensaje al jugador para que espere hasta que se conecten los demás jugadores
            output.println("Espera a que se conecten los demás jugadores");

            // Aquí puedes agregar más lógica para manejar la interacción con el jugador
            // Por ejemplo, puedes leer un mensaje del jugador y actuar en consecuencia
            String message = input.readLine();
            System.out.println("Mensaje del jugador: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}