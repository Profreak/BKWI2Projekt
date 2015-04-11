package de.bkwi.marlon.db;

import java.sql.*;

public class DBVerbindung
{
	private	Statement stmtSQL;  // Objekt für die Ausführung von SQL-Anweisungen
	private Connection dieVerbindung;
	private final String ip = "jdbc:mysql://localhost:3306/haro";
	
	public DBVerbindung()
	{
		
	}
	public boolean oeffneDB()  
	{
		boolean ok=true;
		try
		{
			//JDBC-Treiber für mySQL registrieren und instanziieren
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			//Verbindung zur DB wird mit getConnection() über einen String hergestellt
			dieVerbindung = DriverManager.getConnection(ip ,"root","");
			//Objekt vom Typ Statement zur Anwendung an der Haro-DB erzeugen
			stmtSQL = dieVerbindung.createStatement();
			}
		catch (Exception ex)
		{
			ok = false;
		}
	 return ok;
	 }
	
	public  boolean schliesseDB()
	{
		boolean ok = true;
		try
		{
			//Statement schließen
			stmtSQL.close();
			//DB-Verbindung schließen
			dieVerbindung.close();
		}
		catch (Exception err)   
		{
			ok = false;
		}
		return ok;
	}
	
	public ResultSet leseDB(String pSQL)                 
	{
		//Ergebnistabelle (ResultSet)erzeugen
		ResultSet rs;                            
		try
		{
			//Ausführung der SQL-Anweisung mittels executeQuery(pSQL) im Statement-Objekt und Zuweisung an die Ergebnistabelle
			rs = stmtSQL.executeQuery(pSQL);
		}
		catch(SQLException err)
		{
			rs = null;
			}
		return rs;
	}
	
	public boolean aendern(String pSQL)
	{ 
		boolean ok = true;
		try 
		{
			stmtSQL.executeUpdate(pSQL); 
		}
		catch (SQLException err) 
		{
			ok = false;	
		}
		return ok;
	}
}



