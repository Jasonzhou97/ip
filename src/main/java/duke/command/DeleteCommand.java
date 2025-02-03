package duke.command;
import duke.exception.DukeException;
import duke.main.*;
import duke.task.Task;

public class DeleteCommand extends Command{
    private String[] parts;
    private String response = "";

    public DeleteCommand(String[] parts){
        this.parts = parts;
    }
    public String getResponse(){
        return this.response;
    }
    public void execute (TaskList tasks, Storage storage, Ui ui) throws DukeException{
        try{
            if(parts.length < 2){
                throw new DukeException("OOPS!!! You did not specify an index to delete, please specify an index!");
            }
            int index = Integer.parseInt(parts[1]);
            Task t = tasks.array().get(index - 1);
            tasks.delete(index - 1);
            response += "You have deleted " + t.print();
            storage.saveToFile(tasks);
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new DukeException("OOPS!!! You did not specify an index to delete, please specify an index!");
        }
    }
}
