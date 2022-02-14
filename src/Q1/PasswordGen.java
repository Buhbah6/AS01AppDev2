package Q1;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// --------------------------------------------------------------------
// Assignment 1
// Written by: Anthony Nadeau - 2058983
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class PasswordGen {
    protected int[] fails = new int[7]; // Array that tracks each kind of password generation failure
    protected int generated = 0; // amount of valid passwords generated
    protected boolean flag = false; // flag used to identify when a password is generated that is only uppercase
    protected Random rand = new Random(); // Random object used for Random.nextInt()
    final String[][][] book = { // copy-paste 3D array
		{
			{"ALICE was beginning to get very tired of sitting by her sister on the\n",
				"bank, and of having nothing to do. Once or twice she had peeped into the\n",
				"book her sister was reading, but it had no pictures or conversations in\n",
				"it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n",
			"conversations?\"\n"},
			{"So she was considering in her OWN mind (as well as she could, for the\n",
				"day made her feel very sleepy and stupid), whether the pleasure of\n",
				"making a daisy-chain would be worth the trouble of getting up and\n",
				"picking the daisies, when suddenly a White Rabbit with pink eyes ran\n",
			"close by her.\n"},
			{"There was nothing so very remarkable in that, nor did Alice think it so\n",
				"very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
				"dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
				"out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
				"started to her feet, for it flashed across her mind that she had never\n",
				"before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
				"out of it, and, burning with curiosity, she ran across the field after\n",
				"it and was just in time to see it pop down a large rabbit-hole, under\n",
			"the hedge. In another moment, down went Alice after it!"}
		},
		{
			{"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n",
			"telescope!\"\n"},
			{"And so it was indeed! She was now only ten inches high, and her face\n",
				"brightened up at the thought that she was now the right size for going\n",
			"through the little door into that lovely garden.\n"},
			{"After awhile, finding that nothing more happened, she decided on going\n",
				"into the garden at once; but, alas for poor Alice! When she got to the\n",
				"door, she found she had forgotten the little golden key, and when she\n",
				"went back to the table for it, she found she could not possibly reach\n",
				"it: she could see it quite plainly through the glass and she tried her\n",
				"best to climb up one of the legs of the table, but it was too slippery,\n",
				"and when she had tired herself out with trying, the poor little thing\n",
			"sat down and cried.\n"},
			{"\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
				"sharply. \"I advise you to leave off this minute!\" She generally gave\n",
				"herself very good advice (though she very seldom followed it), and\n",
				"sometimes she scolded herself so severely as to bring tears into her\n",
			"eyes.\n"},
			{"Soon her eye fell on a little glass box that was lying under the table:\n",
				"she opened it and found in it a very small cake, on which the words \"EAT\n",
				"ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
				"Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
				"makes me grow smaller, I can creep under the door: so either way I'll\n",
			"get into the garden, and I don't care which happens!\"\n"},
			{"She ate a little bit and said anxiously to herself, \"Which way? Which\n",
				"way?\" holding her hand on the top of her head to feel which way she was\n",
				"growing; and she was quite surprised to find that she remained the same\n",
			"size. So she set to work and very soon finished off the cake."}
		},
		{
			{"The King and Queen of Hearts were seated on their throne when they\n",
				"arrived, with a great crowd assembled about them--all sorts of little\n",
				"birds and beasts, as well as the whole pack of cards: the Knave was\n",
				"standing before them, in chains, with a soldier on each side to guard\n",
				"him; and near the King was the White Rabbit, with a trumpet in one hand\n",
				"and a scroll of parchment in the other. In the very middle of the court\n",
				"was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
			"trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n"},
			{"The judge, by the way, was the King and he wore his crown over his great\n",
				"wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
			"(some were animals and some were birds) I suppose they are the jurors.\"\n"},
			{"Just then the White Rabbit cried out \"Silence in the court!\"\n"},
			{"\"HERALD! read the accusation!\" said the King."}
		}
};

    /**
     * Default Constructor
     */
    public PasswordGen() {
    }
    
    /**
     * Clears the fails array (used after every successful password generation)
     */
    public void clear() {
        fails = new int[7];
    }
    
    /**
     * Method to generate the base password String consisting of 3 words
     * @return a password to be tested by the other methods
     */
    public String generateString() {
        int validWords = 0; // counts the valid words to ensure 3 valid words are chosen
        String password = ""; 
        int section; // represents the length of the array of 2D arrays
        int paragraph; // represents the length of the array of 1D arrays
        int line; // represents the length of a 1D array
        String[] words;
        while (validWords < 3) {
            section = rand.nextInt(book.length);
            paragraph = rand.nextInt(book[section].length);
            line = rand.nextInt(book[section][paragraph].length);
            words = book[section][paragraph][line].split(" ");
            String word = words[rand.nextInt(words.length)];
            if (hasNewLine(word) || isSingleCharacter(word) || isEqual(password, word))
                continue;
            else {
                password += word;
                validWords++;
            }
        }
        return password;
    }
    
    /**
     * Verifies if the passed string contains the "\n" character
     * @param word word to be checked
     * @return true or false, if the newLine character is in the string.
     */
    public boolean hasNewLine(String word) {
        if (word.contains("\n")) {
            fails[0]++;
            return true;
        }
        return false;
    }
    
    /**
     * Verifies if the passed string is a single character
     * @param word word to be checked
     * @return true or false, if the string is a single character.
     */
    public boolean isSingleCharacter(String word) {
        if (word.length() == 1) {
            fails[1]++;
            return true;
        }
        return false;
    }
    
    /**
     * Verifies if a word is already in the already generated password
     * @param password password to see if the word is contained in
     * @param word word to be checked
     * @return true or false, if the word is found within the password.
     */
    public boolean isEqual(String password, String word) {
        if (password.contains(word)) {
            fails[2]++;
            return true;
        }
        return false;
    }
    
    /**
     * Verifies that the password is of the correct length
     * @param tempPass password being verified
     * @return true or false, if the password is >= 8 char and < 16 char
     */
    public boolean isCorrectLength(String tempPass) {
        if (tempPass.length() < 8 || tempPass.length() >= 16) {
            fails[3]++;
            return false;
        }
        return true;
    }
    
    /**
     * Verifies that the password contains at least 1 Uppercase character
     * @param tempPass password being verified
     * @return true or false, if the password contains >= 1 uppercase character
     */
    public boolean hasUpperCase(String tempPass) {
        Pattern pat = Pattern.compile("[A-Z]");
        Matcher mat = pat.matcher(tempPass);
        if (!mat.find()) {
            fails[4]++;
            return false;
        }
        return true;
    }
    
    /**
     * Verifies that the password contains at least 1 lowercase character
     * @param tempPass password being verified
     * @return true or false, if the password contains >= 1 lowercase character
     */
    public boolean hasLowerCase(String tempPass) {
        Pattern pat = Pattern.compile("[a-z]");
        Matcher mat = pat.matcher(tempPass);
        if (!mat.find()) {
            fails[5]++;
            flag = true; // enables the flag to end the code at the generation of an all CAPS password
            return false;
        }
        return true;
    }

    /**
     * Verifies that the password contains only 1 special character
     * @param tempPass password being verified
     * @return true or false, if the password contains exactly 1 special character
     */
    public boolean hasSingleSpecialCase(String tempPass) {
        Pattern pat = Pattern.compile("[!@#$%^&*-=_+\\|;':\",./?`~]");
        Matcher mat;
        int count = 0;
        for(int i = 0; i < tempPass.length(); i++) {
            mat = pat.matcher(tempPass.charAt(i) + "");
            if (mat.find()) {
                count++;
            }
        }
        if (count < 1 || count > 1) {
            fails[6]++;
            return false;
        }
        return true;
    }
    
    /**
     * Carries the password through the verification methods, and prints the
     * result upon successful completion of all of them.
     * @param password password being carried, and potentially printed.
     */
    public void pipeline(String password) {
        if (isCorrectLength(password) && hasUpperCase(password) &&
                hasLowerCase(password) && hasSingleSpecialCase(password)) {
            generated++;
            String result = String.format("Password = %-15s Newline = %-5d Single = "
                    + "%-5d Equal = %-5d Length = %-5d Upper = %-5d Lower = %-5d Special = %-5d", 
                    password, fails[0], fails[1], fails[2], fails[3], fails[4], fails[5],
                    fails[6]);
            System.out.println(result);
            clear();
        }
    }
   
}
