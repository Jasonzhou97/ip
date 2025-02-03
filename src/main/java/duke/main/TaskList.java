package duke.main;
import duke.task.Task;
import java.util.ArrayList;
import duke.exception.DukeException;

/**
 * A class to represent the list of tasks
 */

public class TaskList {
    /**
     * an arraylist to store all tasks
     */
    private ArrayList<Task> tasks;

    private int num_of_tasks;
    public TaskList(){
        this.tasks = new ArrayList<Task>();
        this.num_of_tasks = 0;
    }

    /**
     *
     * @param task to add task to arraylist
     */
    public String addTask(Task task) {
        tasks.add(task);
        num_of_tasks += 1;
        System.out.println("Got it! I've added this task\n" + task.print());
        System.out.println("Now you have " + num_of_tasks + " tasks in the list.");
        String msg = task.print();
        int num = num_of_tasks;
        return "Got it! I've added this task\n" + msg + "\n" + "Now you have " + num + " tasks in the list.";
    }

    /**
     * Load tasks from storage.
     * @param task parsed from loading from script, add tasks without printing output
     */
    public void addInitialTask(Task task) {
        tasks.add(task);
        num_of_tasks += 1;
    }
    public int getNum_of_tasks() {
        return num_of_tasks;
    }
    /**
     * to print all tasks in list with its index
     */
    public void list() {
        for (int i = 0; i < num_of_tasks; i++) {
            Task t = tasks.get(i);
            int index = i + 1;
            System.out.println(index + ". " + t.print());
        }
    }

    /**
     *
     * @return the arraylist of tasks
     */
    public ArrayList<Task> array(){
        return this.tasks;
    }

    /**
     *
     * @param index the index of the task to delete
     * @throws DukeException if index out of bounds
     */
    public String delete(int index) throws DukeException {
        if (index > num_of_tasks || index < 0){
            throw new DukeException("Oops you entered an invalid index!");
        }
        Task task = this.tasks.get(index);
        System.out.println("Noted. I've removed this task: \n" + task.print());

        this.tasks.remove(index);
        num_of_tasks--;
        System.out.println("Now you have " + num_of_tasks + " tasks in the list.");
        return "Noted. I've removed this task: \n" + task.print();
    }

}
