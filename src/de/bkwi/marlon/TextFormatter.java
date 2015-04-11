package de.bkwi.marlon;

import de.bkwi.marlon.structures.Auftrag;

/**
 * 
 * Diese Klasse formatiert einen Artikel zu einen Text, der in einem Textarea
 * ausgegeben werden kann.
 * 
 * @author Marlon Kanngießer
 *
 */
public class TextFormatter {

	/**
	 * 
	 * formatiert einen Artikel in ein passendes Format
	 * 
	 * @param artikel
	 *            der zu formatierende Artikel
	 * @return einen String mit formartiertem Text in deutsch
	 */
	public static String formatterArtikel(Artikel artikel) {

		// Fehler falls notwendige Variablen null sind
		if (artikel == null || artikel.getArtNr() == null) {
			return TextFormatter.formatterErrorMessage("Der Artikel wurde nicht gefunden!");
		}

		String text = "Artikelbeschreibung: \n\n";
		text += "\tArtikelNr: \t" + artikel.getArtNr() + "\n";
		text += "\tBezeichnung: \t";

		// Bezeichnung könnte nicht vorhanden sein
		if (artikel.getBez() == null) {
			text += artikel.getBez() + "\n\n";
		} else {
			text += "Keine Bezeichnung vorhanden" + "\n\n";
		}

		Auftrag[] auftrag = artikel.getInAuftrag();

		// ausgabe falls keine Auftrag vorhanden ist
		if (auftrag == null || auftrag.length == 0) {
			text += "\tDieser Artikel ist nicht Teil eines Auftrages! \n";
		} else {
			// ausgabe falls Aufträge vorhanden sind
			text += "\tDer Artikel befindet sich in folgenden Aufträgen: \n\n";
			for (int i = 0; i < auftrag.length; i++) {
				Auftrag a = auftrag[i];
				text += "\tAuftragNr: \t" + a.getAufNr() + "\n";
				text += "\t-> Auftragdatum: \t" + a.getAufDat() + "\n";
				text += "\tKunde: \t" + a.getVonKunde().getKdName() + "\n";
				text += "\t\n";
			}
		}

		return text;
	}

	/**
	 * 
	 * Formatiert eine Fehlermeldung
	 * 
	 * @param string
	 *            die zu formatierende Fehlermeldung
	 * @return eine formatierte Fehlermeldung
	 */
	public static String formatterErrorMessage(String string) {
		return "\n\tFehler!: " + string;
	}

}
