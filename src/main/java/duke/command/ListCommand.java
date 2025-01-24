package duke.command;
import duke.main.*;
import duke.task.Task;
public class ListCommand extends Command{

    public void execute (TaskList tasks,Storage storage, Ui ui) {
        for (int i=0;i<tasks.getNum_of_tasks();i++) {
            Task t = tasks.array().get(i);
            int index = i + 1;
            System.out.println(index + ". " + t.print());
        }
    }
}
