import java.util.*;
import java.io.*;
import java.util.Scanner;
    
/**
 *    Klasse FunktionTest
 *
 * @version Ueb06
 * @author  JKrier, JVogt
 *
 */

 public class FunktionTest{
    private Scanner input;
    
    private static final int WERTE = 1;       
    private static final int ANZAHL = 2; 
    private static final int SORT   = 3;
    private static final int ENDE   = 0;
    
    private static final String INT_WERT = "Hier bitte eine ganze Zahl eingeben!";
    
   /**
    * Standard-Konstruktor fuer TestMyUeb6Methods
    */
   public FunktionTest(){
       input = new Scanner(System.in);
   }
      
   /**
    * run --> laesst die MyUeb6Methods-Test's ablaufen
    * 
    */
   public void run(){
         int wahl = 1;

         while (wahl != ENDE){
            try{
                 wahl = readlnInt("\n\n Auswahl: \n 1 = Artithmetisches Mittel berechnen \n 2 = Anzahl reiner Text Strings\n 3 = Inerstion Sort"
                                 +"\n 0 =  Ende\n");
                 switch (wahl){
                    case WERTE :
                         testeMittel();
                         break;
                    case ANZAHL :
                         testeAnzahl();
                         break;
                    case SORT :
                         testeSort();
                         break;
                    case ENDE :
                         System.out.println("\nDas Programm wurde beendet.\n");
                         break;
                    default :
                         System.out.println("\nTreffen Sie bitte eine gueltige Auswahl!\n");
                         break;
                   }   
            }
            catch (AssertionError ae){
                System.err.println(ae);
            }
            catch ( NumberFormatException nfe){
                System.err.println(nfe);                           
            }       
            catch (RuntimeException rex){
                System.err.println(rex);
            }
            
         } 
    
   }
    
   /**
    *  testeMittel: testet die Funktion berechneMittel der Klasse Funktion
    *
    */
    private void testeMittel(){
      int arrayAnzahl = 3;

      double testArray[][] = { { -10.0, 20.0, -0.4, 15.35, 23.23, 98.45, 10.11, -123.0, 12.4, 20.0,},
                               { 8.0, 2.0, -15.0, 14.0, -12.0, 1.0, 77.7, -34.5, 0.1, -0.15, -12.3 },
                               { 1.1, -2.2, 3.3, -4.4, 5.5, -6.6, 7.7, -8.8, 9.9, -10.10, 0.0 }};
      
      for (int i = 0; i < arrayAnzahl; i++ ){
           System.out.println( "Testarray " + (i+1)+ ": " + java.util.Arrays.toString(testArray[i]) +
                               "\nDie Ergebnisse sind: "+ java.util.Arrays.toString(Funktion.berechneWerte(testArray[i])));
      }
   }
  
   /**
    *  testeAnzahl: testet die Funktion berechneAnzahl der Klasse Funktion
    *
    */
    private void testeAnzahl(){
        int arrayAnzahl = 4;
        
        String[][] testArray = {{"Test", "AbCde", "Polizei", "NIX", "ProgI"},
                              {"Test", "ABcdE", "12Polizei", "!?\\", "Prog1"},
                              {"Test", "ab cd e", "1Polizei2", "N!x", "Pr0gI"},
                              {"tesT", "a b c", " Pol ", "1234", "text12!"}};
                              
       for ( int i = 0; i < arrayAnzahl; i++ ){
          System.out.println("Testarray " + (i+1)+ ": " + java.util.Arrays.toString(testArray[i]) +
                             "\nAnzahl reiner Buchstaben-Strings: " + Funktion.berechneAnzahl(testArray[i]));
      }
   }
    
   /**
    *  testeSort: testet die Funktion insertionSort der Klasse Funktion
    *
    */
    private void testeSort(){
        int [] test1 = {10,30,50,80,90,50,10,70,60,0};
        int [] test2 = {55, 77, 99, 11, 44, 33, 22, 66, 88, 111};
        int [] test3 = {73,43,53,23,3,83,63,13,93,33};
     
         System.out.println("Testarray 1: \t" + java.util.Arrays.toString(test1));
         Funktion.insertionSort(test1);
         System.out.println("\nSortiert: \t" + java.util.Arrays.toString(test1));
    
         System.out.println("\nTestarray 2: \t" + java.util.Arrays.toString(test2));
         Funktion.insertionSort(test2);
         System.out.println("\nSortiert: \t" + java.util.Arrays.toString(test2));
   
         System.out.println("\nTestarray 3: \t" + java.util.Arrays.toString(test3));
         Funktion.insertionSort(test3);
         System.out.println("\nSortiert: \t" + java.util.Arrays.toString(test3));
     
   }
   
   /**
     * Einlesen einzugebener Integer Werte.
     *  
     *  @param  Eingabeaufforderung Der Eingabe-Aufforderungs-Text
     *  @return die Eingabe-Zahl
     */
    private int readlnInt(String eingabe){
        int wert = 1;
        try{
            System.out.print(eingabe);
            wert= input.nextInt();
            input.nextLine();
        }
        catch (InputMismatchException e){
            System.err.println(e+ INT_WERT);
        } 
        return wert;
   }
    
   /**
     *  main Methode Ausfuehren des interaktiven Tests.
     *  @param args Kommandozeilenparameter
     */  
    public static void main(String[] args){
        FunktionTest test = new FunktionTest();
        test.run();
   }
}
