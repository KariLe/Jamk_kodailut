/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 1: Opiskelija osaa käyttää ohjelmointiympäristöä tarkoituksenmukaisesti (projektit, luokat, debugger), sekä ymmärtää ja osaa käyttää muuttujia, operaattoreita ja ehtolausekkeita osana työtään.
2: Edellisen lisäksi opiskelija ymmärtää päätös-, silmukka- ja haarautumisrakenteet ja osaa käyttää niitä tarkoituksenmukaisesti. Opiskelija ymmärtää pää- ja aliohjelman eron ja osaa käyttää aliohjelmia osana työtään.
3: Edellisen lisäksi opiskelija ymmärtää taulukoiden merkityksen ja käytön ohjelmoinnin työkaluna, sekä osaa käyttää niitä tarkoituksenmukaisesti
4: Edellisen lisäksi opiskelija hallitsee poikkeukset ja virheiden käsittelyn.
5: Edellisen lisäksi opiskelija osaa käyttää tiedostoja tai tietokantaa tiedon tallennuspaikkana. Opiskelija osaa etsiä ja käyttää ohjelmointikielen tarjoamia (kenties muitakin kuin opintojaksolla esiin tulleita) luokkia tarkoituksenmukaisesti osana työtään.
 * 
 * 
 * 
 * 8.1  6h
 * 10.1 1h
 * 11.1 4h
 * 12.1 4h
 * 13.1 1h
 * 14.1 2h
 * 20.1 2h
 * 26.1 1h
 * 
 * yht. 21h
 */
 
package loppuharjoitus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/*
 * @author Kari Leskinen g9474, HTI12S1A
 */
public class Loppuharjoitus {

   
    
    //määritetään maksimi rivit ja kolumnit pelitaulukolle
    static final int RIVIT = 150;
    static final int KOLUMNIT = 4;
    static int kohtarivilla = 0;
    
    
    //tehdään pelit[][], joka on 2-ulotteinen taulukko, tähän taulukkoon lisätään pelit jtoka tulevat syötteenä käyttäjältä
    static String pelit[][] = new String[RIVIT][KOLUMNIT];
    //taulukko, jossa sijaitsevat otsikot kolumneille
    static String otsikko[][] = {{"Nimi","Genre","Alusta","Status"}};

    
    public static void main(String [] args)
    {
    
      Scanner lukija = new Scanner(System.in);
   
      //pääohjelmalooppi alkaa
      while(true)
      {
          System.out.println("Alkuvalikko");                                        //Tulostetaan ruutuun alkuvalikko
          System.out.println("---------------------------");
          System.out.println("Valitse jokin seuraavista: ");
          System.out.println("1) Pelien listaus");
          System.out.println("2) Pelin lisäys tai poisto");
          System.out.println("3) Tallenna tiedosto");
          System.out.println("4) Avaa tiedosto");
          System.out.println("5) Poistu ohjelmasta");
         
          String valinta = lukija.nextLine();                                       //sjoitetaan käyttäjältä satu valinta valinta muuttujaan tyyppiä String
          
          if(valinta.equals("1") && valinta.matches("^([1-5]{1})$"))                //Tarkistetaan käyttäjän valinnan numero ja että se on sallitulta alueelta ja yhden merkin pituinen
          {
              TulostaTaulukko();                                                    //Kutsutaan taulukontulostus metodia
          }
          else if(valinta.equals("2") && valinta.matches("^([1-5]{1})$"))
          {
              
              System.out.println("Pelien lisäys- ja poistotoiminto");
              System.out.println("---------------------------"); 
              System.out.println("1) Lisää peli");
              System.out.println("2) Poista peli");                                 //Pelien lisäys- ja poistovalikko
              System.out.println("3) Alkuvalikkoon");
              String lisataanko = lukija.nextLine();
              if(lisataanko.equals("1"))
              {
                  LisaaPeli();                                                        //Kutsutaan pelinlisäys metodia
              }
              else if(lisataanko.equals("2"))
              {
                  //for(int j = 0; j < 4; j++)
                  //{
                   while(true) 
                   {    
                   System.out.println("Pelien poistotoiminto");
                   System.out.println("---------------------------");  
                   System.out.println("1)Listaa pelit");                            //Pelien poistovalikkko
                   System.out.println("2)Poista rivi");
                   System.out.println("3)Alkuvalikkoon");                           
                   String poistetaanko = lukija.nextLine();
                   if(poistetaanko.equals("1"))
                   {
                   TulostaTaulukko();                                               //Taulukon tulostusmetodin kutsu        
                   }
                   if(poistetaanko.equals("2"))
                   {
                      PoistaPeli();                                                 //Pelin poistometodin kutsu
                   }
                   if(poistetaanko.equals("3"))
                   {
                       break;
                      
                   }
                   }
         
              }
              else if(lisataanko.equals("3"))
              {
                  continue;
              }
           
          }
          else if(valinta.equals("3") && valinta.matches("^([1-5]{1})$"))
          {
              System.out.println("Tallennetaan tiedosto...");
              TallennaTiedosto();                                                                     //Tiedostoon tallennusmetodin kutsu
              System.out.println("Tiedosto tallennettu!");
          
          }
          else if(valinta.equals("4") && valinta.matches("^([1-5]{1})$"))
          {
              System.out.println("Avataan tiedosto...");
              AvaaTiedosto();                                                                      //Tiedoston avausmetodin kutsu
              System.out.println("Tiedosto avattu!");
              
          }  
          else if(valinta.equals("5") && valinta.matches("^([1-5]{1})$"))
          {
              System.out.println("Poistutaan ohjelmasta");
              break;
          }
      
         
      } //Pääloopin loppu
        
    }

//-----------------------------------------------------
//aliohjelmat alkaa
    
    
//tulostaa taulukon, pelien listaus, aliohjelman määritys
public static void TulostaTaulukko()
{
    try
    {
            System.out.println("Listataan pelit...");
            
          
            //aloitetaan looppi joka tulostaa taulukon 
            for (int i = 0; i < kohtarivilla + 1; i++)                                  //Mennään ensimmäiselle riville,
            {
              for (int j = 0; j < KOLUMNIT; j++)                                        //ensimmäiselle kolumnille, ja käydään ne läpi
              {
                    if(pelit[i][j] != null)                                                 //Tarkistetaan onko taulukon alkio jossa ollaan null, jos ei ole tulostetaan se
                    {
                      System.out.print(" " + pelit[i][j] + " ");                          //Tulostaa taulukon, lisäten tyhjät välit tulosteeseen
                        
                    }
                    //else if(pelit[i][j] == null)                                            //Tarkistetaan onko rivillä null, jos on ei tulosteta ja lisätään riviä yhdellä.
                   // {
                     //kohtarivilla = kohtarivilla + 1;
                    // break;
                   // }
                         
               }
            System.out.println("");
            
            }
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
        System.out.println("Listauksessa havaittiin virhe!");                           //Tätä virhettä tosin tuskin tulee, koska tulostuksen pituus ei ole riippuvainen käyttäjän syötteestä
    }
}
//Pelin lisäys taulukkoon aliohjelma
public static void LisaaPeli()
{
    try
    {
    
            System.out.println("Tämä aliohjelma lisää taulukkoon pelien tietoja");          //otsikko
            System.out.println("---------------------------");        
    
            Scanner lukija = new Scanner(System.in);
           
            //	arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
            //  Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array.
            //  Kopioi taulukon tietystä määritellystä lähdetaulukosta, alkaen annetusta kohdasta, annettuun kohtaan kohdetaulukossa. 
            System.arraycopy(otsikko[0], 0, pelit[0], 0, KOLUMNIT); 

            kohtarivilla = kohtarivilla + 1;                                               //lisätään riviä yhdellä,ettei mennä otsikoiden päälle ja että vaihdetaan riviä kun lisätään uusi peli
        
            int kohdat = 4;
            
            
            for(int i = 0; i < kohdat; i++)
            {                                                                             //Kysyy tiedon otsikkotaulukon kohdan perusteella, 1.Nimi jne.
                System.out.println("Anna " + otsikko[0][i] + ": ");
                pelit[kohtarivilla][i] = lukija.nextLine();
             
            }
     
            System.out.println("Pelin tiedot lisätty!");                            
    }
    catch (Exception e)
    {
        System.out.println("Pelin tietoja ei voitu lisätä!");
    }
    
}
//Pelin poisto taulukosta aliohjelma
public static void PoistaPeli()
{
     try
     {
        System.out.println("Monesko rivi poistetaan?");
        Scanner lukija = new Scanner(System.in);

        int poistokohtarivilla;
        poistokohtarivilla = lukija.nextInt();                                            //Lukijalta tuleva rivinumero sijoitetaan kohtarivilla muuttujaan
      
        if(poistokohtarivilla > 0)
        {
        for(int i = 0; i < KOLUMNIT; i++)
        {
                                                                                     //loopataan kolumnien lukumäärän verran, kohtarivilla määräämän rivin kohdalla, 
                    pelit[poistokohtarivilla][i] = null;                                   //ja sijoitetaan valittuun kohtaan (riviin) null.
                    
        }
        System.out.println("Peli poistettu!!");
      
        }
        else if(poistokohtarivilla == 0)
        {
            System.out.println("Ethän poista otsikkoa!");                           //Käyttäjä ei saa poistaa otsikoita
        }    
     }
     catch (ArrayIndexOutOfBoundsException e)
     {
               System.out.println("Pelin poistaminen epäonnistui!");                //Jos käyttäjä syöttää rivin joka menee yli maksimi rivien, tässä tapauksessa 150, tulee virhe

     }

}
//Taulukon tallennus tiedostoon aliohjelma
public static void TallennaTiedosto()
{
     try
     {
        //koska pelit[][] on objekti voidaan se kirjoittaa tiedostoon fileoutputstreamilla 
        FileOutputStream fos = new FileOutputStream("pelit.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(pelit);
     }
     catch (IOException e)     //otetaan kiinni IO(Input/Output) virhe, jos tallennus ei onnistunut
     {
     System.out.println("Tiedostoon kirjoitus epäonnistui");
     }
      
    
}
//Taulukon avaus tiedostosta aliohjelma
public static void AvaaTiedosto()
{
     try
     {
        FileInputStream fis = new FileInputStream("pelit.txt");                     //Toimii vain ajaessa ohjelmaa.Jos käynnistää ohjelman uudelleen ja valitsee avaus, ei toimi. ??
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        pelit = (String[][]) ois.readObject();
        
        ois.close();
     }
     catch (Exception e)
     {
     System.out.println("Tiedoston avaus epäonnistui");
     }
}

    
    
    
}
//loppu
    