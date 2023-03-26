import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class ExceededLimitException extends Exception{
    public ExceededLimitException(){
        super("Number is out of range.");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input, attempt = 0, min, max;
        min = 1;
        max = 50;
        int rng = ThreadLocalRandom.current().nextInt(min, max + 1);

        do{
            try {
                System.out.println("Guess a number from 1 to 50!");
                input = scan.nextInt();
                if (input > rng && input < 50) {
                    System.out.println("Too high, try again.");
                    attempt++;
                    System.out.println("Correct Answer: (" + rng + ")");
                    System.out.println("Attempt(s): " + attempt);
                } else if (input < rng) {
                    System.out.println("Too low, try again.");
                    attempt++;
                    System.out.println("Correct Answer: (" + rng + ")");
                    System.out.println("Attempt(s): " + attempt);

                } else if (input > 50) {
                    throw new ExceededLimitException();

                } else if (input == rng) {
                    attempt++;
                    System.out.println("You got it in " + attempt + " attempt(s)!");
                    break;
                }
            } catch (ExceededLimitException ele) {
                System.out.println(ele.getMessage());
                System.out.println("Correct Answer: (" + rng + ")");
                System.out.println("Attempt(s): " + attempt);
                continue;
            } catch (InputMismatchException ime){
                System.out.println("Invalid Input.");
                System.out.println("Correct Answer: (" + rng + ")");
                System.out.println("Attempt(s): " + attempt);
                scan.next();
                continue;
            }
        } while(true);
    }
}