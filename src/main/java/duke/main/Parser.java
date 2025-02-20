package duke.main;

import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.AddToDoCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.ExitCommand;
import duke.command.FindCommand;
import duke.command.GreetCommand;
import duke.command.ListCommand;
import duke.command.MarkCommand;
import duke.command.UnmarkCommand;
import duke.exception.DukeException;

/**
 * Parser class to parse user commands
 */
public class Parser {

    public static Command parse(String input) throws DukeException {
        String[] parts = input.split(" ", 2);
        assert(parts.length >= 2);
        String command = parts[0].toLowerCase();

        switch(command) {

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
            case "hi":
                return new GreetCommand();
            case "hey":
                return new GreetCommand();

            default:
                throw new DukeException("OOPS I have no idea what that means :(");
        }

    }
}
