package de.bkwi.marlon;

import de.bkwi.marlon.db.DBVerbindung;
import de.bkwi.marlon.model.Auftrag;

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
