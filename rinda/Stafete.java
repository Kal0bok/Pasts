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

                        iteracija = 1;

                        while (!komandaA.isEmpty() && !komandaB.isEmpty()) {

                            int a = komandaA.poll();
                            int b = komandaB.poll();

                            String msg = iteracija + ". iterācija\n"
                                       + a + " pret " + b + "\n\n";

                            if (a > b) {
                                komandaA.add(a);
                                msg += "Uzvar A dalībnieks!\n"
                                     + b + " ❌ izkrīt\n"
                                     + a + " 🔁 atgriežas rindas beigās";
                            } 
                            else if (b > a) {
                                komandaB.add(b);
                                msg += "Uzvar B dalībnieks!\n"
                                     + a + " ❌ izkrīt\n"
                                     + b + " 🔁 atgriežas rindas beigās";
                            } 
                            else {
                                msg += "💥 Neizšķirts!\nAbi dalībnieki izkrīt!";
                            }

                            JOptionPane.showMessageDialog(
                                null,
                                msg,
                                "Cīņa",
                                JOptionPane.INFORMATION_MESSAGE
                            );

                            iteracija++;
                        }

                        if (komandaA.isEmpty() && komandaB.isEmpty()) {
                            JOptionPane.showMessageDialog(
                                null,
                                "🤯 Abas komandas izkrita!\nNav uzvarētāja!",
                                "Rezultāts",
                                JOptionPane.WARNING_MESSAGE
                            );
                        } 
                        else if (komandaA.isEmpty()) {
                            JOptionPane.showMessageDialog(
                                null,
                                "🏆 Uzvar komanda B!",
                                "Uzvara",
                                JOptionPane.INFORMATION_MESSAGE
                            );
                        } 
                        else {
                            JOptionPane.showMessageDialog(
                                null,
                                "🏆 Uzvar komanda A!",
                                "Uzvara",
                                JOptionPane.INFORMATION_MESSAGE
                            );
                        }

                    } else {
                        JOptionPane.showMessageDialog(
                            null,
                            "Komandas nav izveidotas!",
                            "Brīdinājums",
                            JOptionPane.WARNING_MESSAGE
                        );
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
