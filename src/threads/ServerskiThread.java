package threads;

import classes.Podatak;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerskiThread extends Thread {
    Socket s;
    int clientCounter;
    Podatak p;
    ObjectInputStream ois;
    public ServerskiThread(Socket s, int clientCounter) {
        this.s = s;
        this.clientCounter = clientCounter;
        try {
            ois = new ObjectInputStream(s.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.start();
    }

    @Override
    public void run() {
        while (true){
            try {
                p = (Podatak) ois.readObject();
                System.out.println(p);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
