package de.bkwi.marlon;

/**
 * 
 * @author Marlon Kanngieﬂer
 *
 */
public class Auftrag {

	private String aufNr;
	private String aufDat;
	private Kunde vonKunde;

	/**
	 * 
	 */
	public Auftrag() {

	}

	/**
	 * @return the aufNr
	 */
	public String getAufNr() {
		return aufNr;
	}

	/**
	 * @param aufNr
	 *            the aufNr to set
	 */
	public void setAufNr(String aufNr) {
		this.aufNr = aufNr;
	}

	/**
	 * @return the aufDat
	 */
	public String getAufDat() {
		return aufDat;
	}

	/**
	 * @param aufDat
	 *            the aufDat to set
	 */
	public void setAufDat(String aufDat) {
		this.aufDat = aufDat;
	}

	/**
	 * @return the vonKunde
	 */
	public Kunde getVonKunde() {
		return vonKunde;
	}

	/**
	 * @param vonKunde
	 *            the vonKunde to set
	 */
	public void setVonKunde(Kunde vonKunde) {
		this.vonKunde = vonKunde;
	}
}
