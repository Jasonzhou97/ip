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
        while(true){
            input = sc.nextLine().trim();
            if(input.equalsIgnoreCase("bye")){
                break;
            }
            else{
                processCommand(input,tasks);
            }

        }
        System.out.println("Bye. Hope to see you again soon!");


    }

    private static void processCommand(String input,TaskList tasks){
        String[] parts = input.split(" ",2);
        String command = parts[0].toLowerCase();

        switch(command){
            case "list":
                tasks.list();
                break;
            case "todo":
                tasks.addTask(new ToDo(parts[1]));
                break;

            case "deadline":
                String[] dlParts = parts[1].split("/by",2);
                tasks.addTask(new Deadline(dlParts[0],dlParts[1]));
                break;

            case "event":
                String[] evParts = parts[1].split(" /from ", 2);
                String[] timeParts = evParts[1].split(" /to ", 2);
                tasks.addTask(new Event(evParts[0], timeParts[0], timeParts[1]));
                break;

            case "mark":
                int index = Integer.parseInt(parts[1])-1;
                Task curTask = tasks.array()[index];
                curTask.markDone();
                break;

            case "unmark":
                int unmarkIndex = Integer.parseInt(parts[1])-1;
                Task curTaskUnmark = tasks.array()[unmarkIndex];
                curTaskUnmark.unmark();
                break;


        }
    }
}
