package archiveApp.command;

import archiveApp.ConsoleHelper;
import archiveApp.ZipFileManager;
import archiveApp.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Adding a new file to the archive.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Enter the full file name to add:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());

            zipFileManager.addFile(sourcePath);

            ConsoleHelper.writeMessage("Addition to the archive is completed.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("File not found.");
        }
    }
}
