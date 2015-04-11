package de.bkwi.marlon.model;

/**
 * 
 * @author Marlon Kanngieﬂer
 *
 */
public class Kunde {

	private String kdName;
	private String kdNr;
	
	/**
	 * 
	 */
	public Kunde(String kdNr){
		this.kdNr = kdNr;
	}

	/**
	 * @return the kdName
	 */
	public String getKdName() {
		return kdName;
	}

	/**
	 * @param kdName the kdName to set
	 */
	public void setKdName(String kdName) {
		this.kdName = kdName;
	}
	
	/**
	 * 
	 * @return the Kundennummer
	 */
	public String getKdNr(){
		return kdNr;
	}
	
}
