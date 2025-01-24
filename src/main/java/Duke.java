import java.lang.constant.DynamicCallSiteDesc;
import java.text.ParseException;
import java.util.Scanner;

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

        try {
            while (isExit==false) {
                String cmd = ui.readCommand();
                Command c = Parser.parse(cmd);
                c.execute(tasks, storage, ui);
                isExit = c.isExit();
            }
        }
        catch (DukeException e) {
            ui.showErrorMessage(e);
        }

    }

}
