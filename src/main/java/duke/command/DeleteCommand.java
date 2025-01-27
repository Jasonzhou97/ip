package duke.command;
import duke.exception.DukeException;
import duke.main.*;

public class DeleteCommand extends Command{
    private String[] parts;

    public DeleteCommand(String[] parts){
        this.parts = parts;
    }

    public void execute (TaskList tasks, Storage storage, Ui ui) throws DukeException{
        try{
            if(parts.length < 2){
                throw new DukeException("OOPS!!! You did not specify an index to delete, please specify an index!");
            }
            int index = Integer.parseInt(parts[1]);
            tasks.delete(index-1);
            storage.saveToFile(tasks);
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new DukeException("OOPS!!! You did not specify an index to delete, please specify an index!");
        }
    }
}
