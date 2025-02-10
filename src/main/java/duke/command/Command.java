package duke.command;
import duke.exception.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

import java.util.Arrays;

/**
 * Parent command class.
 */
public abstract class Command {

    public abstract void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException;

    public String getResponse() {
        return "hi";
    }
    public boolean isExit() {
        return false;
    }

    public boolean isMassCommand(String[] input) {
        String content = input[1];
        return content.contains(",");
    }
}
