package classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObListaPodatak {
    public volatile static ObservableList<Podatak> listaPodataka = FXCollections.observableArrayList();
    public static int brojRedni = 0;
}
