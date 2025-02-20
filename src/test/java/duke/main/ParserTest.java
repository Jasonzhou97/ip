package duke.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import duke.command.*;
import duke.exception.DukeException;

class ParserTest {
    @Test
    void parse_listCommand_returnsListCommand() throws DukeException {
        Command result = Parser.parse("list");
        assertTrue(result instanceof ListCommand);
    }

    @Test
    void parse_invalidCommand_returnsNull() throws DukeException {
        Command result = Parser.parse("invalid");
        assertNull(result);
    }


    @Test
    void parse_todoCommand_returnsAddToDoCommand() throws DukeException {
        Command result = Parser.parse("todo read book");
        assertTrue(result instanceof AddToDoCommand);
    }
    @Test
    void parse_findCommand_returnsFindCommand() throws DukeException {
        Command result = Parser.parse("find book");
        assertTrue(result instanceof FindCommand);
    }
}