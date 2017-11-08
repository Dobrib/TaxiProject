package classes;


import java.io.Serializable;
import java.util.Date;

public class Podatak implements Serializable{
    private String datumIVreme;
    private String taksiStanica;
    private String adresaSaBrojem;
    private String napomena;
    private int redniBroj;
    private int kucniBroj;
    private int brojKolege;
    private int vremeUMinutima;
    private int brojLinije;

    public Podatak(int brojLinije, String adresaSaBrojem, int kucniBroj,String taksiStanica, String napomena, int brojKolege, int vremeUMinutima) {
        Date datum = new Date();
        ObListaPodatak.brojRedni++;
        redniBroj = ObListaPodatak.brojRedni;
        datumIVreme = datum.toString();
        this.adresaSaBrojem = adresaSaBrojem;
        this.kucniBroj = kucniBroj;
        this.napomena = napomena;
        this.brojKolege = brojKolege;
        this.vremeUMinutima = vremeUMinutima;
        this.brojLinije = brojLinije;
        this.taksiStanica = taksiStanica;
        datum = null;
    }

    public String getTaksiStanica() {
        return taksiStanica;
    }

    public void setTaksiStanica(String taksiStanica) {
        this.taksiStanica = taksiStanica;
    }

    public int getBrojLinije() {
        return brojLinije;
    }

    public void setBrojLinije(int brojLinije) {
        this.brojLinije = brojLinije;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(String datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public String getAdresaSaBrojem() {
        return adresaSaBrojem;
    }

    public void setAdresaSaBrojem(String adresaSaBrojem) {
        this.adresaSaBrojem = adresaSaBrojem;
    }

    public int getKucniBroj() {
        return kucniBroj;
    }

    public void setKucniBroj(int kucniBroj) {
        this.kucniBroj = kucniBroj;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public int getBrojKolege() {
        return brojKolege;
    }

    public void setBrojKolege(int brojKolege) {
        this.brojKolege = brojKolege;
    }

    public int getVremeUMinutima() {
        return vremeUMinutima;
    }

    public void setVremeUMinutima(int vremeUMinutima) {
        this.vremeUMinutima = vremeUMinutima;
    }

    @Override
    public String toString() {
        return "Podatak{" +
                "redniBroj=" + redniBroj +
                ", datumIVreme='" + datumIVreme + '\'' +
                ", adresaSaBrojem='" + adresaSaBrojem + '\'' +
                ", kucniBroj=" + kucniBroj +
                ", napomena='" + napomena + '\'' +
                ", brojKolege=" + brojKolege +
                ", vremeUMinutima=" + vremeUMinutima +
                '}';
    }
}
