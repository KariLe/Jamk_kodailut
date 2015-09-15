package TavallisetLuokat;

/*
* SQL.java
* Yksinkertainen luokka tietokannan k�sittelyyn
* attribuutit ja metodit staattisia eli t�t� kutsutaan luokan nimell�.
* Ei tarvitse (eik� voi) luoda oliota.
*
*/

import java.sql.*;
//import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//Seuraavat tarvitaan jos luetaan tunnarit ulkoisesta tiedostosta
//import java.io.*;
//import java.util.ArrayList;

public class SQL {
    
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static Statement stmt = null;
    private static PreparedStatement preStmt = null;
    
    
    //Kommenteissa esitetty tietokannan tunnareiden haku ulkoisesta tiedostosta.
    
    //tiedosto josta tiekannan tunnarit luetaan
    //private static String source = "/opt/tunnarit/tunnarit.txt"; //C://temp//tunnarit.txt
    
    /*tunnarit.txt, kolme rivi�
     *
     *jdbc:mysql://localhost/osoitteet
     *root
     *elvis
     */
   

    //Metodi jolla luetaan webbiin n�kym�tt�m�st� tiedostosta rivit muuttujiin
    /*public static String readLineFile(String source, int line) throws Exception
	{	
	FileReader in;
	LineNumberReader lnr;
	String s ="";	

	int num;
        in = new FileReader(source);
		
	lnr = new LineNumberReader(in);
		
	for(int i=0; i<line;i++)
	s=lnr.readLine();
		
	in.close();
	lnr.close();
	return s;
       }
    */
    
    // avaa yhteyden tietokantaan
public static Connection openConnection() throws NamingException, SQLException
    {
            conn = null;
            //Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            InitialContext ctx = new InitialContext();
            //The JDBC Data source joka luotiin
            DataSource ds = (DataSource) ctx.lookup("TutorialJDBCResource");
            conn = ds.getConnection();

            if (conn == null)
            {
                throw new SQLException("Error establishing connection!");
            }
        
       
        //conn = null;
        
        //jos otetaan tunnarit tiedostosta
        /*
        String url = readLineFile(source, 1);
        String tunnari = readLineFile(source, 2);
        String salasana = readLineFile(source, 3);
        */
          
        
        // tahan merkitaan tietokannan osoite ja tietokannan nimi
        /*
        String url = "jdbc:mysql://localhost/ojatko";
        //String url = "jdbc:odbc:osoitteet"
            */
            /*
        try {
           /* Otetaan yhteys. Normaalisti rootin tunnareita ei saa tietenk��n k�ytt��.
            Tunnareita ei saisi my�skaan kovakoodata koodiin, vaan ne pit�isi
            hakea ulkopuolisesta tiedostosta kts. kommentoitu koodi ylemp�n�
           */
            //conn = DriverManager.getConnection(url, "ojatko", "ojatko");
          //conn = DriverManager.getConnection(url, tunnari, salasana);
           
        //} catch(SQLException e){
        //    System.out.println(e);
       // }
        
        // palautetaan avattu yhteys
        return conn;
    }
    
    // sulkee yhteyden
    public static void closeConnection(Connection conn) throws Exception
    {
        conn.close();
    }
    
    // luo yhteydesta Statement-olion
    public static Statement createStmt(Connection conn)
    {
        try {
            return conn.createStatement();
        } catch ( SQLException e ){
            System.out.println(e);
        }
        return null;
    }
    
    // luo yhteydesta PreparedStatement olion tietyn SQL-lauseen mukaisesti
    public static PreparedStatement createPreStmt(Connection conn, String sql)
    {
        try {
            return conn.prepareStatement(sql);
        } catch ( SQLException e ){
            System.out.println(e);
        }
        return null;
    }    
    
    // hakee tietokannasta tietoa Statementin ja SQL-lauseen avulla
    public static ResultSet getRS(Statement stmt, String query)
    {
        try {
            return stmt.executeQuery(query);
        } catch ( SQLException e ){
            System.out.println(e);
        }
        return null;
    }
    
    // tekee paivityksen tietokantaan Statementin ja SQL-lauseen avulla
    public static void updateDB(Statement stmt, String query)
    {
        try {
            stmt.executeUpdate(query);
        } catch ( SQLException e ){
            System.out.println(e);
        }
    }
}

