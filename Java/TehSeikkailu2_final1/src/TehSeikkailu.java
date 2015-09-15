
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.Enumeration;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kari
 */
public class TehSeikkailu extends Applet
{
	Sijainti  currentLocation;
	String    command;       
        Hahmo     seikkailija;
        Vihollinen vihollinen1;
        Vihollinen vihollinen2;
        Vihollinen vihollinen3;
        
        Esine     esine;

	TextField commandInput;
	TextArea  displayOutput;
        TextArea  displayStats;
	Button    buttonInput;

	// Konstructori
	public TehSeikkailu()
	{
		super();
	}

	// Initialisation methodi
        @Override
	public void init()
	{
		super.init();
                seikkailija = new Hahmo();
                //(String nimi,int hitpoints,int defence,int power,int points)
                vihollinen1 = new Vihollinen("Örkki1",10,1,1,1);
                vihollinen2 = new Vihollinen("Örkki Boss",15,2,2,2); 
                vihollinen3 = new Vihollinen("Örkki2",10,1,1,1);   
                
		// Määrittää värit
		setBackground(Color.white);
		setForeground(Color.black);

		Panel appletPanel = new Panel();
               
		// Käytetään border layouttia
		BorderLayout b = new BorderLayout();
		appletPanel.setLayout (b);
		add(appletPanel);
		
		// Määrittää UI:n
		commandInput  = new TextField(20);
		displayOutput = new TextArea(20, 60); // 20 rows x 60 chars
                displayStats = new TextArea(4,10);
		buttonInput   = new Button("OK");
		Panel inputPanel = new Panel();

		// Lisää komponentit inputpanelille
		inputPanel.add(commandInput);
		inputPanel.add(buttonInput);
                //inputPanel.add(displayStats);
                
                //Päällimmäiseksi textarea ja alemmaksi button ja textfield
		appletPanel.add("North", displayOutput);
		appletPanel.add("East", inputPanel);
                appletPanel.add("West",displayStats);
                

		// Luo sijainnit
		Sijainti s1 = new Sijainti  ("---SISÄÄNKÄYNTI---", "");
		Sijainti s2 = new Sijainti  ("---ETELÄINEN KÄYTÄVÄ---", "Olet juuri astunut luolaan ja ");
		Sijainti s3 = new Sijainti  ("---KESKUSHUONE---", "Iso keskushuone josta pääsy jokaiseen luolaston käytävään.");
                Sijainti s4 = new Sijainti  ("---POHJOINEN KÄYTÄVÄ---", "");
                Sijainti s5 = new Sijainti  ("---ULOSKÄYNTI---", "Johtaa ulos luolasta.");
                Sijainti s6 = new Sijainti  ("---ITÄINEN KÄYTÄVÄ---", "Johtaa itäiseen huoneeseen.");
                Sijainti s7 = new Sijainti  ("---LÄNTINEN KÄYTÄVÄ---", "Johtaa läntiseen huoneeseen.");
                Sijainti s8 = new Sijainti  ("---ITÄINEN HUONE---", "");
                Sijainti s9 = new Sijainti  ("---LÄNTINEN HUONE---", "");
                Sijainti s10 = new Sijainti ("---SALAINEN HUONE---", "Valeseinän takaa löytyi pieni huone jossa on aarre!");
                Sijainti s11 = new Sijainti ("---ULKONA---", "Pääsit luolaston läpi elossa! Game over!");
                //Sijainti s12 = new Sijainti ("---KUOLIT---", "Kuolit taistelussa saamiin haavoihin! Game over!");

		// Luo uloskäynnit sijannille s1
		s1.addExit (new Uloskaynti(Uloskaynti.NORTH, s2));		

		// Luo uloskäynnit sijannille s2
                s2.addExit (new Uloskaynti(Uloskaynti.NORTH, s3));
		s2.addExit (new Uloskaynti(Uloskaynti.SOUTH, s1));
                

		// Luo uloskäynnit sijannille s3
		s3.addExit (new Uloskaynti(Uloskaynti.NORTH, s4));
                s3.addExit (new Uloskaynti(Uloskaynti.SOUTH, s2));
                s3.addExit (new Uloskaynti(Uloskaynti.EAST, s6));
                s3.addExit (new Uloskaynti(Uloskaynti.WEST, s7));                         
                
                // Luo uloskäynnit sijannille s4
		s4.addExit (new Uloskaynti(Uloskaynti.NORTH, s5));
		s4.addExit (new Uloskaynti(Uloskaynti.SOUTH, s3));
                
                // Luo uloskäynnit sijannille s5
		s5.addExit (new Uloskaynti(Uloskaynti.NORTH, s11));
		s5.addExit (new Uloskaynti(Uloskaynti.SOUTH, s4));
                 //Luodaan huoneeseen loppuvihollinen Vihollinen(String nimi,int hitpoints,int defence,int power,int points)
                //s5.addEnemy(new Vihollinen("Pomo örkki", 10,2,3,1));
                s5.addEnemy(vihollinen2);
                
                // Luo uloskäynnit sijannille s6
                s6.addExit (new Uloskaynti(Uloskaynti.EAST, s8));
		s6.addExit (new Uloskaynti(Uloskaynti.WEST, s3));
                //Luodaan huoneeseen esine kilpi
                Esine kilpi = new Esine("Kilpi",0,2,"Hyväkuntoinen yhden käden kilpi.",1);
                s6.addItem (kilpi);
                
                // Luo uloskäynnit sijannille s7
		s7.addExit (new Uloskaynti(Uloskaynti.EAST, s3));
		s7.addExit (new Uloskaynti(Uloskaynti.WEST, s9));
                //Luodaan huoneeseen esine miekka                
                Esine miekka = new Esine("Miekka",1,0,"Terävä yhden käden miekka.",1);
                s7.addItem (miekka);
                
                // Luo uloskäynnit sijannille s8
                s8.addExit (new Uloskaynti(Uloskaynti.NORTH, s10));
		s8.addExit (new Uloskaynti(Uloskaynti.WEST, s6));
                //Luodaan huoneeseen esine
                //s8.addItem (new Esine());
                Esine avain1 = new Esine("Avain",0,0,"Avain itäiseen huoneeseen.",1);
                s8.addItem(avain1);
                //Luodaan huoneeseen vihollinen Vihollinen(String nimi,int hitpoints,int defence,int power,int points)
                //s8.addEnemy(new Vihollinen("Örkki 1", 5,1,1,1));
                s8.addEnemy(vihollinen3);
                
                // Luo uloskäynnit sijannille s9
		s9.addExit (new Uloskaynti(Uloskaynti.EAST, s7));
                //Luodaan huoneeseen esine                
                Esine avain2 = new Esine("Avain",0,0,"Avain pohjoiseen uloskäyntiin.",1);
                s9.addItem(avain2);
                //Luodaan huoneeseen vihollinen Vihollinen(String nimi,int hitpoints,int defence,int power,int points)
                // s9.addEnemy(new Vihollinen("Örkki 2", 5,1,1,1));
                s9.addEnemy(vihollinen1);
                
                // Luo uloskäynnit sijannille s10
                s10.addExit (new Uloskaynti(Uloskaynti.SOUTH, s8));
                  //Luodaan huoneeseen esine
                //s10.addItem (new Esine("Timantti",0,0,"Häikäisevän kaunis timantti.",2));
                Esine timantti = new Esine("Timantti",0,0,"Häikäisevän kaunis timantti.",2);
                s10.addItem(timantti);
                // Luo uloskäynnit sijannille s9
                //s11.addExit (new Exit(Exit.EAST, s7));

		// aloitushuone
		currentLocation = s1;

		// Näyttää ensimmäisen sijainnin
                //ShowStats();
                repaint();
		showLocation();                
		repaint();
                
	}

	private void showLocation()
	{
		// Näyttää huoneen otsikon
		displayOutput.append(currentLocation.getTitle());
		displayOutput.append( "\n" );
		
		// Näyttää huoneen kuvauksen
		displayOutput.append( currentLocation.getDescription() + "\n" );
                
                 // Näyttää viholliset
                displayOutput.append( "\nHuoneessa olevat viholliset: \n" );
                // 
                try
                {
		for (Enumeration e = currentLocation.getEnemies().elements(); e.hasMoreElements();)
		{
			Vihollinen an_vihollinen = (Vihollinen) e.nextElement();
			displayOutput.append ("Hyökkäät vihollisen " + an_vihollinen.getNimi() + " kimppuun!\n");
                        //Seikkailija lyö vihollista ja vihollinen seikkailijaa kunnes toinen delaa
                        while(seikkailija.getAlive() == true)
                        {                      
                                 //tarkistetaan onko pelaaja elossa
                                 an_vihollinen.lyo(seikkailija);                                 
                                 if(seikkailija.getAlive() == false)
                                 {
                                    displayOutput.append ("Kuolit! " + an_vihollinen.getNimi() + " voitti!\n"); 
                                    init();
                                    break;
                                 }
                                 displayOutput.append (an_vihollinen.getNimi() + " löi sinua!\n");
                                 displayOutput.append ("Sinun hp: " + seikkailija.getHitpoints() + "\n");
                                 seikkailija.lyo(an_vihollinen);
                                 //tarkistetaan onko vihollinen elossa
                                 if(an_vihollinen.getAlive() == false)
                                 {
                                    displayOutput.append ("Voitit " + an_vihollinen.getNimi() + "!\n");
                                    currentLocation.removeEnemy(an_vihollinen);
                                    break;
                                 }
                                 displayOutput.append ("Löit " + an_vihollinen.getNimi() + "!\n"); 
                                 displayOutput.append ("Vihollisen hp: " + an_vihollinen.getHitpoints() + "\n");
                        
                        }
                      
                        
                       
                        
		}
                }
                catch(NullPointerException e)
                {
                    System.out.println("Tapahtui virhe!");
                }
                // Näyttää esineet
                displayOutput.append( "\nHuoneesta löytyneet esineet: \n" );
		for (Enumeration e = currentLocation.getItems().elements(); e.hasMoreElements();)
		{
			Esine an_esine = (Esine) e.nextElement();                        
			displayOutput.append ("Löysit ja otit käyttöön esineen: " + an_esine.getNimi() + "\n");
                        //laitetaan löytynyt esine hahmon inventaarioon,näistä sais metodin
                        seikkailija.setEsineetArray(an_esine);
                        //kasvatetaan seikkalijan ominaisuuksia esineen mukaan
                        seikkailija.setDefence(an_esine.getDefence());
                        seikkailija.setPower(an_esine.getPower());
                        seikkailija.setPoints(an_esine.getPoints());
                        //poistetaan löytynyt esine sijainnista
                        currentLocation.removeItem(an_esine);
                        
		}
                
               
                

		// Näyttää käytettevät uloskäynnit
		displayOutput.append( "\nKäytettävät uloskäynnit : \n" );
		for (Enumeration e = currentLocation.getExits().elements(); e.hasMoreElements();)
		{
			Uloskaynti an_exit = (Uloskaynti) e.nextElement();
			displayOutput.append (an_exit + "\n");
		}		
		
	}
        private void ShowStats()
        {
             displayStats.insert("Defence: " + seikkailija.getDefence() + "\n",0); 
             displayStats.insert("Power: " + seikkailija.getPower() + "\n",0); 
             displayStats.insert("Hitpoints:" + seikkailija.getHitpoints()+ "\n",0);
             displayStats.insert("Points: " + seikkailija.getPoints() + "\n",0); 
        }

        @Override
	public boolean action (Event evt, Object focus)
	{
		String command;

		// Painettiinko nappia ? 
		if (evt.target instanceof Button)
		{
			// Ottaa stringin
			command = commandInput.getText();

			// Skippaa tyhjät
			if (command.length() == 0) {
                        return true;
                    }

			// Muuntaa isoiksi kirjaimiksi vertailua varten
			command = command.toUpperCase();

			// Katsotaan löytyykö uloskäyntiä
			for (Enumeration e = currentLocation.getExits().elements(); e.hasMoreElements();)
			{
				Uloskaynti an_exit = (Uloskaynti) e.nextElement();

				if ( (an_exit.getDirectionName().compareTo(command) == 0) ||
					 (an_exit.getShortDirectionName().compareTo(command) == 0 )
				   )
				{
                                        // Asettaa sijainnin sijainniksi sijainnin johon exit viittaa
					// Set location to the location pointed to by exit
					currentLocation = an_exit.getLeadsTo();

					// Näytä uusi sijainti
					showLocation();
                                        ShowStats();

					// Tyhjentää textarean
					commandInput.setText (new String());

					// Event käyty
					return true;
				}				
			}

			// jos suunta oli kelpaamaton
			displayOutput.append ("\nVirheellinen valinta!\n");

			// Tyhjentää textarean
			commandInput.setText (new String());

			// Event käyty
			return true;
		}
		// Event ei onnistunut
		else {
                return false;
            }
	}

}