package rinda;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JOptionPane;

import saraksts.Biblioteka;

public class Stafete {

    static Queue<Integer> izveidot(int sk, char burts) {
        Random rand = new Random();
        Queue<Integer> komanda = new LinkedList<>();
        for (int i = 0; i < sk; i++) {
            komanda.add(rand.nextInt(100) + 1);
        }
        JOptionPane.showMessageDialog(null, "Komanda " + burts + " izveidota!", "Pazinojums", JOptionPane.INFORMATION_MESSAGE);
        return komanda;
    }

    static void aplukot(Queue<Integer> komanda, char burts) {
        String virkne = "";

        for (Integer dalibnieks : komanda) {
            virkne += dalibnieks + " | ";
        }
        JOptionPane.showMessageDialog(null, virkne, "Komanda " + burts, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        String izvelne;
        Queue<Integer> komandaA = new LinkedList<>();
        Queue<Integer> komandaB = new LinkedList<>();
        String[] darbibas = {"Izveidot komandu", "Aplukot komandu A", "Aplukot komandu B", "Sākt sacensības", "Apturēt"};
        int dalibniekuSk = 0, iteracija = 0;
        boolean beigas = false;

        do {
            izvelne = (String) JOptionPane.showInputDialog(null,
                    "Izvēlieties darbību", "Izvēlne", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);

            if (izvelne == null)
                izvelne = "Apturēt";

            switch (izvelne) {
                case "Izveidot komandu":
                    dalibniekuSk = (int) Biblioteka.skaitlaParbaude("Cik katra komanda ir dalībnieki?", 4);
                    iteracija = 1;
                    komandaA = izveidot(dalibniekuSk, 'A');
                    komandaB = izveidot(dalibniekuSk, 'B');
                    beigas = false;
                    break;

                case "Aplukot komandu A":
                    if (!komandaA.isEmpty())
                        aplukot(komandaA, 'A');
                    else
                        JOptionPane.showMessageDialog(null, "Komanda A nemaz nav izveidota!",
                                "Brīdinājums", JOptionPane.WARNING_MESSAGE);
                    break;

                case "Aplukot komandu B":
                    if (!komandaB.isEmpty())
                        aplukot(komandaB, 'B');
                    else
                        JOptionPane.showMessageDialog(null, "Komanda B nemaz nav izveidota!",
                                "Brīdinājums", JOptionPane.WARNING_MESSAGE);
                    break;

                case "Sākt sacensības":
                    if (!komandaA.isEmpty() && !komandaB.isEmpty()) {
                        // Logika sacensībām šeit (vēl nav pievienota)
                    } else {
                        JOptionPane.showMessageDialog(null, "Komandas nemaz nav izveidotas!",
                                "Brīdinājums", JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case "Apturēt":
                    // Beigt programmu
                    beigas = true;
                    break;
            }
        } while (!izvelne.equals("Apturēt"));
    }
}
