package duke.command;
import duke.exception.DukeException;
import duke.main.*;
import duke.task.Task;

/**
 * To unmark tasks that users want to unmark
 */
public class UnmarkCommand extends Command {
    private int index;
    private String[] parts;

    private String response = "";

    public UnmarkCommand(String[] parts) {
        this.parts = parts;
    }
    public String getResponse(){
        return this.response;
    }

    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        try {
            if (parts.length < 2) {
                throw new DukeException("OOPS!!! Please provide a task number to unmark.");
            }
            int unmarkIndex = Integer.parseInt(parts[1]) - 1;
            Task curTaskUnmark = tasks.array().get(unmarkIndex);
            response += "You have marked " + curTaskUnmark.getTitle() + " as undone.";
            curTaskUnmark.unmark();
            storage.saveToFile(tasks);
        } catch (NumberFormatException e) {
            throw new DukeException("OOPS!!! The task number must be a number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! Please provide a task number to unmark.");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! The task number is invalid.");
        }
    }
}
