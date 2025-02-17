package duke.command;

import duke.exception.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

/**
 * Greets users.
 */
public class GreetCommand extends Command {

    private String response = "";
    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        this.response += "Wassup man what do you want?";
    }

    public String getResponse() {
        return response;
    }
}
