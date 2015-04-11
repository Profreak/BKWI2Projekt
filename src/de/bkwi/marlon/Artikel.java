package de.bkwi.marlon;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.bkwi.marlon.db.DBVerbindung;
import de.bkwi.marlon.model.Auftrag;
import de.bkwi.marlon.model.Kunde;

/**
 * 
 * @author Marlon Kanngieﬂer
 *
 */
public class Artikel {

	private String artNr;
	private String bez;
	private Auftrag[] inAuftrag;
	private DBVerbindung aktZugriff;

	/**
	 * 
	 */
	public Artikel() {

	}

	/**
	 * 
	 * @param inputText
	 * @throws SQLException
	 */
	public Artikel(String inputText) throws SQLException {

		artNr = inputText;

		aktZugriff = new DBVerbindung();
		if(!aktZugriff.oeffneDB()) throw new SQLException();

		ResultSet rs;

		// Bezeichnung

		rs = aktZugriff
				.leseDB("SELECT bezeichnung FROM artikel WHERE artikelnr = '"
						+ artNr + "'");

		int cols = rs.getMetaData().getColumnCount();

		if (rs.next()) {
			bez = rs.getString(1);
		}

		// Auftr‰ge

		rs.close();

		rs = aktZugriff
				.leseDB("SELECT aufnr FROM auftragspositionen WHERE artikelnr = '"
						+ artNr + "'");

		cols = rs.getMetaData().getColumnCount();

		inAuftrag = new Auftrag[cols];

		while (rs.next()) {
			for (int i = 1; i <= cols; i++) {

				Auftrag a = new Auftrag();
				a.setAufNr(rs.getString(1));

				inAuftrag[i - 1] = a;

			}
		}

		rs.close();

		List<Kunde> kunden = new ArrayList<Kunde>();

		for (int i = 0; i < inAuftrag.length; i++) {

			Auftrag current = inAuftrag[i];
			String kdNr = "";

			rs = aktZugriff
					.leseDB("SELECT aufnr, aufdat FROM auftragskoepfe WHERE aufnr = '"
							+ current.getAufNr() + "'");

			cols = rs.getMetaData().getColumnCount();

			if (rs.next()) {
				kdNr = rs.getString(1);
				current.setAufDat(rs.getString(2));
			}

			rs.close();

			rs = aktZugriff.leseDB("SELECT name FROM kunden WHERE kdnr = '" + kdNr
					+ "'");

			if (rs.next()) {
				Kunde kunde = new Kunde(kdNr);
				kunde.setKdName(rs.getString(1));

				for (Kunde value : kunden) {
					if (value.getKdNr().equals(kunde)) {
						kunde = value;
					}
				}

				current.setVonKunde(kunde);
			}

		}

		if(!aktZugriff.schliesseDB()) throw new SQLException();
	}

	/**
	 * @return the artNr
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
	 * @return the bez
	 */
	public String getBez() {
		return bez;
	}

	/**
	 * @param bez
	 *            the bez to set
	 */
	public void setBez(String bez) {
		this.bez = bez;
	}

	/**
	 * @return the inAuftrag
	 */
	public Auftrag[] getInAuftrag() {
		return inAuftrag;
	}

	/**
	 * @param inAuftrag
	 *            the inAuftrag to set
	 */
	public void setInAuftrag(Auftrag[] inAuftrag) {
		this.inAuftrag = inAuftrag;
	}

}
