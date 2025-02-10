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
    private static final String EMPTY_DESC_ERROR = "OOPS!!! The description of a deadline cannot be empty.";
    private static final String MISSING_DEADLINE_ERROR = "OOPS!!! Please provide a deadline using /by.";
    private static final String INVALID_FORMAT_ERROR = "OOPS!!! Invalid deadline format. Use: deadline <description> /by <time>";
    private static final String INVALID_DATE_ERROR = "Invalid date format. Use yyyy-MM-dd or yyyy-MM-dd HH:mm";
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
    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        try {
            validateInput();
            String[] dlParts = parts[1].split("/by", 2);
            this.response = tasks.addTask(new Deadline(dlParts[0].trim(), dlParts[1].trim()));
            storage.saveToFile(tasks);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException(INVALID_FORMAT_ERROR);
        } catch (IllegalArgumentException e) {
            throw new DukeException(INVALID_DATE_ERROR);
        }
    }
    private void validateInput() throws DukeException {
        // Check if description exists
        if (parts.length < 2) {
            throw new DukeException("Description cannot be empty");
        }

        String[] dlParts = parts[1].split("/by", 2);
        if (dlParts.length < 2) {
            throw new DukeException("Missing deadline");
        }

    }
}
