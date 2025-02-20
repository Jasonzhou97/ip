package duke.command;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Task;
public class ListCommand extends Command{
    private String response = "Your current list:\n";
    public void execute(TaskList tasks, Storage storage, Ui ui) {
        for (int i = 0; i < tasks.getNum_of_tasks(); i++) {
            Task t = tasks.array().get(i);
            int index = i + 1;
            System.out.println(index + ". " + t.print());
            response += index + ". " + t.print() + "\n";
        }
    }
    @Override
    public String getResponse() {
        return this.response;
    }

}
