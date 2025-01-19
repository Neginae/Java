import java.util.Arrays;
import java.util.Scanner;

public class HangmanFinal {

    static Scanner scan = new Scanner(System.in);

    public static String[] countries = { 
        "Argentina", "Australia", "Austria", "Bangladesh", "Belgium", "Brazil", "Canada", 
        "Chile", "China", "Colombia", "Cuba", "Denmark", "Egypt", "Finland", "France", 
        "Germany", "Greece", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", 
        "Italy", "Japan", "Kenya", "Malaysia", "Mexico", "Nepal", "Netherlands", 
        "New Zealand", "Nigeria", "Norway", "Pakistan", "Peru", "Philippines", "Poland", 
        "Portugal", "Russia", "Saudi Arabia", "Singapore", "South Africa", "South Korea", 
        "Spain", "Sweden", "Switzerland", "Thailand", "Turkey", "Ukraine", 
        "United Kingdom", "United States", "Vietnam", "Afghanistan", "Algeria", 
        "Angola", "Bolivia", "Ethiopia", "Morocco", "Paraguay", "Venezuela", "Zimbabwe", 
        "Hungary", "Czech Republic"
    };

    public static String[] gallows = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + 
                                  
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {

        System.out.println("\n\nWelcome to my Hangman Game!");
        System.out.println("\nHangman is a word-guessing game. It keeps asking you to guess characters for a 'country' until:");
        System.out.println("\t1. You guess every character correctly." + "\n\t2. You miss 6 guesses.\n\n");

        int missNumber = 0;
        
        String word = (randomWord(countries));
        char[] charArray = word.toCharArray();

        char[] placeholders = printPlaceholders(charArray);

        char[] missedGuesses = new char[6];

        while (missNumber < 6) {
            System.out.println(showGallows(missNumber, gallows));

            System.out.print("\nWord:   ");
            System.out.println(placeholders);

            System.out.print("\nMisses:   ");
            printMissedGuesses(missedGuesses);

            System.out.print("\n\nGuess:   ");
            char guess = scan.next().charAt(0);
            guess = Character.toLowerCase(guess);

            if (checkGuess(charArray, guess)) {
                updatePlaceholders(charArray, guess, placeholders);
            } else {    
                missedGuesses[missNumber] = guess;
                missNumber++;
            }

            if (Arrays.equals(placeholders, charArray)) {
                System.out.println(showGallows(missNumber, gallows));

                System.out.print("\nWord:   ");
                System.out.println(placeholders);

                System.out.println("\nYAY!");                
                break;
            }
        }

            if (missNumber == 6) {
                System.out.print(gallows[6]);
                System.out.println("\nOOPS!");
                System.out.println("\nThe word was: '" + word + "'");
            }

        scan.close();
    }

    

    public static String randomWord(String[] word) {
        int indexOfWord = (int) (Math.random() * word.length);
        String theWord = "";
        for (int i = 0; i < word.length; i++) {
            if (i == indexOfWord) {
                theWord = word[i];
            }
        }
        return theWord;
    }

    public static char[] printPlaceholders(char[] array) {
        char[] holders = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            holders[i] = '_';
        }
        return holders;
    }

    
    public static String showGallows(int miss, String[] gallow) {
        switch (miss) {
            case 0:
                return gallow[0];
            case 1:
                return gallow[1];
            case 2:
                return gallow[2];
            case 3:
                return gallow[3];
            case 4:
                return gallow[4];
            case 5:
                return gallow[5];
            case 6:
                return gallow[6];

            default:
                return "DEAD CODE";
        }
    }

    public static boolean checkGuess(char[] word, char guess) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guess) {
                return true;
            }
        }
        return false;
    }

    public static void printMissedGuesses(char[] misses) {
        for (int i = 0; i < misses.length; i++) {
            System.out.print(misses[i]);
        }
    }

    public static void updatePlaceholders (char[] word, char guess, char[] placeholders) {
        for (int j = 0; j < word.length; j++) {
            if (word[j] == guess) {
                placeholders[j] = guess;
            }
        }
    }
}

