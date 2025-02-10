package duke.command;
import duke.exception.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Task;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class DeleteCommand extends Command {
    private String[] parts;
    private String response = "";

    public DeleteCommand(String[] parts) {
        this.parts = parts;
    }
    public String getResponse(){
        return this.response;
    }


    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        try {
            if (parts.length < 2) {
                throw new DukeException("OOPS!!! You did not specify an index to delete, please specify an index!");
            }
            Task t = null;
            String content = parts[1];
            if (content.contains(",")) {
                System.out.println("masss");
                String[] indices = content.split(",");
                response = massDelete(indices, tasks, storage);
      }
            else {
                System.out.println("single");
                int index = Integer.parseInt(parts[1]);
                t = tasks.array().get(index - 1);
                tasks.delete(index - 1);
                response += "You have deleted " + t.print();
                storage.saveToFile(tasks);
            }


        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! You did not specify an index to delete, please specify an index!");
        }
    }

    private String massDelete(String[] parts, TaskList tasks, Storage storage) {
        String response = "";
        ArrayList<Integer> indices = new ArrayList<>();
        response += "Noted. I've removed these tasks:\n";
        for (int i = 0; i < parts.length; i++) {
            indices.add(Integer.parseInt(parts[i]));
        }
        Collections.sort(indices, Collections.reverseOrder());
        for (int i = 0; i < indices.size(); i++) {
            // Delete tasks
            int index = indices.get(i) - 1;
            try {
                Task deletedTask = tasks.array().get(index);
                response += deletedTask.print() + "\n";
                tasks.delete(index);
            }
            catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
        storage.saveToFile(tasks);
        return response;
    }
}
