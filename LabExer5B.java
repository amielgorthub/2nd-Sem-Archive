import java.util.*;

class InvalidLetterException extends Exception {
    InvalidLetterException(){
        super("Quiz only accepts letters a, b, c.");
    }
}
class BlankException extends Exception {
    BlankException(){
        super("Quiz does not accept blank answers.");
    }
}

public class Main {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        String question[] = new String[10];
        question[0] = "What is the third planet from the sun?";
        question[1] = "What is the largest planet in our solar system?";
        question[2] = "Which planet is the gas giant?";
        question[3] = "What is the fourth planet from the sun?";
        question[4] = "Which planet is the last planet in our solar system?";
        question[5] = "Which bike did Honda make?";
        question[6] = "Which driver have won an F1 championship?";
        question[7] = "Which vehicle did Porsche make?";
        question[8] = "Which vehicle did Mercedes-Benz make?";
        question[9] = "Which bike did Suzuki make?";

        int points = 0;
        int number = 0;

        String choicesA[] = {"Jupiter", "Jupiter", "Mercury", "Sun", "Uranus",
                "Rebel 500", "Sergio Perez", "Murcielago", "CLK GTR", "GSX R150"};
        String choicesB[] = {"Earth", "Mars", "Neptune", "Jupiter" , "Sun",
                "Multistrada", "Lewis Hamilton", "Stradale", "Gallardo", "CBR150R"};
        String choicesC[] = {"Mars", "Saturn", "Pluto", "Mars", "Pluto",
                "Scrambler", "Nico Hulkenberg", "Panamera S", "Roma", "Desert Sled" };
        String correctAnswers[] = {"B", "A", "B", "C", "C", "A", "B", "C", "A", "A" };

        do {
            try{
                System.out.println("Question " + (number + 1));
                System.out.println("-----------------------");
                System.out.println(question[number] + "\n");
                System.out.println("A. " + choicesA[number]);
                System.out.println("B. " + choicesB[number]);
                System.out.println("C. " + choicesC[number] + "\n");
                System.out.print("==Input Answer: ");
                String answer = scan.nextLine();


                if (answer.equalsIgnoreCase("A")
                        || answer.equalsIgnoreCase("B") || answer.equalsIgnoreCase("C")){
                if(answer.equalsIgnoreCase(correctAnswers[number])){
                    points++;

                }
                } else if (answer.equals("")) {
                    throw new BlankException();
                } else {
                    throw new InvalidLetterException();
                }

                number++;
            } catch (BlankException be){
                System.out.println(be.getMessage());

            } catch (InputMismatchException ime){
                System.out.println("Quiz does not accept non-letter answers.");
            } catch (InvalidLetterException ile){
                System.out.println(ile.getMessage());
            }

        } while (number < 10);
        System.out.println("===END of QUIZ===");
        System.out.println("You got: " + points + " out of 10!");



    }
}