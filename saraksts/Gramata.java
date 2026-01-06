package saraksts;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Gramata {

    private int id, skaits, lppSk;
    private String nosaukums, autors, izdevnieciba;
    private LocalDate panemts, atgriezts;
    private double cena;

    public Gramata(int id, int skaits, int lppSk,
                   String nosaukums, String autors, String izdevnieciba, double cena) {
        this.id = id;
        this.skaits = skaits;
        this.lppSk = lppSk;
        this.nosaukums = nosaukums;
        this.autors = autors;
        this.izdevnieciba = izdevnieciba;
        this.cena = cena;
    }

    public String getNosaukums() {
        return nosaukums;
    }

    public void info() {
        JOptionPane.showMessageDialog(
            null,
            "ID: " + id +
            "\nNosaukums: " + getNosaukums() +
            "\nAutors: " + autors +
            "\nIzdevnieciba: " + izdevnieciba +
            "\nLappušu skaits: " + lppSk +
            "\nCenna: " + cena + " EUR" +
            "\nEksemplāru skaits: " + skaits
        );
    }

    public void panemtGramatu() {
        if (skaits > 0) {
            skaits--;
            panemts = LocalDate.now();
            atgriezts = panemts.plusMonths(1);

            JOptionPane.showMessageDialog(
                null,
                "Gramata panemta: " + panemts +
                "\n Gramatu jaatgriez" + atgriezts
            );

        } else {
            JOptionPane.showMessageDialog(
                null,
                "Gramata nav pieejama, visi eksemplari panemti!",
                "Bridinajums",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }
}
