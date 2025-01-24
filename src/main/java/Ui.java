import java.util.Scanner;
public class Ui {
    private Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String readCommand(){
        return sc.nextLine().trim();
    }
    public void showWelcomeMessage(){
        System.out.println("Hello! I'm Lebum");
        System.out.println("What can I do for you?");
    }

    public void showByeMessage(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showErrorMessage(Exception e){
        System.out.println("OOPS!!! Something went wrong "+e.getMessage());
    }
    public void showErrorMessage(){
        System.out.println("OOPS!!! Something went wrong!");
    }

}
