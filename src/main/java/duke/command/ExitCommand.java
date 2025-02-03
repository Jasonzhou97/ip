package duke.command;
import duke.main.*;

public class ExitCommand extends Command{


    @Override
    public void execute(TaskList tasks, Storage storage,Ui ui) {
        ui.showByeMessage();
    }
    public String getResponse(){
        return "Bye!";
    }
    @Override
    public boolean isExit(){
        return true;
    }
}
