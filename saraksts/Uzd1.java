package saraksts;

import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Uzd1 {
	static boolean jauEksiste(LinkedList<String> saraksts, String elements) {
		for(int i=0;i<saraksts.size(); i++) {
			if(saraksts.get(i).equalsIgnoreCase(elements)) {
				JOptionPane.showMessageDialog(null, "Šads produkts jau ir pievienots sarakstam", "Kļuda",
						JOptionPane.WARNING_MESSAGE);
				return true;
			}
		}
		return false;
	}
	
	private static final String[] atbilde = {"Jā", "Nē"};

	public static void main(String[] args) {
		String izvele, koPievienot, koAtrast, koNonemt, arKoAizstat, izv = null, poz;
		int kurPievienot, kurNonemt, kuruMainit;
		LinkedList<String> saraksts = new LinkedList<>();
		
		do {
			do {
			izvele = JOptionPane.showInputDialog("1 - Produktu\n2 - Produktu skaits\n"+
			"3 - Izvadīt produktus\n4 - Atrast produktu\n"+ 
			"5 - Pievienot konkrētā pozīcija\n"+
			"6 - Noņemt produktu\n7 - Noņemt pēc indeksa\n"+
			"8 - Noņemt pirmo \n9 - Noņemt pēdējo\n"+
			"10 - Mainīt produktu\n11 - Sakārtot alfabētiski\n"+
			"12 - Nodzēst sarakstu\n0 - Apturēt");	
			
			if(izvele == null) 
				izvele = "0";
			}while(!izvele.matches("\\d+"));
			
			switch(izvele) {
			
			case "0":
				JOptionPane.showMessageDialog(null, "Programma apterēta!", 
						"Informācija", JOptionPane.INFORMATION_MESSAGE);
				break;
			
			case "1":			
			do {
				koPievienot =
				JOptionPane.showInputDialog("Kādu produktu pievienot?");
				
				if(koPievienot == null)
					break;
				
			}while((jauEksiste(saraksts, koPievienot) == true)||
			!koPievienot.matches("[\\p{L}&&\\p{IsLatin}]+"));
			
			if(koPievienot == null) 
				break;
			
			saraksts.add(koPievienot.toLowerCase());
			JOptionPane.showMessageDialog(null, "Produkts pievienots!", "Informācija",
					JOptionPane.INFORMATION_MESSAGE);
				break;
			
			case "2":
				JOptionPane.showMessageDialog(null, "Produktu skaits: "+
			saraksts.size(), "Informācija", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case "3":
				if(saraksts.size() == 0)
					JOptionPane.showMessageDialog(null, "Nav sarakstā produktu", 
							"Informācija", JOptionPane.INFORMATION_MESSAGE);
				
				else {
					StringBuilder str = new StringBuilder();
				    for (int i = 0; i < saraksts.size(); i++) {
				        str.append(saraksts.get(i))
				           .append(" (")
				           .append(i)
				           .append(")\n");
				}
				JOptionPane.showMessageDialog(null, str, "Produktu saraksts", 
						JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case "4":
				do {
					koAtrast =
					JOptionPane.showInputDialog("Ko vajag atrast?");
					
					if(koAtrast == null)
						break;
					
					else {
						JOptionPane.showMessageDialog(null, "Šada produkta nav!", "Informācija",
						JOptionPane.WARNING_MESSAGE);
					}
					
				}while(!koAtrast.matches("[\\p{L}&&\\p{IsLatin}]+"));
				
				
				if(saraksts.contains(koAtrast)) {
					kurPievienot = saraksts.indexOf(koAtrast);
					JOptionPane.showMessageDialog(null, "Jūsu produkta indeks: " + kurPievienot, 
							"Informācija", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case "5":
				do {
					izv = JOptionPane.showInputDialog("1 - Pievienot produktu ar indeksu"
							+ "\n2 - Samainit indeksu esošam produktam\n");
					
				if(izv == null) 
					izv = "0";
				}while(!izv.matches("\\d+"));
				
				switch(izv) {
				case "1":
					
					do {
						koPievienot =
						JOptionPane.showInputDialog("Kādu produktu pievienot?");
						
						if (koPievienot == null) 
							break;
						
						if (saraksts.contains(koPievienot.toLowerCase())) {
							JOptionPane.showMessageDialog(null, "Šāds produkts jau ir saraksta!", 
									"Kļuda", JOptionPane.WARNING_MESSAGE);
						}						
					}while(!koPievienot.matches("[\\p{L}&&\\p{IsLatin}]+") || 
							saraksts.contains(koPievienot.toLowerCase()));
					
					if(koPievienot == null) 
						break;
					
					poz=
					JOptionPane.showInputDialog("Kāda pozīcija?");
					
					if (poz == null)
						break;
					
					kurPievienot = Integer.parseInt(poz);
					saraksts.add(kurPievienot, koPievienot.toLowerCase());
					JOptionPane.showMessageDialog(null, "Produkts pievienots!", "Informācija",
							JOptionPane.INFORMATION_MESSAGE);
						break;
					
				case "2":
					
					do {
						koAtrast =
						JOptionPane.showInputDialog("Kādam produktam izmainīt indeksu?");
						
						
						if (koAtrast == null) 
							break;
						
						if (!saraksts.contains(koAtrast.toLowerCase())) {
							JOptionPane.showMessageDialog(null, "Šāda produkta nav saraksta!", 
									"Kļuda", JOptionPane.WARNING_MESSAGE);
						}						
					}while(!koAtrast.matches("[\\p{L}&&\\p{IsLatin}]+") || 
							!saraksts.contains(koAtrast.toLowerCase()));
					
					if(koAtrast == null) 
						break;
					
					poz=
					JOptionPane.showInputDialog("Kāda pozīcija?");
					
					if (poz == null)
						break;
					
					kurPievienot = Integer.parseInt(poz);
					kurNonemt = saraksts.indexOf(koAtrast);
					
					String prod = saraksts.remove(kurNonemt);
					
					if(kurPievienot > kurNonemt) 
						kurPievienot--;
					saraksts.add(kurPievienot, prod);
					
					JOptionPane.showMessageDialog(null, "Produkts pārvietots!", "Informācija",
							JOptionPane.INFORMATION_MESSAGE);
					
					break;
				}
				break;
				
			case "6":
				
				do {
					koNonemt =
					JOptionPane.showInputDialog("Ko vajag noņemt?");
					
					if (koNonemt == null) 
						break;
					
					if (!saraksts.contains(koNonemt.toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Šāda produkta nav saraksta!", 
								"Kļuda", JOptionPane.WARNING_MESSAGE);
					}
				}while(!koNonemt.matches("[\\p{L}&&\\p{IsLatin}]+") || 
						!saraksts.contains(koNonemt.toLowerCase()));
				
				if(koNonemt == null) 
					break;
				
				if(saraksts.contains(koNonemt)) {
					kurNonemt = saraksts.indexOf(koNonemt);
					saraksts.remove(kurNonemt);
					JOptionPane.showMessageDialog(null, "Jūsu produkts ir izdzēsts!", 
							"Informācija", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case "7":
				
				kurNonemt = -1;
				do {
					poz =
					JOptionPane.showInputDialog("Ko vajag noņemt? (indeks)");
					
					if (poz == null) 
						break;
					
					kurNonemt = Integer.parseInt(poz);
					
					if (kurNonemt < 0 || kurNonemt >= saraksts.size()) {
						JOptionPane.showMessageDialog(null, "Šāda produkta nav saraksta!", 
								"Kļuda", JOptionPane.WARNING_MESSAGE);
					}
				}while(!poz.matches("\\d+"));
				
				if(poz == null) 
					break;
				
				String removed = saraksts.remove(kurNonemt);
				JOptionPane.showMessageDialog(null, "Produkts \"" + removed + "\" ir noņemts!", 
                        "Informācija", JOptionPane.INFORMATION_MESSAGE);
				
				break;
				
			case "8":
				
				int koNonemt1 =
				JOptionPane.showConfirmDialog(null, "Tu tiešām grib izdzēst pirmo produktu?", "Izvele", JOptionPane.YES_NO_OPTION);
				
				if (koNonemt1 == JOptionPane.CANCEL_OPTION || koNonemt1 == JOptionPane.CLOSED_OPTION)
				    break;
				
				if(koNonemt1 == JOptionPane.YES_OPTION) {
					if(!saraksts.isEmpty()) {
					saraksts.removeFirst();
					JOptionPane.showMessageDialog(null, "Pirmais produkts ir noņemts!", 
							"Informācija!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Jūms nav produktu saraksta!", 
							"Kļuda", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Darbība atcelta!", "Informācija!", 
						JOptionPane.INFORMATION_MESSAGE);
			}
				break;
				
			case "9":
				
				int koNonemt2 =
				JOptionPane.showConfirmDialog(null, "Tu tiešām grib izdzēst pēdējo produktu?", 
						"Izvele", JOptionPane.YES_NO_OPTION);
				
				if (koNonemt2 == JOptionPane.CANCEL_OPTION || koNonemt2 == JOptionPane.CLOSED_OPTION)
				    break;
				
				if(koNonemt2 == JOptionPane.YES_OPTION) {
					if(!saraksts.isEmpty()) {
					saraksts.removeLast();
					JOptionPane.showMessageDialog(null, "Pēdējais produkts ir noņemts!", 
							"Informācija!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Jūms nav produktu saraksta!", 
							"Kļuda", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Darbība atcelta!", "Informācija!", 
						JOptionPane.INFORMATION_MESSAGE);
			}
				
				break;
				
			case "10":
				
				String jaunsProdukts;
				
				do {
					koAtrast = JOptionPane.showInputDialog("Ko vajag mainīt?");
					if (koAtrast == null) break;

					if (!koAtrast.matches("[\\p{L}&&\\p{IsLatin}]+")) {
						JOptionPane.showMessageDialog(null, "Nederīgs ievads!", "Kļūda",
								JOptionPane.WARNING_MESSAGE);
						continue;
					}

					if (!saraksts.contains(koAtrast.toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Šāda produkta nav sarakstā!", "Kļūda",
								JOptionPane.WARNING_MESSAGE);
					}

				} while (!saraksts.contains(koAtrast.toLowerCase()));
			
			if(koAtrast  == null) 
				break;
			
			jaunsProdukts = JOptionPane.showInputDialog("Ieraksti jaunu produktu:");
			
		    if (jaunsProdukts == null) 
		    	break;
		    
		    if(saraksts.contains(jaunsProdukts.toLowerCase())) {
		    	JOptionPane.showMessageDialog(null, "Šads produkts jau ir pievienots saraksta!",
		    			"Informācija", JOptionPane.INFORMATION_MESSAGE);
		    	break;
		    }
			
			kuruMainit = saraksts.indexOf(koAtrast.toLowerCase());
			arKoAizstat = jaunsProdukts.toLowerCase();
			saraksts.set(kuruMainit, arKoAizstat);
			
			JOptionPane.showMessageDialog(null, "Produkts veiksmīgi nomainīts!",
		            "Informācija", JOptionPane.INFORMATION_MESSAGE);
			
			break;
				
			case "11":
				
				if(saraksts.size() > 0) {
					String atb = (String) JOptionPane.showInputDialog(null,
							"Kārtot produktus alfabētiski augoši?", "Izvēle",
							JOptionPane.INFORMATION_MESSAGE, null, 
							atbilde, atbilde[0]);
					if(atb != null) {
						if(atb.equals("Jā")) {
							 Collections.sort(saraksts);
							JOptionPane.showMessageDialog(null, 
									"Produkti sakārtoti augoši!", "Kārtošana",
									JOptionPane.INFORMATION_MESSAGE);
						}else {
							Collections.sort(saraksts, Collections.reverseOrder());
							JOptionPane.showMessageDialog(null, 
									"Produkti sakārtoti dilstoši!", "Kārtošana",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Jūms nav produktu saraksta!",
							"Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				break;
				
			case "12":
				
				int koNonemt3 =
				JOptionPane.showConfirmDialog(null, "Tu tiešām grib izdzēst visu sarakstu?", "Izvele", JOptionPane.YES_NO_OPTION);
				
				if (koNonemt3 == JOptionPane.CANCEL_OPTION || koNonemt3 == JOptionPane.CLOSED_OPTION)
				    break;
				
				if(koNonemt3 == JOptionPane.YES_OPTION) {
					if(!saraksts.isEmpty()) {
					saraksts.clear();
					JOptionPane.showMessageDialog(null, "Viss saraksts ir izdzēsts!", "Informācija!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Jūms nav produktu saraksta!", "Kļuda", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Darbība atcelta!", "Informācija!", JOptionPane.INFORMATION_MESSAGE);
			}
				
				break;
				
				default:
					JOptionPane.showMessageDialog(null, "Šāda darbība nepastāv!",
							"Brīdinjums", JOptionPane.WARNING_MESSAGE);
			}
		}while(!izvele.equals("0"));
	}
}