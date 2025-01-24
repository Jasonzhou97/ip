public class ExitCommand extends Command{

    @Override
    public void execute(TaskList tasks, Storage storage,Ui ui) {
        ui.showByeMessage();
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
