package duke.main;
import duke.command.Command;
import duke.exception.DukeException;


/**
 * Main class to run when user starts program
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    private Parser parser;

    /**
     * Main class that starts up
     * @param path the path to the txt file that loads and saves task
     */
    public Duke(String path) {
        ui = new Ui();
        storage = new Storage(path);
        try {
            tasks = storage.loadTasks();
        } catch (Exception e) {
            ui.showErrorMessage(e);
            tasks = new TaskList();
        }
    }
    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();

    }

    /**
     * Load the UI
     */
    public void run() {
        ui.showWelcomeMessage();
        boolean isExit = false;


        while (isExit == false) {
            try {
                String cmd = ui.readCommand();
                Command c = Parser.parse(cmd);
                c.execute(tasks, storage, ui);
                isExit = c.isExit();
                }
            catch (DukeException e) {
                ui.showErrorMessage(e);
            }

        }

    }

    public String executeCommand(String input) throws DukeException {
        Command cmd = parser.parse(input);
        try {
            cmd.execute(tasks, storage, ui);
            String message = cmd.showMessage();
            return message;
        }
        catch (DukeException e) {
            return "Oops";
        }
    }

}
