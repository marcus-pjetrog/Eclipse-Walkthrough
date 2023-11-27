package de.pjetrog;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean repeat = false;
		do {
			String eingabe = null;
			String ausgabe = null;
			double zahl1 = 0, zahl2 = 0;
			Scanner sc = new Scanner(System.in);
			//Zahlen(Operanden vom Benutzer einlesen
			try {
				System.out.print("Bitte geben Sie die erste Zahl ein: ");
				eingabe = sc.next();
				zahl1 = Double.parseDouble(eingabe);
				System.out.print("Bitte geben Sie die zweite Zahl ein: ");
				eingabe = sc.next();
				zahl2 = Double.parseDouble(eingabe);
			} catch (NumberFormatException e) {
				// wenn Fehler bei Eingabe
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Die Operanden lauten");
			System.out.println(zahl1);
			System.out.println(zahl2);
			System.out.println("\n\n");
			
			//Auswahl des Operators
			System.out.println("Bitte wählen Sie eine Operation:");
			System.out.println("Addition -- 1");
			System.out.println("Subtraktion -- 2");
			System.out.println("Multiplikation -- 3");
			System.out.println("Division -- 4");
			
			int choice = 0;
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			switch(choice) {
				case 1:
					ausgabe = Double.toString(Operation.addition(zahl1, zahl2));
					System.out.println("Das Ergebnis lautet: " + ausgabe);
					System.out.println();
					break;
				case 2:
					ausgabe = Double.toString(Operation.subtraction(zahl1, zahl2));
					System.out.println("Das Ergebnis lautet: " + ausgabe);
					System.out.println();
					break;
				case 3:
					ausgabe = Double.toString(Operation.multiplication(zahl1, zahl2));
					System.out.println("Das Ergebnis lautet: " + ausgabe);
					System.out.println();
					break;
				case 4:
					ausgabe = Double.toString(Operation.division(zahl1, zahl2));
					System.out.println("Das Ergebnis lautet: " + ausgabe);
					System.out.println();
					break;
				default :
						System.out.println("Es wurde keine Operation gewählt.");
			}
			
			System.out.println("Soll das Programm wiederholt werden");
			System.out.println("j - wiederholen");
			System.out.println("Alle anderen Tasten für - beenden");
			eingabe = sc.next();
			
			if(eingabe.equals("j") || eingabe.equals("J")) {
				repeat = true;
			}else {
				repeat = false;
			}
		} while (repeat);
		System.out.println("Das Programm wurde beendet.");
	}

}
