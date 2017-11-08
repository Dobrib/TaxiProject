package testing;

import classes.Podatak;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Server started.");
        Socket s;
        ServerSocket ss = new ServerSocket(1312);
        s = ss.accept();
        System.out.println("Client connected!");
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        Object podatak;

        while(true){
            podatak = ois.readObject();
            System.out.println((Podatak)podatak);
        }
    }
}
