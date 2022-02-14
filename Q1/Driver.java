package Q1;

/**
 * @author Anthony Nadeau
 */
public class Driver {
    
    public static void main(String[] args) {
        PasswordGen pg = new PasswordGen();
        while (!pg.flag && pg.generated <= 10000) {
            pg.pipeline(pg.generateString());
        }
        System.out.println("Total password generated: " + pg.generated);
        System.out.println("Thanks for using the password generator game. Good bye.");
    }
}
