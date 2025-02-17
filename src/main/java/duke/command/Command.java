package duke.command;
import duke.exception.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;


/**
 * Parent command class.
 */
public abstract class Command {
    private String response;
    private static final String EMPTY_DESC_ERROR = "OOPS!!! The description of a deadline cannot be empty.";
    private static final String MISSING_DEADLINE_ERROR = "OOPS!!! Please provide a deadline using /by.";
    private static final String INVALID_FORMAT_ERROR = "OOPS!!! Invalid deadline format. Use: deadline <description> /by <time>";
    private static final String INVALID_DATE_ERROR = "Invalid date format. Use yyyy-MM-dd or yyyy-MM-dd HH:mm";
    private static final String MULTIPLE_BY_ERROR = "OOPS!!! Multiple /by tags found. Please use only one /by tag.";
    private static final String DUPLICATE_TASK_ERROR = "OOPS!!! This exact deadline already exists in your list.";
    private static final String PAST_DATE_ERROR = "OOPS!!! Deadline cannot be set in the past.";
    private static final String SPECIAL_CHAR_ERROR = "OOPS!!! Description contains invalid special characters.";
    private static final String MAX_LENGTH_ERROR = "OOPS!!! Description is too long. Maximum 100 characters allowed.";
    private static final String EMPTY_TIME_ERROR = "OOPS!!! Time cannot be empty after /by.";
    public abstract void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException;

    public String getResponse() {
        return response;
    }
    public boolean isExit() {
        return false;
    }

    /**
     * Validates if input is a user command or normal command.
     * @param input user input
     * @return if the input contains , which means it is a mass command
     */
    public boolean isMassCommand(String[] input) {
        String content = input[1];
        return content.contains(",");
    }
}
