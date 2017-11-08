package server;

import threads.ServerskiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1312);
            System.out.println("Server je pokrenut!");
            int clientCounter = 0;
            while (true){
                Socket s = ss.accept();
                System.out.println("Client accpeted: " + clientCounter++);
                ServerskiThread st = new ServerskiThread(s,clientCounter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
