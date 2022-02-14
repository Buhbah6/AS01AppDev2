package Q1;

// --------------------------------------------------------------------
// Assignment 1
// Written by: Anthony Nadeau - 2058983
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class Driver {
    
    /**
     * Main method -> tests the PasswordGen class
     * @param args 
     */
    public static void main(String[] args) {
        PasswordGen pg = new PasswordGen();
        while (!pg.flag && pg.generated < 10000) {
            pg.pipeline(pg.generateString());
        }
        System.out.println("\nTotal password generated: " + pg.generated);
        System.out.println("\nThanks for using the password generator game. Good bye.");
    }
}
