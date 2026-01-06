package saraksts;

import java.util.LinkedList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Biblioteka {

    public static String virknesParbaude(String zinojums, String nokl) {
        String ievade;
        do {
            ievade = JOptionPane.showInputDialog(null, zinojums, nokl);
            if (ievade == null)
                return null;

            ievade = ievade.trim();
        } while (!Pattern.matches("^[\\p{L} ]+$", ievade));
        return ievade;
    }

    public static double skaitlaParbaude(String zinojums, double tips) {
        String ievade;
        double skaitlis;

        while (true) {
            ievade = JOptionPane.showInputDialog(null, zinojums, tips);
            if (ievade == null)
                return -1;

            try {
                skaitlis = Double.parseDouble(ievade); 
                if (skaitlis < 0.1) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Ievadīts negatīvs vai pārāk mazs skaitlis!",
                        "Nekorekti dati",
                        JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    return skaitlis;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Ievadīts nekorekts datu tips!",
                    "Kluda",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    static int meklet(LinkedList<Gramata> saraksts, String nosaukums) {
        for (int i = 0; i < saraksts.size(); i++) {
            if (saraksts.get(i).getNosaukums().equalsIgnoreCase(nosaukums))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String nosaukums, autors, izdevnieciba, izvelne;
        int id = 1, skaits, lppSk, indekss;
        double cena;

        LinkedList<Gramata> plaukts = new LinkedList<>();
        LinkedList<Gramata> panemtie = new LinkedList<>();

        String[] darbibas = {
            "Pievienot gramatu",
            "Nonemt gramatu",
            "Apskatīt grāmatu",
            "Iznomāt grāmatu",
            "Apturet"
        };

        do {
            izvelne = (String) JOptionPane.showInputDialog(
                null,
                "Izvēlies darbību",
                "Darbību saraksts",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                darbibas,
                darbibas[0]
            );

            if (izvelne == null)
                izvelne = "Apturet";

            switch (izvelne) {

                case "Pievienot gramatu":
                    nosaukums = virknesParbaude("Ieraksti grāmatas nosaukumu", "Zaļā pasaka");
                    if (nosaukums == null)
                        break;

                    indekss = meklet(plaukts, nosaukums);
                    if (indekss != -1) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Šāda grāmata jau ir pievienota plauktā!",
                            "Brīdinājums",
                            JOptionPane.WARNING_MESSAGE
                        );
                        break;
                    }

                    autors = virknesParbaude("Ieraksti grāmatas autoru", "Kārļis Skalbe");
                    if (autors == null)
                        break;

                    izdevnieciba = virknesParbaude("Norādi grāmatas izdevniecību", "Kakojto");
                    if (izdevnieciba == null)
                        break;

                    skaits = (int) skaitlaParbaude("Norādi eksemplāru skaitu", 1);
                    if (skaits == -1)
                        break;

                    cena = skaitlaParbaude("Norādi grāmatas cenu", 0.1);
                    if (cena == -1.0)
                        break;

                    lppSk = (int) skaitlaParbaude("Norādi lappušu skaitu", 1);
                    if (lppSk == -1)
                        break;

                    plaukts.add(new Gramata(id, skaits, lppSk, nosaukums, autors, izdevnieciba, cena));
                    break;

                case "Nonemt gramatu":
                    if (plaukts.isEmpty()) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Nav plauktā neviena grāmata!",
                            "Brīdinājums",
                            JOptionPane.WARNING_MESSAGE
                        );
                    } else {
                        nosaukums = virknesParbaude("Kā sauc grāmatu, kuru vēlies noņemt", "Balta grāmata");
                        if (nosaukums == null)
                            break;

                        indekss = meklet(plaukts, nosaukums);

                        if (indekss == -1) {
                            JOptionPane.showMessageDialog(
                                null,
                                "Meklētā grāmata nemaz plauktā neatrodas",
                                "Brīdinājums",
                                JOptionPane.WARNING_MESSAGE
                            );
                        } else {
                            plaukts.remove(indekss);
                            JOptionPane.showMessageDialog(
                                null,
                                "Grāmata izdzēsta!",
                                "Paziņojums",
                                JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                    break;

                case "Apskatīt grāmatu":
                    if (plaukts.isEmpty()) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Nav plauktā neviena grāmata!",
                            "Brīdinājums",
                            JOptionPane.WARNING_MESSAGE
                        );
                    } else {
                        nosaukums = virknesParbaude("Kuru grāmatu aplūkot?", "Zaļā pasaka");
                        if (nosaukums == null)
                            break;

                        indekss = meklet(plaukts, nosaukums);
                        if (indekss == -1) {
                            JOptionPane.showMessageDialog(
                                null,
                                "Meklētā grāmata nemaz plauktā neatrodas!",
                                "Brīdinājums",
                                JOptionPane.WARNING_MESSAGE
                            );
                        } else {
                            plaukts.get(indekss).info();
                        }
                    }
                    break;

                case "Iznomāt grāmatu":
                    if (plaukts.isEmpty()) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Nav plauktā neviena grāmata!",
                            "Brīdinājums",
                            JOptionPane.WARNING_MESSAGE
                        );
                    } else {
                        nosaukums = virknesParbaude("Kuru grāmatu vēlies iznomāt?", "Zaļā pasaka");
                        if (nosaukums == null)
                            break;

                        indekss = meklet(plaukts, nosaukums);
                        if (indekss == -1) {
                            JOptionPane.showMessageDialog(
                                null,
                                "Meklētā grāmata nemaz plauktā neatrodas!",
                                "Brīdinājums",
                                JOptionPane.WARNING_MESSAGE
                            );
                        } else {
                            plaukts.get(indekss).panemtGramatu();
                            //Uzglabat paņemto grāmatu linkedlist
                        }
                    }
                    break;   
                    

                case "Apturet":
                    JOptionPane.showMessageDialog(null, "Programma tika apturēta!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
                    break;

            }
        } while (!izvelne.equals("Apturet"));
    }
}
