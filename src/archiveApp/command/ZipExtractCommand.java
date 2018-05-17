package archiveApp.command;

import archiveApp.ConsoleHelper;
import archiveApp.ZipFileManager;
import archiveApp.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Unpacking the archive.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Enter the path to unpack:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage("The archive was unpacked.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Invalid path for unpacking.");
        }
    }
}
