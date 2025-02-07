package duke.main;
import java.util.Scanner;

/**
 * A User interface class to interact with users and read their commands
 */
public class Ui {
    private Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine().trim();
    }
    public void showWelcomeMessage() {
        System.out.println("Wassup! I'm Lebum");
        System.out.println("What can I do for you?");
    }

    public void showByeMessage() {
        System.out.println("Bye. Hope I never see you again!");
    }

    public void showErrorMessage(Exception e) {
        System.out.println("OOPS!!! Something went wrong "+e.getMessage());
    }
    public void showErrorMessage() {
        System.out.println("OOPS!!! Something went wrong!");
    }

    public void showErrorMessage(String solution) {
        System.out.println("OOPS!!! Something went wrong! " + solution);
    }

    public String welcome() {
        return "Hello! I'm Lebum\nWhat can I do for you?";
    }
}
