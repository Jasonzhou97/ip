package duke.command;
import duke.exception.DukeException;
import duke.main.*;
import duke.task.Task;
public class MarkCommand extends Command{
    private int index;
    private String[] parts;

    private String response = "";
    public MarkCommand(String[] parts) {
        this.parts = parts;
    }
    public String getResponse(){
        return this.response;
    }
    public void execute (TaskList tasks, Storage storage, Ui ui) throws DukeException {
        try {
            if (parts.length < 2) {
                throw new DukeException("OOPS!!! Please provide a task number to mark.");
            }
            int index = Integer.parseInt(parts[1]) - 1;
            Task curTask = tasks.array().get(index);
            response = "You have marked " + curTask.getTitle() + " as done.";
            curTask.markDone();
            storage.saveToFile(tasks);
        }
        catch(NumberFormatException e){
            throw new DukeException("OOPS!!! The task number must be a number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! Please provide a task number to mark.");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! The task number is invalid.");
        }
    }
}
