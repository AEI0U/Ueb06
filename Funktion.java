import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *  
 *  Klasse Funktion (Arithmetisches Mittel, Anzahl reiner Textstrings, Array sortieren)
 * @author JKrier, JVogt
 * @version Ueb06
 */

public class Funktion{
  /**
   * Konstruktor der Klasse Funktion
   */
    private Funktion(){
  }
 
  /**
   *  berechneWerte berechnet das Arithmetische Mittel eines Arrays sowie den Messwert, der am nächsten daran liegt und den der am weitesten davon entfernt ist. 
   * 
   * @param double Array, fuer das die Werte berechnet werden
   * @return  MinWert, MittelWert, MaxWert
   */
   public static double[] berechneWerte(double array[] ){
       
        double min = array[0];
        double mittel = 0.0;
        double max = array[0];
        
        for (int i = 1; i < array.length; i++){
            if (Math.abs(mittel - array[i]) < Math.abs(mittel - min)){
                 min = array[i];
            }

            if ( Math.abs(mittel - array[i]) > (Math.abs(mittel - max))){
                max = array[i];
            }
        }
           
        for (int i = 0; i < array.length; i++){
           mittel += array[i];
        }
        mittel /= array.length;
       
        return new double[] { min, mittel, max };
    }
    
  /**
   *  berechneAnzahl - gibt die Anzahl reiner Textstrings eines Arrays an
   *  
   * @param  eingabeString   der zu untersuchende String
   * @return        true ==  enthaelt nur Buchstaben, false == enthaelt NICHT nur Buchstaben
   */
   public static int berechneAnzahl(String[] array){
       int anzahl = array.length;
       //Pattern mit den erlaubten Zeichen
       for (int i = 0; i<array.length;i++){
           String pattern =  "[a-z,A-Z,ä-ü,Ä-Ü,ß]*";
           Pattern p = Pattern.compile(pattern);
           Matcher m = p.matcher(array[i]);
           boolean b = m.matches();
           if( b == false){
               anzahl--;
            }
        }   
       return anzahl;
       
    }


    
   
  /**
   *  insertionSort - Sortiert das uebergebene int-Array
   *
   * @param  das Array, das sortiert werden soll
   */
   public static void insertionSort(int[] array){
     int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }
    
} 
