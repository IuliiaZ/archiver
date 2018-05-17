package archiveApp.command;

import archiveApp.ConsoleHelper;
import archiveApp.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Deleting a file from the archive.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Enter the full path of the file in the archive:");
        Path sourcePath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(sourcePath);

        ConsoleHelper.writeMessage("Deleting from the archive is complete.");
    }
}