package rinda;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import saraksts.Biblioteka;

public class Pasts {
	
	/*
	 * Ievest cilvēka objektus, tam nepieciešama jauna klase
	 * un pivienot tiem atribūtus: vards, rindasId, darbiba
	 */

    public static void main(String[] args) {
        String izvelne, cilveks = null, darbs = null;
        int rindasId = 1;
        Queue<Apmekletais> rinda = new LinkedList<>();

        String[] darbibas = {"Nostāties rindā", "Apskatīt pirmo rindā stāvošo",
                "Noteikt rindas garumu", "Cik pirms manis?", 
                "Aplūkot visus rindā stāvošos", "Apkalpot pirmo", "Apturēt"};

        do {
            izvelne = (String) JOptionPane.showInputDialog(null, "Darbības izvēle",
                    "Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas, 
                    darbibas[0]);

            if(izvelne == null)
                izvelne = "Apturēt";

            switch(izvelne) {
                case "Nostāties rindā":
                    cilveks = Biblioteka.virknesParbaude("Kā sauc cilvēku?", "Jānis");
                    darbs = Biblioteka.virknesParbaude("Ko vajag?", "Saņemšāna");

                    if(cilveks == null)
                        break;

                    Apmekletais apmekletais = new Apmekletais(cilveks, rindasId++, darbs);
                    rinda.add(apmekletais);
                    JOptionPane.showMessageDialog(null, "Cilvēks nostājās rindā!", 
                            "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "Apskatīt pirmo rindā stāvošo":
                    if(!rinda.isEmpty()) {
                        Apmekletais pirmais = rinda.peek();
                        JOptionPane.showMessageDialog(null, "Pirmais rindā ir: " + 
                        pirmais.toString(), "Informācija", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Rindā neviens nestāv!", 
                                "Tukša rinda", JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case "Noteikt rindas garumu":
                    JOptionPane.showMessageDialog(null, "Rindā stāvošo skaits: " + 
                            rinda.size(), "Informācija", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "Cik pirms manis?":
                    if(!rinda.isEmpty()) {
                        cilveks = Biblioteka.virknesParbaude("Kā Tevi sauc?", "Jānis");

                        if(cilveks == null)
                            break;

                        int kartasNr = 0;
                        boolean atrasts = false;
                        for (Apmekletais persona : rinda) {
                            if(cilveks.equalsIgnoreCase(persona.getVards())) {
                                atrasts = true;
                                break;
                            }
                            kartasNr++;
                        }

                        if(atrasts)
                            JOptionPane.showMessageDialog(null, "Pirms Tevis stāv " + kartasNr + 
                                    " cilvēki.", "Informācija", JOptionPane.INFORMATION_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "Nemānies, Tu nemaz rindā nestāvi!",
                                    "Brīdinājums", JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case "Aplūkot visus rindā stāvošos":
                    if (!rinda.isEmpty()) {
                        String virkne = "";
                        for (Apmekletais persona : rinda) {
                            virkne += persona.toString() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, "Rindā stāv:\n" + virkne, 
                                "Cilvēki", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Rindā neviens nestāv!", 
                                "Tukša rinda", JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case "Apkalpot pirmo":
                    if(!rinda.isEmpty()) {
                        Apmekletais apkalpots = rinda.poll();
                        JOptionPane.showMessageDialog(null, apkalpots.getVards() + 
                                " tika apkalpots", "Apkalpošana", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Rindā neviens nestāv!", 
                                "Tukša rinda", JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case "Apturēt":
                    JOptionPane.showMessageDialog(null, "Programma apturēta", 
                            "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } while(!izvelne.equals("Apturēt"));
    }
}
