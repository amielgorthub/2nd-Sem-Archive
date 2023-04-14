import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName, passWord;

        String fileName = "C:\\Users\\C2-17\\OneDrive - STI Education Services Group, Inc\\Desktop\\records.txt";
        try{
            Path filePath = Paths.get(fileName.toString());

            System.out.println("Do you want to Login or Register? (Input 'L' for Login and 'R' for Register.");
            char choice = scan.next().charAt(0);

            if(choice == 'L' || choice == 'l'){
                System.out.println("--Login--");
                System.out.println("Enter Username: ");
                userName = scan.next();
                System.out.println("Enter Password: ");
                passWord = scan.next();

                InputStream input = new BufferedInputStream(Files.newInputStream(filePath));
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String checkUserName = reader.readLine();
                String checkPassWord = reader.readLine();

                if (checkUserName.equals(userName) && checkPassWord.equals(passWord)){
                    System.out.println("You Got In!");
                }
                else {
                    System.out.println("Incorrect Information!");
                }
            } else if (choice == 'R' || choice == 'r') {
                System.out.println("--Register--");
                System.out.println("Enter Username:");
                userName = scan.next();
                System.out.println("Enter Password: ");
                passWord = scan.next();

                OutputStream output = new BufferedOutputStream(Files.newOutputStream(filePath));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                writer.write(userName + "\n");
                writer.write(passWord);
                writer.flush();
                writer.close();
                output.close();
            }
        } catch (InputMismatchException e){
            System.out.println("Invalid Input");
        } catch (Exception e){
            System.out.println("Invalid Path");
        }
    }
}