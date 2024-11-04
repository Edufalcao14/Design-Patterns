package models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalyseurDeTexte {
	private final List<Observer> observers = new ArrayList<>();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObservers(String line) {
		observers.forEach(observer -> observer.update(line));
	}

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Please provide a file path as an argument.");
			return;
		}

		BufferedReader lecteurAvecBuffer = null;
		String ligne;
		AnalyseurDeTexte analyseurDeTexte = new AnalyseurDeTexte();

		// Create observers
		LigneObserver ligneObserver = new LigneObserver();
		MotsObserver motsObserver = new MotsObserver();
		PalindromeObserver palindromeObserver = new PalindromeObserver();
		BelgiqueObserver belgiqueObserver = new BelgiqueObserver();

		// Add observers to the analyseurDeTexte
		analyseurDeTexte.addObserver(ligneObserver);
		analyseurDeTexte.addObserver(motsObserver);
		analyseurDeTexte.addObserver(palindromeObserver);
		analyseurDeTexte.addObserver(belgiqueObserver);

		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			System.out.println("Erreur d'ouverture du fichier.");
			return;
		}

		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			// Notify all observers
			analyseurDeTexte.notifyObservers(ligne);
		}
		lecteurAvecBuffer.close();

		// Display the results from each observer
		System.out.println("Il y avait " + ligneObserver.getLineCount() + " lignes.");
		System.out.println("Il y avait " + motsObserver.getWordCount() + " mots.");
		System.out.println("Il y avait " + palindromeObserver.getPalindromeCount() + " palindromes.");
		System.out.println("Il y avait " + belgiqueObserver.getBelgiqueCount() + " lignes contenant 'Belgique'.");
	}
}
