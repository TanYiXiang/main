package command;

import exception.DukeException;
import storage.Storage;
import task.TaskList;
import ui.Ui;


public class StorageCommand extends Command {

    private boolean isSave;
    private String fileName;

    public StorageCommand(boolean opCode, String fileName) {
        this.isSave = opCode;
        this.fileName = fileName;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) throws DukeException {

        if (isSave) {
            storage.manualSave(fileName, tasks.getTasks());
            Ui.printOutput("Got it your file is saved at: /src/DukeDatabase/" + fileName);
        } else {
            tasks.listOfTasks = storage.manualLoad(fileName);
            storage.saveFile(tasks.getTasks());
            Ui.printOutput("Got it, file loaded!");
        }
    }


}
