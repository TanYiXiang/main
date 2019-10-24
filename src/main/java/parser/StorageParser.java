package parser;

import command.Command;
import command.StorageCommand;
import exception.DukeException;

public class StorageParser extends DescriptionParser {

    private boolean opCode;

    public StorageParser(String userInput, String command,boolean opCode) {
        super(userInput, command);
        this.opCode = opCode;
    }

    @Override
    public Command parse() throws DukeException {
        super.extract();
        return new StorageCommand(opCode,taskFeatures);
    }
}
