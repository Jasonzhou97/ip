package duke.command;
import duke.exception.DukeException;
import duke.main.*;
import duke.task.ToDo;

/**
 * Command to add a todo command
 */
public class AddToDoCommand extends Command{

    private String title;
    private String[] parts;

    public AddToDoCommand(String title) {
        this.title = title;
        parts = title.split(" ",2);
    }

    @Override
    public void execute(TaskList tasks,Storage storage, Ui Ui) throws DukeException {
        try {
            if (parts.length < 2) {
                throw new DukeException("OOPS!!! The description of a todo cannot be empty, please fill in the description!");
            }
            tasks.addTask(new ToDo(parts[1]));
            storage.saveToFile(tasks);
        }

        catch(ArrayIndexOutOfBoundsException e){
            throw new DukeException("OOPS!!! The description of a todo cannot be empty, please fill in the description!");
        }

    }
}
