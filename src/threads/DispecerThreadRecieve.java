package threads;

import classes.ObListaPodatak;
import classes.Podatak;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.text.TableView;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;

public class DispecerThreadRecieve extends Thread {
    Socket s;
    Podatak p;
    ObjectInputStream ois;
    javafx.scene.control.TableView<Podatak> table;

    public DispecerThreadRecieve(Socket s, javafx.scene.control.TableView<Podatak> table) {
        this.table = table;
        this.s = s;
        try {
            ois = new ObjectInputStream(s.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                p = (Podatak) ois.readObject();
                table.setItems(loadData(p));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(p);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ObservableList<Podatak> loadData(Podatak p) {
        ObListaPodatak.listaPodataka.add(p);
        return ObListaPodatak.listaPodataka;
    }
}
