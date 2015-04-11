package de.bkwi.marlon;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.bkwi.marlon.db.DBVerbindung;
import de.bkwi.marlon.structures.Auftrag;
import de.bkwi.marlon.structures.Kunde;

/**
 * 
 * Diese Klasse hat die Aufgabe anhand einer Artikelnummer, die Daten zu dem
 * entsprechendem Artikel aufzurufen und zu speichern.
 * 
 * @author Marlon Kanngie�er
 *
 */
public class Artikel {

	private String artNr;
	private String bez;
	private Auftrag[] inAuftrag;
	private DBVerbindung aktZugriff;

	/**
	 * 
	 * Konstruiert einen neuen Artikel indem es sich mit einer SQL Datenbank
	 * verbindet und die entsprechenden Daten aufruft.
	 * 
	 * @param inputText
	 *            die Artikelnummer
	 * @throws SQLException
	 *             wird geworfen, wenn ein SQL Fehler vorliegt.
	 * @throws NotExsistingAtrNrException
	 *             wird geworfen, wenn die Artikelnummer nicht exsistiert.
	 */
	public Artikel(String inputText) throws SQLException, NotExsistingAtrNrException {

		// Datenbank verbinden
		aktZugriff = new DBVerbindung();
		if (!aktZugriff.oeffneDB())
			throw new SQLException();

		// ben�tigte Variablen zuweisen
		artNr = inputText;
		ResultSet rs;
		int cols = 0;
		List<Auftrag> list = new ArrayList<Auftrag>();
		List<Kunde> kunden = new ArrayList<Kunde>();

		// Bezeichnung

		// abfrage der Bezeichnung
		rs = aktZugriff.leseDB("SELECT bezeichnung FROM artikel WHERE artikelnr = '" + artNr + "'");

		// Resultset durchgehen
		if (rs.next()) {
			bez = rs.getString(1);
			cols++;
		}

		// Fehler schmei�en, wenn kein Eintrag gefunden wurde
		if (cols == 0) {
			throw new NotExsistingAtrNrException();
		}

		// Resultset schlie�en
		rs.close();

		// Auftr�ge

		// Auftragsnummer abfragen
		rs = aktZugriff.leseDB("SELECT aufnr FROM auftragspositionen WHERE artikelnr = '" + artNr + "'");

		// alle Auftr�ge als Objekte erzeugen
		while (rs.next()) {

			Auftrag a = new Auftrag();
			a.setAufNr(rs.getString(1));

			list.add(a);

		}

		// initialisierung von inAuftrag anhand der Anzahl der Auftragsnummern
		inAuftrag = new Auftrag[list.size()];

		// konvertierung der List zu einem Array
		for (int i = 0; i < list.size(); i++) {
			inAuftrag[i] = list.get(i);
		}

		// Resultset schlie�en
		rs.close();

		// alle Auftr�ge durchgehen und Auftragsdatum und kunde hinzuf�gen
		for (int i = 0; i < inAuftrag.length; i++) {

			// tempor�re variabeln
			Auftrag current = inAuftrag[i];
			String kdNr = "";

			// abfrage der kundennummer und auftragssdatum
			rs = aktZugriff.leseDB("SELECT kdNr, aufdat FROM auftragskoepfe WHERE aufnr = '" + current.getAufNr() + "'");

			// hinzuf�gen der Abfrage in die tempor�ren Variabeln
			if (rs.next()) {
				kdNr = rs.getString(1);
				current.setAufDat(rs.getString(2));
			}

			// Resultset schlie�en
			rs.close();

			// Kunden

			// schauen ob der Kunde schon erstellt wurde
			Kunde kunde = getKunde(kdNr, kunden);
			// falls er nicht erstellt wurde abfrage des Namen des Kunden
			if (kunde == null) {

				rs = aktZugriff.leseDB("SELECT name FROM kunden WHERE kdnr = '" + kdNr + "'");

				// hinzuf�gen des Kunden zu des Auftrags Objekt und zu der Liste
				// aller schon vorhandenen Kunden
				if (rs.next()) {
					kunde = new Kunde(kdNr);
					kunde.setKdName(rs.getString(1));

					kunden.add(kunde);

				}
			}

			current.setVonKunde(kunde);

		}

		// schlie�en der Datenbank verbindung
		if (!aktZugriff.schliesseDB())
			throw new SQLException();
	}

	/**
	 * 
	 * Diese Helper Methode gibt einen bereits vorhanden Kunden oder null
	 * zur�ck.
	 * 
	 * @param kdNr
	 *            die eindeutige Kundennummer
	 * @param kunden
	 *            die liste der vorhandenen Kunden
	 * @return null wenn der Kunde noch nicht erstellt wurde
	 */
	private Kunde getKunde(String kdNr, List<Kunde> kunden) {
		for (Kunde value : kunden) {
			// Wenn die Kundennummer exsistiert dann gib das entsprechende
			// Objekt zur�ck
			if (value.getKdNr().equals(kdNr)) {
				return value;
			}
		}
		return null;
	}

	/**
	 * 
	 * @return die Artikelnummer
	 */
	public String getArtNr() {
		return artNr;
	}

	/**
	 * @param artNr
	 *            the artNr to set
	 */
	public void setArtNr(String artNr) {
		this.artNr = artNr;
	}

	/**
	 * @return die Bezeichnung
	 */
	public String getBez() {
		return bez;
	}

	/**
	 * @param bez
	 *            die Bezeichnung zum setzen
	 */
	public void setBez(String bez) {
		this.bez = bez;
	}

	/**
	 * @return alle vorhandenen Auftr�ge
	 */
	public Auftrag[] getInAuftrag() {
		return inAuftrag;
	}

	/**
	 * @param inAuftrag
	 *            setzet die vorhandenen Auftr�ge
	 */
	public void setInAuftrag(Auftrag[] inAuftrag) {
		this.inAuftrag = inAuftrag;
	}

}
