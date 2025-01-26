package duke.main;

import duke.exception.DukeException;
import duke.command.*;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    public Duke (String path) {
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
    public void run () {
        ui.showWelcomeMessage();
        boolean isExit = false;


            while (isExit==false) {
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

}
