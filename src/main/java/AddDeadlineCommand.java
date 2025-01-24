public class AddDeadlineCommand extends Command{
    private String title;
    private String[] parts;
    public AddDeadlineCommand(String title) {
        this.title = title;
        parts = title.split(" ",2);
    }

    public void execute (TaskList tasks,Storage storage, Ui Ui) throws DukeException,ArrayIndexOutOfBoundsException {
        try {
            if (parts.length < 2) {
                throw new DukeException("OOPS!!! The description of a deadline cannot be empty, please fill in the description!");
            }
            String[] dlParts = parts[1].split("/by", 2);
            if (dlParts.length<2){
                throw new DukeException("OOPS!!! Please provide a deadline using /by.");
            }
            tasks.addTask(new Deadline(dlParts[0], dlParts[1]));
            storage.saveToFile(tasks);
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new DukeException("OOPS!!! Invalid deadline format. Use: deadline <description> /by <time>");
        }
        catch (DukeException e) {
            throw new DukeException("Invalid date format. Use yyyy-MM-dd or yyyy-MM-dd HH:mm");
        }
    }
}
