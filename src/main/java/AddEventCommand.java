public class AddEventCommand extends Command{

    private String title;
    private String[] parts;
    public AddEventCommand(String title) {
        this.title = title;
        parts = title.split(" ",2);
    }

    public void execute (TaskList tasks,Storage storage, Ui ui) throws DukeException,ArrayIndexOutOfBoundsException {
        try {
            if (parts.length<2){
                throw new DukeException("OOPS!!! The description of an event cannot be empty, please fill in the description!");
            }
            String[] evParts = parts[1].split(" /from ", 2);
            if (evParts.length < 2) {
                throw new DukeException("OOPS!!! Please provide event time using /from and /to.");
            }
            String[] timeParts = evParts[1].split(" /to ", 2);
            if (timeParts.length < 2) {
                throw new DukeException("OOPS!!! Please provide event end time using /to.");
            }
            tasks.addTask(new Event(evParts[0], timeParts[0], timeParts[1]));
            storage.saveToFile(tasks);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! Invalid event format. Use: event <description> /from <start-time> /to <end-time>");
        }
    }
}
