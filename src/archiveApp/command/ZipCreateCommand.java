package archiveApp.command;

import archiveApp.ConsoleHelper;
import archiveApp.ZipFileManager;
import archiveApp.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

import static archiveApp.ConsoleHelper.*;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            writeMessage("Creating an archive.");

            ZipFileManager zipFileManager = getZipFileManager();

            writeMessage("Enter the full name of the file or directory to be archived:");
            Path sourcePath = Paths.get(readString());
            zipFileManager.createZip(sourcePath);

            writeMessage("The archive was created.");

        } catch (PathIsNotFoundException e) {
            writeMessage("You have incorrectly specified the name of the file or directory.");
        }
    }
}
