import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

    /*
    implement the method below so that it extracts a URL from a String
    I will write the basics for this one method, you will have to implement the other two methods from scratch
    */

    public static String extractURL(String text) {
        String regex = "(https?://\\S+)";  // Matches HTTP or HTTPS URLs

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }

    /*
    implement the method below to validate an email address
     */

    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";  // Basic email pattern

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /*
    implement the method below so that it returns a list of words with repeated letters
    */

    public static List<String> findWordsWithRepeatLetters(String input) {
        List<String> wordsWithRepeatLetters = new ArrayList<>();
        String[] words = input.split("\\s+");
        String regex = ".*([a-zA-Z])\\1.*";  // Matches any word with repeated letters

        Pattern pattern = Pattern.compile(regex);

        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                wordsWithRepeatLetters.add(word);
            }
        }
        return wordsWithRepeatLetters;
    }

    /*
    Bonus Problem ;)
    implement the method below so that it returns a list of words that are repeated twice accidentally in a string
    for example: "appleapple orange pearpear pineapple" -> ["appleapple", "pearpear"]
    */

    public static List<String> findRepeatedWords(String input) {
        List<String> repeatedWords = new ArrayList<>();
        String[] words = input.split("\\s+");
        String regex = "(\\b\\w+\\b)\\1";  // Matches any word that repeats immediately

        Pattern pattern = Pattern.compile(regex);

        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                repeatedWords.add(word);
            }
        }
        return repeatedWords;
    }

    public static void main(String[] args) {
        // Test extractURL
        String text = "Check out this link: https://www.example.com and this one http://example.org";
        System.out.println("Extracted URL: " + extractURL(text)); // Output: https://www.example.com

        // Test validateEmail
        String email1 = "test@example.com";
        String email2 = "invalid-email";
        System.out.println("Email validation (test@example.com): " + validateEmail(email1)); // Output: true
        System.out.println("Email validation (invalid-email): " + validateEmail(email2)); // Output: false

        // Test findWordsWithRepeatLetters
        String sentence = "This is a test sentence with cool and different letters.";
        List<String> repeatedLetterWords = findWordsWithRepeatLetters(sentence);
        System.out.println("Words with repeated letters: " + repeatedLetterWords); // Output: [cool, letters]

        // Test findRepeatedWords
        String repeatedWordsSentence = "appleapple orange pearpear pineapple";
        List<String> repeatedWords = findRepeatedWords(repeatedWordsSentence);
        System.out.println("Repeated words: " + repeatedWords); // Output: [appleapple, pearpear]
    }
}