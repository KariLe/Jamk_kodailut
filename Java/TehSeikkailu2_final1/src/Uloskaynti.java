/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kari
 */
public class Uloskaynti 
{
	// Numeeriset koodit
	public static final int UNDEFINED = 0;
	public static final int NORTH = 1;
	public static final int SOUTH = 2;
	public static final int EAST  = 3;
	public static final int WEST  = 4;
	public static final int UP    = 5;
	public static final int DOWN  = 6;
	public static final int NORTHEAST = 7;
	public static final int NORTHWEST = 8;
	public static final int SOUTHEAST = 9;
	public static final int SOUTHWEST = 10;
	public static final int IN = 11;
	public static final int OUT = 12;

	// Stringi koodit	
	public static final String[] dirName = 
	{ 
		"UNDEFINED",
		"NORTH",
		"SOUTH",
		"EAST",
		"WEST",
		"UP",
		"DOWN",
		"NORTHEAST",
		"NORTHWEST",
		"SOUTHEAST",
		"SOUTHWEST",
		"IN",
		"OUT"
	};

	public static final String[] shortDirName = 
	{
		"NULL",
		"N",
		"S",
		"E",
		"W",
		"U",
		"D",
		"NE",
		"NW",
		"SE",
		"SW",
		"I",
		"O"		
	};

	// Jäsen muuttujat
	private Sijainti m_leadsTo = null;
	private int m_direction;

	// Suunnan kokonainen nimi
	private String m_directionName;

	// Suunnan lyhyt nimi
	private String m_shortDirectionName;
        
        //

	// Konstruktori
	public Uloskaynti()
	{
		m_direction = Uloskaynti.UNDEFINED;
		m_leadsTo = null;
		m_directionName = dirName[UNDEFINED];
		m_shortDirectionName = shortDirName[UNDEFINED];
	}

	// Kokonainen Konstruktori
	public Uloskaynti( int direction, Sijainti leadsTo )
	{
		m_direction = direction;

		// Assign direction names
		if (direction <= dirName.length )
			m_directionName = dirName[m_direction];
		if (direction <= shortDirName.length )
			m_shortDirectionName = shortDirName[m_direction];

		// Assign location
		m_leadsTo = leadsTo;
	}

	// toString metodi
        @Override
	public String toString()
	{
		return m_directionName;
	}

	// Asettaa suunnan nimen
	public void setDirectionName( String dirname )
	{
		m_directionName = dirname;
	}

	// Palauttaa suunnan nimen
	public String getDirectionName()
	{
		return m_directionName;
	}

	// Asetttaa lyhyen suunnan nimen
	public void setShortDirectionName ( String shortName )
	{
		m_shortDirectionName = shortName;
	}

	// Palauttaa lyhyen suunnan nimen
	public String getShortDirectionName ()
	{
		return m_shortDirectionName;
	}

	// Asettaa sijainnin
	public void setLeadsTo ( Sijainti leadsTo )
	{
		m_leadsTo = leadsTo;
	}

	// Palauttaa sijainnin
	public Sijainti getLeadsTo (  )
	{
		return m_leadsTo;
	}

}
