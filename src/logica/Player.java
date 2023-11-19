package logica;

import java.io.PrintWriter;
import java.net.Socket;

public class Player {
    private boolean isDealer;
    private Socket socket;
    private PrintWriter output;
    private String name;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public PrintWriter getOutput() {
        return output;
    }

    public void setOutput(PrintWriter output) {
        this.output = output;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDealer() {
        return isDealer;
    }

    public void setDealer(boolean dealer) {
        isDealer = dealer;
    }

    public Player(Socket socket, PrintWriter output, String name, boolean isDealer) {
        this.socket = socket;
        this.output = output;
        this.name = name;
        this.isDealer = isDealer;
    }


}

