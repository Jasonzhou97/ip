import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Lebum");
        System.out.println("What can I do for you?");
        Scanner sc = new Scanner(System.in);
        String input;
        TaskList tasks = new TaskList();
        while(!(input=sc.nextLine()).equalsIgnoreCase("bye")){
            String task = input;
            if(task.equals("list")){
                tasks.list();
            }
            else if(task.equals("bye")){
                break;
            }
            else{
                tasks.addTask(task);
            }
        }
        System.out.println("Bye. Hope to see you again soon!");


    }
}
