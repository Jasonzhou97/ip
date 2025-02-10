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
            if (isMassCommand(parts)) {
                response += "You have unmarked the following tasks as done:\n";
                massUnmark(tasks, storage);
            }
            else {
                int unmarkIndex = Integer.parseInt(parts[1]) - 1;
                Task curTaskUnmark = tasks.array().get(unmarkIndex);
                response += "You have marked " + curTaskUnmark.getTitle() + " as undone.";
                curTaskUnmark.unmark();
                storage.saveToFile(tasks);
            }
        } catch (NumberFormatException e) {
            throw new DukeException("OOPS!!! The task number must be a number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! Please provide a task number to unmark.");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! The task number is invalid.");
        }
    }

    public void massUnmark(TaskList tasks, Storage storage) {
        String content = parts[1];
        String[] indexArray = content.split(",");
        for (int i = 0; i < indexArray.length; i++) {
            int index = Integer.parseInt(indexArray[i]);
            Task t = tasks.array().get(index - 1);
            t.unmark();
            response += t.print() + "\n";
        }
        storage.saveToFile(tasks);
    }
}
