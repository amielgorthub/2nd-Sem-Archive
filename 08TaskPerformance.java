import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word1, word2, sub;

        System.out.println("Enter the first word: ");
        word1 = scan.next();
        System.out.println("Enter the second word: ");
        word2 = scan.next();

        sub = word1.substring(word1.length()-2);

        Pattern patt = Pattern.compile("^\\D{1,2}" + sub);

        Matcher match = patt.matcher(word2);
        if(match.matches()){
            System.out.println(word1 + " rhymes with " + word2 + ".");

        }
        else{
            System.out.println("I'm not sure! Sorry!");
        }
    }
}