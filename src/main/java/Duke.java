import java.lang.constant.DynamicCallSiteDesc;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        System.out.println("Hello! I'm Lebum");
        System.out.println("What can I do for you?");
        Scanner sc = new Scanner(System.in);
        String input;
        TaskList tasks = new TaskList();

        while(true){
            try {
                input = sc.nextLine().trim();
                if (input.equalsIgnoreCase("bye")) {
                    break;
                }
                processCommand(input, tasks);
            }
            catch (DukeException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println("OOPS!!! Something went wrong "+e.getMessage());
            }

        }
        System.out.println("Bye. Hope to see you again soon!");

    }

    /**
     *
     * @param input the input that user keys in
     * @param tasks the arraylist that will store the tasks
     * @throws DukeException when exceptions are specific to Duke
     */

    private static void processCommand(String input,TaskList tasks) throws DukeException {
        String[] parts = input.split(" ",2);
        String command = parts[0].toLowerCase();

        /**
         * handles different commands and exceptions handling
         */
        switch(command){
            case "list":
                tasks.list();
                break;

            case "delete":
                try{
                    if(parts.length < 2){
                        throw new DukeException("OOPS!!! You did not specify an index to delete, please specify an index!");
                    }
                    int index = Integer.parseInt(parts[1]);
                    tasks.delete(index-1);

                }
                catch (ArrayIndexOutOfBoundsException e){
                    throw new DukeException("OOPS!!! You did not specify an index to delete, please specify an index!");
                }
                break;
            case "todo":
                try {
                    if (parts.length < 2) {
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty, please fill in the description!");
                    }
                    tasks.addTask(new ToDo(parts[1]));
                }

                catch(ArrayIndexOutOfBoundsException e){
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty, please fill in the description!");
                    }

                break;

            case "deadline":
                try {
                    if (parts.length < 2) {
                        throw new DukeException("OOPS!!! The description of a deadline cannot be empty, please fill in the description!");
                    }
                    String[] dlParts = parts[1].split("/by", 2);
                    if (dlParts.length<2){
                        throw new DukeException("OOPS!!! Please provide a deadline using /by.");
                    }
                    tasks.addTask(new Deadline(dlParts[0], dlParts[1]));
                }
                catch(ArrayIndexOutOfBoundsException e){
                    throw new DukeException("OOPS!!! Invalid deadline format. Use: deadline <description> /by <time>");
                }
                break;

            case "event":
                try {
                    if (parts.length<2){
                        throw new DukeException("OOPS!!! The description of an event cannot be empty, please fill in the description!");
                    }
                    String[] evParts = parts[1].split(" /from ", 2);
                    if (evParts.length < 2) {
                        throw new DukeException("OOPS!!! Please provide event time using /from and /to.");
                    }
                    String[] timeParts = evParts[1].split(" /to ", 2);
                    if (timeParts.length < 2) {
                        throw new DukeException("OOPS!!! Please provide event end time using /to.");
                    }
                    tasks.addTask(new Event(evParts[0], timeParts[0], timeParts[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DukeException("OOPS!!! Invalid event format. Use: event <description> /from <start-time> /to <end-time>");
                }
                break;

            case "mark":
                try {
                    if (parts.length < 2) {
                        throw new DukeException("OOPS!!! Please provide a task number to mark.");
                    }
                    int index = Integer.parseInt(parts[1]) - 1;
                    Task curTask = tasks.array().get(index);
                    curTask.markDone();
                }
                catch(NumberFormatException e){
                    throw new DukeException("OOPS!!! The task number must be a number.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DukeException("OOPS!!! Please provide a task number to mark.");
                } catch (IndexOutOfBoundsException e) {
                    throw new DukeException("OOPS!!! The task number is invalid.");
                }
                break;

            case "unmark":
                try {
                    if (parts.length < 2) {
                        throw new DukeException("OOPS!!! Please provide a task number to unmark.");
                    }
                    int unmarkIndex = Integer.parseInt(parts[1]) - 1;
                    Task curTaskUnmark = tasks.array().get(unmarkIndex);
                    curTaskUnmark.unmark();
                }
                catch (NumberFormatException e) {
                    throw new DukeException("OOPS!!! The task number must be a number.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DukeException("OOPS!!! Please provide a task number to unmark.");
                } catch (IndexOutOfBoundsException e) {
                    throw new DukeException("OOPS!!! The task number is invalid.");
                }

                break;
            default:
                System.out.println("OOPS I have no idea what that means :(");


        }
    }
}
