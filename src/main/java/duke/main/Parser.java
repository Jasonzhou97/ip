package duke.main;

import duke.command.*;
import duke.exception.DukeException;

/**
 * Parser class to parse user commands
 */
public class Parser {
    public static Command parse(String input) throws DukeException {
        String[] parts = input.split(" ",2);
        String command = parts[0].toLowerCase();

        switch(command){
            case "list":
                return new ListCommand();

            case "delete":
                return new DeleteCommand(parts);

            case "todo":
                return new AddToDoCommand(input);


            case "deadline":
                return new AddDeadlineCommand(input);

            case "event":
                return new AddEventCommand(input);

            case "mark":
                return new MarkCommand(parts);

            case "unmark":
                return new UnmarkCommand(parts);

            case "bye":
                return new ExitCommand();

            case "find":
                return new FindCommand(parts);
            default:
                throw new DukeException("OOPS I have no idea what that means :(");
        }

    }
}
