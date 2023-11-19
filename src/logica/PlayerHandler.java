

package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerHandler implements Runnable {
    private Player player;
    private BufferedReader input;
    private PrintWriter output;
    private BlackJack game; // Referencia al juego de Blackjack

    public PlayerHandler(Player player) {
        this.player = player;
        this.game = game;
        try {
            Socket socket = player.getSocket();
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = input.readLine()) != null) {
                if (player.isDealer()) {
                    // Lógica para manejar al crupier
                    // Puedes usar métodos de la clase BlackJack aquí
                    System.out.println("Mensaje del crupier: " + message);
                } else {
                    // Lógica para manejar a los jugadores humanos
                    // Puedes usar métodos de la clase BlackJack aquí
                    System.out.println("Mensaje del jugador: " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                player.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
