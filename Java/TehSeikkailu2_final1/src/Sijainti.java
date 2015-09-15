
import java.util.ArrayList;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kari
 */
public class Sijainti 
{
	// Jäsen muuttujat
	private String m_roomTitle;
	private String m_roomDescription;
	private Vector m_vecExits;
        private Vector m_vecItems;
        private Vector m_vecEnemies;
        private Vihollinen m_vihollinen = null;
        private Esine m_esine = null;
       // ArrayList esineetHuoneessaArray = new ArrayList();
        //private Esine esine;

	// Tyhjä konstruktori
	public Sijainti()
	{
		// Blank title + description
		m_roomTitle = new String ();
		m_roomDescription = new String();
		m_vecExits = new Vector();
                m_vecItems = new Vector();
                m_vecEnemies = new Vector();
	}

	// Osittainen konstruktori
	public Sijainti( String title )
	{
		// Assign title
		m_roomTitle = title;

		// Blank description
		m_roomDescription = new String();

		// Blank exits
		m_vecExits = new Vector();
                m_vecItems = new Vector();
                m_vecEnemies = new Vector();
	}

	// Täysi konstruktori
	public Sijainti( String title, String description )
	{
		// Assign title + description
		m_roomTitle = title;
		m_roomDescription = description;

		// Blank exits
		m_vecExits = new Vector();
                m_vecItems = new Vector();
                m_vecEnemies = new Vector();
	}

	// toString metodi
        @Override
	public String toString()
	{
		return m_roomTitle;
	}
        
        //Lisää vihollisen tähän sijaintiin
        public void addEnemy(Vihollinen vihollinen)
        {
            m_vecEnemies.addElement(vihollinen);
        }
        
        //Poistaa vihollisen tästä sijainnista
        public void removeEnemy( Vihollinen vihollinen)
        {
                 if (m_vecEnemies.contains (vihollinen))
		{
			m_vecEnemies.removeElement (vihollinen);
		}            
        }
        
        //Palauttaa viholliset
        public Vector getEnemies()
        {
            return (Vector) m_vecEnemies.clone();
        }
        
        
        //Lisää esineen tähän sijaintiin
        public void addItem ( Esine item )
        {
            m_vecItems.addElement(item);
        }
        //poistaa esineen tästä sijainnista
        public void removeItem ( Esine item )
        {
            if (m_vecItems.contains (item))
		{
			m_vecItems.removeElement (item);
		}
            
        }
        //Palauttaa esineet
        public Vector getItems ()
        {
            return (Vector) m_vecItems.clone();
        }

	// Lisää uloskäynnin tähän sijaintiin
	public void addExit ( Uloskaynti exit )
	{
		m_vecExits.addElement (exit);
	}

	// Poistaa uloskäynnin tästä sijainnista
	public void removeExit ( Uloskaynti exit )
	{
		if (m_vecExits.contains (exit))
		{
			m_vecExits.removeElement (exit);
		}
	}   

	// Palauttaa vektorin uloskäynneistä
	public Vector getExits ()
	{
		// Return a clone, as we don't want an external
		// object to modify our original vector
		return (Vector) m_vecExits.clone();
	}
	
	// Palauttaa sijainnin otsikon
	public String getTitle()
	{
		return m_roomTitle;
	}

	// Asettaa sijainnin otsikon
	public void setTitle( String roomTitle )
	{
		m_roomTitle = roomTitle;
	}

	// Palauttaa sijainnin kuvauksen
	public String getDescription()
	{
		return m_roomDescription;
	}

	// Asettaa sijainnin kuvauksen
	public void setDescription( String roomDescription )
	{
		m_roomDescription = roomDescription;
	}
}