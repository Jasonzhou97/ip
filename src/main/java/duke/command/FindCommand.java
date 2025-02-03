package duke.command;

import duke.exception.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Task;
public class FindCommand extends Command {

    private String[] parts;
    public FindCommand(String[] parts){
        this.parts = parts;
    }
    private String response = "";
    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        try {
            boolean found = false;
            int counter = 0;
            if(parts.length != 2){
                throw new DukeException("Invalid finding! Please input 'find /title/ ;");
            }
            for (Task k : tasks.array()) {
                String title = k.getTitle();
                for (String p: this.parts){
                    if(title.contains(p)){
                        System.out.println((counter + 1) + "." + k.print());
                        response += (counter + 1) + "." + k.print();
                        found = true;
                        counter += 1;
                    }
                }
            }
            if(!found){
                System.out.println("Oops, there are no matching tasks!");
            }
        }
        catch (DukeException e){
            throw new DukeException("Invalid finding! Please input 'find /title/ ;");
        }
    }
    public String getResponse(){
        return this.response;
    }
}
