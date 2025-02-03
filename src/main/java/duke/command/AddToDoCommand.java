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

    private String response = "";

    public AddToDoCommand(String title) {
        this.title = title;
        parts = title.split(" ",2);
    }
    public String getResponse(){
        return this.response;
    }
    @Override
    public void execute(TaskList tasks, Storage storage, Ui Ui) throws DukeException {
        try {
            if (parts.length < 2) {
                throw new DukeException("OOPS!!! The description of a todo cannot be empty, please fill in the description!");
            }
            ToDo todo = new ToDo(parts[1]);
            tasks.addTask(todo);
            response += todo.print();
            storage.saveToFile(tasks);
        }

        catch (ArrayIndexOutOfBoundsException e){
            throw new DukeException("OOPS!!! The description of a todo cannot be empty, please fill in the description!");
        }

    }
}
