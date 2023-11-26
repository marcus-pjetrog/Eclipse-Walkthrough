package de.pjetrog;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		int menge = 0;
		int bAuswahl = 0;
		// Behälterobjekte erzeugen
		Wasserbehaelter behaelterA = new Wasserbehaelter();
		Wasserbehaelter behaelterB = new Wasserbehaelter();
		// Anfangssituation beide Wasserbehälter sind initialisiert
		behaelterA.anzeigen("BehälterA");
		System.out.println("****************************************************");
		behaelterB.anzeigen("BehälterB");
		while(true) {
			// Ausnahmebehandlung bei Benutzereingabe
			try {
				menge = Integer.parseInt(JOptionPane.showInputDialog(null, "Welche Menge soll umgepumpt werden"));
				bAuswahl = Integer.parseInt(JOptionPane.showInputDialog("Aus welchem Behälter soll umgepumpt werden?\n1 - für BehälterA\n2 - für BehälterB,\n"
						+ "alle anderen Zahlen beenden das Programm!\n"
						+ "Es kann maximal der momentane Füllstand des jeweigen Behälters umgepumpt werden."));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Falsche Eingabe, wiederholen!");
				//e.printStackTrace();
			} catch (HeadlessException e) {
				JOptionPane.showMessageDialog(null, "Falsche Eingabe, wiederholen!");
				//e.printStackTrace();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Falsche Eingabe, wiederholen!");
			}
		}
		// Auswahl der Behälter aus denen umgepumpt werden soll
		// bei ungültiger Zahleneingabe wird das Programm vorzeitig beendet
		if(bAuswahl == 1) {
			System.out.println("Die Menge welche aus BehälterA in BehälterB umgepumpt werden soll: " + menge + " Liter.");
			System.out.println("*********Pumpvorgang*********");
			// wenn die Menge welche umgepumpt werden soll
			// nicht größer als das maximale Behältervolumen ist
			if(!(menge + behaelterB.getFuellstand() > Wasserbehaelter.MAXFUELLSTAND)) {
				// Something else that needs to be done...
				behaelterA.ablauf(menge);
				behaelterB.zulauf(menge);
			}else {
				menge = behaelterA.getFuellstand() - Wasserbehaelter.MAXFUELLSTAND;
				behaelterB.ablauf(menge);
				behaelterA.zulauf(menge);
			}
			// Kontrollausgaben
			System.out.println("Der Füllstand von BehälterB ist " + behaelterB.getFuellstand() + " Liter.");
			System.out.println("Der Füllstand von BehälterA ist " + behaelterA.getFuellstand() + " Liter.");
		}else if(bAuswahl == 2) {
			System.out.println("Die Menge welche aus BehälterB in BehälterA umgepumpt werden soll: " + menge + " Liter.");
			System.out.println("*********Pumpvorgang*********");
			// wenn die Menge welche umgepumpt werden soll
			// nicht größer als das maximale Behältervolumen ist
			if(!(menge + behaelterA.getFuellstand() > Wasserbehaelter.MAXFUELLSTAND)) {
				behaelterB.ablauf(menge);
				behaelterA.zulauf(menge);
			}else {
				menge = behaelterB.getFuellstand() - Wasserbehaelter.MAXFUELLSTAND;
				behaelterA.ablauf(menge);
				behaelterB.zulauf(menge);
			}
			// Kontrollausgaben
			System.out.println("Der Füllstand von BehälterA ist " + behaelterA.getFuellstand() + " Liter.");
			System.out.println("Der Füllstand von BehälterB ist " + behaelterB.getFuellstand() + " Liter.");
		}else {
			JOptionPane.showMessageDialog(null, "Das Programm wurde vorzeitig durch Benutzereingabe beendet!");
			System.exit(0);
		}
	}

}
