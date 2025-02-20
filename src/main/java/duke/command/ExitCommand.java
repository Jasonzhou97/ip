package duke.command;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;

/**
 * Command to execute the GUI when user enters bye
 */
public class ExitCommand extends Command {

    /**
     * Execute the exit command when user enters bye.
     * @param tasks list of tasks loaded from storage
     * @param storage the storage to load and save tasks
     * @param ui to allow users to interact
     */
    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) {
        ui.showByeMessage();
    }
    public String getResponse() {
        return "Bye! Hope I never see you again!";
    }
    @Override
    public boolean isExit() {
        return true;
    }
}
