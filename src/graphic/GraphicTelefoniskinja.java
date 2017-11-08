package graphic;

import classes.ObListaPodatak;
import classes.Podatak;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import threads.DispecerThreadRecieve;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class GraphicTelefoniskinja extends Application {
    VBox verticalBox = new VBox();
    Scene scene;
    ObservableList<Podatak> data;
    ObjectOutputStream oos;
    Socket s = null;
    TableView<Podatak> table;

    boolean daLiSeEditujeRed = false;

    HBox horisontalBoxForTable;
    HBox horisontalBoxForLabel;
    HBox horisontalBoxForRow;

    Label brojLinije_l;
    Label adresaSaBrojevima_l;
    Label taksiStanica_l;
    Label kucniBroj_l;
    Label napomena_l;
    Label brojKolege_l;
    Label vremeUMinutima_l;

    TextField brojLinije;
    TextField adresaSaBrojevima;
    TextField taksiStanica;
    TextField kucniBroj;
    TextField napomena;
    TextField brojKolege;
    TextField vremeUMinutima;

    TableColumn colbrojVoznje;
    TableColumn colbrojLinije;
    TableColumn colDatumIVreme;
    TableColumn colAdresaSaBrojem;
    TableColumn colKucniBroj;
    TableColumn colTaxiStanica;
    TableColumn colNapomena;
    TableColumn colBrojKolege;
    TableColumn colVremeUMinutima;

    Button btn;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Zuti taksi - Telefoniskinja");
        initialisation();
        try {
            s = new Socket("192.168.0.12", 1312);
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

        table.setMaxHeight(650);
        table.setMinHeight(650);

        table.setMaxWidth(1300);
        table.setMinWidth(1300);


        colbrojVoznje = new TableColumn("Broj voznje");
        colbrojVoznje.setMinWidth(162);
        colbrojVoznje.setMaxWidth(162);
        colbrojVoznje.setEditable(true);
        colbrojVoznje.setCellValueFactory(new PropertyValueFactory<Podatak, Integer>("redniBroj"));

        colbrojLinije = new TableColumn("Broj linije");
        colbrojLinije.setMinWidth(162);
        colbrojLinije.setMaxWidth(162);
        colbrojLinije.setCellValueFactory(new PropertyValueFactory<Podatak, Integer>("brojLinije"));

        colDatumIVreme = new TableColumn("Datum");
        colDatumIVreme.setMinWidth(162);
        colDatumIVreme.setMaxWidth(162);
        colDatumIVreme.setCellValueFactory(new PropertyValueFactory<Podatak, String>("datumIVreme"));

        colAdresaSaBrojem = new TableColumn("Adresa");
        colAdresaSaBrojem.setMinWidth(162);
        colAdresaSaBrojem.setMaxWidth(162);
        colAdresaSaBrojem.setCellValueFactory(new PropertyValueFactory<Podatak, String>("adresaSaBrojem"));

        colKucniBroj = new TableColumn("Broj kuce");
        colKucniBroj.setMinWidth(162);
        colKucniBroj.setMaxWidth(162);
        colKucniBroj.setCellValueFactory(new PropertyValueFactory<Podatak, Integer>("kucniBroj"));

        colTaxiStanica = new TableColumn("Taksi stanica");
        colTaxiStanica.setMinWidth(162);
        colTaxiStanica.setMaxWidth(162);
        colTaxiStanica.setCellValueFactory(new PropertyValueFactory<Podatak, String>("taksiStanica"));

        colNapomena = new TableColumn("Napomena");
        colNapomena.setMinWidth(162);
        colNapomena.setMaxWidth(162);
        colNapomena.setCellValueFactory(new PropertyValueFactory<Podatak, String>("napomena"));

        colBrojKolege = new TableColumn("Broj Kolege");
        colBrojKolege.setMinWidth(162);
        colBrojKolege.setMaxWidth(162);
        colBrojKolege.setCellValueFactory(new PropertyValueFactory<Podatak, Integer>("brojKolege"));

        colVremeUMinutima = new TableColumn("Vreme");
        colVremeUMinutima.setMinWidth(162);
        colVremeUMinutima.setMaxWidth(162);
        colVremeUMinutima.setCellValueFactory(new PropertyValueFactory<Podatak, Integer>("vremeUMinutima"));

        table.getColumns().addAll(colbrojVoznje, colbrojLinije, colDatumIVreme, colAdresaSaBrojem, colKucniBroj, colNapomena, colBrojKolege, colVremeUMinutima);

        horisontalBoxForTable = new HBox();
        horisontalBoxForTable.setMaxWidth(1300);
        horisontalBoxForTable.setMinWidth(1300);

        horisontalBoxForLabel = new HBox();
        horisontalBoxForRow = new HBox();

        brojLinije_l = new Label("Broj linije");
        brojLinije_l.setMinWidth(162);
        brojLinije_l.setMaxWidth(162);

        adresaSaBrojevima_l = new Label("Adresa i broj");
        adresaSaBrojevima_l.setMinWidth(162);
        adresaSaBrojevima_l.setMaxWidth(162);

        taksiStanica_l = new Label("Taksi stanica");
        taksiStanica_l.setMinWidth(162);
        taksiStanica_l.setMaxWidth(162);

        kucniBroj_l = new Label("Broj adrese");
        kucniBroj_l.setMinWidth(162);
        kucniBroj_l.setMaxWidth(162);

        napomena_l = new Label("Napomena");
        napomena_l.setMinWidth(162);
        napomena_l.setMaxWidth(162);

        brojKolege_l = new Label("Broj kolege");
        brojKolege_l.setMinWidth(162);
        brojKolege_l.setMaxWidth(162);

        vremeUMinutima_l = new Label("Vreme");
        vremeUMinutima_l.setMinWidth(162);
        vremeUMinutima_l.setMaxWidth(162);

        brojLinije = new TextField();
        brojLinije.setMinWidth(162);
        brojLinije.setMaxWidth(162);

        adresaSaBrojevima = new TextField();
        adresaSaBrojevima.setMinWidth(162);
        adresaSaBrojevima.setMaxWidth(162);

        taksiStanica = new TextField();
        taksiStanica.setMinWidth(162);
        taksiStanica.setMaxWidth(162);

        kucniBroj = new TextField();
        kucniBroj.setMinWidth(162);
        kucniBroj.setMaxWidth(162);

        napomena = new TextField();
        napomena.setMinWidth(162);
        napomena.setMaxWidth(162);

        brojKolege = new TextField();
        brojKolege.setMinWidth(162);
        brojKolege.setMaxWidth(162);

        vremeUMinutima = new TextField();
        vremeUMinutima.setMinWidth(162);
        vremeUMinutima.setMaxWidth(162);

        btn = new Button("Prosledi");
        btn.setMaxWidth(162);
        btn.setMinWidth(162);
        ObjectOutputStream oos = null;

        btn.setOnMouseClicked(event -> {

            if (daLiSeEditujeRed) {
                int n = table.getSelectionModel().getSelectedItem().getRedniBroj();
                for (Podatak m : ObListaPodatak.listaPodataka) {
                    if (n == m.getRedniBroj()) {
                        m.setBrojKolege(Integer.parseInt(brojKolege.getText()));
                        m.setVremeUMinutima(Integer.parseInt(vremeUMinutima.getText()));
                        System.out.println("preradjen: " + m);
                        break;
                    }
                }
                table.refresh();
                daLiSeEditujeRed = false;
                brojLinije.setDisable(false);
                adresaSaBrojevima.setDisable(false);
                taksiStanica.setDisable(false);
                kucniBroj.setDisable(false);
                napomena.setDisable(false);
                table.getSelectionModel().select(null);
            } else {
                table.getSelectionModel().select(null);
                Podatak p = new Podatak(Integer.parseInt(brojLinije.getText()), adresaSaBrojevima.getText(), Integer.parseInt(kucniBroj.getText()), taksiStanica.getText(), napomena.getText(), Integer.parseInt(brojKolege.getText()), Integer.parseInt(vremeUMinutima.getText()));
                table.setItems(loadData(p));
            }


        });

        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(table.getSelectionModel().getSelectedItem() != null)
                {
                    daLiSeEditujeRed = true;
                    brojLinije.setDisable(true);
                    adresaSaBrojevima.setDisable(true);
                    taksiStanica.setDisable(true);
                    kucniBroj.setDisable(true);
                    napomena.setDisable(true);
                    Podatak m = (Podatak)table.getSelectionModel().getSelectedItem();
                    System.out.println(m);
                }
            }

        });

        horisontalBoxForRow.getChildren().addAll(brojLinije, adresaSaBrojevima, taksiStanica, kucniBroj, napomena, brojKolege, vremeUMinutima, btn);
        horisontalBoxForLabel.getChildren().addAll(brojLinije_l, adresaSaBrojevima_l, taksiStanica_l, kucniBroj_l, napomena_l, brojKolege_l, vremeUMinutima_l);
        horisontalBoxForTable.getChildren().add(table);
        verticalBox.getChildren().addAll(horisontalBoxForLabel, horisontalBoxForRow, horisontalBoxForTable);
    }

    private void onEdit() {
        if (table.getSelectionModel().getSelectedItem() != null) {
            brojLinije.setDisable(true);
            adresaSaBrojevima.setDisable(true);
            taksiStanica.setDisable(true);
            kucniBroj.setDisable(true);
            napomena.setDisable(true);
            daLiSeEditujeRed = true;
        }
    }

    public ObservableList<Podatak> loadData(Podatak p) {
        try {
            oos.writeObject(p);
            oos.flush();
            ObListaPodatak.listaPodataka.add(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Podatak pom:ObListaPodatak.listaPodataka) {
            System.out.println("niz: " + pom);
        }
        return ObListaPodatak.listaPodataka;
    }

    public ObservableList<Podatak> reloadData() {
        System.out.println("reload liste.");
            return ObListaPodatak.listaPodataka;
    }
}

