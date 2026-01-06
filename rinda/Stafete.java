package rinda;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class Stafete {

	public static void main(String[] args) {
		String izvelne;
		Queue<Integer> komandaA = new LinkedList<>();
		Queue<Integer> komandaB = new LinkedList<>();
		String[] darbibas = {"Izveidot komandas", "Aplūkot komandu A",
                "Aplūkot komandu B", "Sākt sacensības",  "Apturēt"};
		int dalibniekuSk = 0, iteracija = 0;
		boolean beigas = false;
		
		do {
            izvelne = (String) JOptionPane.showInputDialog(null, "Darbības izvēle",
                    "Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas, 
                    darbibas[0]);

            if(izvelne == null)
                izvelne = "Apturēt";

            switch(izvelne) {
            
            }
		}
		
	}

}
