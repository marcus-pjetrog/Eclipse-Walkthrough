package de.pjetrog;

import java.util.Random;

import javax.swing.JOptionPane;

public class Generator {
	
	public static String codeWortGenerator(int codeWortLaenge) {
		 // Datensatz
       String alphabetL = "abcdefghijklmnopqrstuvwxyz";
       String alphabetU = alphabetL.toUpperCase();
       String numbers = "1234567890";
       String allData = alphabetL + alphabetU + numbers;
       String codewort = "";
     
       // Objekt fuer Zufallszahl
       Random rd = new Random();
       int index = 0;

       for(int i = 0; i < codeWortLaenge; i++){
           // Zufallsindex wird erzeugt
           index = rd.nextInt(allData.length());
           codewort += allData.charAt(index);
           //System.out.print(allData.charAt(index));
       }
       return codewort;
	}

}
