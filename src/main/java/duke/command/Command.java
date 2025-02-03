package duke.command;
import duke.exception.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

/**
 * Parent command class.
 */
public abstract class Command {
    public abstract void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException;

    public String showMessage() {
        return "hi";
    }
    public boolean isExit() {
        return false;
    }
}
