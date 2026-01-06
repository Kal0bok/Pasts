package rinda;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;
import saraksts.Biblioteka;

public class Pasts {

    public static void main(String[] args) {
        String izvelne, cilveks = null;
        int kartasNr;
        Queue<String> rinda = new LinkedList<>();
        
        String[] darbibas = {"Nostāties rindā", "Apskatīt pirmo ridna stāvošo",
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
                cilveks = 
                Biblioteka.virknesParbaude("Kā sauc cilvēku?", "Jānis");
                
                if(cilveks == null)
                    break;
                
                rinda.add(cilveks);
                JOptionPane.showMessageDialog(null, "Cilvēks nostājās rindā!", 
                        "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
                break;
                
            case "Apskatīt pirmo ridna stāvošo":
                if(!rinda.isEmpty())
                    JOptionPane.showMessageDialog(null, "Pirmais rindā ir "+ 
                rinda.peek(), "Informācija", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Rindā neviens nestāv!", 
                            "Tukša rinda", JOptionPane.WARNING_MESSAGE);
                break;
                
            case "Noteikt rindas garumu":
                if(!rinda.isEmpty())
                    JOptionPane.showMessageDialog(null, "Rindā stāvošo skaits:  "+ 
                rinda.size(), "Informācija", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Rindā neviens nestāv!", 
                            "Tukša rinda", JOptionPane.WARNING_MESSAGE);
                break;
            
            case "Cik pirms manis?":
                if(!rinda.isEmpty())
                    cilveks = 
                    Biblioteka.virknesParbaude("Kā Tevi sauc?", "Jānis");
                
                if(cilveks == null)
                    break;
                
                kartasNr = 0;
                boolean atrasts = false;
                for(String persona : rinda){
                    if(cilveks.equalsIgnoreCase(persona)) {
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
                
                break;
                
            case "Aplūkot visus rindā stāvošos":
                if (!rinda.isEmpty()) {
                    String virkne = " ";
                    kartasNr = 1;
                    for(String persona : rinda) {
                    	virkne += kartasNr+". "+persona+"\n";
                    	kartasNr++;
                    }
                    

                    JOptionPane.showMessageDialog(null, "Rindā stāv:\n"+virkne, 
                            "Cilvēki", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Rindā neviens nestāv!", 
                            "Tukša rinda", JOptionPane.WARNING_MESSAGE);
                }
                break;
                
            case "Apkalpot pirmo":
                if(!rinda.isEmpty()) {
                    JOptionPane.showMessageDialog(null, rinda.poll()+
                    		" tika apkalpots", "Apkalpošana", 
                    		JOptionPane.INFORMATION_MESSAGE);
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
