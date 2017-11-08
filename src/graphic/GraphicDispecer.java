package graphic;

import classes.ObListaPodatak;
import classes.Podatak;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import threads.DispecerThreadRecieve;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class GraphicDispecer extends Application {

    VBox verticalBox = new VBox();
    Scene scene;
    ObservableList<Podatak> data;
    ObjectOutputStream oos;
    Socket s = null;
    int clientCounter;
    Podatak p;
    ObjectInputStream ois;
    TableView<Podatak> table;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Zuti taksi - Dispecer");
        initialisation();
        try {
            ServerSocket ss = new ServerSocket(1312);
            Socket s = ss.accept();
            oos = new ObjectOutputStream(s.getOutputStream());
            DispecerThreadRecieve dr = new DispecerThreadRecieve(s, table);
        } catch (IOException e) {
            e.printStackTrace();
        }

        verticalBox.setMinWidth(700);
        verticalBox.setMaxWidth(700);
        data = FXCollections.observableArrayList();
        scene = new Scene(verticalBox, 700, 700);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void initialisation() {
        table = new TableView<Podatak>();

        table.setMaxWidth(1300);
        table.setMinWidth(1300);

        table.setMaxHeight(650);
        table.setMinHeight(650);


        TableColumn colbrojVoznje = new TableColumn("Broj voznje");
        colbrojVoznje.setMinWidth(162);
        colbrojVoznje.setMaxWidth(162);
        colbrojVoznje.setEditable(true);
        colbrojVoznje.setCellValueFactory(new PropertyValueFactory<Podatak, Integer>("redniBroj"));

        TableColumn colbrojLinije = new TableColumn("Broj linije");
        colbrojLinije.setMinWidth(162);
        colbrojLinije.setMaxWidth(162);
        colbrojLinije.setCellValueFactory(new PropertyValueFactory<Podatak, Integer>("brojLinije"));

        TableColumn colDatumIVreme = new TableColumn("Datum");
        colDatumIVreme.setMinWidth(162);
        colDatumIVreme.setMaxWidth(162);
        colDatumIVreme.setCellValueFactory(new PropertyValueFactory<Podatak, String>("datumIVreme"));

        TableColumn colAdresaSaBrojem = new TableColumn("Adresa");
        colAdresaSaBrojem.setMinWidth(162);
        colAdresaSaBrojem.setMaxWidth(162);
        colAdresaSaBrojem.setCellValueFactory(new PropertyValueFactory<Podatak, String>("adresaSaBrojem"));

        TableColumn colKucniBroj = new TableColumn("Broj kuce");
        colKucniBroj.setMinWidth(162);
        colKucniBroj.setMaxWidth(162);
        colKucniBroj.setCellValueFactory(new PropertyValueFactory<Podatak, Integer>("kucniBroj"));

        TableColumn colTaxiStanica = new TableColumn("Taksi stanica");
        colTaxiStanica.setMinWidth(162);
        colTaxiStanica.setMaxWidth(162);
        colTaxiStanica.setCellValueFactory(new PropertyValueFactory<Podatak, String>("taksiStanica"));

        TableColumn colNapomena = new TableColumn("Napomena");
        colNapomena.setMinWidth(162);
        colNapomena.setMaxWidth(162);
        colNapomena.setCellValueFactory(new PropertyValueFactory<Podatak, String>("napomena"));

        TableColumn colBrojKolege = new TableColumn("Broj Kolege");
        colBrojKolege.setMinWidth(162);
        colBrojKolege.setMaxWidth(162);
        colBrojKolege.setCellValueFactory(new PropertyValueFactory<Podatak, Integer>("brojKolege"));

        TableColumn colVremeUMinutima = new TableColumn("Vreme");
        colVremeUMinutima.setMinWidth(162);
        colVremeUMinutima.setMaxWidth(162);
        colVremeUMinutima.setCellValueFactory(new PropertyValueFactory<Podatak, Integer>("vremeUMinutima"));

        table.getColumns().addAll(colbrojVoznje, colbrojLinije, colDatumIVreme, colAdresaSaBrojem, colKucniBroj, colNapomena, colBrojKolege, colVremeUMinutima);

        HBox horisontalBoxForTable = new HBox();
        horisontalBoxForTable.setMaxWidth(1300);
        horisontalBoxForTable.setMinWidth(1300);
        HBox horisontalBoxForLabel = new HBox();
        HBox horisontalBoxForRow = new HBox();

        Label brojLinije_l = new Label("Broj linije");
        brojLinije_l.setMinWidth(162);
        brojLinije_l.setMaxWidth(162);

        Label adresaSaBrojevima_l = new Label("Adresa i broj");
        adresaSaBrojevima_l.setMinWidth(162);
        adresaSaBrojevima_l.setMaxWidth(162);

        Label taksiStanica_l = new Label("Taksi stanica");
        taksiStanica_l.setMinWidth(162);
        taksiStanica_l.setMaxWidth(162);

        Label kucniBroj_l = new Label("Broj adrese");
        kucniBroj_l.setMinWidth(162);
        kucniBroj_l.setMaxWidth(162);

        Label napomena_l = new Label("Napomena");
        napomena_l.setMinWidth(162);
        napomena_l.setMaxWidth(162);

        Label brojKolege_l = new Label("Broj kolege");
        brojKolege_l.setMinWidth(162);
        brojKolege_l.setMaxWidth(162);

        Label vremeUMinutima_l = new Label("Vreme");
        vremeUMinutima_l.setMinWidth(162);
        vremeUMinutima_l.setMaxWidth(162);

        TextField brojLinije = new TextField();
        brojLinije.setMinWidth(162);
        brojLinije.setMaxWidth(162);

        TextField adresaSaBrojevima = new TextField();
        adresaSaBrojevima.setMinWidth(162);
        adresaSaBrojevima.setMaxWidth(162);

        TextField taksiStanica = new TextField();
        taksiStanica.setMinWidth(162);
        taksiStanica.setMaxWidth(162);

        TextField kucniBroj = new TextField();
        kucniBroj.setMinWidth(162);
        kucniBroj.setMaxWidth(162);

        TextField napomena = new TextField();
        napomena.setMinWidth(162);
        napomena.setMaxWidth(162);

        Button btn = new Button("Prosledi");
        btn.setMaxWidth(162);
        btn.setMinWidth(162);

        TextField brojKolege = new TextField();
        brojKolege.setMinWidth(162);
        brojKolege.setMaxWidth(162);

        TextField vremeUMinutima = new TextField();
        vremeUMinutima.setMinWidth(162);
        vremeUMinutima.setMaxWidth(162);


        ObjectOutputStream oos = null;

        btn.setOnMouseClicked(event -> {
            table.refresh();
            Podatak p = new Podatak(Integer.parseInt(brojLinije.getText()), adresaSaBrojevima.getText(), Integer.parseInt(kucniBroj.getText()), taksiStanica.getText(), napomena.getText(), Integer.parseInt(brojKolege.getText()),Integer.parseInt(vremeUMinutima.getText()));
            table.setItems(loadData(p));
        });

        horisontalBoxForRow.getChildren().addAll(brojLinije, adresaSaBrojevima, taksiStanica, kucniBroj, napomena,brojKolege,vremeUMinutima, btn);
        horisontalBoxForLabel.getChildren().addAll(brojLinije_l, adresaSaBrojevima_l, taksiStanica_l, kucniBroj_l, napomena_l,brojKolege_l,vremeUMinutima_l);
        horisontalBoxForTable.getChildren().add(table);
        verticalBox.getChildren().addAll(horisontalBoxForLabel, horisontalBoxForRow, horisontalBoxForTable);
    }

    public ObservableList<Podatak> loadData(Podatak p) {
        ObListaPodatak.listaPodataka.add(p);

        try {
            oos.writeObject(p);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Podatak pom:ObListaPodatak.listaPodataka) {
            System.out.println("niz: " + pom);
        }
        return ObListaPodatak.listaPodataka;
    }
}
