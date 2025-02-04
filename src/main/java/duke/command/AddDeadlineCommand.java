package duke.command;
import duke.exception.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Deadline;



/**
 * Class that handles adding deadlines.
 */
public class AddDeadlineCommand extends Command {
    private String title;
    private String[] parts;

    private String response = "";

    /**
     * Command to add deadline.
     * @param title The name of the instruction
     */
    public AddDeadlineCommand(String title) {
        this.title = title;
        parts = title.split(" ", 2);
    }

    @Override
    public String getResponse() {
        return this.response;
    }


    /**
     * Executes the add command.
     * @param tasks The list of tasks to add to
     * @param storage The storage to save to
     * @param Ui The Ui user interacts with
     * @throws DukeException Thrown when dates are invalid
     * @throws ArrayIndexOutOfBoundsException Thrown when array length is not as expected
     */
    public void execute(TaskList tasks, Storage storage, Ui Ui) throws DukeException, ArrayIndexOutOfBoundsException {
        try {
            if (parts.length < 2) {
                throw new DukeException("OOPS!!! The description of a deadline cannot be empty, "
                        + "please fill in the description!");
            }
            String[] dlParts = parts[1].split("/by", 2);
            if (dlParts.length < 2) {
                throw new DukeException("OOPS!!! Please provide a deadline using /by.");
            }
            this.response = tasks.addTask(new Deadline(dlParts[0], dlParts[1]));
            storage.saveToFile(tasks);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! Invalid deadline format. Use: deadline <description> /by <time>");
        }
        catch (DukeException e) {
            throw new DukeException("Invalid date format. Use yyyy-MM-dd or yyyy-MM-dd HH:mm");
        }
    }
}
