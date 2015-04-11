package de.bkwi.marlon;

import de.bkwi.marlon.model.Auftrag;

/**
 * 
 * @author Marlon Kanngieﬂer
 *
 */
public class TextFormatter {

	/**
	 * 
	 * @param artikel
	 * @return
	 */
	public static String formatterArtikel(Artikel artikel) {

		if(artikel == null  || artikel.getArtNr() == null){
			return TextFormatter.formatterErrorMessage("Der Artikel wurde nicht gefunden!");
		}
		
		
		String text = "Artikelbeschreibung: \n\n";
		text += "\tArtikelNr: \t" + artikel.getArtNr() + "\n";
		text += "\tBezeichnung: \t";
		
		if(artikel.getBez() == null) {
			text += artikel.getBez() + "\n\n";
		} else {
			text += "Keine Bezeichnung vorhanden" + "\n\n";
		}
		
		Auftrag[] auftrag = artikel.getInAuftrag();

		if (auftrag == null || auftrag.length == 0) {
				text += "\tDieser Artikel ist nicht Teil eines Auftrages! \n";
		} else {
			text += "\tDer Artikel befindet sich in folgenden Auftr‰gen: \n\n";
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
	 * @param string
	 * @return
	 */
	public static String formatterErrorMessage(String string) {
		return "\n\tFehler!: " + string;
	}

}
