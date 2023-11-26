package de.pjetrog;

public class Wasserbehaelter {
	// das maximale Volumen der beiden Wasserbehälter
	final static int MAXFUELLSTAND = 100;
	private int fuellstand = 60;
	
	public int getFuellstand() {
		return fuellstand;
	}
	public void setFuellstand(int fuellstand) {
		this.fuellstand = fuellstand;
	}
	
	// Methoden um das wasser der beiden Behälter
	// umzupumpen
	public  void ablauf(int menge) {
		this.setFuellstand(this.getFuellstand() - menge); 
	}
	public void zulauf(int menge) {
		this.setFuellstand(this.getFuellstand() + menge);
	}
	public void anzeigen(String behaelter) {
		System.out.println("Der " + behaelter + " hat ein maximales Volumen von " + MAXFUELLSTAND + " Litern.");
		System.out.println("Der momentane Füllstand beträgt " + this.getFuellstand() + " Liter.");
	}


}
